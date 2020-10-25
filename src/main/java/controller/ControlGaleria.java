package controller;

import model.*;

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
                System.out.println("- "+auxiliar.toString());
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
        verListadoDeArtistasMasVendidos();
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

                    compraDeUnaObraDirecto(npedido,fecha,pagado,"nombre",clienteaux,obraux);

                    System.out.println("el numero de pedido es "+npedido);
                    System.out.println("Agregado correctamente");
                    npedido++;
                }
            }
        }
    }

    public long compraDeUnaObraDirecto(long numeroPedido, Calendar fechaRecibido, boolean pagado, String nombreRepartidor, Cliente compraCliente, Obra compraObra)
    {
        Compra nueva = new Compra(numeroPedido,fechaRecibido,pagado,nombreRepartidor,compraCliente,compraObra);
        listaCompras.add(nueva);
        return numeroPedido;
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


    public ArrayList<Long> verListadoDeArtistasMasVendidos()
    {

        long [] codigosArtista = new long [listaArtistas.size()];
        int [] repeticiones = new int[listaArtistas.size()];
        ArrayList <Long> llavesLista = new ArrayList<>();

        int contador = 0;
        for(Map.Entry< Long, Artista> entrada_mapa : listaArtistas.entrySet())
        {
            codigosArtista[contador] = entrada_mapa.getValue().getCodigoArtista();
            contador++;
        }
        for(int posicion = 0; posicion < listaArtistas.size(); posicion++){
            repeticiones[posicion] = 0;
        }

        for(int posicion_codigos = 0; posicion_codigos < listaArtistas.size(); posicion_codigos++)
        {
            for(Compra compra: listaCompras)
            {
                for(Artista artista: compra.getCompraObra().getArtistas())
                {
                    if(artista.getCodigoArtista() == codigosArtista[posicion_codigos])
                    {
                        repeticiones[posicion_codigos]++;
                    }
                }
            }
        }

        int maximo = 0;
        for(int posicion_repeticiones = 0; posicion_repeticiones < listaArtistas.size(); posicion_repeticiones++)
        {
            if(repeticiones[posicion_repeticiones] > maximo)
            {
                maximo = repeticiones[posicion_repeticiones];
            }
        }

        Artista masVendido;
        int contadorArtistas = listaArtistas.size();

        do
        {

            for(int posicion_codigos = 0; posicion_codigos < listaArtistas.size(); posicion_codigos++)
            {
                if(maximo == repeticiones[posicion_codigos])
                {
                    for(Map.Entry<Long, Artista> mapa : listaArtistas.entrySet())
                    {
                        if(mapa.getValue().getCodigoArtista() == codigosArtista[posicion_codigos])
                        {
                            masVendido = mapa.getValue();
                            System.out.println("Artista: "+ masVendido.getNombres()+" "+masVendido.getApellidos()+"\tNumero Compras: "+maximo);
                            llavesLista.add(masVendido.getCedula());

                        }

                    }
                    contadorArtistas--;

                }

            }
            maximo--;

        }while(contadorArtistas > 0);

        return llavesLista;
    }

    public ArrayList<Obra> generarObrasEscultura(){
        ArrayList <Obra> auxiliar = new ArrayList<>();
        for(Obra unaObra : this.listaObras){
            if(unaObra instanceof Escultura){
                auxiliar.add(unaObra);
            }
        }
        return auxiliar;
    }

    public ArrayList <Compra> filtrarCompraCuadro(){
        ArrayList <Compra> auxiliar = new ArrayList<>();
        for(Compra compra: this.listaCompras){
            if(compra.getCompraObra() instanceof Cuadro){
                auxiliar.add(compra);
            }
        }
        return auxiliar;
    }

    public int gananciaTotalObtenida(){
        int acumulador = 0;
        for(Compra compra: this.listaCompras){
            acumulador += compra.getCompraObra().getPrecioRef();
        }
        return acumulador;
    }


}

