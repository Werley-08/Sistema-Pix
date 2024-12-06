package view;

import utils.ClearScreen;

import java.util.Scanner;

public class usuarioView {

    public static void menu(Scanner scanner){

        String opcion;

        do {
            ClearScreen.clear();
            System.out.println("========= MENU USUÁRIO =========");
            System.out.println("1 - EDITAR DADOS");
            System.out.println("2 - DELETAR USUÁRIO");
            System.out.println("0 - VOLTAR PARA O MENU PRINCIPAL");
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            opcion = scanner.nextLine();

            //if(opcion.equals("1")) {
            //
            //
            // usuarioController.editarDados();}
            //if(opcion.equals("2")) { usuarioController.deletarDados();}
            if(opcion.equals("0")) { System.out.println("VOLTANDO PARA MENU PRINCIPAL...\n");}
            else            { System.out.println("OPÇÃO INVÁLIDA! TENTE NOVAMENTE");}

        }while(!opcion.equals("0"));

    }

}
