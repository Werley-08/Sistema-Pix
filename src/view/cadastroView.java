package view;

import controller.usuarioController;
import dao.conexaoDAO;
import model.usuarioModel;
import utils.ClearScreen;

import java.time.LocalDate;
import java.util.Scanner;

public class cadastroView{

    public static void cadastrar(Scanner scanner){

        String login;
        String senha;
        String nome;
        LocalDate dataDeNascimento;
        String tipoPessoa;
        String cpf;
        String cnpj;
        String telefone;
        String email;

        boolean cadastrado = false;

        do {
            ClearScreen.clear();
            System.out.println("========= LOGIN =========");
            System.out.println("DIGITE 'F' SE FOR PESSOA FÍSICA E 'J' SE FOR PESSOA JURÍDICA ");
            tipoPessoa = scanner.nextLine();

            if(tipoPessoa.equals("F")){

                System.out.println("DIGITE SEU CPF");
                cpf = scanner.nextLine();
                cnpj = null;

            }else if(tipoPessoa.equals("F")){

                System.out.println("DIGITE SEU CPNJ");
                cnpj = scanner.nextLine();
                cpf = null;

            }else{

                System.out.println("CAMPO INCORRETO! REALIZE SEU CADASTRO NOVAMENTE...");
                continue;

            }
            System.out.println("ESCOLHA UM LOGIN");
            login = scanner.nextLine();
            System.out.println("ESCOLHA UMA SENHA");
            senha = scanner.nextLine();
            System.out.println("DIGITE SEU NOME");
            nome = scanner.nextLine();
            System.out.println("DIGITE SUA DATA DE NASCIMENTO");
            dataDeNascimento = LocalDate.parse(scanner.nextLine());
            System.out.println("DIGITE SEU TELEFONE");
            telefone = scanner.nextLine();
            System.out.println("DIGITE SEU EMAIL");
            email = scanner.nextLine();

            usuarioModel usuario = new usuarioModel(login, senha, nome, dataDeNascimento, tipoPessoa, cpf, cnpj, telefone, email);

            usuarioController.adicionarUsuario(usuario);

            System.out.println("CADASTRO REALIZADO COM SUCESSO!\n");
            System.out.println("REALIZE LOGIN PARA ENTRAR NO SISTEMA\n");
            cadastrado = true;

        }while(!cadastrado);

    }

}


