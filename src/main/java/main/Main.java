package main;

import main.modelo.Vehiculo;
import main.servicio.VehiculoPrinter;
import main.servicio.VehiculoService;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de VehiculoService
        VehiculoService vehiculoService = VehiculoService.getInstance();

        Vehiculo vehiculo1 = vehiculoService.crearVehiculo("ABC123", "Toyota", 2020, 1000.0);
        Vehiculo vehiculo2 = vehiculoService.crearVehiculo("XYZ456", "Honda", 2021, 1200.0);
        Vehiculo vehiculo3 = vehiculoService.crearVehiculo("LMN789", "Ford", 2022, 1500.0);

        // Imprimir los detalles de los vehículos con VehiculoPrinter
        VehiculoPrinter vehiculoPrinter = VehiculoPrinter.getInstance();

        vehiculoPrinter.imprimirInformacion(vehiculo1);
        vehiculoPrinter.imprimirInformacion(vehiculo2);
        vehiculoPrinter.imprimirInformacion(vehiculo3);
    }
}