package com.example.ventapasajes.dataPasaje;

public class SingletonData {

    private static SingletonData instance;
    private DataAllVentaPasaje dataAllVentaPasaje;

    private SingletonData() {
        dataAllVentaPasaje = new DataAllVentaPasaje();
    }

    public static SingletonData getInstance() {
        if (instance == null) {
            instance = new SingletonData();
        }
        return instance;
    }

    public DataAllVentaPasaje getDataAllVentaPasaje() {
        return dataAllVentaPasaje;
    }

    public void setDataAllVentaPasaje(DataAllVentaPasaje dataAllVentaPasaje) {
        this.dataAllVentaPasaje = dataAllVentaPasaje;
    }
}

