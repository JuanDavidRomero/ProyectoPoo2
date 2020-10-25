package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Instalacion extends Obra
{
    // Atributos
    private String descripcion;
    ArrayList<Material> tipo = new ArrayList<>();

    // Constructores
    public Instalacion()
    { }

    public Instalacion(long pid, String titulo, Calendar fecha, Double precioRef, String dimensiones, String descripcion)
    {
        super(pid, titulo, fecha, precioRef, dimensiones);
        this.descripcion = descripcion;
    }

    // Metodos
    @Override
    public double calcularPrecio()
    {
        double porci =0;
        porci=tipo.size()*5;
        return (precioRef*porci)/100+precioRef;
    }

    // Accessors

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



}
