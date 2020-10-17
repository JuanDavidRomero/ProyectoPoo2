package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Instalacion extends Obra
{
    private String descripcion;

    ArrayList<Material> tipo = new ArrayList<>();

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Instalacion() {
    }

    public Instalacion(long pid, String titulo, Calendar fecha, Double precioRef, String dimensiones, String descripcion) {
        super(pid, titulo, fecha, precioRef, dimensiones);
        this.descripcion = descripcion;
    }

    @Override
    public double calcularPrecio() {
        return 0;
    }
}
