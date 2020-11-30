package model.archivos;

import model.Instalacion;
import model.Obra;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class ObraInstalacionArchivo
{
    @XmlElement(name="Instalacion")
    private ArrayList<Instalacion> instalaciones = new ArrayList<>();

    public ObraInstalacionArchivo() {
    }

    public ArrayList<Instalacion> getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(Instalacion instalacion) {
        this.instalaciones.add(instalacion);
    }
}