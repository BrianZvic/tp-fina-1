package com.banco.services.menu;

import com.banco.domain.Cliente;
import com.banco.domain.Direccion;
import com.banco.entrada.ImputConsoleServices;
import com.banco.services.pantalla.PantallaService;
import com.banco.services.pantalla.PantallaServiceImp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenuServiceImpl implements MenuServices {

    private final PantallaService pantallaService = new PantallaServiceImp();
    private final String INGRESE_DATOS = "Imgrese los siguientes datos:";
    private final String DIRECCION = "Direccion";

    private String[] menuGetCliente = {"Ver detalle cliente","Crear cuenta",
                                        "Ver saldo cuentas","Eliminar cuenta","Ingresar saldo","Modificar valor giro encubierto",
                                            "Retirar saldo","Interes de cuenta"};
    public MenuServiceImpl() {
    }

    public PantallaService getPantallaService() {
        return pantallaService;
    }

    @Override
    public Cliente menuAddCliente() {
        System.out.println("\n");
        System.out.println(INGRESE_DATOS);
        String nombre = getPantallaService().pantallaString("Nombre");
        String apellido = getPantallaService().pantallaString("Apellido");
        int dni = getPantallaService().pantallaInt("DNI");
        LocalDate fechN = LocalDate.parse(getPantallaService().pantallaString("Fecha de Nacimiento:"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return new Cliente(dni,nombre,apellido,menuAddDireccion(),fechN);
    }

    @Override
    public Direccion menuAddDireccion() {
        System.out.println("-".repeat(30));
        System.out.println(DIRECCION);
        String nombreD = getPantallaService().pantallaString("Nombre de calle");
        int altura = getPantallaService().pantallaInt("Altura");
        String nombreL = getPantallaService().pantallaString("Ciudad");
        String nombreP = getPantallaService().pantallaString("Provincia");
        return new Direccion(nombreD,altura,nombreL,nombreP);
    }

    @Override
    public void menuAddCuenta() {
        System.out.println("-".repeat(30));
        System.out.println("Tipo de cuenta");
        System.out.println("1: Cuenta Ahorro");
        System.out.println("2: Cuenta corriente");
        System.out.println("Ingrese opcion: ");
        int opc = ImputConsoleServices.getScanner().nextInt();

    }

    @Override
    public int menuGetCliente(Cliente cliente) {
        System.out.println("\n");
        System.out.println("-".repeat(30));
        System.out.printf("BIENVENIDO: %s %s\n", cliente.getNombre(),cliente.getApellido());
        System.out.println("-".repeat(30));
        for (int i = 0; i < menuGetCliente.length; i++) {
            System.out.println(i+1 +" "+ menuGetCliente[i]);
        }
        System.out.println("0: Atras");
        System.out.print("Ingrese una opcion: ");
        return ImputConsoleServices.getScanner().nextInt();
    }

    @Override
    public int menuCrearCuenta() {
        System.out.println("\n");
        System.out.println("1: Cuenta Corriente");
        System.out.println("2: Caja Ahorro");
        System.out.println("0. Salir");
        System.out.print("Ingrese una opcion: ");
        return ImputConsoleServices.getScanner().nextInt();

    }

    @Override
    public int menuBanco() {
        System.out.println("\n");
        System.out.println("-".repeat(30));
        System.out.println("        MENU PRINCIPAL        ");
        System.out.println("-".repeat(30));
        System.out.println("Ingrese una opcion:");
        System.out.println("1: Agregar cliente");
        System.out.println("2: Ver all clientes");
        System.out.println("3: Ver detalle Cliente");
        System.out.println("4: Exportar clientes");
        System.out.println("0. Salir");
        System.out.print("Ingrese su opcion: ");
        return ImputConsoleServices.getScanner().nextInt();

    }
}
