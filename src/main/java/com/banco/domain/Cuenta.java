package com.banco.domain;
import com.banco.enums.CuentaEnum;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Cuenta {
    private UUID id;
    private String alias;
    private Long cbu;
    private double saldo;
    private CuentaEnum tipoCuenta;
    private String[] animales = {
            "Perro", "Gato", "Elefante", "León", "Tigre", "Jirafa", "Cebra",
            "Oso", "Pato", "Gallina", "Caballo", "Vaca", "Canguro", "Mono",
            "Ratón", "Zorro", "Conejo", "Hámster", "Pez", "Serpiente", "Araña"
    };
    private String[] objetosHogar = {
            "Sofá", "Mesa", "Silla", "Cama", "Lámpara", "Cortina", "Alfombra",
            "Televisor", "Refrigerador", "Horno", "Microondas", "Licuadora",
            "Tostadora", "Cuchillo", "Tenedor", "Plato", "Vaso", "Cubiertos",
            "Espejo", "Mueble"
    };
    private String[] plantas = {
            "Rosa", "Girasol", "Orquídea", "Margarita", "Cactus", "Helecho",
            "Lirio", "Bambú", "Tulipán", "Hortensia", "Dalia", "Aloe Vera",
            "Hiedra", "Lavanda", "Pino", "Palma", "Jazmín", "Clavel", "Pensamiento",
            "Cala"
    };


    public Cuenta(CuentaEnum tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
        this.alias = createAlias();
        this.cbu = createCbu();
        this.id = UUID.randomUUID();
    }

    public Cuenta(CuentaEnum tipoCuenta,double saldo ) {
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        this.alias = createAlias();
        this.cbu = createCbu();
        this.id = UUID.randomUUID();
    }

    public Cuenta() {
    }

    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    protected String createAlias() {

        Random random = new Random();
        int randomIndex = random.nextInt(getAnimales().length-1);

        String element1 = getAnimales()[randomIndex];
        String element2 = getPlantas()[randomIndex];
        String element3 = getObjetosHogar()[randomIndex];
        return element1 + "-" + element2 + "-" + element3;
    }



    protected Long createCbu() {
        long min = 10000000L; // Mínimo número de 8 dígitos
        long max = 99999999L; // Máximo número de 8 dígitos

        return ThreadLocalRandom.current().nextLong(min, max + 1);
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Long getCbu() {
        return cbu;
    }

    public void setCbu(Long cbu) {
        this.cbu = cbu;
    }

    public CuentaEnum getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(CuentaEnum tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public void setObjetosHogar(String[] objetosHogar) {
        this.objetosHogar = objetosHogar;
    }

    public void setPlantas(String[] plantas) {
        this.plantas = plantas;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {

        this.saldo = saldo;
    }

    public String[] getAnimales() {
        return animales;
    }

    public void setAnimales(String[] animales) {
        this.animales = animales;
    }

    public String[] getObjetosHogar() {
        return objetosHogar;
    }

    public String[] getPlantas() {
        return plantas;
    }
}
