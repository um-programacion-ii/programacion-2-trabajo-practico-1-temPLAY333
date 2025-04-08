package main.modelo;

public class Vehiculo {
    private String patente;
    private String marca;
    private int anio;
    private Double capacidadCargaKg;

    public Vehiculo(String patente, String marca, int anio, Double capacidadCargaKg) {
        this.patente = patente;
        this.marca = marca;
        this.anio = anio;
        this.capacidadCargaKg = capacidadCargaKg;
    }

    public Vehiculo () {
        this.patente = "patente";
        this.marca = "marca";
        this.anio = 0;
        this.capacidadCargaKg = 0.0;
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Double getCapacidadCargaKg() {
        return capacidadCargaKg;
    }

    public void setCapacidadCargaKg(Double capacidadCargaKg) {
        this.capacidadCargaKg = capacidadCargaKg;
    }

    public void mostrarInformacion() {
        System.out.println("Patente: " + this.patente);
        System.out.println("Marca: " + this.marca);
        System.out.println("Año: " + this.anio);
        System.out.println("Capacidad de carga (kg): " + this.capacidadCargaKg);
    }
}
