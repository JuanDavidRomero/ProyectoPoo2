package controller;

import model.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;

public class GestionObras
{
    /* ver listado de obras disponibles
    se muestra un listado por pantalla que muestra la informacion
    basica de una obra(titulo,fecha de creacion,precio de referencia,una foto
    y sus dimensiones) solo deben salir las obras que estan disponibles
    para la compra. se debe usar de un metodo to String()*/
    public void VerObrasDisponibles(ArrayList<Compra> listaCompras, ArrayList<Obra> listaObras)
    {
        ArrayList<Obra> disponibles = new ArrayList<>();
        ArrayList<Obra> enCompra= new ArrayList<>();

        // hace una lista de las obras con compras
        for(Compra obrasC : listaCompras)
        {
            enCompra.add(obrasC.getCompraObra());
        }
        // compara la lista de las obras con compras y las obras normales
        for(Obra compara: listaObras)
        {
            if(!enCompra.contains(compara))
            {
                disponibles.add(compara);
            }
        }

        //imprime
        System.out.println("***Obras Disponibles***\n");
        for(Obra impri: disponibles)
        {
            //System.out.println("- "+impri.toString(0));
            System.out.println();
        }

    }

    // solo mostrar las obras que cumplan con el criterio de busqueda
    public void BuscarObra(String criterio, ArrayList<Obra> listaObras)
    {
        switch(criterio)
        {
            // se ingresa el criterio de busqueda
            case "titulo":{buscarObraTitulo(listaObras);}break;
            case "artista":{buscarObraArtista(listaObras);}break;
            case "año":{buscarObraAno(listaObras);}break;
            default :{System.out.println("Criterio no encontrado");}break;
        }
    }

    public void buscarObraTitulo(ArrayList<Obra> listaObras)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el titulo de la obra a buscar: ");
        String buscar = in.nextLine();
        ArrayList <Obra> resultadoBusqueda = new ArrayList<>();
        boolean hayResultado =false;
        // ciclo para obras
        for(Obra obraBuscadora : listaObras)
        {
            // aqui se mira si el titulo buscado y el de la obra actual son iguales o se parecen
            if(obraBuscadora.getTitulo().contains(buscar))
            {
                hayResultado=true;
                resultadoBusqueda.add(obraBuscadora);
            }
        }
        // se muestra en pantalla los resultados
        System.out.println("\n***Resultados busqueda***\n");
        for(Obra mostar: resultadoBusqueda)
        {
           // System.out.println("- "+mostar.toString(1));
            System.out.println();
        }
        if(!hayResultado)
        {
            System.out.println("No hay ninguna obra que coincida con la busqueda");
        }
    }

    public void buscarObraArtista(ArrayList<Obra> listaObras)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre del artista de la obra a buscar: ");
        String artista = in.nextLine();
        ArrayList <Obra> resultadoBusqueda = new ArrayList<>();
        boolean encontro=false;

        // ciclo para mirar las obras
        for(Obra obraBuscadora : listaObras)
        {
            // ciclo para mirar los artistas de las obras
          for(long llave: obraBuscadora.getArtistas().keySet())
            {

                Artista comparar = obraBuscadora.getArtistas().get(llave);
                // se une en un string el nombre y apellido del artista
                String nombre= comparar.getNombres()+" "+comparar.getApellidos();

                if(nombre.contains(artista))
                {
                    encontro=true;
                    resultadoBusqueda.add(obraBuscadora);
                }
            }
        }

        // se imprimen resultados
        if(encontro)
        {
            System.out.println("\n***Resultados busqueda***\n");
            for(Obra mostar: resultadoBusqueda)
            {
               // System.out.println("- "+mostar.toString(1));
                System.out.println();
            }
        }
        else
        {
            System.out.println("\n"+"No hay ninguna obra que coincida con la busqueda");
        }

    }

    public void buscarObraAno(ArrayList<Obra> listaObras)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el año de la obra a buscar: ");
        boolean encontrado=false;
        int ano= in.nextInt();
        ArrayList <Obra> resultadoBusqueda = new ArrayList<>();

        // ciclo para ver las obras
        for(Obra obraBuscadora : listaObras)
        {
            Calendar fecha = obraBuscadora.getFecha();
            int year = fecha.get(Calendar.YEAR);
            if(year==ano)
            {
                encontrado=true;
                resultadoBusqueda.add(obraBuscadora);
            }
        }
        // se muestran los resultados
        if(encontrado)
        {
            System.out.println("\n***Resultados busqueda***\n");
            for(Obra mostar: resultadoBusqueda)
            {
               // System.out.println("- "+mostar.toString(1)+"\n");
            }
        }
        else
        {
            System.out.println("\nNo hay ninguna obra que coincida con la busqueda");
        }
    }

    public Obra buscarObraCodigo(long codigo, ArrayList<Obra> listaObras)
    {
        // ciclo para ver laso bras
        for(Obra buscadora: listaObras)
        {
            if(buscadora.getPid()==codigo)
            {
                return buscadora;
            }
        }
        return null;
    }

    public void InsertarObra(ArrayList<Obra>listaObras, Map<Long, Artista> listaArtistas)
    {
        Scanner ingreso = new Scanner(System.in);
        Calendar fecha = Calendar.getInstance();
        // ingreso de datos nueva obra
        System.out.println("\n***Ingrese los datos de la nueva obra***");

        // se valida el pid con las codiciones de arriba
        System.out.print("\npid: ");
        long pid = ingreso.nextLong();
        ingreso = new Scanner(System.in);
        Obra temp =new Instalacion();
        temp.setPid(pid);
        boolean respuesta = checkpid(pid,listaObras);
        if(!respuesta)
        {
            System.out.println("no se pudo crear la nueva obra");
            return;
        }
        // ingreso titulo
        System.out.print("\nTitulo: ");
        String titulo = ingreso.nextLine();
        ingreso = new Scanner(System.in);
        // ingreso año
        System.out.print("\nFecha año :");
        int ano = ingreso.nextInt();
        ingreso = new Scanner(System.in);
        // ingreso precio
        System.out.print("\nPrecioRef: ");
        double precioRef = ingreso.nextDouble();
        ingreso = new Scanner(System.in);
        // ingreso dimensiones
        System.out.print("\nDimenciones: ");
        String dimensiones = ingreso.nextLine();
        ingreso = new Scanner(System.in);

        // se crea el objeto Obra
        fecha.set(Calendar.YEAR,ano);
        Obra nueva = new Instalacion(pid,titulo,fecha,precioRef,dimensiones,"plaza sol");//------->

        boolean artistaDone=false;

        // proceso para añadir un artista a la obra
        do{
            System.out.println("\n***Lista Artistas***");
            int numero=1;
            // se muestran la opcion de artistas
            System.out.println("0.Ingresar artista");
            for(Map.Entry<Long, Artista> mostrar: listaArtistas.entrySet())
            {
                System.out.println(numero+"."+mostrar.getValue().toString(1));
                numero+=1;
            }
            System.out.print("Para agregarle un Artista seleccione a uno de la lista: ");
            int selec = ingreso.nextInt();

            // se ingresa un nuevo artista a la lista
            if(selec==0)
            {
                this.InserArtista(listaArtistas);

            }
            // se seleciona un artista de la lista
            else if (selec<=listaArtistas.size())
            {
                artistaDone=true;
                selec-=1;
                if(listaArtistas.get(selec)!=null)
                {
                    Artista elnuevo = listaArtistas.get(selec);
                    nueva.setArtista(elnuevo);
                    elnuevo.setObras(nueva);
                    listaObras.add(nueva);
                }
                System.out.println("Obra ingresada\n");
            }

            else
            {
                System.out.println("Opcion no disponible");
            }

        }while(!artistaDone);
    }

    public void modifiObra(long codigo, ArrayList<Obra> listaObras,Map<Long, Artista> listaArtista)
    {
        Obra trabajo =buscarObraCodigo(codigo,listaObras);
        // condicion para ver si se encontro la obra con el codigo
        if(trabajo!=null)
        {
            // presentacion info Obra
            System.out.println("\n***Datos de la obra***\n");
            System.out.println(
                    "1.Titulo:"+trabajo.getTitulo()+
                            "\n2.Pid: "+trabajo.getPid()+
                            "\n3.Fecha: " +trabajo.getFecha().get(Calendar.YEAR)+
                            "\n4.PrecioRef: " +trabajo.getPrecioRef());
                          //  "\n5.Dimensiones: " +trabajo.getDimensiones());

            System.out.print("6.Artista: " );
           // for(Artista impri: trabajo.getArtista())
            {
            //    System.out.print(impri.toString(1,1)+".");
            }

            System.out.print("\n\nDigite el numero de la opcion que quiera modificar: ");
            Scanner entrada = new Scanner(System.in);
            int opcion = entrada.nextInt();

            switch (opcion)
            {
                case 1:
                {
                    System.out.print("Ingrese el nuevo titulo:");
                    entrada= new Scanner(System.in);
                    String nuevoT= entrada.nextLine();
                    trabajo.setTitulo(nuevoT);
                }break;

                case 2:
                {
                    System.out.print("Ingrese el nuevo pid:");
                    entrada= new Scanner(System.in);
                    long nuevoP= entrada.nextLong();
                    // se valida que el pid este dentro de la restricciones
                    if(this.checkpid(nuevoP,listaObras))
                    {
                        trabajo.setPid(nuevoP);
                    }
                    else
                    {
                        System.out.println("Lo sentimos, no se le pudo asignar nuevo pid a la obra");
                    }
                }break;

                case 3:
                {
                    int ano;
                    System.out.print("Ingrese el nuevo año");
                    entrada= new Scanner(System.in);
                    ano=entrada.nextInt();
                    Calendar fechaN = Calendar.getInstance();
                    fechaN.set(Calendar.YEAR,ano);
                    trabajo.setFecha(fechaN);
                }break;

                case 4:
                {
                    System.out.print("Ingrese el nuevo precio:");
                    entrada= new Scanner(System.in);
                    double nuevoPre= entrada.nextDouble();
                    trabajo.setPrecioRef(nuevoPre);
                }break;

                case 5:
                {
                    System.out.print("Ingrese las nuevas dimensiones:");
                    entrada= new Scanner(System.in);
                    String nuevoD= entrada.nextLine();
                    //trabajo.setDimensiones(nuevoD);
                }break;

                case 6:
                {
                    boolean esta=false;
                    do{
                        System.out.println("\n***Lista Artistas***\n");
                        int orden=1;
                        System.out.println("0.Ingresar nuevo artista");
                        // se presenta lista de artistas
                        for(Map.Entry<Long, Artista> impri: listaArtista.entrySet())
                        {
                            System.out.println(orden+"."+impri.getValue().toString(1));
                            orden+=1;
                        }
                        entrada = new Scanner((System.in));
                        System.out.print("\nIngrese el artista de la obra:");
                        int selec = entrada.nextInt();
                        // se añade un nuevo artista a la lista
                        if(selec==0)
                        {
                            this.InserArtista(listaArtista);
                        }
                        else
                        {
                            esta=true;
                            // quitarle la obra al artista anterior
                           // for(Artista viejo: trabajo.getArtista())
                            {
                               // viejo.getObras().remove(trabajo);
                            }
                            // quitarle el artista a la obra
                           // trabajo.getArtista().clear();
                            //asignarle el nuevo artista
                            Artista nuevo = listaArtista.get(selec-1);
                            trabajo.setArtista(nuevo);
                            // añadirle la obra al artista nuevo
                            nuevo.setObras(trabajo);
                        }
                    }while(!esta);
                }break;
                default: System.out.println("Esa opcion no esta disponible"); break;
            }
        }
        else
        {
            System.out.println("Lo siento, no hemos encontrado la obra con el codigo "+codigo);
        }
    }

    public void InserArtista(Map<Long, Artista> listaArtistas)
    {
        System.out.println("Ingrese los datos del artista\n");

        Scanner ingreso = new Scanner(System.in);

        int codigoArtista = listaArtistas.size();
        Artista ultimoA = listaArtistas.get(codigoArtista-1);
        long ultimoCod = ultimoA.getCodigoArtista()+1;

        System.out.print("Cedula: ");
        long cedula = ingreso.nextLong();
        ingreso = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = ingreso.nextLine();
        ingreso = new Scanner(System.in);
        System.out.print("Apellidos: ");
        String apellidos = ingreso.nextLine();

        ingreso = new Scanner(System.in);
        int ano,mes,dia;
        System.out.print("Año de nacimiento: ");
        ano = ingreso.nextInt();
        ingreso = new Scanner(System.in);
        System.out.print("Mes de nacimiento: ");
        mes = ingreso.nextInt();
        ingreso = new Scanner(System.in);
        System.out.print("Dia de nacimiento: ");
        dia = ingreso.nextInt();
        Calendar fechaNacimineto = Calendar.getInstance();
        fechaNacimineto.set(ano,mes,dia);
        ingreso = new Scanner(System.in);
        System.out.print("Telefono: ");
        long telefono = ingreso.nextLong();

        // se crea el objeto Artista y se añade a la lista
        Artista nuevo = new Artista(ultimoCod,cedula,nombre,apellidos,fechaNacimineto,telefono);
        listaArtistas.put(nuevo.getCodigoArtista(), nuevo);
    }

    private boolean checkpid(long pid, ArrayList<Obra> listaObras)
    {
        if((pid/1000000<=0))
        {
            System.out.println("Muy pocos digitos, deben ser 7");
            return false;
        }
        else if(10<=(pid/1000000))
        {
            System.out.println("Te pasaste de digitos! son solo 7");
            return false;
        }
        for(Obra checker: listaObras)
        {
            if(checker.getPid()==pid)
            {
                System.out.println("El pid ya lo tiene asignado otra obra ");
                return false;
            }
        }
        return true;
    }

    public Obra eliminarObra(ArrayList<Obra> eliminar,ArrayList<Compra> listaCompras, Obra obra)
    {
        if(eliminar.contains(obra))
        {
            boolean esta=false;
            for(Compra buscadora: listaCompras)
            {
                if(buscadora.getCompraObra().equals(obra))
                {
                    esta=true;
                }

            }
            if(!esta)
            {
                Obra eliminado = eliminar.remove(eliminar.indexOf(obra));
                System.out.println("Obra eliminada exitosamente");
                return eliminado;
            }
            else
            {
                System.out.println("La obra esta asocieda a una compra y no se puede eliminar");
                return null;
            }
        }
        else
        {
            System.out.println("obra no encontrada");
            return null;
        }
    }

    public void listaObras(ArrayList<Obra> listaObras, Map<Long, Artista> listaArtistas)
    {
        Calendar fechaAgregar1 = Calendar.getInstance();
        Calendar fechaAgregar2 = Calendar.getInstance();
        Calendar fechaAgregar3 = Calendar.getInstance();
        Calendar fechaAgregar4 = Calendar.getInstance();
        Calendar fechaAgregar5 = Calendar.getInstance();
        Calendar fechaAgregar6 = Calendar.getInstance();
        Calendar fechaAgregar7 = Calendar.getInstance();
        Calendar fechaAgregar8 = Calendar.getInstance();
        Calendar fechaAgregar9 = Calendar.getInstance();
        Calendar fechaAgregar10 = Calendar.getInstance();
        Calendar fechaAgregar11= Calendar.getInstance();
        Calendar fechaAgregar12 = Calendar.getInstance();
        Calendar fechaAgregar13 = Calendar.getInstance();
        Calendar fechaAgregar14 = Calendar.getInstance();
        Calendar fechaAgregar15 = Calendar.getInstance();
        Calendar fechaAgregar16 = Calendar.getInstance();

        //Obras
        fechaAgregar1.set(Calendar.YEAR,1922);
        Obra o1 = new Instalacion(1234567,"Galerie Bruno Bishofberger",fechaAgregar1,40000.0,"grande", "plaza sol");
        fechaAgregar2.set(Calendar.YEAR,1950);
        Material m1 = new Material("madera", "Los árboles son una creación asombrosa de la naturaleza");
        Obra o2 = new Escultura(2345671,"autorretrado con chaqueta azul",fechaAgregar2,80000.0,"grande",m1, 15.1);
        fechaAgregar3.set(Calendar.YEAR,1877);
        Obra o3 = new Cuadro(3456712,"remeros en el yernes",fechaAgregar3,60000.0,"normal","Marlborough", "Óleo",Clasificacion.OBRA_MAESTRA);
        fechaAgregar4.set(Calendar.YEAR,1931);
        Obra o4 = new Cuadro(4567123,"la persistencia de la memoria",fechaAgregar4,1000000.0,"grande","Los relojes blandos o Los relojes derretidos", "Oleo", Clasificacion.OBRA_MAESTRA);
        fechaAgregar5.set(Calendar.YEAR,1651);
        Obra o5 = new Instalacion(5671234,"Esther Arias Galerías de Arte y Taller",fechaAgregar5,200000000.0,"grande","Situado en un antiguo edificio del siglo XVIII");
        fechaAgregar6.set(Calendar.YEAR,1946);
        Obra o6 = new Instalacion(6712345,"Hans Mayer",fechaAgregar6,50000000.0,"grande","famoso por ser un espacio que abre sus puertas a otros tipos de arte");
        fechaAgregar7.set(Calendar.YEAR,1800);
        Material m2 = new Material("marmol", "es una roca metamorfica compacta formada a partir de rocas calizas");
        Obra o7 = new Escultura(7123456,"La Piedad ",fechaAgregar7,34800000.0,"grande",m2,25.7);
        fechaAgregar8.set(Calendar.YEAR,1901);
        Obra o8 = new Instalacion(2345678,"Annely Juda Fine Art ",fechaAgregar8,3000000000.0,"grande"," Artistas de todo el mundo se unen en una composición armónica y delicada que tienes que vivir");
        fechaAgregar9.set(Calendar.YEAR,1907);
        Material m3 = new Material("marmol", "es una roca metamorfica compacta formada a partir de rocas calizas");
        Obra o9 = new Escultura(3456789,"Venus de Milo",fechaAgregar9,88000.0,"grande",m3, 34.8);
        fechaAgregar16.set(Calendar.YEAR,1888);
        Obra o10 = new Instalacion(4567890,"Marlborough Fine Art",fechaAgregar16,23400000.0,"grande","está llena de los más reconocidos artistas contemporáneos.");

        // Artista
        fechaAgregar10.set(1884,1,12);
        Artista a1 = new Artista(023,123456789,"max","beckmann" ,fechaAgregar10,311585421);
        fechaAgregar11.set(1848,7, 19);
        Artista a2 = new Artista(002,234567890,"gustave","caillebotte",fechaAgregar11,311585422);
        fechaAgregar12.set(1904,4,11);
        Artista a3 = new Artista(003,345678901,"salvador","dali",fechaAgregar12,311585423);
        fechaAgregar13.set(1746,2,30);
        Artista a4 = new Artista(004,456789012,"francisco","de goya",fechaAgregar13, 311585424);
        fechaAgregar14.set(1862,5,14);
        Artista a5 = new Artista( 005, 567890123,"gustav","klimt",fechaAgregar14,311585425);
        fechaAgregar15.set(1853,2,30);
        Artista a6 = new Artista(006,678901234,"vincent","van gogh",fechaAgregar15,311585426);

        // Asignar artistas y obra
        a1.setObras(o1);
        o1.setArtista(a1);
        a1.setObras(o2);
        o2.setArtista(a1);
        a2.setObras(o3);
        o3.setArtista(a2);
        a3.setObras(o4);
        o4.setArtista(a3);
        a3.setObras(o5);
        o5.setArtista(a3);
        a3.setObras(o6);
        o6.setArtista(a3);
        a4.setObras(o7);
        o7.setArtista(a4);
        a5.setObras(o8);
        o8.setArtista(a5);
        a5.setObras(o9);
        o9.setArtista(a5);
        a6.setObras(o10);
        o10.setArtista(a6);

        //  Añadir a la lista
        listaObras.add(o1);
        listaObras.add(o2);
        listaObras.add(o3);
        listaObras.add(o4);
        listaObras.add(o5);
        listaObras.add(o6);
        listaObras.add(o7);
        listaObras.add(o8);
        listaObras.add(o9);
        listaObras.add(o10);
        listaArtistas.get(a1);
        listaArtistas.put(a2.getCodigoArtista(), a2);
        listaArtistas.put(a3.getCodigoArtista(), a3);
        listaArtistas.put(a4.getCodigoArtista(), a4);
        listaArtistas.put(a5.getCodigoArtista(), a5);
        listaArtistas.put(a6.getCodigoArtista(), a6);

    }

}
