package dao;

import model.contaBancariaModel;
import model.usuarioModel;
import model.chaveAleatoriaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class contabancariaDAO {
    public static void cadastrarContaBancaria(contaBancariaModel contaBancaria, usuarioModel usuario){
        String sql = "INSERT INTO contasbancarias (agencia, conta, login, senha, telefone, telefoneassociado, cpf, cpfassociado, email, emailassociado, cnpj, cnpjassociado, chavealeatoria, saldo, chavealeatoriaassociada) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection conn = conexaoDAO.connection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, contaBancaria.getAgencia());
                pstmt.setString(2, contaBancaria.getConta());
                pstmt.setString(3, usuario.getLogin());
                pstmt.setObject(4, usuario.getSenha());
                pstmt.setString(5, usuario.getTelefone());
                pstmt.setNull(6, java.sql.Types.VARCHAR);
                pstmt.setObject(7, usuario.getCpf());
                pstmt.setNull(8, java.sql.Types.VARCHAR);
                pstmt.setString(9, usuario.getEmail());
                pstmt.setNull(10, java.sql.Types.VARCHAR);
                pstmt.setString(11, usuario.getCnpj());
                pstmt.setNull(12, java.sql.Types.VARCHAR);
                pstmt.setString(13, chaveAleatoriaModel.gerarChaveAleatoria());
                pstmt.setDouble(14, contaBancaria.getSaldo());
                pstmt.setNull(15, java.sql.Types.VARCHAR);

            pstmt.executeUpdate();
            System.out.println("Conta bancária inserida com sucesso!");

        } catch (Exception e) {

            System.out.println(e);

        }
    }

    public static contaBancariaModel associarChavePix(usuarioModel usuario, String opcaoChavePix) {

        String sql = "";

             if(opcaoChavePix.equals("1")){ sql = "UPDATE contasbancarias SET telefoneassociado = ? WHERE login = ? AND senha = ?"; }
        else if(opcaoChavePix.equals("2")){ sql = "UPDATE contasbancarias SET emailassociado = ? WHERE login = ? AND senha = ?"; }
        else if(opcaoChavePix.equals("3")){
                if(usuario.getTipoPessoa().equals("F")){ sql = "UPDATE contasbancarias SET cpfassociado = ? WHERE login = ? AND senha = ?"; }
                if(usuario.getTipoPessoa().equals("J")){ sql = "UPDATE contasbancarias SET cnpjassociado = ? WHERE login = ? AND senha = ?"; } }
        else if(opcaoChavePix.equals("4")){ sql = "UPDATE contasbancarias SET chavealeatoriaassociada = ? WHERE login = ? AND senha = ?"; }

        try{

            Connection conn = conexaoDAO.connection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "sim");
            pstmt.setString(2, usuario.getLogin());
            pstmt.setString(3, usuario.getSenha());

            pstmt.executeUpdate();
            System.out.println("Chave pix associada com sucesso!");

        }catch (Exception e){

            System.out.println(e);

        }

        return null;

    }
}
