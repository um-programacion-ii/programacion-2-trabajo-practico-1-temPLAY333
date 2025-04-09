package test.servicio;

import main.modelo.Camion;
import main.modelo.Vehiculo;
import main.servicio.VehiculoPrinter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class VehiculoPrinterTest {

    private VehiculoPrinter vehiculoPrinter;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        vehiculoPrinter = VehiculoPrinter.getInstance();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testimprimirInformacion() {
        // Crear un mock de Vehiculo
        Vehiculo vehiculo = mock(Vehiculo.class);
        when(vehiculo.getPatente()).thenReturn("ABC123");
        when(vehiculo.getMarca()).thenReturn("Toyota");
        when(vehiculo.getAnio()).thenReturn(2020);
        when(vehiculo.getCapacidadCargaKg()).thenReturn(1500.0);

        // Ejecutar el método a probar
        vehiculoPrinter.imprimirInformacion(vehiculo);

        // Verificar la salida
        String salida = outContent.toString();
        assertTrue(salida.contains("ABC123"));
        assertTrue(salida.contains("Toyota"));
        assertTrue(salida.contains("2020"));
        assertTrue(salida.contains("1500.0"));

        // Verificar que los métodos del mock fueron llamados
        verify(vehiculo).getPatente();
        verify(vehiculo).getMarca();
        verify(vehiculo).getAnio();
        verify(vehiculo).getCapacidadCargaKg();
    }

    @Test
    public void testimprimirInformacionNull() {
        // Probar con un vehículo null
        vehiculoPrinter.imprimirInformacion(null);

        String salida = outContent.toString();
        assertTrue(salida.contains("No se puede imprimir un vehículo nulo"));
    }

    @Test
    public void testimprimirInformacionCamion() {
        // Crear un mock de Camion
        Camion camion = mock(Camion.class);
        when(camion.getPatente()).thenReturn("XYZ789");
        when(camion.getMarca()).thenReturn("Ford");
        when(camion.getAnio()).thenReturn(2018);
        when(camion.getCapacidadCargaKg()).thenReturn(2000.0);
        when(camion.getTieneAcoplado()).thenReturn(true);

        // Ejecutar el método a probar
        vehiculoPrinter.imprimirInformacion(camion);

        // Verificar la salida
        String salida = outContent.toString();
        assertTrue(salida.contains("XYZ789"));
        assertTrue(salida.contains("Ford"));
        assertTrue(salida.contains("2018"));
        assertTrue(salida.contains("2000.0"));
        assertTrue(salida.contains("¿Tiene acoplado?: Sí"));

        // Verificar que los métodos del mock fueron llamados
        verify(camion).getPatente();
        verify(camion).getMarca();
        verify(camion).getAnio();
        verify(camion).getCapacidadCargaKg();
        verify(camion).getTieneAcoplado();
    }

    @Test
    public void testimprimirInformacionCamionNull() {
        // Probar con un camion null
        vehiculoPrinter.imprimirInformacion((Camion) null);

        String salida = outContent.toString();
        assertTrue(salida.contains("No se puede imprimir un vehículo nulo"));
    }

    // Restaurar System.out después de cada test
    @org.junit.jupiter.api.AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}