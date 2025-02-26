package com.example.models;

public class Divisor {
    static public Polinomio dividirPolinomios(Polinomio dividendo, Polinomio divisor, Polinomio quociente) {
        int grauQuociente = dividendo.getGrau() - divisor.getGrau();
        quociente.setGrau(grauQuociente);
        int valor = dividendo.getValor(dividendo.getGrau()) / divisor.getValor(divisor.getGrau());
        quociente.insereValor(grauQuociente, valor);
        int grauTemp = quociente.getGrau() + divisor.getGrau();
        Polinomio polinomioTemp = criaPolinomioTemp(grauTemp, valor, divisor, quociente);
        Polinomio proximoASerDividido = subtraiPolinomios(dividendo, polinomioTemp);
        if (proximoASerDividido.getGrau() >= divisor.getGrau()) {
            Polinomio quocienteTemp = dividirPolinomios(proximoASerDividido, divisor, quociente);
            return quocienteTemp;
        } else {
            // Próximo a ser dividido é o resto
            quociente.setResto(proximoASerDividido);
            return quociente;
        }
    }

    static private Polinomio criaPolinomioTemp(int grau, int valor, Polinomio divisor, Polinomio quociente) {
        Polinomio polinomioTemp = new Polinomio(grau);
        for (int i = divisor.getGrau(); i >= 0; i--) {
            polinomioTemp.insereValor(i + quociente.getGrau(), valor * divisor.getValor(i));
        }
        return polinomioTemp;
    }

    static private Polinomio subtraiPolinomios(Polinomio dividendo, Polinomio temp) {
        Polinomio resultado = new Polinomio(dividendo.getGrau() - 1);
        for (int i = resultado.getGrau(); i >= 0; i--) {
            resultado.insereValor(i, dividendo.getValor(i) - temp.getValor(i));
        }
        return resultado;
    }
}
