package com.banco.services.banco;
import com.banco.domain.*;
import com.banco.entrada.ImputConsoleServices;
import com.banco.enums.CuentaEnum;
import com.banco.services.cliente.ClienteServices;
import com.banco.services.cuenta.CuentaServices;
import com.banco.services.cuenta.CuentaServicesImpl;
import com.banco.services.menu.MenuServiceImpl;
import com.banco.services.menu.MenuServices;
import com.banco.services.menu.whilemenu.WhileMenuServices;
import com.banco.services.pantalla.PantallaServiceImp;
import java.util.*;


public class BancoServiceIml implements BancoService{
        private MenuServices menuServices;
        private PantallaServiceImp pantalla;
        private WhileMenuServices whileMenuServices;
        private CuentaServices cuentaServices;
        private ClienteServices clienteServices;


        public static final String NO_SE_HA_ENCONTRADO_CLIENTE = "No se ha encontrado al cliente";
        public static final String CUENTA_CREADA_CORRECTAMENTE = "Cuenta creada correctamente";
        public static final String NO_SE_HA_ENCONTRADO_CUENTA = "No se ha encontrado la cuenta";
        public static final String INGRESE_CANTIDAD_SALDO = "Ingrese la cantidad de dinero que quiere ingresar";
        public static final String SALDO_AGREGADO_CORRECTAMENTE = "Saldo agregado correctamente";
        public static final String SALDO_INVALIDO = "Saldo invalido";
        public static final String CUENTA_INVALIDA = "Cuenta invalida";
        public static final String INGRESE_DNI_CLIENTE = "Ingrese el dni del cliente: ";
        public static final String INGRESE_NUMERO_CUENTA = "Ingrese el numero de cuenta: ";
        public static final String INGRESE_MONTO_GIRO_DESCUBIERTO = "Ingrese el monto en giro decubierto";
    public static final String MONTO_GIRO_MODIFICADO = "Monto giro descubierto modificado";


    public BancoServiceIml(MenuServices menuServices, PantallaServiceImp pantalla, WhileMenuServices whileMenuServices, CuentaServices cuentaServices, ClienteServices clienteServices) {
        this.menuServices = menuServices;
        this.pantalla = pantalla;
        this.whileMenuServices = whileMenuServices;
        this.cuentaServices = cuentaServices;
        this.clienteServices = clienteServices;
    }

    public MenuServices getMenuServices() {
        return menuServices;
    }

    public PantallaServiceImp getPantalla() {
        return pantalla;
    }

    public WhileMenuServices getWhileMenuServices() {
        return whileMenuServices;
    }

    public CuentaServices getCuentaServices() {
        return cuentaServices;
    }

    public ClienteServices getClienteServices() {
        return clienteServices;
    }


    @Override
    public void ingresarSaldo(ArrayList<Cuenta> cuentas) {
        double saldoIngresar;
        Cuenta cuenta = new Cuenta();
        do {
            System.out.print(INGRESE_CANTIDAD_SALDO + ": ");
            saldoIngresar = ImputConsoleServices.getScanner().nextDouble();
            if (saldoIngresar > 0) {
                getCuentaServices().consultarSaldo(cuentas);
                System.out.print(INGRESE_NUMERO_CUENTA);
                String idCuenta = ImputConsoleServices.getScanner().next();
                cuenta = getCuentaServices().getCuenta(cuentas, idCuenta);
                if (cuenta != null){
                    cuenta.setSaldo(cuenta.getSaldo() + saldoIngresar);
                    System.out.println(SALDO_AGREGADO_CORRECTAMENTE);
                }else {
                    System.out.println(CUENTA_INVALIDA);
                }
            } else {
                System.out.println(SALDO_INVALIDO);
            }
        }while (saldoIngresar < 0 || cuenta == null) ;


    };

    @Override
    public void getCliente(Banco banco) {
        Optional<Map.Entry<Cliente, ArrayList<Cuenta>>> cliente = getClienteServices().getClienteByDni(banco);
        if (cliente.isPresent()){
            ArrayList<Cuenta> cuentas = cliente.get().getValue();
            int opc;
            do {
                opc = getMenuServices().menuGetCliente(cliente.get().getKey());
                switch (opc) {
                    case 1 -> getClienteServices().detalleCliente(cliente);
                    case 2 -> getCuentaServices().createCuenta(cuentas);
                    case 3 -> getCuentaServices().consultarSaldo(cuentas);
                    case 4 -> getCuentaServices().deleteCuenta(cuentas);
                    case 5 -> ingresarSaldo(cuentas);
                    case 6 -> getCuentaServices().modGiro(cuentas);
                    case 7 -> getCuentaServices().retirarSaldo(cuentas);
                    case 8 -> getCuentaServices().interesCuenta(cuentas);
                    default -> System.out.println("Opcion invalida");
                }
            }while (opc != 0);

        }else {
            System.out.println(NO_SE_HA_ENCONTRADO_CLIENTE);
        }

    }
}
