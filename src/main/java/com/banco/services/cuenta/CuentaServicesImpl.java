package com.banco.services.cuenta;

import com.banco.domain.Cliente;
import com.banco.domain.Cuenta;
import com.banco.domain.CuentaAhorro;
import com.banco.domain.CuentaCorriente;
import com.banco.entrada.ImputConsoleServices;
import com.banco.enums.CuentaEnum;
import com.banco.services.banco.BancoServiceIml;
import com.banco.services.menu.MenuServiceImpl;
import com.banco.services.menu.MenuServices;
import com.banco.services.pantalla.PantallaService;
import com.banco.services.pantalla.PantallaServiceImp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class CuentaServicesImpl implements CuentaServices{

    public static final String VALOR_SUPERA_SALDO_CUENTA= "El valor ingresaro supera el saldo de la cuenta";
    public static final String EXTRACCION_EXITOSA= "Extraccion exitosa";
    public static final String INGRESE_INTERESES = "Ingrese el interes: ";
    public static final String OPERACION_EXITOSA = "Operacion exitosa";
    public static final String OPERACION_INVALIDA = "Operacion invalida";

    private MenuServices menuServices = new MenuServiceImpl();
    private PantallaService pantallaService = new PantallaServiceImp();

    public CuentaServicesImpl() {
    }

    public MenuServices getMenuServices() {
        return menuServices;
    }

    public PantallaService getPantallaService() {
        return pantallaService;
    }

    @Override
    public void consultarSaldo(ArrayList<Cuenta> cuentas) {
        DecimalFormat df = new DecimalFormat("#.00");
        double saldo = 0;
        for (Cuenta cuenta: cuentas) {
            System.out.println("".repeat(30));
            System.out.printf("Cuenta: %s - Tipo: %s - Saldo: %s\n",cuenta.getId().toString(),cuenta.getTipoCuenta().toString(),
                    df.format(cuenta.getSaldo()));

            saldo += cuenta.getSaldo();
        }
        System.out.println("-".repeat(30));
        String print = saldo > 0?"Total de las cuentas: " + df.format(saldo): "No hay cuentas activas";
        System.out.println(print);

    }
    public Cuenta getCuenta(ArrayList<Cuenta> cuentas, String id) {
        for (Cuenta cuenta: cuentas) {
            if (id.equals(cuenta.getId().toString())){
                return cuenta;
            }
        }
        return null;
    };

    @Override
    public void retirarSaldo(ArrayList<Cuenta> cuentas) {
        consultarSaldo(cuentas);
        Cuenta cta = getCuenta(cuentas,ImputConsoleServices.getNumeroCuenta());
        double saldo = ImputConsoleServices.getIngresoSaldo();
        if (cta.getTipoCuenta().equals(CuentaEnum.CUENTA_CORRIENTE)){
            CuentaCorriente cCorriente = (CuentaCorriente) cta;
            if (saldo < cCorriente.getGiro()){
                cta.setSaldo(cta.getSaldo() - saldo);
                System.out.println(EXTRACCION_EXITOSA);
            }else {
                System.out.println(VALOR_SUPERA_SALDO_CUENTA);
            }

        }else {
            if (saldo < cta.getSaldo()){
                cta.setSaldo(cta.getSaldo() - saldo);
                System.out.println(EXTRACCION_EXITOSA);
            }
            else {
                System.out.println(VALOR_SUPERA_SALDO_CUENTA);
            }
        }

    }
    @Override
    public void modGiro(ArrayList<Cuenta> cuentas) {
        consultarSaldo(cuentas);
        Cuenta cta = getCuenta(cuentas,ImputConsoleServices.getNumeroCuenta());
        if(cta.getTipoCuenta().equals(CuentaEnum.CUENTA_CORRIENTE)){
            CuentaCorriente ctaCriente = (CuentaCorriente) cta;
            System.out.print(BancoServiceIml.INGRESE_MONTO_GIRO_DESCUBIERTO + ": ");
            double saldoGiro= ImputConsoleServices.getScanner().nextDouble();
            ctaCriente.setGiro(saldoGiro);
            System.out.println(BancoServiceIml.MONTO_GIRO_MODIFICADO);
        }else {
            System.out.println(BancoServiceIml.CUENTA_INVALIDA);
        }
    }

    @Override
    public void interesCuenta(ArrayList<Cuenta> cuentas) {
        consultarSaldo(cuentas);
        Cuenta cuenta = getCuenta(cuentas,ImputConsoleServices.getNumeroCuenta());
        System.out.print(INGRESE_INTERESES);
        int inter = ImputConsoleServices.getScanner().nextInt();

        if (inter > 0){
            double porc = (float)inter/100;
            cuenta.setSaldo(cuenta.getSaldo() + (cuenta.getSaldo() * porc));
            System.out.println(OPERACION_EXITOSA);
        }else {
            System.out.println(OPERACION_INVALIDA);
        }
    }

    @Override
    public void createCuenta(ArrayList<Cuenta> cuentas) {
        int opc = getMenuServices().menuCrearCuenta();
        if (opc == 1){
                cuentas.add(new CuentaCorriente(CuentaEnum.CUENTA_CORRIENTE));
                System.out.println(BancoServiceIml.CUENTA_CREADA_CORRECTAMENTE);
            } else if (opc == 2) {
                cuentas.add(new CuentaAhorro(CuentaEnum.CAJA_AHORRO));
                System.out.println(BancoServiceIml.CUENTA_CREADA_CORRECTAMENTE);
            }



    }

    @Override
    public void deleteCuenta(ArrayList<Cuenta> cuentas) {
        getPantallaService().forCuenta(cuentas);
        String nCuenta = ImputConsoleServices.getNumeroCuenta();
        for (int i = 0; i < cuentas.size(); i++ ){
            cuentas.removeIf(e -> nCuenta.equals(e.getId().toString()));
        }
        System.out.println(CuentaServicesImpl.OPERACION_EXITOSA);
        getPantallaService().forCuenta(cuentas);
    }
}
