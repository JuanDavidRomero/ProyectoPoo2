package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Obra {
    private long pid;
    private String titulo;
    private Calendar fecha;
    private double precioRef;
    private String dimenciones;
    private ArrayList<Artista> artista= new ArrayList<>();

    // CONSTRUCTORES
    public Obra()
    { }

    public Obra(long pid, String titulo, Calendar fecha, Double precioRef, String dimensiones)
    {
        this.pid = pid;
        this.titulo = titulo;
        this.fecha = fecha;
        this.precioRef = precioRef;
        this.dimenciones = dimensiones;
    }

    // ACCESORS
    public long getPid(){return pid;}
    public void setPid(long pid){this.pid = pid;}

    public String getTitulo(){return titulo;}
    public void setTitulo(String titulo){this.titulo = titulo;}

    public Calendar getFecha(){return fecha;}
    public void setFecha(Calendar fecha){this.fecha = fecha;}

    public Double getPrecioRef(){return precioRef;}
    public void setPrecioRef(Double precioRef){this.precioRef = precioRef;}

    public String getDimensiones(){return dimenciones;}
    public void setDimensiones(String dimensiones){this.dimenciones = dimensiones;}

    public ArrayList<Artista> getArtista(){return artista;}
    public void setArtista(Artista artista){this.artista.add(artista);}

    // toString
    public String toString()
    {
        return  ", Titulo='" + titulo + '\'' +
                ", Fecha=" + fecha.get(Calendar.YEAR) +
                ", PrecioRef=" + precioRef +
                ", Dimensiones='" + dimenciones + '\'' +
                ",Autor= "+artista.get(0).getNombres()+
                ", Foto=" + "todavia no hay foto sorry, pero en la entrega 3 si abra" +
                '}';
    }

    public String toString(int o)
    {
        int ano = fecha.get(Calendar.YEAR);
        return  "Titulo: "+titulo+
                "\n  Año: "+ano+
                "\n  Precio: "+precioRef+
                "\n  Dimencion: "+dimenciones;
    }



}
