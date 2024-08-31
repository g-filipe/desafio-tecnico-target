package org.gfilipe.projects.desafio_5;

import java.util.Scanner;

public class InversaoString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("** Invertendo palavras **");
        System.out.print("Digite uma palavra: ");

        String palavra = sc.next();
        StringBuilder palavraInvertida = new StringBuilder();

        for (int i = palavra.length()-1; i >= 0; i--) {
            palavraInvertida.append(palavra.charAt(i));
        }
        System.out.println("Aqui está a sua palavra invertida: " + palavraInvertida);
    }
}
