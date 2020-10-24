package controller;

import model.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestControlGaleria{
    private static ControlGaleria controlador;
    private static GestionObras controlObras;
    private static GestionCliente controlClientes;

    @BeforeClass
    public static void BeforeDeLaClase(){
        System.out.println("Inicio de testing");
        controlador=new ControlGaleria();
        controlObras=new GestionObras();
        controlClientes=new GestionCliente();
        ArrayList<Cliente> listaClientes=new ArrayList<>();
        ArrayList<Compra> listaCompras = new ArrayList<>();
        ArrayList<Obra> listaObras= new ArrayList<>();
        ArrayList<Artista> listaArtistas= new ArrayList<>();
        Calendar C1= new GregorianCalendar(2020,11,12);
        Calendar C2= new GregorianCalendar(2012,11,13);
        Calendar C3= new GregorianCalendar(2018,4,23);
        Calendar C4= new GregorianCalendar(2002,9,3);
        Calendar C5= new GregorianCalendar(2006,0,7);
        Calendar C6= new GregorianCalendar(2006,0,7);


        Cliente c1 = listaClientes.get(0);
        Cliente c2 = listaClientes.get(1);
        Cliente c3 = listaClientes.get(2);

        Obra o1 = listaObras.get(0);
        Obra o2 = listaObras.get(1);
        Obra o3 = listaObras.get(2);
        Obra o5 = listaObras.get(4);
        Obra o7 = listaObras.get(6);
        Obra o8 = listaObras.get(7);

        Compra cp1 = new Compra(1000, C1, true, "andres", c1, o1);
        Compra cp2 = new Compra(1001, C2, false, "santi", c1, o3);
        Compra cp3 = new Compra(1002, C3, true, "kami", c2, o2);
        Compra cp4 = new Compra(1003, C4, false, "juan", c3, o7);
        Compra cp5 = new Compra(1004, C5, true, "sofi", c3, o8);
        Compra cp6 = new Compra(1005, C6, false, "adri", c3, o5);

        // Agregar lista
        listaCompras.add(cp1);
        listaCompras.add(cp2);
        listaCompras.add(cp3);
        listaCompras.add(cp4);
        listaCompras.add(cp5);
        listaCompras.add(cp6);
    }

    @Test
    public void opcion1Test() {
        System.out.println("Test de la opcion 1");
    }

    @Test
    public void opcion2Test(){
        System.out.println("Test de la opcion 2");
    }

    @Test
    public void opcion3Test(){
        System.out.println("Test de la opcion 3");
    }

    @Test
    public void opcion4Test(){
        System.out.println("Test de la opcion 4");
    }

    @Test
    public void opcion5Test(){
        System.out.println("Test de la opcion 5");
        long pid = 2345671;
        Obra busqueda = controlObras.buscarObraCodigo(pid,this.controlador.getListaObras());
        Assert.assertNotNull("Eliminacion exitosa",controlObras.eliminarObra(this.controlador.getListaObras(), this.controlador.getListaCompras(), busqueda));
        long pid2 = 3894238;
        Obra busqueda2 = controlObras.buscarObraCodigo(pid2,this.controlador.getListaObras());
        Assert.assertNotNull("No se encontro la obra a eliminar",controlObras.eliminarObra(this.controlador.getListaObras(), this.controlador.getListaCompras(), busqueda2));
    }

    @Test
    public void opcion6Test(){
        System.out.println("Test de la opcion 6");
    }

    @Test
    public void opcion7Test(){
        System.out.println("Test de la opcion 7");
    }

    @Test
    public void opcion8Test(){
        System.out.println("Test de la opcion 8");
    }
}
