package model;

import java.util.Calendar;
import java.util.Objects;

public class Compra
{
    private long numeroPedido;
    private Calendar fechaRecibido;
    private boolean pagado;
    private String nombreRepartidor;
    private Cliente compraCliente = new Cliente();
    private Obra compraObra = new Obra();

    // Construcutores
    public Compra(){}

    public Compra(long numeroPedido, Calendar fechaRecibido, boolean pagado, String nombreRepartidor, Cliente compraCliente, Obra compraObra) {
        this.numeroPedido = numeroPedido;
        this.fechaRecibido = fechaRecibido;
        this.pagado = pagado;
        this.nombreRepartidor = nombreRepartidor;
        this.compraCliente = compraCliente;
        this.compraObra = compraObra;
    }

    public Compra(long numeroPedido, Calendar fechaRecibido, boolean pagado, String nombreRepartidor) {
        this.numeroPedido = numeroPedido;
        this.fechaRecibido = fechaRecibido;
        this.pagado = pagado;
        this.nombreRepartidor = nombreRepartidor;
    }

    //Acessors

    public long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Calendar getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Calendar fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    public Cliente getCompraCliente() {
        return compraCliente;
    }

    public void setCompraCliente(Cliente compraCliente) {
        this.compraCliente = compraCliente;
    }

    public Obra getCompraObra() {
        return compraObra;
    }

    public void setCompraObra(Obra compraObra) {
        this.compraObra = compraObra;
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return numeroPedido == compra.numeroPedido;
    }

    public int hashCode() {
        return Objects.hash(numeroPedido);
    }

    //toString
    public String toString(){
        String nombre_completo_cliente = this.compraCliente.getNombres() + " " + this.compraCliente.getApellidos();
        return "Obra:\t" + compraObra.getTitulo() + "\n  PID:\t" + compraObra.getPid()+"\n"
                + "  Cliente:\t" + nombre_completo_cliente + "\n  Fecha:\t" + this.fechaRecibido.getTime() + "\n\n";
    }

    public String toString(int s)
    {
        String nombre_completo_cliente = this.compraCliente.getNombres() + " " + this.compraCliente.getApellidos();
        return "Obra: " + compraObra.getTitulo() + "\n  PID: " + compraObra.getPid()+"\n"
                + "  Cliente:" + nombre_completo_cliente + "\n  Fecha:" + this.fechaRecibido.getTime()
                + "\n  Precio: " + compraObra.getPrecioRef();
    }
}
