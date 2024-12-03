package dao;

import model.usuarioModel;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class usuarioDAO{

    public static void adicionarUsuario(usuarioModel usuario){

        String sql = "INSERT INTO usuarios (login, senha, nome, dataDeNascimento, tipoPessoa, cpf, cnpj, telefone, email) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try{

            Connection conn = conexaoDAO.connection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            if(usuario.getTipoPessoa().equals("F")){

                pstmt.setString(1, usuario.getLogin());
                pstmt.setString(2, usuario.getSenha());
                pstmt.setString(3, usuario.getNome());
                pstmt.setObject(4, usuario.getDataDeNascimento());
                pstmt.setString(5, usuario.getTipoPessoa());
                pstmt.setString(6, usuario.getCpf());
                pstmt.setNull(7, java.sql.Types.VARCHAR);
                pstmt.setString(8, usuario.getTelefone());
                pstmt.setString(9, usuario.getEmail());

            }else if(usuario.getTipoPessoa().equals("J")){

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

        }catch (Exception e){

            System.out.println(e);

        }

    }

}


