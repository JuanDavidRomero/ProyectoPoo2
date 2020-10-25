package controller;

import model.Artista;
import model.Cliente;
import model.Compra;
import model.Obra;

import java.util.*;
import java.util.stream.Collectors;

public class ControlGaleria
{
    Scanner ingreso = new Scanner(System.in);

    //Mapas
    private Map<Long, Cliente> listaClientes = new HashMap<>();
    private Map<Long, Artista> listaArtistas = new HashMap<>();

    // Listas
    private ArrayList<Compra> listaCompras = new ArrayList<>();
    private ArrayList<Obra> listaObras= new ArrayList<>();

    // controladores
    private GestionCliente controlClientes = new GestionCliente();
    private GestionObras controlObras= new GestionObras();

    //Constructores
    public ControlGaleria()
    {  }

    // Acessors


    public Map<Long, Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Map<Long, Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Compra> getListaCompras(){return listaCompras;}
    public void setListaCompras(ArrayList<Compra> listaCompras){this.listaCompras = listaCompras;}

    public ArrayList<Obra> getListaObras(){return listaObras;}
    public void setListaObras(ArrayList<Obra> listaObras){this.listaObras = listaObras;}

    public Map<Long, Artista> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(Map<Long, Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }

    public GestionCliente getControlClientes(){return controlClientes;}
    public void setControlClientes(GestionCliente controlClientes){this.controlClientes = controlClientes;}

    public GestionObras getControlObras(){return controlObras;}
    public void setControlObras(GestionObras controlObras){this.controlObras = controlObras;}

    // Metodos

    public void datosPrueba()
    {

        controlClientes.listaClientes(listaClientes);
        controlObras.listaObras(listaObras,listaArtistas);

        //Compras
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

    //1.Ver listado de Obras disponibles
    public void opcion1()
    {
        this.controlObras.VerObrasDisponibles(listaCompras,listaObras);
        espacio();
    }
    //2.Buscar una Obra por título, artista o año
    public void opcion2()
    {
        Scanner ingreso = new Scanner(System.in);
        System.out.println("Ingrese el criterio de busqueda(titulo/artista/año): ");
        String criterio = ingreso.nextLine();
        controlObras.BuscarObra(criterio,listaObras);
        espacio();
    }
    //3.Insertar una Obra
    public void opcion3()
    {
        controlObras.InsertarObra(listaObras,listaArtistas);
        //listaObras.add(insertar);
        espacio();
    }
    //4.Modificar una Obra
    public void opcion4()
    {
        System.out.println("Ingrese el codigo de la obra a buscar:");
        Scanner ingreso = new Scanner(System.in);
        long pid = ingreso.nextLong();
        controlObras.modifiObra(pid,listaObras,listaArtistas);
        espacio();
    }
    //5.Eliminar una Obra
    public void opcion5()
    {
        ingreso = new Scanner(System.in);
        System.out.println("Ingrese el pid de la obra a eliminar:");
        long pid = ingreso.nextLong();
        Obra busqueda = controlObras.buscarObraCodigo(pid,listaObras);
        controlObras.eliminarObra(listaObras,listaCompras,busqueda);
        espacio();
    }
    //6.Ver listado de Clientes registrados en el sistema
    public void opcion6()
    {
        System.out.println("***Lista Clientes***\n");
        controlClientes.listarClientes(listaClientes);
        espacio();
    }
    //7.Buscar un Cliente
    public void opcion7()
    {
        Scanner ingreso= new Scanner(System.in);
        System.out.print("Ingrese la cedula del cliente a buscar: ");
        long codigo = ingreso.nextLong();
        controlClientes.buscarCliente(codigo,listaClientes);
        espacio();
    }
    //8.Insertar Cliente
    public void opcion8()
    {
        controlClientes.agregarCliente(listaClientes);
        espacio();
    }
    //9.Modificar datos de Cliente
    public void opcion9()
    {
        System.out.print("Digite el codigo de identificacion del cliente:");
        long codId = ingreso.nextLong();
        Cliente clienteaux = controlClientes.buscasClienteNI(codId, listaClientes);
        if(clienteaux != null)
            controlClientes.modificarDatosDeCliente(clienteaux,listaClientes);

        espacio();
    }
    //10.Eliminar un Cliente
    public void opcion10()
    {
        System.out.print("Digite el codigo de identificacion del cliente:");
        long codId = ingreso.nextInt();
        Cliente clienteaux = controlClientes.buscasClienteNI(codId, listaClientes);
        if(clienteaux != null)
        {
            boolean auxBorrar = ClienteCompra(codId);
            if(!auxBorrar)
                controlClientes.eliminarUnCliente(listaClientes, clienteaux);
            else System.out.println("No se puede eliminar un cliente vinculado a una compra");
        }
        espacio();
    }
    //11.Realizar compra de una Obra
    public void opcion11()
    {
        long nPedido = 1000;
        System.out.print("Digite el codigo de identificacion del cliente: ");
        long codId = ingreso.nextLong();
        Cliente temp =controlClientes.buscasClienteNI(codId,listaClientes);
        if(temp!=null)
        {
            System.out.print("Digite el PID de la obra que desea comprar: ");
            long pid = ingreso.nextInt();
            Obra temp2 = controlObras.buscarObraCodigo(pid,listaObras);
            if(temp2!=null)
            {
                realizarCompraDeUnaObra(codId, pid, nPedido);
            }
            else
            {
                System.out.println("No se ha encontrado la obra con el codigo pid ingresado");
            }
        }
        espacio();
    }
    //12.Eliminar compra de obra
    public void opcion12()
    {
        eliminarCompraObra();
        espacio();
    }
    //13.Ver listado de Compras existentes
    public void opcion13()
    {
        System.out.println("\n***Lista de Compras***\n");
        for(Compra auxiliar : listaCompras)
        {
            if(auxiliar.isPagado())
            {
                System.out.println("- "+auxiliar.toString(1));
                System.out.println();
            }
        }
        espacio();
    }
    //14.Ver listado de Compras para un mes y año específico insertado por el usuario
    public void opcion14()
    {
        VerListadoDeComprasParaUnAño();
        espacio();
    }
    //15.Ver listado de Artistas más vendidos
    public void opcion15()
    {
      //  VerListadoDeArtistasMasVendidos();
        System.out.println();
        espacio();
    }

    private void espacio()
    {
        System.out.print("volver menu?(s/n): ");
        Scanner entrada= new Scanner(System.in);
        String res = entrada.nextLine();
        char res1 = res.charAt(0);
        if(res1=='s')
        {
            for (int i = 0; i < 100; ++i) System.out.println();
        }
    }

    public Boolean ClienteCompra(long codId)
    {
        for (Compra recorrer : listaCompras)
        {
            if (recorrer.getCompraCliente().getCodigoCliente() == codId)
                return true;
        }
        return false;
    }

    // Metodos compras

    public void realizarCompraDeUnaObra(long codId, long pid, long npedido)
    {
        Scanner scan = new Scanner(System.in);
        Cliente clienteaux = controlClientes.buscasClienteNI(codId,listaClientes);
        Obra obraux = controlObras.buscarObraCodigo(pid,listaObras);
        boolean pagado = true, salir = false;
        if(clienteaux != null)
        {
            if(obraux != null)
            {
                for(Compra recorrer: listaCompras)
                {
                    if(recorrer.getCompraObra().getPid() == pid)
                    {
                        salir = true;
                        System.out.println("Esta compra ya se encuentra registrada");
                    }
                }
                if(!salir)
                {
                    System.out.print("Digite la fecha de recibido\n");
                    System.out.print("Dia: ");
                    int Dia = scan.nextInt();
                    System.out.print("Mes: ");
                    int Mes = scan.nextInt()-1;
                    System.out.print("Año: ");
                    int Anio = scan.nextInt();
                    Calendar fecha = new GregorianCalendar(Anio, Mes, Dia);
                    System.out.print("¿La obra esta pagada?(si/no):");
                    scan.nextLine();
                    String estado = scan.nextLine();
                    if (estado.equals("si"))
                        pagado = true;
                    else if(estado.equals("no"))
                        pagado = false;
                    System.out.print("Digite el nombre del repartidor: ");
                    String nRepartido = scan.nextLine();
                    Compra pedido = new Compra(npedido, fecha, pagado, nRepartido, clienteaux, obraux);
                    listaCompras.add(pedido);
                    System.out.println("el numero de pedido es "+npedido);
                    System.out.println("Agregado correctamente");
                    npedido++;
                }
            }
        }
    }

    public Compra eliminarCompraObra()
    {
        Scanner scan = new Scanner(System.in);
        Compra eliminado;
        System.out.print("Digite el numero de compra a eliminar:");
        long borrar = scan.nextLong();
        for(Compra recorrer: listaCompras){
            if(recorrer.getNumeroPedido() == borrar){
                System.out.print("¿Esta seguro de borrar la compra?(s/n): ");
                scan = new Scanner(System.in);
                String confirmacion = scan.nextLine();
                if(confirmacion == "s")
                {
                    eliminado = listaCompras.remove(listaCompras.indexOf(recorrer));
                    return eliminado;
                }
                else
                    return null;
            }
        }
        System.out.println("El numero de compra no existe");
        return null;
    }
/*
    public void VerListadoDeArtistasMasVendidos()
    {

        System.out.println("***Lista de artistas mas vendidos***\n");

        int vector[] = new int [listaArtistas.size()]; /// CHECK BORRAR


        for(int posicion_vector = 0; posicion_vector < listaArtistas.size(); posicion_vector++)
        {
            vector[posicion_vector] = 0;
        }

        ArrayList<long> listaLLaves = listaArtistas.keySet();

        for(long llave : listaLLaves)
        {
            for(Compra compra : listaCompras)
            {
                for(Artista artista: compra.getCompraObra().getArtista())
                {
                    if(listaArtistas.get(llave).getCedula()== artista.getCedula())
                    {
                        vector[listaLLaves.indexOf(llave)]++;
                    }
                }
            }

        }
/*
        for(Map.Entry<Long, Artista> artista : this.listaArtistas.entrySet())
        {
            for(Compra compra : this.listaCompras)
            {
                for(Artista artista2 : compra.getCompraObra().getArtista())
                {
                    if(artista.getValue().getCedula() == artista2.getCedula())
                    {

                        vector[listaArtistas.indexOf(artista)]++;
                    }

                }
            }
        }

        int maximo = vector[0];

        for(int posicion_vector = 0; posicion_vector < listaArtistas.size(); posicion_vector++)
        {
            if(vector[posicion_vector] > maximo)
            {
                maximo = vector[posicion_vector];
            }
        }

        int okay = 1;
        for( int a = maximo; a >= 0; a--)
        {

            for(int posicion_vector = 0; posicion_vector < listaArtistas.size(); posicion_vector++){
                if(vector[posicion_vector] == a){
                    System.out.println(okay + ". "+ listaArtistas.get(posicion_vector).toString(1,2)+": "+ a);
                    okay++;
                }
            }
        }
    }
*/

    /*
// ESTA NO FUNCIONA ARREGLAR!!!!!!!!!
    public void VerListadoDeArtistasMasVendidos()
    {
        long matriz [][]= new long[listaArtistas.size()][2];
        ArrayList<Long> listaLlaves = new ArrayList<>();

        for(long llave: listaArtistas.keySet())
        {
          System.out.println(llave);
          listaLlaves.add(llave);
        }

        // iniciamos matriz
        for(int i=0;i<listaArtistas.size();i++)
        {
            for(int j=0;j<2;j++)
            {
                if(j==0)
                {
                    matriz[i][j]=listaLlaves.get(j);
                }
                else
                {
                    matriz[i][j]=0;
                }
            }
        }

        System.out.println("Lista llaves: "+listaLlaves);

        // se miran las compras de los artistas
        System.out.println("ok1");
        for(Compra obra :listaCompras)
        {
            System.out.println("ok2");
            for(Artista arti: obra.getCompraObra().getArtista())
            {
                System.out.println("ok3");
                System.out.println("codigo artista:"+arti.getCodigoArtista());
                System.out.println(listaLlaves.indexOf(arti.getCodigoArtista()));
                matriz[listaLlaves.indexOf(arti.getCodigoArtista())][1]++;
            }
        }

        System.out.println("OK4");
        // se organiza
        for(int posicion=0; posicion<listaArtistas.size();posicion++)
        {
            System.out.println("ok5");
            for (int posi = 0; posi < listaArtistas.size()-1; posi++)
            {
                System.out.println("ok6");
                if (matriz[posi][1] < matriz[posi + 1][1])
                {
                    System.out.println("ok7");
                    long tempLlave = matriz[posi][0];
                    long tempContador = matriz[posi][1];

                    matriz[posi][1] = matriz[posi + 1][1];
                    matriz[posi][0] = matriz[posi + 1][0];

                    matriz[posi + 1][1] = tempLlave;
                    matriz[posi + 1][0] = tempContador;

                }

            }
        }

        System.out.println("ok8");
        // se imprime

        for(int o=0; o<listaArtistas.size();o++)
        {
            System.out.println("ok9");
            for(int k=0;k<2;k++)
            {
                System.out.println("ok10");
                if(k==0)
                {
                    System.out.println("ok11");
                    System.out.println("Nombre artista: "+listaArtistas.get(matriz[o][0]));
                }
                if(k==1)
                {
                    System.out.println("ok12");
                    System.out.println("Obras Vendidas: "+matriz[o][1]);
                }
                System.out.println();
            }
        }
        System.out.println("ok13");

    }*/


    public void VerListadoDeComprasParaUnAño()
    {
        int anno;
        int mes;
        boolean encontro = false;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite el año que desea consultar: ");
        anno = teclado.nextInt();
        System.out.println("Digite el mes que desea consultar (1 - 12): ");
        mes = teclado.nextInt();
        mes--;
        Calendar aux = Calendar.getInstance();
        aux.set(Calendar.YEAR, anno);
        aux.set(Calendar.MONTH, mes);

        for(Compra compra : listaCompras)
        {
            if(compra.getFechaRecibido().get(Calendar.YEAR) == anno)
            {
                if(compra.getFechaRecibido().get(Calendar.MONTH)== mes)
                {
                    encontro =true;
                    System.out.println();
                    System.out.println("obra: " + compra.getCompraObra().getTitulo());
                    System.out.println("cliente: " + compra.getCompraCliente().toString(1,2));
                    System.out.println("fecha: " + compra.getFechaRecibido().getTime());
                    System.out.println("precio: " + compra.getCompraObra().getPrecioRef());
                }
            }
        }
        if(!encontro)
        {
            System.out.println("No se ha encontrado compras con esa fecha");
        }
    }
}
