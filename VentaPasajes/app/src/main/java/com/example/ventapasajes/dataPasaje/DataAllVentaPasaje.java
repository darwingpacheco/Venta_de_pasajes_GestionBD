package com.example.ventapasajes.dataPasaje;

import org.threeten.bp.LocalTime;
import java.util.List;

public class DataAllVentaPasaje {

    private String ubicacionOrigen;
    private String ubicacionDestino;
    private String nombrePasajero;
    private String numDocumentoPasajero;
    private String numTelefonoPasajero;
    private LocalTime horaRecogidaPasajero;
    private String nombreChoferRecogida;
    private String placaBusRecogida;
    private String numeroBusRecogida;
    private int cantidadPuestos;
    private List<Integer> asientosSeleccionados;

    // Getters y Setters

    public String getUbicacionOrigen() {
        return ubicacionOrigen;
    }

    public void setUbicacionOrigen(String ubicacionOrigen) {
        this.ubicacionOrigen = ubicacionOrigen;
    }

    public String getUbicacionDestino() {
        return ubicacionDestino;
    }

    public void setUbicacionDestino(String ubicacionDestino) {
        this.ubicacionDestino = ubicacionDestino;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public String getNumDocumentoPasajero() {
        return numDocumentoPasajero;
    }

    public void setNumDocumentoPasajero(String numDocumentoPasajero) {
        this.numDocumentoPasajero = numDocumentoPasajero;
    }

    public String getNumTelefonoPasajero() {
        return numTelefonoPasajero;
    }

    public void setNumTelefonoPasajero(String numTelefonoPasajero) {
        this.numTelefonoPasajero = numTelefonoPasajero;
    }

    public LocalTime getHoraRecogidaPasajero() {
        return horaRecogidaPasajero;
    }

    public void setHoraRecogidaPasajero(LocalTime horaRecogidaPasajero) {
        this.horaRecogidaPasajero = horaRecogidaPasajero;
    }

    public String getNombreChoferRecogida() {
        return nombreChoferRecogida;
    }

    public void setNombreChoferRecogida(String nombreChoferRecogida) {
        this.nombreChoferRecogida = nombreChoferRecogida;
    }

    public String getPlacaBusRecogida() {
        return placaBusRecogida;
    }

    public void setPlacaBusRecogida(String placaBusRecogida) {
        this.placaBusRecogida = placaBusRecogida;
    }

    public String getNumeroBusRecogida() {
        return numeroBusRecogida;
    }

    public void setNumeroBusRecogida(String numeroBusRecogida) {
        this.numeroBusRecogida = numeroBusRecogida;
    }

    public int getCantidadPuestos() {
        return cantidadPuestos;
    }

    public void setCantidadPuestos(int cantidadPuestos) {
        this.cantidadPuestos = cantidadPuestos;
    }

    public List<Integer> getAsientosSeleccionados() {
        return asientosSeleccionados;
    }

    public void setAsientosSeleccionados(List<Integer> asientosSeleccionados) {
        this.asientosSeleccionados = asientosSeleccionados;
    }
}