package view;

import controller.pixController;
import model.usuarioModel;
import utils.ClearScreen;

import java.util.Scanner;



public class pixView {

    public static void menu(Scanner scanner, usuarioModel usuarioLogado){

        String opcion;
        int tipoChave = 0;

        do {
            ClearScreen.clear();
            System.out.println("========= MENU PIX =========");
            System.out.println("1 - FAZER PIX");
            System.out.println("0 - VOLTAR PARA O MENU PRINCIPAL");
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            opcion = scanner.nextLine();

            if(opcion.equals("1")) {
                    System.out.println("INSIRA O TIPO DA CHAVE:");
                    System.out.println("1 - TELEFONE");
                    System.out.println("2 - CPF");
                    System.out.println("3 - E-MAIL");
                    System.out.println("4 - CNPJ");
                    System.out.println("5 - CHAVE ALEATÓRIA");
                    tipoChave = Integer.parseInt(scanner.nextLine());

                    System.out.println("INSIRA A CHAVE DA PESSOA:");
                    String chavePixDestinatario = scanner.nextLine();

                    System.out.println("INSIRA O VALOR DO PIX:");
                    double valorPix = Double.parseDouble(scanner.nextLine());

                pixController.fazerPix(usuarioLogado, tipoChave, chavePixDestinatario, valorPix);

            }
            if(opcion.equals("0")) { System.out.println("VOLTANDO PARA MENU PRINCIPAL...\n");}
            else            { System.out.println("OPÇÃO INVÁLIDA! TENTE NOVAMENTE");}

        }while(!opcion.equals("0"));
    }
}
