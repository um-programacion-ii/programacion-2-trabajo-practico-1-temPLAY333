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

    @Test
    public void testCrearVehiculo() {
        Vehiculo vehiculo = vehiculoService.crearVehiculo("ABC123", "Toyota", 2020, 1500.0);
        assertNotNull(vehiculo);
        verify(vehiculoService, times(1)).validarPatente("ABC123");
        verify(vehiculoService, times(1)).validarMarca("Toyota");
        verify(vehiculoService, times(1)).validarAnio(2020);
        verify(vehiculoService, times(1)).validarCapacidadCargaKg(1500.0);
    }

    @Test
    public void testCrearVehiculoPatenteInvalida() {
        Vehiculo vehiculo = vehiculoService.crearVehiculo("INVALID", "Toyota", 2020, 1500.0);
        assertNull(vehiculo);
        verify(vehiculoService, times(1)).validarPatente("INVALID");
    }

    @Test
    public void testCrearVehiculoMarcaInvalida() {
        Vehiculo vehiculo = vehiculoService.crearVehiculo("ABC123", "", 2020, 1500.0);
        assertNull(vehiculo);
        verify(vehiculoService, times(1)).validarMarca("");
    }

    @Test
    public void testCrearVehiculoAnioInvalido() {
        Vehiculo vehiculo = vehiculoService.crearVehiculo("ABC123", "Toyota", 1800, 1500.0);
        assertNull(vehiculo);
        verify(vehiculoService, times(1)).validarAnio(1800);
    }

    @Test
    public void testCrearVehiculoCapacidadCargaInvalida() {
        Vehiculo vehiculo = vehiculoService.crearVehiculo("ABC123", "Toyota", 2020, -500.0);
        assertNull(vehiculo);
        verify(vehiculoService, times(1)).validarCapacidadCargaKg(-500.0);
    }

    // Ahora testea cada metodo que usa el servicio por separado, asegurate de hacer varios test por metodo
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

}