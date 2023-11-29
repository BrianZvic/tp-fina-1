package com.banco.services.pantalla;

import com.banco.domain.Cliente;
import com.banco.domain.Cuenta;
import com.banco.domain.CuentaAhorro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface PantallaService {

    void getAllClientes(Map.Entry<Cliente, ArrayList<Cuenta>> cl);

    void forCuenta(ArrayList<Cuenta> cuenta);

    String pantallaString(String string);
    int pantallaInt(String string);
    float pantallaFloat(String string);
}
