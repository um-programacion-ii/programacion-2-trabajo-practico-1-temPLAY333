package main.servicio;

import main.modelo.Auto;
import main.modelo.Camion;
import main.modelo.Vehiculo;

public class VehiculoService {
    private static VehiculoService instance;

    private VehiculoService() {
        // Constructor privado para evitar instanciación externa
    }

    public static VehiculoService getInstance() {
        if (instance == null) {
            instance = new VehiculoService();
        }
        return instance;
    }

    public Vehiculo crearVehiculo(String patente, String marca, int anio, Double capacidadCargaKg) {
        // Crear un nuevo objeto Vehiculo
        try {
            this.validarVehiculo(patente, marca, anio, capacidadCargaKg);
        } catch (IllegalArgumentException exception) {
            System.out.println("Error al crear el vehículo: " + exception.getMessage());
        }
        return new Vehiculo(patente, marca, anio, capacidadCargaKg);
    }

    public Camion crearCamion(String patente, String marca, int anio, Double capacidadCargaKg, boolean tieneAcoplado) {
        // Crear un nuevo objeto Camion

        try {
            this.validarVehiculo(patente, marca, anio, capacidadCargaKg);
            this.validarTieneAcoplado(tieneAcoplado);
        } catch (IllegalArgumentException exception) {
            System.out.println("Error al crear el vehículo: " + exception.getMessage());
        }
        return new Camion(patente, marca, anio, capacidadCargaKg, tieneAcoplado);
    }

    public Auto crearAuto(String patente, String marca, int anio, Double capacidadCargaKg, int cantidadPasajeros) {
        // Crear un nuevo objeto Auto
        try {
            this.validarVehiculo(patente, marca, anio, capacidadCargaKg);
            this.validarCantidadPasajeros(cantidadPasajeros);
        } catch (IllegalArgumentException exception) {
            System.out.println("Error al crear el vehículo: " + exception.getMessage());
        }
        return new Auto(patente, marca, anio, capacidadCargaKg, cantidadPasajeros);
    }

    public void validarVehiculo(String patente, String marca, int anio, Double capacidadCargaKg) {
        this.validarMarca(marca);
        this.validarPatente(patente);
        this.validarAnio(anio);
        this.validarCapacidadCargaKg(capacidadCargaKg);
    }

    public void validarPatente(String patente) {
        // Validar la patente
        if (patente == null || patente.isEmpty()) {
            throw new IllegalArgumentException("Patente inválida. Debe tener 6 caracteres y no puede estar vacía.");
        }

        // Validar el formato de la patente (formato viejo: 3 letras y 3 números)
        if (!patente.matches("^[A-Z]{3}\\d{3}$")) {
            // Validar el formato de la patente (formato nuevo: 2 letras, 3 números y 2 letras)
            if (!patente.matches("^[A-Z]{2}\\d{3}[A-Z]{2}$")) {
                throw new IllegalArgumentException("Patente inválida. Debe seguir el formato viejo (LLLNNN) o el formato nuevo (LLNNNLL).");
            }
        }
    }

    public void validarMarca(String marca) {
        // Validar la marca
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("Marca inválida. No puede estar vacía.");
        }
    }

    public void validarAnio(int anio) {
        // Validar el año, siendo mayor que 1900 y menor o igual a 2025
        if (anio <= 1900 || anio > 2025) {
            throw new IllegalArgumentException("Año inválido. Debe ser mayor que 1900.");
        }
    }

    public void validarCapacidadCargaKg(Double capacidadCargaKg) {
        // Validar la capacidad de carga, siempre tiene que ser positiva
        if (capacidadCargaKg == null || capacidadCargaKg <= 0) {
            throw new IllegalArgumentException("Capacidad de carga inválida. Debe ser mayor que 0.");
        }
    }

    public void validarTieneAcoplado(Boolean tieneAcoplado) {
        // Solo validar si el valor es nulo
        if (tieneAcoplado == null) {
            throw new IllegalArgumentException("El estado del acoplado no puede ser nulo.");
        }
    }

    public void validarCantidadPasajeros(int cantidadPasajeros) {
        // Validar la cantidad de pasajeros, siendo mayor que 0
        if (cantidadPasajeros <= 0) {
            throw new IllegalArgumentException("Cantidad de pasajeros inválida. Debe ser mayor que 0.");
        }
    }
}