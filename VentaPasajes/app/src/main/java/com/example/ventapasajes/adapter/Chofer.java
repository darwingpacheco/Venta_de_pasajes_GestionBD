package com.example.ventapasajes.adapter;

public class Chofer {

    private String nombre;
    private String numeroPlaca;
    private String numeroBuseta;

    public Chofer(String nombre, String numeroPlaca, String numeroBuseta) {
        this.nombre = nombre;
        this.numeroPlaca = numeroPlaca;
        this.numeroBuseta = numeroBuseta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public String getNumeroBuseta() {
        return numeroBuseta;
    }
}
