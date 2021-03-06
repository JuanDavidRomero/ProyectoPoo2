package model;

import java.util.Calendar;

public class Escultura extends Obra
{
    private Material material;
    private double peso;
    Material tipo = new Material();

    // Constructores
    public Escultura()
    { }
    public Escultura(long pid, String titulo, Calendar fecha, Double precioRef, String dimensiones, Material material, double peso)
    {
        super(pid, titulo, fecha, precioRef, dimensiones);
        this.material = material;
        this.peso = peso;
    }

    // Accesors

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



    // Metodos


    @Override
    public double calcularPrecio()
    {
        double opera=0;

        if(peso<10)
        {
            return precioRef;
        }
        else if(peso>10)
        {
            opera-=10;
            this.precioRef=(opera*precioRef)/100+precioRef;
            return (opera*precioRef)/100+precioRef;
        }

        return 0;

    }

    @Override
    public String toString() {
        return "Escultura" +
                "\n material{ " +
                "\n nombre del material: " +material.getNombre() +
                "\n descripcion del material: " +material.getDescripion() +
                "\n peso= " + peso +
                "\n tipo= " + tipo +
                "\n pid= " + pid +
                "\n titulo= " + titulo +
                "\n fecha= " + fecha.getTime() +
                "\n precioRef= " + precioRef +
                "\n dimenciones= " + dimenciones;
    }
}
