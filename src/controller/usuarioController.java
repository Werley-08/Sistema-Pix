package controller;

import dao.usuarioDAO;
import model.usuarioModel;

public class usuarioController {

    public static void adicionarUsuario(usuarioModel usuario){

        usuarioDAO.adicionarUsuario(usuario);

    }

    public static usuarioModel logarUsuario(String login, String senha){

        return usuarioDAO.logarUsuario(login, senha);

    }

}
