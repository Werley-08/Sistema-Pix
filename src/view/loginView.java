package view;

import dao.conexaoDAO;
import utils.ClearScreen;
import java.util.Scanner;

public class loginView {

    public static void logar(Scanner scanner){

        String usuario;
        String senha;
        boolean logado = false;

        do {
            ClearScreen.clear();
            System.out.println("========= LOGIN =========");
            System.out.println("DIGITE SEU USUÁRIO");
            usuario = scanner.nextLine();

            System.out.println("DIGITE SUA SENHA");
            senha = scanner.nextLine();

            // Lógica do Login...

//            if(se der errado){
//
//                System.out.println("Login Incorreto! Deseja Tentar Novamente?");
//
//            }else{
//
//                System.out.println("Entrando no Menu Principal");
//                viewMenuPrincipal.menu();
//
//            }

            new conexaoDAO().connection();
            System.out.println("ENTRANDO NO MENU PRINCIPAL...\n");
            logado = true;
            viewMenuPrincipal.menu(scanner);

        }while(!logado);

    }

}
