package com.banco.dbbanco;

import com.banco.domain.*;
import com.banco.enums.CuentaEnum;

import java.time.LocalDate;
import java.util.ArrayList;

public class Db {
    private Banco banco;


    public Db(Banco banco) {
        this.banco = banco;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void setUser(){
        Cliente cliente1 = new Cliente(12324123, "Jose", "Perez", new Direccion("Echeverrias", 123, "San Justo", "Catamarca"), LocalDate.of(1999, 12, 30));
        Cliente cliente2 = new Cliente(98765432, "Ana", "Gomez", new Direccion("Rivadavia", 456, "La Matanza", "Buenos Aires"), LocalDate.of(1995, 5, 15));
        Cliente cliente3 = new Cliente(55555555, "Carlos", "Rodriguez", new Direccion("Belgrano", 789, "Morón", "Buenos Aires"), LocalDate.of(1980, 8, 22));
        Cliente cliente4 = new Cliente(11112222, "Laura", "Lopez", new Direccion("Sarmiento", 321, "Lomas de Zamora", "Buenos Aires"), LocalDate.of(1992, 3, 10));
        Cliente cliente5 = new Cliente(33334444, "Martin", "Fernandez", new Direccion("Alsina", 555, "Quilmes", "Buenos Aires"), LocalDate.of(1988, 6, 5));
        Cliente cliente6 = new Cliente(66667777, "Silvia", "Martinez", new Direccion("Mitre", 999, "Avellaneda", "Buenos Aires"), LocalDate.of(1975, 9, 18));
        Cliente cliente7 = new Cliente(88889999, "Lucas", "Gutierrez", new Direccion("San Martin", 777, "Berazategui", "Buenos Aires"), LocalDate.of(1990, 11, 25));
        Cliente cliente8 = new Cliente(44446666, "Paula", "Diaz", new Direccion("Colon", 888, "Banfield", "Buenos Aires"), LocalDate.of(1983, 4, 12));
        Cliente cliente9 = new Cliente(22223333, "Federico", "Alvarez", new Direccion("Roca", 222, "Adrogué", "Buenos Aires"), LocalDate.of(1997, 7, 8));
        Cliente cliente10 = new Cliente(77778888, "Marina", "Luna", new Direccion("Sanchez", 333, "Ezeiza", "Buenos Aires"), LocalDate.of(1985, 2, 20));

        ArrayList<Cuenta> cuentasCliente1 = new ArrayList<>();
        cuentasCliente1.add(new CuentaAhorro(CuentaEnum.CAJA_AHORRO, 1500.00));

        ArrayList<Cuenta>  cuentasCliente2 = new ArrayList<>();
        cuentasCliente2.add(new CuentaAhorro(CuentaEnum.CAJA_AHORRO, 1500.00));

        ArrayList<Cuenta>  cuentasCliente3 = new ArrayList<>();
        cuentasCliente3.add(new CuentaAhorro(CuentaEnum.CAJA_AHORRO, 1200.00));

        ArrayList<Cuenta>  cuentasCliente4 = new ArrayList<>();
        cuentasCliente4.add(new CuentaAhorro(CuentaEnum.CAJA_AHORRO, 800.00));

        ArrayList<Cuenta>  cuentasCliente5 = new ArrayList<>();
        cuentasCliente5.add(new CuentaAhorro(CuentaEnum.CAJA_AHORRO, 2000.00));

        ArrayList<Cuenta>  cuentasCliente6 = new ArrayList<>();
        cuentasCliente6.add(new CuentaAhorro(CuentaEnum.CAJA_AHORRO, 1800.00));
        cuentasCliente6.add(new CuentaAhorro(CuentaEnum.CAJA_AHORRO, 1200.00));

        ArrayList<Cuenta>  cuentasCliente7 = new ArrayList<>();
        cuentasCliente7.add(new CuentaAhorro(CuentaEnum.CAJA_AHORRO, 700.00));

        ArrayList<Cuenta>  cuentasCliente8 = new ArrayList<>();
        cuentasCliente8.add(new CuentaAhorro(CuentaEnum.CAJA_AHORRO, 1500.0));

        ArrayList<Cuenta> cuentasCliente9 = new ArrayList<>();
        cuentasCliente9.add(new CuentaAhorro(CuentaEnum.CAJA_AHORRO, 800.0));

        ArrayList<Cuenta>  cuentasCliente10 = new ArrayList<>();
        cuentasCliente10.add(new CuentaAhorro(CuentaEnum.CAJA_AHORRO, 400.0));

        getBanco().getClientes().put(cliente1,cuentasCliente1);
        getBanco().getClientes().put(cliente2,cuentasCliente2);
        getBanco().getClientes().put(cliente3,cuentasCliente3);
        getBanco().getClientes().put(cliente4,cuentasCliente4);
        getBanco().getClientes().put(cliente5,cuentasCliente5);
        getBanco().getClientes().put(cliente6,cuentasCliente6);
        getBanco().getClientes().put(cliente7,cuentasCliente7);
        getBanco().getClientes().put(cliente8,cuentasCliente8);
        getBanco().getClientes().put(cliente9,cuentasCliente9);
        getBanco().getClientes().put(cliente10,cuentasCliente10);

    }
}
