package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.usuarioModel;

public class pixDAO {
    public static int buscarContaPorChaveTipo(int tipoChave, String chavePix) {
        String sqlBusca = ""; // Consulta para buscar o dado
        String sqlVerifica = ""; // Consulta para verificar se está associado
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        switch (tipoChave) {
            case 1: // Tipo 1 - telefone
                sqlBusca = "SELECT id FROM contasbancarias WHERE telefone = ?";
                sqlVerifica = "SELECT telefoneassociado FROM contasbancarias WHERE id = ?";
                break;
            case 2: // Tipo 2 - CPF
                sqlBusca = "SELECT id FROM contasbancarias WHERE cpf = ?";
                sqlVerifica = "SELECT cpfassociado FROM contasbancarias WHERE id = ?";
                break;
            case 3: // Tipo 3 - e-mail
                sqlBusca = "SELECT id FROM contasbancarias WHERE email = ?";
                sqlVerifica = "SELECT emailassociado FROM contasbancarias WHERE id = ?";
                break;
            case 4: // Tipo 4 - CNPJ
                sqlBusca = "SELECT id FROM contasbancarias WHERE cnpj = ?";
                sqlVerifica = "SELECT cnpjassociado FROM contasbancarias WHERE id = ?";
                break;
            case 5: // Tipo 5 - chave aleatória
                sqlBusca = "SELECT id FROM contasbancarias WHERE chavealeatoria = ?";
                sqlVerifica = "SELECT chavealeatoriaassociada FROM contasbancarias WHERE id = ?";
                break;
            default:
                System.out.println("ERRO: Tipo de chave inválido.");
                return -1; // Tipo inválido
        }

        try (Connection conn = conexaoDAO.connection()) {
            pstmt = conn.prepareStatement(sqlBusca);
            pstmt.setString(1, chavePix);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int idConta = rs.getInt("id");
                rs.close();

                pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setInt(1, idConta);
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    String associado = rs.getString(1);
                    if ("sim".equalsIgnoreCase(associado)) {
                        return idConta;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar conta pela chave PIX: " + e.getMessage());
        }
        return -1;
    }

    public static boolean verificarSaldoSuficiente(String loginUsuario, double valor) {
        String sql = "SELECT cb.saldo FROM contasbancarias cb "
                + "JOIN usuarios u ON cb.login = u.login " // Relacionando as tabelas pelo campo 'login'
                + "WHERE u.login = ?"; // Filtrando pelo login do usuário
        ResultSet rs = null;

        try (Connection conn = conexaoDAO.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, loginUsuario);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                double saldo = rs.getDouble("saldo");

            //    System.out.println("Saldo encontrado: " + saldo);
            //  System.out.println("Valor necessário: " + valor);

                return saldo >= valor;
            } else {
                System.out.println("Nenhuma conta encontrada para o login: " + loginUsuario);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Erro ao verificar saldo: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    System.err.println("Erro ao fechar ResultSet: " + e.getMessage());
                }
            }
        }
    }

    public static boolean realizarTransferencia(String loginOrigem, int idContaDestino, double valor) {
        String sqlBuscaContaOrigem = "SELECT id FROM contasbancarias WHERE login = ?";
        String sqlDebito = "UPDATE contasbancarias SET saldo = saldo - ? WHERE id = ?";
        String sqlCredito = "UPDATE contasbancarias SET saldo = saldo + ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmtBuscaConta = null;
        PreparedStatement pstmtDebito = null;
        PreparedStatement pstmtCredito = null;
        ResultSet rs = null;

        try {
            conn = conexaoDAO.connection();
            conn.setAutoCommit(false); // Inicia a transação

            pstmtBuscaConta = conn.prepareStatement(sqlBuscaContaOrigem);
            pstmtBuscaConta.setString(1, loginOrigem);
            rs = pstmtBuscaConta.executeQuery();

            if (!rs.next()) {
                System.out.println("Conta de origem não encontrada para o login: " + loginOrigem);
                return false; // Conta de origem não encontrada
            }

            int idContaOrigem = rs.getInt("id");

            if (!verificarSaldoSuficiente(loginOrigem, valor)) {
                System.out.println("Saldo insuficiente para realizar a transferência.");
                return false; // Saldo insuficiente
            }

            //Subtrai do saldo da conta de origem
            pstmtDebito = conn.prepareStatement(sqlDebito);
            pstmtDebito.setDouble(1, valor);
            pstmtDebito.setInt(2, idContaOrigem);
            int rowsDebito = pstmtDebito.executeUpdate();

            //Adiciona ao saldo da conta de destino
            pstmtCredito = conn.prepareStatement(sqlCredito);
            pstmtCredito.setDouble(1, valor);
            pstmtCredito.setInt(2, idContaDestino);
            int rowsCredito = pstmtCredito.executeUpdate();

            //Verifica se as atualizações foram bem-sucedidas
            if (rowsDebito > 0 && rowsCredito > 0) {
                conn.commit(); // Se tudo der certo, confirma a transação
                System.out.println("Transferência realizada com sucesso!");
                return true;
            } else {
                conn.rollback(); // Caso algo dê errado, faz rollback
                System.out.println("Erro na transferência. Rollback realizado.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao realizar transferência: " + e.getMessage());
            e.printStackTrace();

            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Rollback realizado devido ao erro.");
                }
            } catch (SQLException rollbackEx) {
                System.out.println("Erro ao realizar rollback: " + rollbackEx.getMessage());
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                if (pstmtBuscaConta != null) {
                    pstmtBuscaConta.close();
                }
                if (pstmtDebito != null) {
                    pstmtDebito.close();
                }
                if (pstmtCredito != null) {
                    pstmtCredito.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return false; // Retorna false se algo deu errado durante a transferência
    }

    // Método para realizar o PIX (transferência)
    public static void realizarPix(usuarioModel usuarioLogado, int tipoChave, String chavePixDestino, double valor) {

        // Busca a conta de destino associada à chave PIX e tipo
        int idContaDestino = buscarContaPorChaveTipo(tipoChave, chavePixDestino);

        // Verifica se a chave PIX é válida
        if (idContaDestino == -1) {
            System.out.println("ERRO: Chave PIX não encontrada ou inválida.");
            return; // Chave PIX não encontrada ou inválida
        }

        // Verifica o saldo da conta de origem
        if (!verificarSaldoSuficiente(usuarioLogado.getLogin(), valor)) {
            System.out.println("ERRO: Saldo insuficiente para realizar o PIX.");
            return; // Saldo insuficiente
        }

        // Realiza a transferência entre as contas
        if (realizarTransferencia(usuarioLogado.getLogin(), idContaDestino, valor)) {
            System.out.println("PIX REALIZADO COM SUCESSO! :)");
        } else {
            System.out.println("ERRO: Não foi possível realizar a transferência.");
        }
    }
}
