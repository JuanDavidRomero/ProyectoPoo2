package model.archivos;

import java.util.ArrayList;
import model.Artista;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ArtistaArchivo
{
    @XmlElement (name="artista")
    private ArrayList<Artista> artistas ;

    public ArtistaArchivo() {
        this.artistas = new ArrayList<Artista>();
    }


    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(Artista artista) {
        this.artistas.add(artista);
    }
}