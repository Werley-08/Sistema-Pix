package model;

import java.util.UUID;

public class chaveAleatoriaModel {
    public static String gerarChaveAleatoria() {
        return UUID.randomUUID().toString();
    }
}
