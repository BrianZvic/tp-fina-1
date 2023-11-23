package com.banco.services.archivos;

import com.banco.domain.Banco;
import com.banco.domain.Cliente;
import com.banco.domain.Cuenta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface ArchivoService {
    void crearCsv(Banco banco) ;
}
