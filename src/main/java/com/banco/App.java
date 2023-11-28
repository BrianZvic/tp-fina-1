package com.banco;

import com.banco.dbbanco.Db;
import com.banco.domain.*;
import com.banco.enums.CuentaEnum;
import com.banco.services.archivos.ArchivoServicesImpl;
import com.banco.services.banco.BancoService;
import com.banco.services.banco.BancoServiceIml;
import com.banco.services.cliente.ClienteServicesImpl;
import com.banco.services.cuenta.CuentaServicesImpl;
import com.banco.services.menu.MenuServiceImpl;
import com.banco.services.menu.whilemenu.WhileMenuServiceImpl;
import com.banco.services.menu.whilemenu.WhileMenuServices;
import com.banco.services.pantalla.PantallaServiceImp;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App

{
    public static void main( String[] args ) {

        Banco banco1 = new Banco("Zviky", null);
        Db db = new Db(banco1);
        db.setUser();

        WhileMenuServices main = new WhileMenuServiceImpl(banco1,new MenuServiceImpl(),
                new BancoServiceIml(new MenuServiceImpl(), new PantallaServiceImp(),
                        new WhileMenuServiceImpl(), new CuentaServicesImpl(),new ClienteServicesImpl(new MenuServiceImpl(),new PantallaServiceImp())),new ArchivoServicesImpl(),
                new ClienteServicesImpl(new MenuServiceImpl(),new PantallaServiceImp()));

        main.homeMenu();




    }


}
