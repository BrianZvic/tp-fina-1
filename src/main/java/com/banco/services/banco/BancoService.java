package com.banco.services.banco;

import com.banco.domain.Banco;
import com.banco.domain.Cliente;
import com.banco.domain.Cuenta;
import com.banco.domain.CuentaCorriente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface BancoService {
    void addCliente(Banco banco);
    void deleteCuenta(Optional<Map.Entry<Cliente, ArrayList<Cuenta>>> cliente);
    Optional<Map.Entry<Cliente, ArrayList<Cuenta>>>getClienteByDni(Banco banco);
    void getAllClientes(Banco banco);
    void detalleCliente(Optional<Map.Entry<Cliente, ArrayList<Cuenta>>> cliente);
    void getCliente(Banco banco);
    void createCuenta(Optional<Map.Entry<Cliente, ArrayList<Cuenta>>> cliente);

    void ingresarSaldo(ArrayList<Cuenta> cuentas);





}
