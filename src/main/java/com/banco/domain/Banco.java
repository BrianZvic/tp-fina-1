package com.banco.domain;
import java.util.ArrayList;
import java.util.HashMap;

public class Banco {
    private String nombre;
    private Direccion direccion;
    private HashMap<Cliente, ArrayList<Cuenta>> clientes;

    public Banco(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.clientes = new HashMap<>();
    }

    public Banco() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public HashMap<Cliente, ArrayList<Cuenta>> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<Cliente, ArrayList<Cuenta>> clientes) {
        this.clientes = clientes;
    }

}
