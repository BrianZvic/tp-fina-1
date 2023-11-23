package com.banco.domain;


import com.banco.enums.CuentaEnum;

public class CuentaAhorro extends Cuenta {
    private double tazaInteres;



    public CuentaAhorro(double tazaInteres) {
        this.tazaInteres = tazaInteres;
    }

    public CuentaAhorro(CuentaEnum tipoCuenta) {
        super(tipoCuenta);


    }

    public CuentaAhorro(CuentaEnum tipoCuenta,double saldo) {
        super(tipoCuenta,saldo);

    }

    public double getTazaInteres() {
        return tazaInteres;
    }

    public void setTazaInteres(double tazaInteres) {
        this.tazaInteres = tazaInteres;
    }




}

