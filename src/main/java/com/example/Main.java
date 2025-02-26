package com.example;

import java.util.Scanner;

import com.example.models.Divisor;
import com.example.models.Polinomio;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem vindo ao divisor de polinômios!");
        System.out.println("Começe indicando qual o grau do Polinômio Dividendo.");
        System.out.print("Grau: ");
        int grau = input.nextInt();
        Polinomio dividendo = new Polinomio(grau);
        dividendo.insereValores();
        System.out.println("Agora indique o grau do segundo polinômio, o Divisor.");
        System.out.print("Grau: ");
        grau = input.nextInt();
        Polinomio divisor = new Polinomio(grau);
        divisor.insereValores();
        System.out.println(
                "Ok! Agora vou dividir o Dividendo pelo Divisor e retornar o Quociente! Se houver um Resto eu também o retornarei!");
        Polinomio quociente = new Polinomio();
        Polinomio quocienteFinal = Divisor.dividirPolinomios(dividendo, divisor, quociente);
        quocienteFinal.resetaGrau();
        System.out.println("Quociente:");
        quocienteFinal.exibePolinomioFinal();
    }
}