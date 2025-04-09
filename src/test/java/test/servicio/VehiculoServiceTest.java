package test.servicio;


import main.modelo.Vehiculo;
import main.servicio.VehiculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VehiculoServiceTest {

    private VehiculoService vehiculoService;

    @BeforeEach
    public void setUp() {
        vehiculoService = Mockito.spy(VehiculoService.getInstance());
    }

    // Test de creación de vehículo usando mockeito para las metodos internos
    @Test
    public void testCrearVehiculo() {
        String patente = "ABC123";
        String marca = "Toyota";
        int anio = 2020;
        Double capacidadCargaKg = 1000.0;

        // Mockear el metodo validarVehiculo
        doNothing().when(vehiculoService).validarVehiculo(patente, marca, anio, capacidadCargaKg);

        // Crear el vehículo
        Vehiculo vehiculo = vehiculoService.crearVehiculo(patente, marca, anio, capacidadCargaKg);

        // Verificar que el vehículo fue creado correctamente
        assertNotNull(vehiculo);
        assertEquals(patente, vehiculo.getPatente());
        assertEquals(marca, vehiculo.getMarca());
        assertEquals(anio, vehiculo.getAnio());
        assertEquals(capacidadCargaKg, vehiculo.getCapacidadCargaKg());
    }

    // test de validación de vehículo, con diversos casos erroneos, tambien con mockito
    @Test
    public void testValidarVehiculo() {
        String patente = "ABC123";
        String marca = "Toyota";
        int anio = 2020;
        Double capacidadCargaKg = 1000.0;

        // Mockear los metodos de validación
        doNothing().when(vehiculoService).validarMarca(marca);
        doNothing().when(vehiculoService).validarPatente(patente);
        doNothing().when(vehiculoService).validarAnio(anio);
        doNothing().when(vehiculoService).validarCapacidadCargaKg(capacidadCargaKg);

        // Validar el vehículo
        assertDoesNotThrow(() -> vehiculoService.validarVehiculo(patente, marca, anio, capacidadCargaKg));
    }

    @Test
    public void testValidarVehiculoMarcaInvalida() {
        String patente = "ABC123";
        String marca = "Toyota";
        int anio = 2020;
        Double capacidadCargaKg = 1000.0;

        // Mockear los metodos de validación
        doThrow(new IllegalArgumentException()).when(vehiculoService).validarMarca(marca);
        doNothing().when(vehiculoService).validarPatente(patente);
        doNothing().when(vehiculoService).validarAnio(anio);
        doNothing().when(vehiculoService).validarCapacidadCargaKg(capacidadCargaKg);

        // Validar el vehículo
        assertThrows(
                IllegalArgumentException.class,
                () -> vehiculoService.validarVehiculo(patente, marca, anio, capacidadCargaKg)
        );
    }

    @Test
    public void testValidarVehiculoPatenteInvalida() {
        String patente = "ABC123";
        String marca = "Toyota";
        int anio = 2020;
        Double capacidadCargaKg = 1000.0;

        // Mockear los metodos de validación
        doThrow(new IllegalArgumentException()).when(vehiculoService).validarPatente(patente);
        doNothing().when(vehiculoService).validarMarca(marca);
        doNothing().when(vehiculoService).validarAnio(anio);
        doNothing().when(vehiculoService).validarCapacidadCargaKg(capacidadCargaKg);

        // Validar el vehículo
        assertThrows(
                IllegalArgumentException.class,
                () -> vehiculoService.validarVehiculo(patente, marca, anio, capacidadCargaKg)
        );
    }

    @Test
    public void testValidarVehiculoAnioInvalido() {
        String patente = "ABC123";
        String marca = "Toyota";
        int anio = 2020;
        Double capacidadCargaKg = 1000.0;

        // Mockear los metodos de validación
        doNothing().when(vehiculoService).validarPatente(patente);
        doNothing().when(vehiculoService).validarMarca(marca);
        doThrow(new IllegalArgumentException()).when(vehiculoService).validarAnio(anio);
        doNothing().when(vehiculoService).validarCapacidadCargaKg(capacidadCargaKg);

        // Validar el vehículo
        assertThrows(
                IllegalArgumentException.class,
                () -> vehiculoService.validarVehiculo(patente, marca, anio, capacidadCargaKg)
        );
    }

    @Test
    public void testValidarVehiculoCapacidadCargaInvalida() {
        String patente = "ABC123";
        String marca = "Toyota";
        int anio = 2020;
        Double capacidadCargaKg = 1000.0;

        // Mockear los metodos de validación
        doNothing().when(vehiculoService).validarPatente(patente);
        doNothing().when(vehiculoService).validarMarca(marca);
        doNothing().when(vehiculoService).validarAnio(anio);
        doThrow(new IllegalArgumentException()).when(vehiculoService).validarCapacidadCargaKg(capacidadCargaKg);

        // Validar el vehículo
        assertThrows(
                IllegalArgumentException.class,
                () -> vehiculoService.validarVehiculo(patente, marca, anio, capacidadCargaKg)
        );
    }

    @Test
    public void testCrearCamion() {
        String patente = "ABC123";
        String marca = "Toyota";
        int anio = 2020;
        Double capacidadCargaKg = 1000.0;
        boolean tieneAcoplado = true;

        // Mockear el metodo validarVehiculo
        doNothing().when(vehiculoService).validarVehiculo(patente, marca, anio, capacidadCargaKg);
        doNothing().when(vehiculoService).validarTieneAcoplado(tieneAcoplado);

        // Crear el vehículo
        Vehiculo vehiculo = vehiculoService.crearCamion(patente, marca, anio, capacidadCargaKg, tieneAcoplado);

        // Verificar que el vehículo fue creado correctamente
        assertNotNull(vehiculo);
        assertEquals(patente, vehiculo.getPatente());
        assertEquals(marca, vehiculo.getMarca());
        assertEquals(anio, vehiculo.getAnio());
        assertEquals(capacidadCargaKg, vehiculo.getCapacidadCargaKg());
    }

    @Test
    public void testCrearAuto() {
        String patente = "ABC123";
        String marca = "Toyota";
        int anio = 2020;
        Double capacidadCargaKg = 1000.0;
        int cantidadPasajeros = 5;

        // Mockear el metodo validarVehiculo
        doNothing().when(vehiculoService).validarVehiculo(patente, marca, anio, capacidadCargaKg);
        doNothing().when(vehiculoService).validarCantidadPasajeros(cantidadPasajeros);

        // Crear el vehículo
        Vehiculo vehiculo = vehiculoService.crearAuto(patente, marca, anio, capacidadCargaKg, cantidadPasajeros);

        // Verificar que el vehículo fue creado correctamente
        assertNotNull(vehiculo);
        assertEquals(patente, vehiculo.getPatente());
        assertEquals(marca, vehiculo.getMarca());
        assertEquals(anio, vehiculo.getAnio());
        assertEquals(capacidadCargaKg, vehiculo.getCapacidadCargaKg());
    }

    @Test
    public void testValidarPatente() {
        assertThrows(IllegalArgumentException.class, () -> vehiculoService.validarPatente(""));
        assertThrows(IllegalArgumentException.class, () -> vehiculoService.validarPatente(null));
        assertThrows(IllegalArgumentException.class, () -> vehiculoService.validarPatente("123ABC"));
        assertThrows(IllegalArgumentException.class, () -> vehiculoService.validarPatente("12ABC43"));

        assertDoesNotThrow(() -> vehiculoService.validarPatente("ABC123"));
        assertDoesNotThrow(() -> vehiculoService.validarPatente("AB123CD"));
    }

    @Test
    public void testValidarMarca() {
        assertThrows(IllegalArgumentException.class, () -> vehiculoService.validarMarca(""));
        assertThrows(IllegalArgumentException.class, () -> vehiculoService.validarMarca(null));

        assertDoesNotThrow(() -> vehiculoService.validarMarca("Toyota"));
        assertDoesNotThrow(() -> vehiculoService.validarMarca("Honda"));
    }

    @Test
    public void testValidarAnio() {
        assertThrows(IllegalArgumentException.class, () -> vehiculoService.validarAnio(1800));
        assertThrows(IllegalArgumentException.class, () -> vehiculoService.validarAnio(2026));

        assertDoesNotThrow(() -> vehiculoService.validarAnio(1901));
        assertDoesNotThrow(() -> vehiculoService.validarAnio(2020));
        assertDoesNotThrow(() -> vehiculoService.validarAnio(2025));
    }

    @Test
    public void testValidarCapacidadCargaKg() {
        assertThrows(IllegalArgumentException.class, () -> vehiculoService.validarCapacidadCargaKg(null));
        assertThrows(IllegalArgumentException.class, () -> vehiculoService.validarCapacidadCargaKg(-1.0));
        assertThrows(IllegalArgumentException.class, () -> vehiculoService.validarCapacidadCargaKg(0.0));

        assertDoesNotThrow(() -> vehiculoService.validarCapacidadCargaKg(1.0));
        assertDoesNotThrow(() -> vehiculoService.validarCapacidadCargaKg(1000.0));
    }

    @Test
    public void testValidarTieneAcoplado() {
        assertThrows(IllegalArgumentException.class, () -> vehiculoService.validarTieneAcoplado(null));

        assertDoesNotThrow(() -> vehiculoService.validarTieneAcoplado(true));
        assertDoesNotThrow(() -> vehiculoService.validarTieneAcoplado(false));
    }

    @Test
    public void testValidarCantidadPasajeros() {
        assertThrows(IllegalArgumentException.class, () -> vehiculoService.validarCantidadPasajeros(0));
        assertThrows(IllegalArgumentException.class, () -> vehiculoService.validarCantidadPasajeros(-1));

        assertDoesNotThrow(() -> vehiculoService.validarCantidadPasajeros(1));
        assertDoesNotThrow(() -> vehiculoService.validarCantidadPasajeros(5));
    }

}