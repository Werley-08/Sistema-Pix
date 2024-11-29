package view;

import utils.ClearScreen;
import java.util.Scanner;

public class contaBancariaView {

    public static void menu(Scanner scanner){

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
            //if(opcion.equals("3")) { contaBancariaController.associarChavePix();}
            if(opcion.equals("0")) { System.out.println("VOLTANDO PARA MENU PRINCIPAL...\n");}
            else            { System.out.println("OPÇÃO INVÁLIDA! TENTE NOVAMENTE");}

        }while(!opcion.equals("0"));
    }
}
