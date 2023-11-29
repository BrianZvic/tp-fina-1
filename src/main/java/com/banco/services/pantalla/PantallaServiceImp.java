package com.banco.services.pantalla;
import com.banco.domain.Cliente;
import com.banco.domain.Cuenta;
import com.banco.entrada.ImputConsoleServices;

import java.util.ArrayList;
import java.util.Map;

public class PantallaServiceImp implements PantallaService{

    @Override
    public void getAllClientes(Map.Entry<Cliente, ArrayList<Cuenta>> cl) {
        Cliente cliente = cl.getKey();

        System.out.printf("Nombre: %s - Apellido: %s - Dni: %d - Fecha Nacimiento: %s - Edad: %d\n",
                cliente.getNombre(),cliente.getApellido(),cliente.getDni(),
                cliente.getFechNac(),cliente.getEdad());
    }

    public void forCuenta(ArrayList<Cuenta> cuenta){
        for (Cuenta cn: cuenta) {
            System.out.println("-------------------------------------------------");
            System.out.printf("\t Cuenta: %s\n",cn.getId().toString());
            System.out.printf("\t Tipo de cuenta: %s\n",cn.getTipoCuenta().toString());
            System.out.printf("\t CBU: %s\n",cn.getCbu());
            System.out.printf("\t Saldo: %s\n",cn.getSaldo());
        }
    }

    @Override
    public String pantallaString(String string) {
        System.out.print(string+": ");
        return ImputConsoleServices.getScanner().next();
    }

    @Override
    public int pantallaInt(String string) {
        System.out.print(string+": ");

        return ImputConsoleServices.getScanner().nextInt();
    }

    @Override
    public float pantallaFloat(String string) {
        return 0;
    }
}
