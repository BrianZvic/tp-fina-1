package com.banco.services.menu;

import com.banco.domain.Cliente;
import com.banco.domain.Cuenta;
import com.banco.domain.Direccion;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public interface MenuServices {
    public static final String USUARIO_AGREGADO_CORRECTAMENTE = "Usuario agregado correctamente!!";
    public Cliente menuAddCliente();
    public Direccion menuAddDireccion();

    public void menuAddCuenta();
    int menuGetCliente(Cliente cliente);
    int menuCrearCuenta();
    int menuBanco();
}
