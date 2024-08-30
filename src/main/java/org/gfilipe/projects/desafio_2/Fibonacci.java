package org.gfilipe.projects.desafio_2;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numeroInformado = sc.nextInt();
        int numeroAtual = 1;
        int numeroAnterior = 0;

        while (numeroAtual < numeroInformado) {
            int proximoNumero = numeroAtual + numeroAnterior;

            numeroAnterior = numeroAtual;
            numeroAtual = proximoNumero;
        }

        if (numeroAtual == numeroInformado) {
            System.out.println("O número informado pertence à sequência Fibonnaci");
        } else {
            System.out.println("O número informado não pertence à sequência Fibonnaci");
        }
    }
}

/*2) Dado a sequência de Faturamento, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Faturamento e retorne uma mensagem avisando se o número informado pertence ou não a sequência.

IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código;*/