package com.banco.domain;
import java.time.LocalDate;
import java.util.UUID;

public class Cliente {
    private UUID id;
    private int dni;
    private String nombre;
    private String apellido;
    private Direccion direccion;
    private int edad;
    private LocalDate fechNac;


    public Cliente(int dni, String nombre, String apellido, Direccion direccion, LocalDate fechNac) {
        this.id = UUID.randomUUID();
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fechNac = fechNac;
        this.edad = setEdad(fechNac);
    }

    public Cliente() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    private int setEdad(LocalDate fechNac) {
        int anio = LocalDate.now().getYear() - fechNac.getYear();
        if(fechNac.getMonthValue() > LocalDate.now().getMonthValue()){
            return anio -1;
        }else{
            return anio;
        }
    }

    public LocalDate getFechNac() {
        return fechNac;
    }

    public void setFechNac(LocalDate fechNac) {
        this.fechNac = fechNac;
    }


}
