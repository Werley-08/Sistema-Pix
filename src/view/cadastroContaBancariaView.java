package view;

import controller.contaBancariaController;
import controller.usuarioController;
import model.contaBancariaModel;
import model.usuarioModel;
import utils.ClearScreen;

import java.time.LocalDate;
import java.util.Scanner;

public class cadastroContaBancariaView {

    public static void cadastrar(Scanner scanner, usuarioModel usuario) {
        boolean cadastrado = false;

        do {
            ClearScreen.clear();

            //CADASTRO DE CONTA BANCÁRIA INICIA AQUI
            String opcaoChavePix = "";
            double saldo;

            System.out.println("========= CADASTRAR CONTA BANCÁRIA =========");
            System.out.println("DEPOSITE O VALOR EM CONTA:");
            saldo = scanner.nextDouble();

            scanner.nextLine();

            if(usuario.getTipoPessoa().equals("F")){
                System.out.println("DIGITE O NÚMERO CORRESPONDENTE A CHAVE PIX QUE VOCÊ DESEJA CRIAR:");
                System.out.println("1 - TELEFONE");
                System.out.println("2 - E-MAIL");
                System.out.println("3 - CPF");
                System.out.println("4 - CHAVE ALEATÓRIA");

                opcaoChavePix = scanner.nextLine();
            }

            if (usuario.getTipoPessoa().equals("J")){
                System.out.println("DIGITE O NÚMERO CORRESPONDENTE A CHAVE PIX QUE VOCÊ DESEJA CRIAR:");
                System.out.println("1 - TELEFONE");
                System.out.println("2 - E-MAIL");
                System.out.println("3 - CNPJ");
                System.out.println("4 - CHAVE ALEATÓRIA");

                opcaoChavePix = scanner.nextLine();
            }

            contaBancariaModel contaBancaria = new contaBancariaModel(saldo);
            contaBancariaController.cadastrarContaBancaria(contaBancaria, usuario);
            contaBancariaController.associarChavePix(usuario, opcaoChavePix);

            System.out.println("REALIZE LOGIN PARA ENTRAR NO SISTEMA\n");
            cadastrado = true;

        } while(!cadastrado);

    }

}
