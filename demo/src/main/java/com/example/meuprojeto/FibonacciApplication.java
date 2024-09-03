package com.example.meuprojeto;

import java.util.Scanner;

public class FibonacciApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int number;

        System.out.println("Digite números para verificar se pertencem à sequência de Fibonacci.");
        System.out.println("Digite 'sair' para encerrar.");

        while (true) {
            System.out.print("Digite um número: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                number = Integer.parseInt(input);
                if (isFibonacci(number)) {
                    System.out.println(number + " pertence à sequência de Fibonacci.");
                } else {
                    System.out.println(number + " não pertence à sequência de Fibonacci.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro ou 'sair' para encerrar.");
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }

    private static boolean isFibonacci(int number) {
        if (number < 0) return false;

        int a = 0;
        int b = 1;

        while (b < number) {
            int next = a + b;
            a = b;
            b = next;
        }

        return b == number;
    }
}
