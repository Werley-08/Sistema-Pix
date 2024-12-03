package view;

import controller.usuarioController;
import model.usuarioModel;
import utils.ClearScreen;
import java.util.Scanner;

public class loginView{

    public static void logar(Scanner scanner){

        String login;
        String senha;
        boolean logado = false;

        do {
            ClearScreen.clear();
            System.out.println("========= LOGIN =========");
            System.out.println("DIGITE SEU USUÁRIO");
            login = scanner.nextLine();
            System.out.println("DIGITE SUA SENHA");
            senha = scanner.nextLine();

            usuarioModel usuarioLogado = usuarioController.logarUsuario(login, senha);

            if(usuarioLogado == null){

                System.out.println("Login Incorreto!");

            }else{

                System.out.println("ENTRANDO NO MENU PRINCIPAL...\n");
                viewMenuPrincipal.menu(scanner, usuarioLogado);
                logado = true;

            }

        }while(!logado);

    }

}
