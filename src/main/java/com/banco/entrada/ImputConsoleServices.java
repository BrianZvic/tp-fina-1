package com.banco.entrada;

import com.banco.services.banco.BancoServiceIml;
import com.banco.services.cuenta.CuentaServicesImpl;

import java.util.Scanner;

public class ImputConsoleServices {

        public static Scanner scanner;
        private ImputConsoleServices() {}


        public static void createScanner(){
            if(scanner == null){
                scanner = new Scanner(System.in);
            }
        }

        public static Scanner getScanner(){
            if (scanner == null) {
                scanner = new Scanner(System.in);
            }
            return scanner;
        }

        public static void closeScanner(){
            if(scanner != null){
                scanner.close();
            }
        }

        public static String getNumeroCuenta(){
            System.out.print(BancoServiceIml.INGRESE_NUMERO_CUENTA);
            return ImputConsoleServices.getScanner().next();
        }
        public static double getIngresoSaldo(){
            System.out.print(BancoServiceIml.INGRESE_CANTIDAD_SALDO + ": ");
            return ImputConsoleServices.getScanner().nextDouble();
        }

    }


