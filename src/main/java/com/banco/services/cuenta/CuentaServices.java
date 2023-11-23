package com.banco.services.cuenta;

import com.banco.domain.Cuenta;

import java.util.ArrayList;

public interface CuentaServices {
    void consultarSaldo(ArrayList<Cuenta> cuentas);
    void retirarSaldo(ArrayList<Cuenta> cuentas);
    Cuenta getCuenta(ArrayList<Cuenta> cuentas, String id);
    void modGiro(ArrayList<Cuenta> cuentas);
    void interesCuenta(ArrayList<Cuenta> cuentas);
}
