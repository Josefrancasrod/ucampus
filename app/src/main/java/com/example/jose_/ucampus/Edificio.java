package com.example.jose_.ucampus;

public class Edificio {



    private String nombreEdifico;
    private int imagen;

    public Edificio(){


    }

    public Edificio(String nombreEdifico, int imagen) {
        this.nombreEdifico = nombreEdifico;
        this.imagen = imagen;
    }

    public String getNombreEdifico() {
        return nombreEdifico;
    }

    public void setNombreEdifico(String nombreEdifico) {
        this.nombreEdifico = nombreEdifico;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
