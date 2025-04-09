package main.servicio;

import main.modelo.Camion;
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
        if (vehiculo == null) {
            System.out.println("No se puede imprimir un vehículo nulo");
            return;
        }

        // Imprimir la información del vehículo
        System.out.println("Información del vehículo:");
        System.out.println("Patente: " + vehiculo.getPatente());
        System.out.println("Marca: " + vehiculo.getMarca());
        System.out.println("Año: " + vehiculo.getAnio());
        System.out.println("Capacidad de carga (kg): " + vehiculo.getCapacidadCargaKg());
    }

    public void imprimirInformacion(Camion camion) {
        if (camion == null) {
            System.out.println("No se puede imprimir un vehículo nulo");
            return;
        }

        // Imprimir la información del vehículo
        System.out.println("Información del vehículo:");
        System.out.println("Patente: " + camion.getPatente());
        System.out.println("Marca: " + camion.getMarca());
        System.out.println("Año: " + camion.getAnio());
        System.out.println("Capacidad de carga (kg): " + camion.getCapacidadCargaKg());
        System.out.println("¿Tiene acoplado?: " + (camion.getTieneAcoplado() ? "Sí" : "No"));
    }
}
