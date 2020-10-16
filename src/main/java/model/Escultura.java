package model;

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

    @Override
    public double calcularPrecio() {
        return 0;
    }
}
