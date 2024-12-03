package dao;

import model.usuarioModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class usuarioDAO {

    public static void adicionarUsuario(usuarioModel usuario) {

        String sql = "INSERT INTO usuarios (login, senha, nome, dataDeNascimento, tipoPessoa, cpf, cnpj, telefone, email) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection conn = conexaoDAO.connection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            if (usuario.getTipoPessoa().equals("F")) {

                pstmt.setString(1, usuario.getLogin());
                pstmt.setString(2, usuario.getSenha());
                pstmt.setString(3, usuario.getNome());
                pstmt.setObject(4, usuario.getDataDeNascimento());
                pstmt.setString(5, usuario.getTipoPessoa());
                pstmt.setString(6, usuario.getCpf());
                pstmt.setNull(7, java.sql.Types.VARCHAR);
                pstmt.setString(8, usuario.getTelefone());
                pstmt.setString(9, usuario.getEmail());

            } else if (usuario.getTipoPessoa().equals("J")) {

                pstmt.setString(1, usuario.getLogin());
                pstmt.setString(2, usuario.getSenha());
                pstmt.setString(3, usuario.getNome());
                pstmt.setObject(4, usuario.getDataDeNascimento());
                pstmt.setString(5, usuario.getTipoPessoa());
                pstmt.setNull(6, java.sql.Types.VARCHAR);
                pstmt.setString(7, usuario.getCnpj());
                pstmt.setString(8, usuario.getTelefone());
                pstmt.setString(9, usuario.getEmail());

            }

            pstmt.executeUpdate();
            System.out.println("Usuário inserido com sucesso!");

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public static usuarioModel logarUsuario(String login, String senha) {

        String sql = "SELECT login, senha, nome, dataDeNascimento, tipoPessoa, cpf, cnpj, telefone, email " + "FROM usuarios WHERE login = ? AND senha = ?";

        try{

            Connection conn = conexaoDAO.connection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, login);
            pstmt.setString(2, senha);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                usuarioModel usuarioLogado = new usuarioModel();

                usuarioLogado.setLogin(rs.getString("login"));
                usuarioLogado.setSenha(rs.getString("senha"));
                usuarioLogado.setNome(rs.getString("nome"));
                usuarioLogado.setDataDeNascimento(rs.getObject("dataDeNascimento", java.time.LocalDate.class));
                usuarioLogado.setTipoPessoa(rs.getString("tipoPessoa"));

                // Verifica o tipo de pessoa e define CPF ou CNPJ
                if(rs.getString("tipoPessoa").equals("F")){

                    usuarioLogado.setCpf(rs.getString("cpf"));
                    usuarioLogado.setCnpj(null);

                }else if(rs.getString("tipoPessoa").equals("J")){

                    usuarioLogado.setCnpj(rs.getString("cnpj"));
                    usuarioLogado.setCpf(null);

                }

                usuarioLogado.setTelefone(rs.getString("telefone"));
                usuarioLogado.setEmail(rs.getString("email"));

                return usuarioLogado;

            }

        }catch (Exception e){

            System.out.println(e);

        }

        return null;

    }

}


