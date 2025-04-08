package main.servicio;

import main.modelo.Vehiculo;

public class VehiculoPrinter {
    // Singleton
    private static VehiculoPrinter instance;

    private VehiculoPrinter() {
        // Constructor privado para evitar instanciación externa
    }

    public static VehiculoPrinter getInstance() {
        if (instance == null) {
            instance = new VehiculoPrinter();
        }
        return instance;
    }

    public void imprimirInformacion(Vehiculo vehiculo) {
        // Imprimir la información del vehículo
        System.out.println("Información del vehículo:");
        System.out.println("Patente: " + vehiculo.getPatente());
        System.out.println("Marca: " + vehiculo.getMarca());
        System.out.println("Año: " + vehiculo.getAnio());
        System.out.println("Capacidad de carga (kg): " + vehiculo.getCapacidadCargaKg());
    }
}
