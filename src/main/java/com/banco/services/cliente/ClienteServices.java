package com.banco.services.cliente;

import com.banco.domain.Banco;
import com.banco.domain.Cliente;
import com.banco.domain.Cuenta;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public interface ClienteServices {

    void addCliente(Banco banco);
    void getAllClientes(Banco banco);
    Optional<Map.Entry<Cliente, ArrayList<Cuenta>>> getClienteByDni(Banco banco);
    void detalleCliente(Optional<Map.Entry<Cliente, ArrayList<Cuenta>>> cliente);

}
