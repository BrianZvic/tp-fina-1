package com.banco.domain;

import com.banco.enums.CuentaEnum;

public class CuentaCorriente extends Cuenta{
    private double giro;



    public CuentaCorriente(double giro) {
        this.giro = giro;
    }
    public CuentaCorriente() {

    }

    public CuentaCorriente(CuentaEnum tipoCuenta) {
        super(tipoCuenta);
    }

    public double getGiro() {
        return giro;
    }

    public void setGiro(double giro) {
        this.giro = giro;
    }



}
