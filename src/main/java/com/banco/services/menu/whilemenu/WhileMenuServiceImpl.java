package com.banco.services.menu.whilemenu;

import com.banco.domain.Banco;
import com.banco.services.archivos.ArchivoService;
import com.banco.services.banco.BancoService;
import com.banco.services.menu.MenuServices;

public class WhileMenuServiceImpl implements WhileMenuServices {
    Banco banco;
    MenuServices menuServices;
    BancoService bancoService;
    ArchivoService archivoService;

    public WhileMenuServiceImpl(Banco banco, MenuServices menuServices, BancoService bancoService, ArchivoService archivoService) {
        this.banco = banco;
        this.menuServices = menuServices;
        this.bancoService = bancoService;
        this.archivoService =archivoService;
    }

    public WhileMenuServiceImpl() {
    }

    @Override
    public void homeMenu() {
        int op;
        do {
            op = menuServices.menuBanco();
            switch (op) {
                case 1 -> bancoService.addCliente(this.banco);
                case 2 -> bancoService.getAllClientes(this.banco);
                case 3 -> bancoService.getCliente(this.banco);
                case 4 -> archivoService.crearCsv(banco);
            }

        }while (op!= 0);
    }
}
