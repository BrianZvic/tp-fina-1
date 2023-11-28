package com.banco.services.menu.whilemenu;

import com.banco.domain.Banco;
import com.banco.services.archivos.ArchivoService;
import com.banco.services.banco.BancoService;
import com.banco.services.cliente.ClienteServices;
import com.banco.services.menu.MenuServices;

public class WhileMenuServiceImpl implements WhileMenuServices {
    Banco banco;
    MenuServices menuServices;
    BancoService bancoService;
    ArchivoService archivoService;
    ClienteServices clienteServices;


    public WhileMenuServiceImpl(Banco banco, MenuServices menuServices, BancoService bancoService, ArchivoService archivoService, ClienteServices clienteServices) {
        this.banco = banco;
        this.menuServices = menuServices;
        this.bancoService = bancoService;
        this.archivoService = archivoService;
        this.clienteServices = clienteServices;
    }

    public WhileMenuServiceImpl() {
    }


    @Override
    public void homeMenu() {
        int op;
        do {
            op = menuServices.menuBanco();
            switch (op) {
                case 1 -> this.clienteServices.addCliente(this.banco);
                case 2 -> this.clienteServices.getAllClientes(this.banco);
                case 3 -> bancoService.getCliente(this.banco);
                case 4 -> archivoService.crearCsv(banco);
            }

        }while (op!= 0);
    }
}
