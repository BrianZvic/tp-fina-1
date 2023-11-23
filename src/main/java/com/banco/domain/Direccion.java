package com.banco.domain;

public class Direccion {
    private String nombreCalle;
    private int altura;
    private String localidad;
    private String provincia;

    public Direccion(String nombreCalle, int altura, String localidad, String provincia) {
        this.nombreCalle = nombreCalle;
        this.altura = altura;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Direccion() {
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
