package com.banco.services.menu;

import com.banco.domain.Cliente;
import com.banco.domain.Direccion;
import com.banco.entrada.ImputConsoleServices;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenuServiceImpl implements MenuServices {


    @Override
    public Cliente menuAddCliente() {
        System.out.println("\n");
        System.out.println("Imgrese los siguientes datos:");
        System.out.print("Nombre: ");
        String nombre = ImputConsoleServices.getScanner().next();
        System.out.print("Apellido: ");
        String apellido = ImputConsoleServices.getScanner().next();
        System.out.print("Dni: ");
        int dni = ImputConsoleServices.getScanner().nextInt();
        System.out.print("Fecha de Nacimiento: ");
        String fech = ImputConsoleServices.getScanner().next();
        LocalDate fechN = LocalDate.parse(fech, DateTimeFormatter.ofPattern("dd/MM/yyyy"));


        return new Cliente(dni,nombre,apellido,menuAddDireccion(),fechN);
    }

    @Override
    public Direccion menuAddDireccion() {
        System.out.println("-".repeat(30));
        System.out.println("Direccion");
        System.out.print("Nombre: ");
        String nombreD = ImputConsoleServices.getScanner().next();
        System.out.print("Altura: ");
        int altura = ImputConsoleServices.getScanner().nextInt();
        System.out.print("Localidad: ");
        String nombreL = ImputConsoleServices.getScanner().next();
        System.out.print("Provincia: ");
        String nombreP = ImputConsoleServices.getScanner().next();
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
        System.out.println("1: Ver detalle cliente");
        System.out.println("2: Crear cuenta");
        System.out.println("3: Ver saldo cuentas");
        System.out.println("4: Eliminar cuenta");
        System.out.println("5: Ingresar saldo");
        System.out.println("6: Modificar valor giro encubierto");
        System.out.println("7: Retirar saldo");
        System.out.println("8: Interes de cuenta");
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
