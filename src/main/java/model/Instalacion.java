package model;

import java.util.ArrayList;

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

    @Override
    public double calcularPrecio() {
        return 0;
    }
}
