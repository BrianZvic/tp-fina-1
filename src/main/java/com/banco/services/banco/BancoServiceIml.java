package com.banco.services.banco;
import com.banco.domain.*;
import com.banco.entrada.ImputConsoleServices;
import com.banco.enums.CuentaEnum;
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


    public BancoServiceIml(MenuServices menuServices, PantallaServiceImp pantalla, WhileMenuServices whileMenuServices, CuentaServices cuentaServices) {
        this.menuServices = menuServices;
        this.pantalla = pantalla;
        this.whileMenuServices = whileMenuServices;
        this.cuentaServices = cuentaServices;

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

    @Override
    public void addCliente(Banco banco) {
        Cliente cliente = getMenuServices().menuAddCliente();
        banco.getClientes().put(cliente,new ArrayList<>());
        System.out.println(MenuServiceImpl.USUARIO_AGREGADO_CORRECTAMENTE);

    }

    @Override
    public void deleteCuenta(Optional<Map.Entry<Cliente, ArrayList<Cuenta>>> cliente) {
        if (cliente.isPresent()){
            ArrayList<Cuenta> cuenta = cliente.get().getValue();
            getPantalla().forCuenta(cuenta);
            String nCuenta = ImputConsoleServices.getNumeroCuenta();
            for (int i = 0; i < cuenta.size(); i++ ){
               cuenta.removeIf(e -> nCuenta.equals(e.getId().toString()));
            }
            System.out.println(CuentaServicesImpl.OPERACION_EXITOSA);
            getPantalla().forCuenta(cuenta);
        }
    }

    @Override
    public Optional<Map.Entry<Cliente, ArrayList<Cuenta>>> getClienteByDni(Banco banco) {
        System.out.print(INGRESE_DNI_CLIENTE);
        int dni = ImputConsoleServices.getScanner().nextInt();
        for (Map.Entry<Cliente,ArrayList<Cuenta>> client: banco.getClientes().entrySet()) {
            if (client.getKey().getDni() == dni){
                return Optional.of(client);
            }
        }
        return Optional.empty();
    }

    @Override
    public void getAllClientes(Banco banco) {
        System.out.println("\n");
        for (Map.Entry<Cliente, ArrayList<Cuenta>> entry : banco.getClientes().entrySet()){
            getPantalla().getAllClientes(entry);
        }
    }

    @Override
    public void detalleCliente(Optional<Map.Entry<Cliente, ArrayList<Cuenta>>> cliente) {
        if(cliente.isPresent()){
            getPantalla().getAllClientes(cliente.get());
        }else {
            System.out.println(NO_SE_HA_ENCONTRADO_CLIENTE);
        }

    }

    @Override
    public void createCuenta(Optional<Map.Entry<Cliente, ArrayList<Cuenta>>> cliente) {
        int opc = getMenuServices().menuCrearCuenta();
        if (cliente.isPresent()){
            if (opc == 1){
                cliente.get().getValue().add(new CuentaCorriente(CuentaEnum.CUENTA_CORRIENTE));
                System.out.println(CUENTA_CREADA_CORRECTAMENTE);
            } else if (opc == 2) {
                cliente.get().getValue().add(new CuentaAhorro(CuentaEnum.CAJA_AHORRO));
                System.out.println(CUENTA_CREADA_CORRECTAMENTE);
            }


        }
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
        Optional<Map.Entry<Cliente, ArrayList<Cuenta>>> cliente = getClienteByDni(banco);
        if (cliente.isPresent()){
            ArrayList<Cuenta> cuentas = cliente.get().getValue();
            int opc;
            do {
                opc = getMenuServices().menuGetCliente(cliente.get().getKey());
                switch (opc) {
                    case 1 -> detalleCliente(cliente);
                    case 2 -> createCuenta(cliente);
                    case 3 -> getCuentaServices().consultarSaldo(cuentas);
                    case 4 -> deleteCuenta(cliente);
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
