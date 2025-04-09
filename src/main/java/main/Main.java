package main;

import main.modelo.Vehiculo;
import main.servicio.VehiculoPrinter;
import main.servicio.VehiculoService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crea una lista de vehículos y los imprime
        VehiculoService vehiculoService = VehiculoService.getInstance();
        VehiculoPrinter vehiculoPrinter = VehiculoPrinter.getInstance();

        Vehiculo vehiculo1 = vehiculoService.crearVehiculo("ABC123", "Toyota", 2020, 1500.0);
        Vehiculo camion = vehiculoService.crearCamion("DEF456", "Ford", 2018, 5000.0, true);
        Vehiculo auto = vehiculoService.crearAuto("GHI789", "Honda", 2021, 1200.0, 5);

        vehiculoService.agregarVehiculo(vehiculo1);
        vehiculoService.agregarVehiculo(camion);
        vehiculoService.agregarVehiculo(auto);

        // Imprime los datos de los vehículos
        for (Vehiculo vehiculo : vehiculoService.getVehiculos()) {
            vehiculoPrinter.imprimirInformacion(vehiculo);
            System.out.println();
        }

        // Imprime la información de un vehículo específico por patente
        String patenteBuscada = "JKL012";
        vehiculoPrinter.infoVehiculoPorPatente(vehiculoService.getVehiculos(), patenteBuscada);
    }
}