package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Artista
{
    private long codigoArtista;
    private long cedula;
    private String nombres;
    private String apellidos;
    private Calendar fechaNacimiento;
    private long telefono;
    private ArrayList<Obra> obras= new ArrayList<>();

    // CONSTRUCTORES
    public Artista ()
    {}

    public Artista(long codigoArtista, long cedula, String nombres, String apellidos, Calendar fechaNacimiento, long telefono)
    {
        this.codigoArtista = codigoArtista;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    // ACESSORS
    public long getCodigoArtista() {
        return codigoArtista;
    }
    public void setCodigoArtista(long codigoArtista) {
        this.codigoArtista = codigoArtista;
    }

    public long getCedula() {
        return cedula;
    }
    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getTelefono() {
        return telefono;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Obra> getObras() {
        return obras;
    }
    public void setObras(Obra obra) {

        this.obras.add(obra);
    }

    // toString
    public String toString()
    {
        return "Artista{" +
                "codigoArtista=" + codigoArtista +
                ", cedula=" + cedula +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", telefono=" + telefono +
                ", obras=" + obras +
                '}';
    }

    public String toString(int a)
    {
        return "Nombre: "+nombres+" "+apellidos+
                "\t  Cedula: "+cedula;

    }
    public String toString(int a,int b)
    {
        return nombres+" "+apellidos;
    }
}
