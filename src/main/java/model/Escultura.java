package model;

import java.util.Calendar;

public class Escultura extends Obra
{
    private Material material;
    private double peso;

    Material tipo = new Material();

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Escultura() {

    }

    public Escultura(long pid, String titulo, Calendar fecha, Double precioRef, String dimensiones, Material material, double peso) {
        super(pid, titulo, fecha, precioRef, dimensiones);
        this.material = material;
        this.peso = peso;
    }

    @Override
    public double calcularPrecio() {
        return 0;
    }
}
