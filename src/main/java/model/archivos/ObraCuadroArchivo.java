package model.archivos;

import model.Cuadro;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class ObraCuadroArchivo
{
    @XmlElement(name="cuadro")
    private ArrayList<Cuadro> cuadros = new ArrayList<Cuadro>();

    public ObraCuadroArchivo() {
    }

    public ArrayList<Cuadro> getCuadros() {
        return cuadros;
    }

    public void setCuadros(Cuadro cuadro) {
        this.cuadros.add(cuadro);
    }
}