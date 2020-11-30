package model.archivos;

import model.Cliente;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class ClienteArchivo
{
    @XmlElement(name="cliente")
    private ArrayList<Cliente> clientes;

    public ClienteArchivo() {
        this.clientes =new ArrayList<>();
    }


    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Cliente cliente) {
        this.clientes.add(cliente);
    }
}