package main.modelo;

public class Camion extends Vehiculo {
    private Boolean tieneAcoplado;

    public Camion(String patente, String marca, int anio, Double capacidadCargaKg, Boolean tieneAcoplado) {
        super(patente, marca, anio, capacidadCargaKg);
        this.tieneAcoplado = tieneAcoplado;
    }

    public Camion() {
        super();
        this.tieneAcoplado = false;
    }

    public Boolean getTieneAcoplado() {
        return tieneAcoplado;
    }

    public void setTieneAcoplado(Boolean tieneAcoplado) {
        this.tieneAcoplado = tieneAcoplado;
    }
}
