package model;

import java.time.LocalDate;

public class usuarioModel{

        // Atributos
        private int id;
        private String login;
        private String senha;
        private String nome;
        private LocalDate dataDeNascimento;
        private String tipoPessoa;
        private String cpf;
        private String cnpj;
        private String telefone;
        private String email;


        public usuarioModel(){

        }

        public usuarioModel(String login, String senha, String nome, LocalDate dataDeNascimento, String tipoPessoa, String cpf, String cnpj, String telefone, String email){

            this.login = login;
            this.senha = senha;
            this.nome = nome;
            this.dataDeNascimento = dataDeNascimento;
            this.tipoPessoa = tipoPessoa;
            this.cpf = cpf;
            this.cnpj = cnpj;
            this.telefone = telefone;
            this.email = email;
        }

//    // Verifica se é pessoa física ou jurídica
//    public boolean isCpfOrCnpjValid() {
//        if ("Fisica".equalsIgnoreCase(tipoPessoa) && cpf != null && !cpf.isEmpty()) {
//            return cnpj == null || cnpj.isEmpty();
//        } else if ("Juridica".equalsIgnoreCase(tipoPessoa) && cnpj != null && !cnpj.isEmpty()) {
//            return cpf == null || cpf.isEmpty();
//        }
//        return false;
//    }

    public void exibirUsuario(){

        System.out.println("ID: " + id);
        System.out.println("Login: " + login);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo de Pessoa: " + tipoPessoa);
        System.out.println("CPF: " + (cpf != null ? cpf : "N/A"));
        System.out.println("CNPJ: " + (cnpj != null ? cnpj : "N/A"));
        System.out.println("Telefone: " + telefone);
        System.out.println("E-mail: " + email);

    }

//    public boolean realizarLogin(String login, String senha){
//
//    }

//    public void editarDados(S){
//
//    }
//
//    public void removerUsuario(){
//
//    }

        // Getters e Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public LocalDate getDataDeNascimento() {
            return dataDeNascimento;
        }

        public void setDataDeNascimento(LocalDate dataDeNascimento) {
            this.dataDeNascimento = dataDeNascimento;
        }

        public String getTipoPessoa() {
            return tipoPessoa;
        }

        public void setTipoPessoa(String tipoPessoa) {
            this.tipoPessoa = tipoPessoa;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getCnpj() {
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }
