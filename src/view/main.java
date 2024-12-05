package view;

import utils.ClearScreen;
import java.util.Scanner;

public class main {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);  // Manter scanner na classe main
        String opcion;

        do {
            ClearScreen.clear();
            System.out.println("========= MENU INICIAL =========");
            System.out.println("1 - REALIZAR LOGIN");
            System.out.println("2 - REALIZAR CADASTRO");
            System.out.println("0 - SAIR");
            System.out.print("ESCOLHA UMA OPÇÃO: ");
            opcion = scanner.nextLine();

            if(opcion.equals("1")) { loginView.logar(scanner); continue;}
            if(opcion.equals("2")) { cadastroUsuarioView.cadastrar(scanner); continue;}

            if(opcion.equals("0")) { System.out.println("SAINDO DO SISTEMA...\n"); }
            else { System.out.println("OPÇÃO INVÁLIDA! TENTE NOVAMENTE"); }

        } while (!opcion.equals("0"));

        scanner.close();  // Fechar o scanner no final da execução

    }

}
