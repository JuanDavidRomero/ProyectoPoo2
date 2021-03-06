package model;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

@XmlSeeAlso({Cuadro.class,Instalacion.class,Escultura.class})
@XmlType

public abstract class Obra
{
    protected long pid;
    protected String titulo;
    protected Calendar fecha;
    protected double precioRef;
    protected String dimenciones;
    protected ArrayList<Artista> artistas= new ArrayList<>();


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

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(Artista artistas) {
        this.artistas.add(artistas);
    }

    //Metodos
    public abstract double calcularPrecio();


}
