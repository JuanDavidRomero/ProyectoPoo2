package model;

import java.util.Calendar;

public class Cuadro extends Obra
{
    // Atributos
    private String tema;
    private String tecnica;
    private Clasificacion clasificacion;

    // Constructores
    public Cuadro(long pid, String titulo, Calendar fecha, Double precioRef, String dimensiones, String tema, String tecnica, Clasificacion clasificacion)
    {
        super(pid, titulo, fecha, precioRef, dimensiones);
        this.tema = tema;
        this.tecnica = tecnica;
        this.clasificacion = clasificacion;
    }

    // Metodos
    @Override
    public double calcularPrecio()
    {
        if(clasificacion== Clasificacion.OBRA_MAESTRA)
        {
            this.precioRef=(precioRef*5)/100+precioRef;
            return (precioRef*5)/100+precioRef;
        }
        if(clasificacion==Clasificacion.OBRA_REPRESENTATIVA)
        {
            this.precioRef=(precioRef*3)/100+precioRef;
            return (precioRef*3)/100+precioRef;
        }

        return 0;
    }



    // Accessors
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public String toString() {
        return "Cuadro" +
                "\n tema= " + tema +
                "\n tecnica= " + tecnica +
                "\n clasificacion= " + clasificacion +
                "\n pid= " + pid +
                "\n titulo= " + titulo +
                "\n fecha= " + fecha.getTime() +
                "\n precioRef= " + precioRef +
                "\n dimenciones= " + dimenciones;
    }
}
