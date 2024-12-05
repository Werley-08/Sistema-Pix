package controller;

import dao.contabancariaDAO;
import model.contaBancariaModel;
import model.usuarioModel;

public class contaBancariaController {
    public static void cadastrarContaBancaria(contaBancariaModel contaBancaria, usuarioModel usuario){
        contabancariaDAO.cadastrarContaBancaria(contaBancaria, usuario);
    }

    public static void associarChavePix(usuarioModel usuario, String opcaoChavePix) {
        contabancariaDAO.associarChavePix(usuario, opcaoChavePix);
    }
}
