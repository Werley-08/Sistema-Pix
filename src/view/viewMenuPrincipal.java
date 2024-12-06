package view;

import model.usuarioModel;
import utils.ClearScreen;

import java.util.Scanner;

public class viewMenuPrincipal{

    public static void menu(Scanner scanner, usuarioModel usuarioLogado){

        String opcion;

        do{
            ClearScreen.clear();

            usuarioLogado.exibirUsuario();

            System.out.println("======== MENU PRINCIPAL ========");
            System.out.println("1 - ÁREA PIX");
            System.out.println("2 - ÁREA USUÁRIO");
            System.out.println("3 - ÁREA CONTA BANCÁRIA");
            System.out.println("0 - LOGOUT");
            System.out.print("Escolha uma opção: ");
            opcion = scanner.nextLine();

            if(opcion.equals("1")) { pixView.menu(scanner, usuarioLogado); continue; }
            if(opcion.equals("2")) { usuarioView.menu(scanner); continue; }
            if(opcion.equals("3")) { contaBancariaView.menu(scanner, usuarioLogado); continue; }
            if(opcion.equals("0")) { System.out.println("VOLTANDO PARA O MENU INICIAL...\n"); }
            else { System.out.println("COMANDO INVÁLIDO!"); }

        } while (!opcion.equals("0"));
    }
}
