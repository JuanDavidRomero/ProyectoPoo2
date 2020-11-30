package model.archivos;

import model.Compra;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class CompraArchivo
{
    @XmlElement(name="compra")
    private ArrayList<Compra> Compras;

    public CompraArchivo() {
        this.Compras =new ArrayList<>();
    }

    public ArrayList<Compra> getCompras() {
        return Compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.Compras = compras;
    }
}