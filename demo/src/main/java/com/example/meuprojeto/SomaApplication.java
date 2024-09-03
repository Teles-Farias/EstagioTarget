package com.example.meuprojeto;

public class SomaApplication {

    public static void main(String[] args) {
        int INDICE = 13;
        int SOMA = 0;
        int K = 0;

        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }

        System.out.println("O valor de SOMA ao final do processamento é: " + SOMA);

        //O valor obtido é 91//
    }
}
