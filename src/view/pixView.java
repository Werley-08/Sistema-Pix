package view;

import utils.ClearScreen;
import java.util.Scanner;

public class pixView {

    public static void menu(Scanner scanner){

        String opcion;

        do {
            ClearScreen.clear();
            System.out.println("========= MENU PIX =========");
            System.out.println("1 - FAZER PIX");
            System.out.println("0 - VOLTAR PARA O MENU PRINCIPAL");
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            opcion = scanner.nextLine();

            //if(opcion.equals("1")) { pixController.fazerPix();}
            if(opcion.equals("0")) { System.out.println("VOLTANDO PARA MENU PRINCIPAL...\n");}
            else            { System.out.println("OPÇÃO INVÁLIDA! TENTE NOVAMENTE");}

        }while(!opcion.equals("0"));
    }
}
