package model;

import java.util.Calendar;

public class Cuadro extends Obra {
    private String tema;
    private String tecnica;
    private Clasificacion clasificacion;

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

    public Cuadro(long pid, String titulo, Calendar fecha, Double precioRef, String dimensiones, String tema, String tecnica, Clasificacion clasificacion) {
        super(pid, titulo, fecha, precioRef, dimensiones);
        this.tema = tema;
        this.tecnica = tecnica;
        this.clasificacion = clasificacion;
    }

    @Override
    public double calcularPrecio() {
        return 0;
    }
}
