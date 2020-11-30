package controller;

import model.*;
import model.archivos.*;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControlArchivos
{
    private HashMap <String,String> listaRutas = new HashMap<>();

    // asignar rutas
    public ControlArchivos()
    {
        listaRutas.put("artistas","./archivos/Artistas.xml");
        listaRutas.put("clientes","./archivos/Clientes.xml");
        listaRutas.put("compras","./archivos/Compras.xml");
        listaRutas.put("cuadros","./archivos/Obras/Cuadros.xml");
        listaRutas.put("esculturas","./archivos/Obras/Esculturas.xml");
        listaRutas.put("instalaciones","./archivos/Obras/Instalaciones.xml");
    }

    // escribir datos de prueba . PROGRAMADORES
    // actualizar datos archivo, general

    public  void escribirDatos(ControlGaleria datos)
    {
        System.out.println("Escribiendo artistas...");
        this.escrbirArtistas(datos.getListaArtistas());
        System.out.println("Artistas escritos ");

        System.out.println("\nEscribiendo clientes...");
        this.escribirClientes(datos.getListaClientes());
        System.out.println("Clientes escritos ");


        System.out.println("\nEscribiendo compras...");
        this.escribirCompras(datos.getListaCompras());
        System.out.println("Compras escritos ");


        System.out.println("\nEscribiendo cuadros...");
        this.escribirCuadro(datos.getListaObras());
        System.out.println("Cuadros escritos ");


        System.out.println("\nEscribiendo Instalaciones...");
        this.escribirInstalacion(datos.getListaObras());
        System.out.println("Instalaciones escritas ");

        System.out.println("\nEscribiendo esculturas...");
        this.escribirEscultura(datos.getListaObras());
        System.out.println("Esculturas escritas ");


    }

    public void cargarDatosArchivos(ControlGaleria galeria)
    {
        // cargando artistas
        System.out.println("Cargando info artistas...");
        ArtistaArchivo archivoA= leerArtistas(1);
        Map subirA = new HashMap();

        for(Artista cargar: archivoA.getArtistas())
        {
            subirA.put(cargar.getCedula(),cargar);
        }

        // cargando clientes
        System.out.println("Cargando info clientes...");
        Map subirC = new HashMap();
        ClienteArchivo archivoC= leerClientes(1);

        for(Cliente cargar2: archivoC.getClientes())
        {
            subirC.put(cargar2.getCedula(),cargar2);
        }

        // cargando compras
        System.out.println("Cargando info compras...");
        CompraArchivo archivoCo = leerCompras(1);
        ArrayList<Compra> subirCo = new ArrayList<>();

        for(Compra agregar: archivoCo.getCompras())
        {
            subirCo.add(agregar);
        }

        // cargando cuadros
        System.out.println("Cargando info cuadros...");
        ObraCuadroArchivo archivoCu = leerCuadro(1);
        ArrayList<Obra> subirO = new ArrayList<>();

        for(Obra agregarCu : archivoCu.getCuadros())
        {
            subirO.add(agregarCu);
        }

        // cargando instalaciones
        System.out.println("Cargando info instalaciones...");
        ObraInstalacionArchivo archivoI = leerInstalacion(1);

        for(Obra agregarI : archivoI.getInstalaciones())
        {
            subirO.add(agregarI);
        };


        // cargando esculturas
        System.out.println("Cargando info esculturas...");
        ObraEsculturaArchivo archivoE = leerEscultura(1);

        for(Obra agregarE : archivoE.getEsculturas())
        {
            subirO.add(agregarE);
        }

        // actualizar galeria
        galeria.setListaArtistas(subirA);
        galeria.setListaClientes(subirC);
        galeria.setListaCompras(subirCo);
        galeria.setListaObras(subirO);



    }

    public void relacionAO(ControlGaleria galeria)
    {
        ArrayList<Obra> listaO = galeria.getListaObras();

        for(Obra enlazando: galeria.getListaObras())
        {
            //   System.out.println("ya casi");
            for(Long llave: galeria.getListaArtistas().keySet())
            {
                //     System.out.println("vamos");
                for(Obra deA : galeria.getListaArtistas().get(llave).getObras())
                {
                    //       System.out.println("pasa");
                    if(enlazando.getTitulo().equals(deA.getTitulo()))
                    {
                        enlazando.setArtistas(galeria.getListaArtistas().get(llave));
                        //         System.out.println("enlazado");
                    }

                }

            }
        }


    }

    // leer datos de prueba. PROGRAMADORES

    public void leerDatosPrueba(int opcion)
    {
        switch (opcion)
        {
            case 1: leerArtistas(0); break;
            case 2: leerClientes(0); break;
            case 3: leerCompras(0); break;
            case 4: leerCuadro(0); break;
            case 5: leerInstalacion(0); break;
            case 6: leerEscultura(0); break;
            default:
                System.out.println("Sorry no esta disponible esta opcion");
                break;
        }
    }

    // escribir especifico

    public void escrbirArtistas(Map<Long, Artista> infoArtistas )
    {
        ArtistaArchivo escribir = new ArtistaArchivo();
        String ruta = listaRutas.get("artistas");

        for(Long llave : infoArtistas.keySet())
        {
            escribir.setArtistas(infoArtistas.get(llave));
        }

        try
        {
            File file = new File(ruta);
            if(file.exists())
            {
                file.delete();
            }

        }catch(Exception e)
        {

        }

        try(FileWriter fw =new FileWriter(ruta,true))
        {
            JAXBContext context = JAXBContext.newInstance(ArtistaArchivo.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            m.marshal(escribir,fw);
        }catch (IOException e)
        {
            System.out.println("Error escribiendo en archivo");
            e.printStackTrace();
        }
        catch(JAXBException e)
        {
            System.out.println("Error conviertiendo objeto en XML");
            e.printStackTrace();
        }

    }
    public ArtistaArchivo leerArtistas(int a)
    {
        String ruta= listaRutas.get("artistas");
        ArtistaArchivo listaA = new ArtistaArchivo();

        try(FileReader fr = new FileReader(ruta))
        {
            listaA= JAXB.unmarshal(fr, ArtistaArchivo.class);

            if (a == 0)
            {
                for(Artista mostrar: listaA.getArtistas() )
                {
                    System.out.println(mostrar.toString());
                    System.out.println("\t\t\t");
                }
            }

            return listaA;


        }
        catch (FileNotFoundException e)
        {
            System.err.println("El archivo no se encontro:"+e.getMessage());
        }catch (IOException e)
        {
            System.err.println("Error al procesar archivo: "+e.getMessage());
            e.printStackTrace();
        }

        return listaA;


    }

    public void escribirClientes(Map<Long, Cliente> infoClientes)
    {
        ClienteArchivo escribir = new ClienteArchivo();
        String ruta = listaRutas.get("clientes");

        for(Long llave : infoClientes.keySet())
        {
            escribir.setClientes(infoClientes.get(llave));
        }

        try
        {
            File file = new File(ruta);
            if(file.exists())
            {
                file.delete();
            }

        }catch(Exception e)
        {

        }

        try(FileWriter fw =new FileWriter(ruta,true))
        {
            JAXBContext context = JAXBContext.newInstance(ClienteArchivo.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            m.marshal(escribir,fw);
        }catch (IOException e)
        {
            System.out.println("Error escribiendo en archivo");
            e.printStackTrace();
        }
        catch(JAXBException e)
        {
            System.out.println("Error conviertiendo objeto en XML");
            e.printStackTrace();
        }
    }
    public ClienteArchivo leerClientes(int a)
    {
        String ruta= this.listaRutas.get("clientes");
        ClienteArchivo listaA = new ClienteArchivo();

        try(FileReader fr = new FileReader(ruta))
        {
            listaA= JAXB.unmarshal(fr, ClienteArchivo.class);

            if(a==0)
            {
                for(Cliente mostrar: listaA.getClientes() )
                {
                    System.out.println("\n"+mostrar.toString());
                    System.out.println("\t\t\t");
                }
            }

            return listaA;

        }
        catch (FileNotFoundException e)
        {
            System.err.println("El archivo no se encontro:"+e.getMessage());
        }catch (IOException e)
        {
            System.err.println("Error al procesar archivo: "+e.getMessage());
            e.printStackTrace();
        }

        return listaA;
    }

    public void escribirCompras(ArrayList<Compra> infoCompras)
    {
        String ruta = listaRutas.get("compras");
        CompraArchivo escribir = new CompraArchivo();
        escribir.setCompras(infoCompras);

        try
        {
            File file = new File(ruta);
            if(file.exists())
            {
                file.delete();
            }

        }catch(Exception e)
        {

        }

        try(FileWriter fw =new FileWriter(ruta,true))
        {
            JAXBContext context = JAXBContext.newInstance(CompraArchivo.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            m.marshal(escribir,fw);
            System.out.println("escrito");
        }catch (IOException e)
        {
            System.out.println("Error escribiendo en archivo");
            e.printStackTrace();
        }
        catch(JAXBException e)
        {
            System.out.println("Error conviertiendo objeto en XML");
            e.printStackTrace();
        }


    }
    public CompraArchivo leerCompras(int a)
    {
        String ruta=listaRutas.get("compras");
        CompraArchivo listaA = new CompraArchivo();
        try(FileReader fr = new FileReader(ruta))
        {
            listaA= JAXB.unmarshal(fr, CompraArchivo.class);

            if(a==0)
            {
                for(Compra mostrar: listaA.getCompras() )
                {
                    System.out.println(mostrar);
                    System.out.println("\t\t\t");
                }
            }

            return listaA;
        }
        catch (FileNotFoundException e)
        {
            System.err.println("El archivo no se encontro:"+e.getMessage());
        }catch (IOException e)
        {
            System.err.println("Error al procesar archivo: "+e.getMessage());
            e.printStackTrace();
        }

        return listaA;
    }

    public void escribirCuadro(ArrayList<Obra> infoObras)
    {
        String ruta = listaRutas.get("cuadros");
        ObraCuadroArchivo escribir = new ObraCuadroArchivo();

        for(Obra mira: infoObras)
        {
            if(mira instanceof Cuadro)
            {
                escribir.setCuadros((Cuadro)mira);
            }
        }


        try
        {
            File file = new File(ruta);
            if(file.exists())
            {
                file.delete();
            }

        }catch(Exception e)
        {

        }

        try(FileWriter fw =new FileWriter(ruta,true))
        {
            JAXBContext context = JAXBContext.newInstance(ObraCuadroArchivo.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            m.marshal(escribir,fw);
            System.out.println("escrito");
        }catch (IOException e)
        {
            System.out.println("Error escribiendo en archivo");
            e.printStackTrace();
        }
        catch(JAXBException e)
        {
            System.out.println("Error conviertiendo objeto en XML");
            e.printStackTrace();
        }


    }
    public ObraCuadroArchivo leerCuadro(int a)
    {
        String ruta= listaRutas.get("cuadros");
        ObraCuadroArchivo listaA= new ObraCuadroArchivo();

        try(FileReader fr = new FileReader(ruta))
        {
            listaA= JAXB.unmarshal(fr, ObraCuadroArchivo.class);
            if(a==0)
            {
                for(Cuadro mostrar: listaA.getCuadros() )
                {
                    System.out.println(mostrar.toString());
                    System.out.println("\t\t\t");
                }
            }

            return listaA;
        }
        catch (FileNotFoundException e)
        {
            System.err.println("El archivo no se encontro:"+e.getMessage());
        }catch (IOException e)
        {
            System.err.println("Error al procesar archivo: "+e.getMessage());
            e.printStackTrace();
        }

        return listaA;
    }

    public void escribirInstalacion(ArrayList<Obra> infoObras)
    {
        String ruta = listaRutas.get("instalaciones");
        ObraInstalacionArchivo escribir = new ObraInstalacionArchivo();

        for(Obra mira: infoObras)
        {
            if(mira instanceof Instalacion)
            {
                escribir.setInstalaciones((Instalacion) mira);
            }
        }


        try
        {
            File file = new File(ruta);
            if(file.exists())
            {
                file.delete();
            }

        }catch(Exception e)
        {

        }

        try(FileWriter fw =new FileWriter(ruta,true))
        {
            JAXBContext context = JAXBContext.newInstance(ObraInstalacionArchivo.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            m.marshal(escribir,fw);
            System.out.println("escrito");
        }catch (IOException e)
        {
            System.out.println("Error escribiendo en archivo");
            e.printStackTrace();
        }
        catch(JAXBException e)
        {
            System.out.println("Error conviertiendo objeto en XML");
            e.printStackTrace();
        }



    }
    public ObraInstalacionArchivo leerInstalacion(int a)
    {
        String ruta= listaRutas.get("instalaciones");
        ObraInstalacionArchivo listaA = new ObraInstalacionArchivo();
        try(FileReader fr = new FileReader(ruta))
        {
            listaA= JAXB.unmarshal(fr, ObraInstalacionArchivo.class);

            if(a==0)
            {
                for(Instalacion mostrar: listaA.getInstalaciones() )
                {
                    System.out.println(mostrar.toString());
                    System.out.println("\t\t\t");
                }
            }

            return listaA;

        }
        catch (FileNotFoundException e)
        {
            System.err.println("El archivo no se encontro:"+e.getMessage());
        }catch (IOException e)
        {
            System.err.println("Error al procesar archivo: "+e.getMessage());
            e.printStackTrace();
        }

        return listaA;
    }

    public void escribirEscultura(ArrayList<Obra> infoObras)
    {
        String ruta = listaRutas.get("esculturas");
        ObraEsculturaArchivo escribir = new ObraEsculturaArchivo();

        for(Obra mira: infoObras)
        {
            if(mira instanceof Escultura)
            {
                escribir.setEsculturas((Escultura) mira);
            }
        }


        try
        {
            File file = new File(ruta);
            if(file.exists())
            {
                file.delete();
            }

        }catch(Exception e)
        {

        }

        try(FileWriter fw =new FileWriter(ruta,true))
        {
            JAXBContext context = JAXBContext.newInstance(ObraEsculturaArchivo.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            m.marshal(escribir,fw);
            System.out.println("escrito");
        }catch (IOException e)
        {
            System.out.println("Error escribiendo en archivo");
            e.printStackTrace();
        }
        catch(JAXBException e)
        {
            System.out.println("Error conviertiendo objeto en XML");
            e.printStackTrace();
        }

    }
    public ObraEsculturaArchivo leerEscultura(int a)
    {
        String ruta= listaRutas.get("esculturas");
        ObraEsculturaArchivo listaA = new ObraEsculturaArchivo();
        try(FileReader fr = new FileReader(ruta))
        {
            listaA= JAXB.unmarshal(fr, ObraEsculturaArchivo.class);

            if(a==0)
            {
                for(Escultura mostrar: listaA.getEsculturas() )
                {
                    System.out.println(mostrar.toString());
                    System.out.println("\t\t\t");
                }

            }

            return listaA;

        }
        catch (FileNotFoundException e)
        {
            System.err.println("El archivo no se encontro:"+e.getMessage());
        }catch (IOException e)
        {
            System.err.println("Error al procesar archivo: "+e.getMessage());
            e.printStackTrace();
        }

        return listaA;
    }

    /*
    escribir
    leer
    actualizar
    poner los datos en programa y hacer relaciones
     */

    // modifi
    public static void modificar()
    {

        String ruta= "C:\\Users\\kamio\\Desktop\\3 semestre\\POO\\Do's\\Proyecto\\3_entrega\\ProyectoPoo2\\archivos\\Artistas.xml";
        try(FileReader fr = new FileReader(ruta))
        {
            ArtistaArchivo listaA= JAXB.unmarshal(fr, ArtistaArchivo.class);

            listaA.getArtistas().get(0).setNombres("Kamila");
            File fichero = new File(ruta);
            fichero.delete();

            //escribir(listaA);


        }catch (FileNotFoundException e)
        {
            System.err.println("El archivo no se encontro:"+e.getMessage());
        }catch (IOException e)
        {
            System.err.println("Error al procesar archivo: "+e.getMessage());
            e.printStackTrace();
        }

    }
}