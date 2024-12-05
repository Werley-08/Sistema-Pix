package view;

import controller.contaBancariaController;
import model.usuarioModel;
import utils.ClearScreen;
import java.util.Scanner;

public class contaBancariaView {

    public static void menu(Scanner scanner, usuarioModel usuarioLogado){

        String opcion;

        do{
            ClearScreen.clear();
            System.out.println("========= MENU CONTA BANCÁRIA =========");
            System.out.println("1 - EDITAR DADOS");
            System.out.println("2 - DELETAR CONTA BANCARIA");
            System.out.println("3 - ASSOCIAR NOVA CHAVE PIX A CONTA");
            System.out.println("0 - VOLTAR PARA O MENU PRINCIPAL");
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            opcion = scanner.nextLine();

            //if(opcion.equals("1")) { contaBancariaController.editarDados();}
            //if(opcion.equals("2")) { contaBancariaController.deletarDados();}
            if(opcion.equals("3")) {
                String opcaoChavePix = "";

                if(usuarioLogado.getTipoPessoa().equals("F")){
                    System.out.println("DIGITE O NÚMERO CORRESPONDENTE A CHAVE PIX QUE VOCÊ DESEJA CRIAR:");
                    System.out.println("1 - TELEFONE");
                    System.out.println("2 - E-MAIL");
                    System.out.println("3 - CPF");
                    System.out.println("4 - CHAVE ALEATÓRIA");

                    opcaoChavePix = scanner.nextLine();
                }

                if (usuarioLogado.getTipoPessoa().equals("J")){
                    System.out.println("DIGITE O NÚMERO CORRESPONDENTE A CHAVE PIX QUE VOCÊ DESEJA CRIAR:");
                    System.out.println("1 - TELEFONE");
                    System.out.println("2 - E-MAIL");
                    System.out.println("3 - CNPJ");
                    System.out.println("4 - CHAVE ALEATÓRIA");

                    opcaoChavePix = scanner.nextLine();
                }

                contaBancariaController.associarChavePix(usuarioLogado, opcaoChavePix);
                continue;
            }
            if(opcion.equals("0")) { System.out.println("VOLTANDO PARA MENU PRINCIPAL...\n");}
            else            { System.out.println("OPÇÃO INVÁLIDA! TENTE NOVAMENTE");}

        }while(!opcion.equals("0"));
    }
}
