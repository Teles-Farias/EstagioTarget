package com.example.meuprojeto;

import java.util.Scanner;

public class InverterStringApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Digite as strings que deseja inverter.");
        System.out.println("Digite 'sair' para encerrar.");

        while (true) {
            System.out.print("Digite uma string: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("sair")) {
                break;
            }

            String reversed = inverterString(input);
            System.out.println("String invertida: " + reversed);
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }

    private static String inverterString(String str) {
        char[] caracteres = str.toCharArray();
        int inicio = 0;
        int fim = caracteres.length - 1;

        while (inicio < fim) {
            // Troca os caracteres
            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;

            // Move os índices
            inicio++;
            fim--;
        }

        return new String(caracteres);
    }
}
