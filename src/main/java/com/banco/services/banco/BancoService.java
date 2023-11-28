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



    void getCliente(Banco banco);


    void ingresarSaldo(ArrayList<Cuenta> cuentas);





}
