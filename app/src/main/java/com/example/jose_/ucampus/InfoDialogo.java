package com.example.jose_.ucampus;

public class InfoDialogo {

    private String nombreEdifico,nombreEncargado,nombreCordinador;
    private int imagen;

    public InfoDialogo(String nombreEdifico, String nombreEncargado, String nombreCordinador, int imagen) {
        this.nombreEdifico = nombreEdifico;
        this.nombreEncargado = nombreEncargado;
        this.nombreCordinador = nombreCordinador;
        this.imagen = imagen;
    }

    public String getNombreEdifico() {
        return nombreEdifico;
    }

    public void setNombreEdifico(String nombreEdifico) {
        this.nombreEdifico = nombreEdifico;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public String getNombreCordinador() {
        return nombreCordinador;
    }

    public void setNombreCordinador(String nombreCordinador) {
        this.nombreCordinador = nombreCordinador;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
