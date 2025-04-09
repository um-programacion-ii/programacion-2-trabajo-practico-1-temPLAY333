package main;

import main.modelo.Vehiculo;
import main.servicio.VehiculoPrinter;
import main.servicio.VehiculoService;

public class Main {
    public static void main(String[] args) {
        // Crea un vehiculo, un camion y un Auto, he imprime sus datos
        VehiculoService vehiculoService = VehiculoService.getInstance();
        VehiculoPrinter vehiculoPrinter = VehiculoPrinter.getInstance();

        Vehiculo vehiculo = vehiculoService.crearVehiculo("ABC123", "Toyota", 2020, 1500.0);
        Vehiculo camion = vehiculoService.crearCamion("DEF456", "Ford", 2018, 5000.0, true);
        Vehiculo auto = vehiculoService.crearAuto("GHI789", "Honda", 2021, 1200.0, 5);

        // Imprime los datos de los vehiculos
        System.out.println("Datos del vehiculo:");
        vehiculoPrinter.imprimirInformacion(vehiculo);
        System.out.println("\nDatos del camion:");
        vehiculoPrinter.imprimirInformacion(camion);
        System.out.println("\nDatos del auto:");
        vehiculoPrinter.imprimirInformacion(auto);
    }
}