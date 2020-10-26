package model;

public class Material{
    private String nombre;
    private String descripion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public Material() {}

    public Material(String nombre, String descripion) {
        this.nombre = nombre;
        this.descripion = descripion;
    }

    @Override
    public String toString() {
        return "-Material" +
                "\n nombre= " + nombre +
                "\n descripion= " + descripion;
    }
}
