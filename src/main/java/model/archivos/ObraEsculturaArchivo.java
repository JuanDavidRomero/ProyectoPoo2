package model.archivos;

import model.Escultura;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class ObraEsculturaArchivo
{
    @XmlElement(name="Escultura")
    private ArrayList<Escultura> esculturas = new ArrayList<Escultura>();

    public ObraEsculturaArchivo() {
    }

    public ArrayList<Escultura> getEsculturas() {
        return esculturas;
    }

    public void setEsculturas(Escultura escultura) {
        this.esculturas.add(escultura);
    }
}