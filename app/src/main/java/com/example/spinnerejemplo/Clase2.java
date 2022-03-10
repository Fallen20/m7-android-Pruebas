package com.example.spinnerejemplo;

public class Clase2 {
    private String nombreOriginal;
    private int imagenOriginal;//las img son int

    public Clase2(String nombre, int imagen) {
        this.nombreOriginal = nombre;
        this.imagenOriginal = imagen;
    }

    public String getNombreOriginal() {
        return nombreOriginal;
    }

    public void setNombreOriginal(String nombreOriginal) {
        this.nombreOriginal = nombreOriginal;
    }

    public int getImagenOriginal() {
        return imagenOriginal;
    }

    public void setImagenOriginal(int imagenOriginal) {
        this.imagenOriginal = imagenOriginal;
    }

    @Override
    public String toString() {
        return "Clase2{" +
                "nombre='" + nombreOriginal + '\'' +
                ", imagen=" + imagenOriginal +
                '}';
    }
}
