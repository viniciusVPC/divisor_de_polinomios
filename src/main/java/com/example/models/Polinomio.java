package com.example.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Polinomio {
    private int grau;
    private Map<Integer, Integer> valores = new HashMap<Integer, Integer>();
    private Scanner input = new Scanner(System.in);
    private boolean carregaResto;
    private Polinomio resto;

    public Polinomio(int grau) {
        this.grau = grau;
        for (int i = 0; i <= grau; i++) {
            valores.put(i, 0);
        }
    }

    public Polinomio() {

    }

    public void setResto(Polinomio resto) {
        carregaResto = true;
        this.resto = resto;
    }

    public void insereValores() {
        for (int i = grau; i >= 0; i--) {
            exibePolinomio();
            System.out.print("Insira o valor do " + i + "º grau do polinômio: ");
            valores.put(i, input.nextInt());
        }
        System.out.println("Polinômio criado.");
        exibePolinomioFinal();
    }

    public void insereValor(int index, int valor) {
        valores.put(index, valor);
    }

    public void resetaGrau() {
        grau = valores.size() - 1;
    }

    public void exibePolinomio() {
        for (int j = grau; j >= 0; j--) {
            if (valores.get(j) == 0) {
                System.out.printf("_");
            } else
                System.out.printf("%+d", valores.get(j));
            if (j == 0) {
                System.out.printf(" ");
            } else
                System.out.printf("X^%d ", j);
        }
        System.out.println("");
    }

    public void exibePolinomioFinal() {
        for (int j = grau; j >= 0; j--) {
            if (valores.get(j) == 0) {
                System.out.printf("");
            } else {
                if (valores.get(j) == 1)
                    System.out.printf("");
                else if (valores.get(j) == -1)
                    System.out.printf("-");
                else
                    System.out.printf("%+d", valores.get(j));
                if (j == 0) {
                    System.out.printf(" ");
                } else
                    System.out.printf("X^%d ", j);
            }
        }
        System.out.println("");
        if (carregaResto) {
            System.out.println("Resto: ");
            resto.exibePolinomioFinal();
        }
    }

    public int getGrau() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    public int getValor(int index) {
        return valores.get(index);
    }

}
