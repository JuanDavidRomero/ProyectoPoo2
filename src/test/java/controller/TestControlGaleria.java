package controller;

import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.PasswordAuthentication;
import java.util.*;

public class TestControlGaleria
{
    public static ControlGaleria controlador;

    @Before
    public void crearDatosPrueba()
    {
        System.out.println("Inicio de testing");
        controlador=new ControlGaleria();

        ArrayList<Compra> listaCompras = new ArrayList<>();
        ArrayList<Obra> listaObras= new ArrayList<>();
        HashMap <Long,Artista> listaArtistas = new HashMap<Long,Artista>();
        HashMap <Long,Cliente> listaClientes = new HashMap<>();

        // Clientes
        //crea objetos
        Cliente c1 = new Cliente(1111111, 876543210, "wu", "zetian" , "avenida 13", 311585424);
        Cliente c2 = new Cliente(2222222, 765432109, "charles", "talleyrand", "avenida 14", 311585422);
        Cliente c3 = new Cliente(3333333,543210987,"victor","lustig","avenida 15",311585423);

        //añade a mapa
        listaClientes.put((long) 876543210,c1);
        listaClientes.put((long)765432109, c2);
        listaClientes.put((long)543210987, c3);

        //Obras
        //crea objetos
        Calendar fechaAgregar1 = Calendar.getInstance();
        Calendar fechaAgregar2 = Calendar.getInstance();
        Calendar fechaAgregar3 = Calendar.getInstance();
        Calendar fechaAgregar4 = Calendar.getInstance();
        Calendar fechaAgregar5 = Calendar.getInstance();
        Calendar fechaAgregar6 = Calendar.getInstance();

        // Escultura
        fechaAgregar1.set(Calendar.YEAR,1950);
        Material m1 = new Material("madera", "Los árboles son una creación asombrosa de la naturaleza");
        Obra o1 = new Escultura(2345671,"autorretrado con chaqueta azul",fechaAgregar1,80000.0,"grande",m1, 15.1);

        fechaAgregar2.set(Calendar.YEAR,1800);
        Material m2 = new Material("marmol", "es una roca metamorfica compacta formada a partir de rocas calizas");
        Obra o2 = new Escultura(7123456,"La Piedad ",fechaAgregar2,34800000.0,"grande",m2,25.7);

        // Instalacion
        fechaAgregar3.set(Calendar.YEAR,1922);
        Obra o3 = new Instalacion(1234567,"Galerie Bruno Bishofberger",fechaAgregar3,40000.0,"grande", "plaza sol");

        fechaAgregar4.set(Calendar.YEAR,1651);
        Obra o4 = new Instalacion(5671234,"Esther Arias Galerías de Arte y Taller",fechaAgregar4,200000000.0,"grande","Situado en un antiguo edificio del siglo XVIII");

        // Cuadro
        fechaAgregar5.set(Calendar.YEAR,1877);
        Obra o5 = new Cuadro(3456712,"remeros en el yernes",fechaAgregar5,60000.0,"normal","Marlborough", "Óleo",Clasificacion.OBRA_MAESTRA);

        fechaAgregar6.set(Calendar.YEAR,1931);
        Obra o6 = new Cuadro(4567123,"la persistencia de la memoria",fechaAgregar6,1000000.0,"grande","Los relojes blandos o Los relojes derretidos", "Oleo", Clasificacion.OBRA_MAESTRA);

        //añade a lista

        listaObras.add(o1);
        listaObras.add(o2);
        listaObras.add(o3);
        listaObras.add(o4);
        listaObras.add(o5);
        listaObras.add(o6);

        // Compras
        //crea objetos
        Calendar C1= new GregorianCalendar(2020,11,12);
        Calendar C2= new GregorianCalendar(2012,11,13);
        Calendar C3= new GregorianCalendar(2018,4,23);

        Compra cp1 = new Compra(1000, C1, true, "andres", c1, o1);
        Compra cp2 = new Compra(1001, C2, false, "santi", c2, o3);
        Compra cp3 = new Compra(1002, C3, true, "kami", c3, o5);

        //añade a lista
        listaCompras.add(cp1);
        listaCompras.add(cp2);
        listaCompras.add(cp3);

        // Artistas
        //crea objetos
        Calendar fechaAgregar7 = Calendar.getInstance();
        Calendar fechaAgregar8 = Calendar.getInstance();
        Calendar fechaAgregar9 = Calendar.getInstance();
        fechaAgregar7.set(1884,1,12);
        Artista a1 = new Artista(023,123456789,"max","beckmann" ,fechaAgregar7,311585421);
        fechaAgregar8.set(1848,7, 19);
        Artista a2 = new Artista(002,234567890,"gustave","caillebotte",fechaAgregar8,311585422);
        fechaAgregar9.set(1904,4,11);
        Artista a3 = new Artista(003,345678901,"salvador","dali",fechaAgregar9,311585423);
        //crea relaciones
        a1.setObras(o1);
        a1.setObras(o2);
        a1.setObras(o3);
        a2.setObras(o4);
        a2.setObras(o5);
        a3.setObras(o6);

        o1.setArtistas(a1);
        o2.setArtistas(a1);
        o3.setArtistas(a1);
        o4.setArtistas(a2);
        o5.setArtistas(a2);
        o6.setArtistas(a3);

        //añade a lista
        listaArtistas.put(a1.getCedula(), a1);
        listaArtistas.put(a2.getCedula(), a2);
        listaArtistas.put(a3.getCedula(), a3);

        controlador.setListaArtistas(listaArtistas);
        controlador.setListaCompras(listaCompras);
        controlador.setListaObras(listaObras);
        controlador.setListaClientes(listaClientes);
    }


    @Test
    public void opcion1Test()
    {
        System.out.println("-Realizando la prueba 1");
        ArrayList<Obra> disponibles = new ArrayList<>();
        ArrayList<Obra> enCompra= new ArrayList<>();

        // hace una lista de las obras con compras
        for(Compra obrasC : controlador.getListaCompras())
        {
            enCompra.add(obrasC.getCompraObra());
        }
        // compara la lista de las obras con compras y las obras normales
        for(Obra compara: controlador.getListaObras())
        {
            if(!enCompra.contains(compara))
            {
                disponibles.add(compara);
            }
        }

        // TEST

        Assert.assertTrue("La obra o1 de tipo escultura, no deberia estar en disponible",disponibles.contains(controlador.getListaObras().get(0)));
        Assert.assertTrue("La obra o2 de tipo escultura,  deberia estar en disponible",disponibles.contains(controlador.getListaObras().get(1)));
        Assert.assertFalse("La obra o3 de tipo intaslacion, no deberia estar en disponible",disponibles.contains(controlador.getListaObras().get(2)));
        Assert.assertTrue("La obra o4 de tipo intaslacion, deberia estar en disponible",disponibles.contains(controlador.getListaObras().get(3)));
        Assert.assertFalse("La obra o5 de tipo cuadro, no deberia estar en disponible",disponibles.contains(controlador.getListaObras().get(4)));
        Assert.assertTrue("La obra o6 de tipo cuadro,  deberia estar en disponible",disponibles.contains(controlador.getListaObras().get(5)));

    }

    @Test
    public void opcion2Test_titulo()
    {
        System.out.println("-Realizando la prueba 2 por titulo");
        ArrayList<String> titulosB = new ArrayList<>();
        titulosB.add("La Piedad");
        titulosB.add("La Gioconda");

        for(int i=0;i<2;i++)
        {
            ArrayList <Obra> resultadoBusqueda = new ArrayList<>();
            boolean hayResultado =false;
            // ciclo para obras
            for(Obra obraBuscadora : controlador.getListaObras())
            {
                // aqui se mira si el titulo buscado y el de la obra actual son iguales o se parecen
                if(obraBuscadora.getTitulo().contains(titulosB.get(i)))
                {
                    hayResultado=true;
                    resultadoBusqueda.add(obraBuscadora);
                }
            }
            if(i==0)
            {
                Assert.assertTrue("la obra con titulo -La Piedad- no se ha encontrado",hayResultado);
            }

            if(i==1)
            {
                Assert.assertTrue("la obra con titulo -La gioconda- no se ha encontrado",hayResultado);
            }

        }

    }

    @Test
    public void opcion2Test_artista()
    {
        System.out.println("-Realizando la prueba 2 por nombre artista");
        ArrayList<String> artistaB = new ArrayList<>();
        artistaB.add("max beckmann");
        artistaB.add("andru play");

      for(int i=0;i<2;i++)
      {
          ArrayList <Obra> resultadoBusqueda = new ArrayList<>();
          boolean encontro=false;

          // ciclo para mirar las obras
          for(Obra obraBuscadora : controlador.getListaObras())
          {
              // ciclo para mirar los artistas de las obras
              for(Artista llave: obraBuscadora.getArtistas())
              {
                  Artista comparar = obraBuscadora.getArtistas().get(obraBuscadora.getArtistas().indexOf(llave));
                  // se une en un string el nombre y apellido del artista
                  String nombre= comparar.getNombres()+" "+comparar.getApellidos();

                  if(nombre.contains(artistaB.get(i)))
                  {
                      encontro=true;
                      resultadoBusqueda.add(obraBuscadora);
                  }
              }
          }

          if(i==0)
          {
              Assert.assertTrue("El artista con nombre -max beckmann- no se encontro",encontro);
          }
          if(i==1)
          {
              Assert.assertTrue("El artista con nombre -andru play- no se encontro",encontro);
          }

      }

    }

    @Test
    public void opcion2Test_ano()
    {
        System.out.println("-Realizando la prueba 2 por año");

        ArrayList<Integer> annoB = new ArrayList<>();
        annoB.add(1922);
        annoB.add(2020);

        for(int i=0;i<2;i++)
        {
            boolean encontrado=false;
            ArrayList <Obra> resultadoBusqueda = new ArrayList<>();

            // ciclo para ver las obras
            for(Obra obraBuscadora :controlador.getListaObras())
            {
                Calendar fecha = obraBuscadora.getFecha();
                int year = fecha.get(Calendar.YEAR);
                if(year==annoB.get(i))
                {
                    encontrado=true;
                    resultadoBusqueda.add(obraBuscadora);
                }
            }

            if(i==0)
            {
                Assert.assertTrue("El año 1922 no presenta resultados de busqueda",encontrado);
            }
            if(i==1)
            {
                Assert.assertTrue("El año 2020 no presenta resultados de busqueda",encontrado);
            }

        }


    }

    @Test
    public void opcion3Test()
    {
        //Insertar una obra
        System.out.println("-Realizando la prueba 3");

        Calendar fechaAgregar1 = Calendar.getInstance();
        fechaAgregar1.set(Calendar.YEAR,1924);
        Instalacion o1 = new Instalacion(8888888,"la prueba",fechaAgregar1,90000.0,"grande", "es una obra muy bonita que nos dara un cinco");

        Calendar fechaAgregar2 = Calendar.getInstance();
        fechaAgregar2.set(Calendar.YEAR,1925);
        Cuadro o2 = new Cuadro(7778886,"la prueba2",fechaAgregar2,60000.0,"normal","cafe aguila roja", "Óleo",Clasificacion.OBRA_MAESTRA);

        Calendar fechaAgregar3 = Calendar.getInstance();
        fechaAgregar1.set(Calendar.YEAR,1926);
        Material m1 = new Material("madera", "estamos trascendiedo la sobreescritura");
        Escultura o3 = new Escultura(3334445,"la prueba3",fechaAgregar3,80000.0,"grande",m1, 15.1);

        for(int i=1;i<=3;i++)
        {
            if(i == 1)
            {
                boolean respuesta = controlador.getControlObras().checkpid(o3.getPid(), controlador.getListaObras());
                if(!respuesta)
                {
                    System.out.println("no se pudo crear la nueva obra escultura");
                    return;
                }
                Material nE =o3.getMaterial();
                double peso =o3.getPeso();
                Obra nueva = new Escultura(o3.getPid(),o3.getTitulo(),o3.getFecha(),o3.getPrecioRef(),o3.getDimenciones(),o3.getMaterial(),peso);
                controlador.getListaObras().add(nueva);
            }
            else if(i == 2)
            {
                boolean respuesta = controlador.getControlObras().checkpid(o1.getPid(), controlador.getListaObras());
                if(!respuesta)
                {
                    System.out.println("no se pudo crear la nueva obra instalacion");
                    return;
                }
                System.out.println("JESUS PLS");
                Obra nueva = new Instalacion(o1.getPid(),o1.getTitulo(),o1.getFecha(),o1.getPrecioRef(),o1.getDimenciones(),o1.getDescripcion());
                controlador.getListaObras().add(nueva);
            }
            else if(i == 3)
            {
                boolean respuesta = controlador.getControlObras().checkpid(o2.getPid(), controlador.getListaObras());
                if(!respuesta)
                {
                    System.out.println("no se pudo crear la nueva obra cuadro");
                    return;
                }

                String tema = o2.getTema();
                String tecnica = o2.getTecnica();
                Clasificacion clasificacion =o2.getClasificacion();

                Obra nueva = new Cuadro(o2.getPid(),o2.getTitulo(),o2.getFecha(),o2.getPrecioRef(),o2.getDimenciones(),tema, tecnica,clasificacion);
                controlador.getListaObras().add(nueva);
            }
            else{System.out.println("valor no valido");}

        }
        Assert.assertTrue("No se encuentra la obra o1",controlador.getListaObras().contains(o1));
        Assert.assertTrue("No se encuentra la obra o2",controlador.getListaObras().contains(o2));
        Assert.assertTrue("No se encuentra la obra o3",controlador.getListaObras().contains(o3));
        Obra o4 = o1;
        o4.setTitulo("idk cambio");
        Assert.assertTrue("No se encuentra la obra o4",controlador.getListaObras().contains(o4));

    }

    @Test
    public void opcion4Test()
    {
        //4.Modificar una Obra
    }

    @Test
    public void opcion5Test()
    {
        //5.Eliminar una Obra
        Obra busqueda1 = controlador.getControlObras().buscarObraCodigo(1234567, controlador.getListaObras());
        Obra result1 = controlador.getControlObras().eliminarObra(controlador.getListaObras(),controlador.getListaCompras(),busqueda1);

        Obra busqueda2 = controlador.getControlObras().buscarObraCodigo(7123456, controlador.getListaObras());
        Obra result2 = controlador.getControlObras().eliminarObra(controlador.getListaObras(),controlador.getListaCompras(),busqueda1);

        Assert.assertNotNull("La obra con el pib 1234567 no ha sido eliminada",result1);
        Assert.assertTrue("La obra on el pib 1234567 sigue en la lista de obras",controlador.getListaObras().contains(busqueda1));
        Assert.assertNotNull("La obra con el pib 7123456 no ha sido eliminada",result2);
        Assert.assertTrue("La obra con el pib 7123456 sigue en la lista de obras",controlador.getListaObras().contains(busqueda2));

    }

    @Test
    public void opcion7Test()
    {
        //7.Buscar un Cliente
        System.out.println("-Realizando la prueba 7");
        Cliente result1 = controlador.getControlClientes().buscarCliente(876543210,controlador.getListaClientes());
        Cliente result2 = controlador.getControlClientes().buscarCliente(879685746,controlador.getListaClientes());

        Assert.assertNotNull("El cliente con la cedula 876543210 no se ha encontrado",result1);
        Assert.assertNotNull("El cliente con la cedula 879685746 no se ha encontrado",result2);
    }

    @Test
    public void opcion8Test()
    {
        //8.Insertar Cliente
        System.out.println("-Realizando la prueba 8");

        Cliente c1 = new Cliente(4444444, 8665242, "Pablo", "el patron del mal" , "avenida napoles", 311586424);


        Cliente temp = new Cliente();
        temp.setCodigoCliente(c1.getCodigoCliente());

        if(!controlador.getListaClientes().containsValue(temp))
        {
            Cliente clienteNuevo=new Cliente(c1.getCodigoCliente(),c1.getCedula(),c1.getNombres(),c1.getApellidos(),c1.getDireccionEntrega(),c1.getTelefono());
            controlador.getListaClientes().put(c1.getCedula(),clienteNuevo);
            System.out.println("Cliente ingresado");
        }
        else
        {
            System.out.println("El codigo ya lo tiene registrado otro cliente");
            System.out.println("No se pudo añadir cliente");
        }

        Assert.assertTrue("El cliente con cedula 8665242 no ha sido agregado ",controlador.getListaClientes().containsKey(8665242));
        Assert.assertTrue("El cliente con cedula 1765242 no ha sido agregado ",controlador.getListaClientes().containsKey(1765242));


    }

    @Test
    public void opcion9Test()
    {
        //9.Modificar datos de Cliente
        System.out.println("-Realizando la prueba 9");
    }

    @Test
    public void opcion10Test()
    {
        //10.Eliminar un Cliente
        System.out.println("-Realizando la prueba 10");
    }

    @Test
    public void opcion11Test()
    {
        //11.Realizar compra de una Obra
        System.out.println("-Realizando la prueba 11");

        Cliente cli = controlador.getListaClientes().get((long)765432109);
        Obra obra = controlador.getControlObras().buscarObraCodigo(7123456, controlador.getListaObras());
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.YEAR,1990);
        long numeroP = controlador.compraDeUnaObraDirecto((long)1003,fecha,true,"alonzo",cli,obra);

        Compra buscar = controlador.getListaCompras().get(3);

        Assert.assertEquals("El precio esperadado y el actual",1003,buscar.getNumeroPedido());
        Assert.assertEquals("La fecha esperadada y la actual",fecha,buscar.getFechaRecibido());
        Assert.assertEquals("Pago esperado y el actual",true,buscar.isPagado());
        Assert.assertEquals("Nombre del repatidor esperado y el actual","alonzo",buscar.getNombreRepartidor());
        Assert.assertEquals("El nombre del cliente esperado y el actual",cli.getNombres(),buscar.getCompraCliente().getNombres());
        Assert.assertEquals("El titulo de la obra esperado y el actual",obra.getTitulo(),buscar.getCompraObra().getTitulo());
        Assert.assertEquals("El titulo de la obra esperado y el actual","Un titulo de error",buscar.getCompraObra().getTitulo());

    }

    @Test
    public void opcion12Test()
    {
        //12.Eliminar compra de obra
        System.out.println("-Realizando la prueba 12");
    }

    @Test
    public void opcion13Test()
    {
        //13.Ver listado de Compras existentes
        System.out.println("-Realizando la prueba 13");
    }

    @Test
    public void opcion14Test()
    {
        //14.Ver listado de Compras para un mes y año específico insertado por el usuario
        System.out.println("-Realizando la prueba 14");

    }

    @Test
    public void opcion15Test()
    {
        System.out.println("-Realizando la prueba 14");
        ArrayList<Long> llave = controlador.verListadoDeArtistasMasVendidos();

        Artista temp1 = controlador.getListaArtistas().get((long)123456789);
        Artista result = controlador.getListaArtistas().get(llave.get(0));
        Assert.assertEquals("La cedula del artista con mas ventas es ",temp1.getCedula(),result.getCedula());

        temp1 = controlador.getListaArtistas().get((long)234567890);
        result = controlador.getListaArtistas().get(llave.get(1));
        Assert.assertEquals("La cedula del artista en segundo lugar con mas ventas  es ",temp1.getCedula(),result.getCedula());

        temp1 = controlador.getListaArtistas().get((long)345678901);
        result = controlador.getListaArtistas().get(llave.get(0));
        Assert.assertEquals("La cedula del artista con mas ventas es ",temp1.getCedula(),result.getCedula());
    }



}
