package main.servicio;

import main.modelo.Vehiculo;
import main.servicio.VehiculoService;

import java.util.ArrayList;

public class VehiculoPrinter {
    // Singleton
    private static VehiculoPrinter instance;
    private static VehiculoService vehiculoService;

    private VehiculoPrinter() {
        vehiculoService = VehiculoService.getInstance();
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
        System.out.println(vehiculo.getDetallesEspecificos()); // Polimorfismo
    }

    public void infoVehiculoPorPatente (ArrayList<Vehiculo> vehiculos, String patente) {
        try {
            vehiculoService.validarPatente(patente);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        // Imprimir la información del vehículo con esa patente
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                this.imprimirInformacion(vehiculo);
                return;
            }
        }
        System.out.println("No se encontró un vehículo con la patente: " + patente);
    }
}
