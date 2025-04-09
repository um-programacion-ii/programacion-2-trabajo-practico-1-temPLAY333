package main.modelo;

public class Auto extends Vehiculo{
    private int cantidadPasajeros;

    public Auto(String patente, String marca, int anio, Double capacidadCargaKg, int cantidadPasajeros) {
        super(patente, marca, anio, capacidadCargaKg);
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public Auto() {
        super();
        this.cantidadPasajeros = 0;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    @Override
    public String getDetallesEspecificos() {
        return "Auto con capacidad para " + cantidadPasajeros + " pasajeros.";
    }
}
