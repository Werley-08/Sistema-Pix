package controller;

import model.usuarioModel;
import dao.pixDAO;

public class pixController {
    public static void fazerPix(usuarioModel usuarioLogado,int tipoChave, String chavePixDestino, double valor) {
            pixDAO.realizarPix(usuarioLogado,tipoChave, chavePixDestino, valor);
    }
}
