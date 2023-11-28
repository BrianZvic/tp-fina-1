package com.banco.services.cliente;

import com.banco.domain.Banco;
import com.banco.domain.Cliente;
import com.banco.domain.Cuenta;
import com.banco.entrada.ImputConsoleServices;
import com.banco.services.banco.BancoServiceIml;
import com.banco.services.menu.MenuServiceImpl;
import com.banco.services.menu.MenuServices;
import com.banco.services.pantalla.PantallaService;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class ClienteServicesImpl implements ClienteServices{

    MenuServices menuServices;
    PantallaService pantallaService;

    public ClienteServicesImpl(MenuServices menuServices, PantallaService pantallaService) {
        this.menuServices = menuServices;
        this.pantallaService = pantallaService;
    }

    public MenuServices getMenuServices() {
        return menuServices;
    }

    public PantallaService getPantallaService() {
        return pantallaService;
    }

    @Override
    public void addCliente(Banco banco) {
        Cliente cliente = getMenuServices().menuAddCliente();
        banco.getClientes().put(cliente,new ArrayList<>());
        System.out.println(MenuServiceImpl.USUARIO_AGREGADO_CORRECTAMENTE);
    }

    @Override
    public void getAllClientes(Banco banco) {
        System.out.println("\n");
        for (Map.Entry<Cliente, ArrayList<Cuenta>> entry : banco.getClientes().entrySet()){
            getPantallaService().getAllClientes(entry);
        }
    }

    @Override
    public Optional<Map.Entry<Cliente, ArrayList<Cuenta>>> getClienteByDni(Banco banco) {
        System.out.print(BancoServiceIml.INGRESE_DNI_CLIENTE);
        int dni = ImputConsoleServices.getScanner().nextInt();
        for (Map.Entry<Cliente,ArrayList<Cuenta>> client: banco.getClientes().entrySet()) {
            if (client.getKey().getDni() == dni){
                return Optional.of(client);
            }
        }
        return Optional.empty();
    }

    @Override
    public void detalleCliente(Optional<Map.Entry<Cliente, ArrayList<Cuenta>>> cliente) {
        if(cliente.isPresent()){
            getPantallaService().getAllClientes(cliente.get());
        }else {
            System.out.println(BancoServiceIml.NO_SE_HA_ENCONTRADO_CLIENTE);
        }
    }
}
