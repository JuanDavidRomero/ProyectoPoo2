package model.archivos;

import model.Obra;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class ObraArchivo
{
    // @XmlElement(name="Obra")
    private ArrayList<Obra> obras = new ArrayList<Obra>();

    public ObraArchivo() {
    }

    public ArrayList<Obra> getObras() {
        return obras;
    }

    public void setObras(ArrayList<Obra> obras) {
        this.obras = obras;
    }
}