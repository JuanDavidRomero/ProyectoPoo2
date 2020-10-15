package model;

import java.util.Objects;

public class Cliente
{
    private long codigoCliente;
    private long cedula;
    private String nombres;
    private String apellidos;
    private String direccionEntrega;
    private long telefono;

    // Constructores
    public Cliente(){ }

    public Cliente(long codigoCliente, long cedula, String nombres, String apellidos, String direccionEntrega, long telefono) {
        this.codigoCliente = codigoCliente;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccionEntrega = direccionEntrega;
        this.telefono = telefono;
    }

    //Acessors
    public long getCodigoCliente() {
        return codigoCliente;
    }
    public void setCodigoCliente(long codigoCliente) {
        this.codigoCliente = codigoCliente;
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

    public String getDireccionEntrega() {
        return direccionEntrega;
    }
    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public long getTelefono() {
        return telefono;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return codigoCliente == cliente.codigoCliente;
    }

    public int hashCode() {
        return Objects.hash(codigoCliente);
    }

    // toString
    public String toString() {
        return "Codigo de cliente: "+codigoCliente+
                "\n  Cedula: "+cedula+
                "\n  Nombre: "+nombres+" "+apellidos+
                "\n  Direccion de entrega: "+direccionEntrega+
                "\n  Telefono: "+telefono;

    }

    public String toString(int x, int y ) {
        String nombreCompleto=nombres+" "+apellidos;
        return "Nombre: "+nombreCompleto;
    }

    public String toString(int x)
    {
        return
                "Cedula: " + cedula +
                        "\n  Nombre: " + nombres +" "+apellidos +
                        "\n  Telefono: " + telefono+
                        "\n  Numero identificacion: "+codigoCliente;
    }
}
