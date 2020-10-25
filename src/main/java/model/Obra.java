package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public abstract class Obra
{
    protected long pid;
    protected String titulo;
    protected Calendar fecha;
    protected double precioRef;
    protected String dimenciones;
    protected HashMap<Long,Artista> artistas= new HashMap<>();


    // Constructores
    public Obra()
    {

    }
    public Obra(long pid, String titulo, Calendar fecha, Double precioRef, String dimensiones)
    {
        this.pid = pid;
        this.titulo = titulo;
        this.fecha = fecha;
        this.precioRef = precioRef;
        this.dimenciones = dimensiones;
    }

    // Accessors


    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public double getPrecioRef() {
        return precioRef;
    }

    public void setPrecioRef(double precioRef) {
        this.precioRef = precioRef;
    }

    public String getDimenciones() {
        return dimenciones;
    }

    public void setDimenciones(String dimenciones) {
        this.dimenciones = dimenciones;
    }

    public HashMap<Long, Artista> getArtistas()
    {
        return artistas;
    }

    public void setArtista(Artista artistas)
    {
        this.artistas.put(artistas.getCedula(),artistas);
    }

    //Metodos
    public abstract double calcularPrecio();


}
