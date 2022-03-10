package com.example.edt01;

public class Calculator {
    //independiente de la actividad
    public double suma(double num1, double num2){
        //si el nombre del metodo esta en gris no lo estan usando
        return num1+num2;
    }

    public double resta(double num1, double num2){
        return num1-num2;
    }

    public double multi(double num1, double num2){
        return num1*num2;
    }

    public double div(double num1, double num2){
        return num1/num2;
    }
}
