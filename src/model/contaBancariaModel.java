package model;

import java.util.Random;

public class contaBancariaModel {
    String conta;
    String agencia;
    double saldo;

    public contaBancariaModel(double saldo) {
        this.conta = gerarNumeroConta();
        this.agencia = gerarAgencia();
        this.saldo = saldo;
    }



    public String gerarAgencia() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    public String gerarNumeroConta() {
        Random random = new Random();

        int tamanho = 8 + random.nextInt(13);
        StringBuilder conta = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            conta.append(random.nextInt(10));
        }
        return conta.toString();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
}
