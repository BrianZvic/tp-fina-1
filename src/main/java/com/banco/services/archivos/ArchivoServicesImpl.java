package com.banco.services.archivos;
import com.banco.domain.Banco;
import com.banco.domain.Cliente;
import com.banco.domain.Cuenta;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArchivoServicesImpl implements ArchivoService{

    private final String rutaCarpeta = "/src/main/java/com/banco/services/archivos/";

    @Override
    public void crearCsv(Banco banco)  {

        String path = System.getProperty("user.dir").concat(rutaCarpeta).concat("clientes.csv");

       HashMap<Cliente,ArrayList<Cuenta>> data = banco.getClientes();

        try(CSVWriter writer = new CSVWriter(new FileWriter(path))) {
            String[] header = {"Numero_titular","Nombre_titular","Tipo_Cuenta","Saldo"};
            writer.writeNext(header);


            for (Map.Entry<Cliente,ArrayList<Cuenta>> user: banco.getClientes().entrySet()) {
                Cliente cliente = user.getKey();
                String[] cl = {
                        cliente.getId().toString(), cliente.getNombre() + " " + cliente.getApellido()
                };
                for (Cuenta cta : user.getValue()){
                    String[] dta ={
                            cta.getTipoCuenta().toString(),
                            String.valueOf(cta.getSaldo())
                    };
                    String[] datos = Arrays.copyOf(cl,cl.length + dta.length);
                    System.arraycopy(dta, 0, datos, cl.length, dta.length);

                   writer.writeNext(datos);
                }


            }


        }catch (IOException e){
            System.out.println("Algo salio  mal: " + e.getMessage());
        }
    }
}
