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
            System.out.println("- "+mostar.toString());
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
          for(Artista llave: obraBuscadora.getArtistas())
            {
                Artista comparar = obraBuscadora.getArtistas().get(obraBuscadora.getArtistas().indexOf(llave));
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
                System.out.println("- "+mostar.toString());
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

        // ingreso de datos nueva obra

        System.out.println("\n***Ingrese los datos de la nueva obra***");
        System.out.println("Ingrese el pid:");
        long pid = ingreso.nextLong();
        ingreso= new Scanner(System.in);

        // primero se valia que el pid sea el correcto
        if(checkpid(pid,listaObras))
        {
            // ingreso titulo
            System.out.print("\nIngrese el titulo: ");
            String titulo = ingreso.nextLine();
            ingreso = new Scanner(System.in);
            // ingreso año
            System.out.print("\nIngre el  año : ");
            int ano = ingreso.nextInt();
            ingreso = new Scanner(System.in);
            // ingreso precio
            System.out.print("\nIngrese el precio de referencia: ");
            double precioRef = ingreso.nextDouble();
            ingreso = new Scanner(System.in);
            // ingreso dimensiones
            System.out.print("\nIngrese las dimenciones: ");
            String dimensiones = ingreso.nextLine();
            ingreso = new Scanner(System.in);
            Calendar fecha = Calendar.getInstance();
            fecha.set(Calendar.YEAR,ano);

            System.out.println("Registre un artista a la obra\n");
            boolean artistaDone=false;
            // proceso para añadir un artista a la obra
            do
            {
                ArrayList<Long> listaLlaves = new ArrayList<>();

                System.out.println("\n***Lista Artistas***");
                // se muestran la opcion de artistas
                System.out.println("0.Ingresar artista");

                int numero=1;
                for(long llaves: listaArtistas.keySet())
                {
                    listaLlaves.add(llaves);
                    System.out.println(numero+"."+listaArtistas.get(llaves).toString(1));
                    numero+=1;
                }

                System.out.print("Selecion el artista que le desea registrar a la Obra:  ");
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
                    if(selec != 0)
                    {
                       Artista nuevo = listaArtistas.get(listaLlaves.indexOf(selec)-1);

                        System.out.println("\n\n¿Que tipo de obra va a ingresar?");
                        System.out.println("1. Escultura ");
                        System.out.println("2. Instalacion ");
                        System.out.println("3. Cuadro ");
                        int tipo = ingreso.nextInt();

                        switch (tipo)
                        {
                            // escultura
                            case 1:
                            {
                                System.out.println("¿Con que tipo de material fue hecha la escultura?");
                                String nE = ingreso.nextLine();
                                System.out.println("De una descripcion del material");
                                String descripcion = ingreso.nextLine();
                                Material material = new Material(nE, descripcion);
                                System.out.println("Ingrese el peso de la escultura");
                                double peso = ingreso.nextDouble();
                                insertarObraEscultura(listaObras,listaArtistas,nuevo.getCedula(),pid,titulo,fecha,precioRef,dimensiones,material,peso);
                            }break;

                            //Instalacion
                            case 2:
                            {
                                System.out.println("De una breve descripcion del la instalacion");
                                String descripcion = ingreso.nextLine();
                                insertarObraInstalacion(listaObras,listaArtistas,nuevo.getCedula(),pid,titulo,fecha,precioRef,dimensiones,descripcion);
                            }break;

                            //Cuadro
                            case 3:
                            {
                                System.out.println("Ecriba el tema del cuadro");
                                String tema = ingreso.nextLine();
                                System.out.println("Describa la tecnica del cuadro");
                                String tecnica = ingreso.nextLine();
                                System.out.println("Clasifique el cuadro");
                                System.out.println("1. Obra maestra");
                                System.out.println("2. Obra representativa");
                                int clasificacion = ingreso.nextInt();

                                if(clasificacion<=2)
                                {
                                    insertarObraCuadro(listaObras,listaArtistas,nuevo.getCedula(),pid,titulo,fecha,precioRef,dimensiones,tema,tecnica,clasificacion);
                                }
                                else
                                {
                                    System.out.println("Opcion no disponible");
                                }

                            }break;

                            default:
                            System.out.println("Opcion no disponible");
                            break;
                        }
                        System.out.println("Obra ingresada\n");
                    }
                }

            }while(!artistaDone);
        }
        else{System.out.println("No se pudo crear la nueva obra ");}

    }

    public Obra insertarObraCuadro(ArrayList<Obra>listaObras,Map<Long,Artista>listaArtistas,long llaveArtista,long pid, String titulo, Calendar fecha, Double precioRef, String dimensiones, String tema, String tecnica, int clasificacion)
    {
        if(checkpid(pid,listaObras))
        {
            if(clasificacion==0)
            {
                Obra temp = new Cuadro(pid,titulo,fecha,precioRef,dimensiones,tema,tecnica,Clasificacion.OBRA_MAESTRA);
                temp.setArtistas(listaArtistas.get(llaveArtista));
                listaObras.add(temp);
                return temp;
            }
            if(clasificacion==1)
            {
                Obra temp = new Cuadro(pid,titulo,fecha,precioRef,dimensiones,tema,tecnica,Clasificacion.OBRA_REPRESENTATIVA);
                temp.setArtistas(listaArtistas.get(llaveArtista));
                listaObras.add(temp);
                return temp;
            }
        }

        return null;

    }

    public Obra insertarObraEscultura(ArrayList<Obra>listaObras,Map<Long,Artista>listaArtistas,long llaveArtista,long pid, String titulo, Calendar fecha, Double precioRef, String dimensiones, Material material, double peso)
    {
        if(checkpid(pid,listaObras))
        {
            Obra temp = new Escultura(pid,titulo,fecha,precioRef,dimensiones,material,peso);
            temp.setArtistas(listaArtistas.get(llaveArtista));
            listaObras.add(temp);
            return temp;
        }
       return null;
    }

    public Obra insertarObraInstalacion(ArrayList<Obra>listaObras,Map<Long,Artista>listaArtistas,long llaveArtista,long pid, String titulo, Calendar fecha, Double precioRef, String dimensiones, String descripcion)
    {
        if(checkpid(pid,listaObras))
        {
            Obra temp = new Instalacion(pid,titulo,fecha,precioRef,dimensiones,descripcion);
            temp.setArtistas(listaArtistas.get(llaveArtista));
            listaObras.add(temp);
            return temp;
        }
        return null;

    }


    public void modifiObra(long codigo, ArrayList<Obra> listaObras,Map<Long, Artista> listaArtista)
    {
        Scanner entrada = new Scanner(System.in);
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
                            "\n4.PrecioRef: " +trabajo.getPrecioRef() +
                            "\n5.Dimensiones: " +trabajo.getDimenciones());

            System.out.print("6.Artista: " );
            for(Artista impri: trabajo.getArtistas()) {
                System.out.print(impri.toString(1,1)+".");
            }

            if(trabajo.getClass().getSimpleName().equals("Cuadro")){
                System.out.println("7. tema");
                System.out.println("8. tecnica");
                System.out.println("9. clasificacion");
            }
            if(trabajo.getClass().getSimpleName().equals("Escultura")){
                System.out.println("7. material escultura");
                System.out.println("8. peso escultura");
            }
            if(trabajo.getClass().getSimpleName().equals("Instalacion")){
                System.out.println("7. descripcion instalacion");
                System.out.println("8. material escultura");
            }


            System.out.print("\nDigite el numero de la opcion que quiera modificar: ");
            int opcion = entrada.nextInt();

            if(opcion <=6) {
                switch (opcion) {
                    case 1: {
                        System.out.print("Ingrese el nuevo titulo:");
                        entrada = new Scanner(System.in);
                        String nuevoT = entrada.nextLine();
                        trabajo.setTitulo(nuevoT);
                    }
                    break;

                    case 2: {
                        System.out.print("Ingrese el nuevo pid:");
                        entrada = new Scanner(System.in);
                        long nuevoP = entrada.nextLong();
                        // se valida que el pid este dentro de la restricciones
                        if (this.checkpid(nuevoP, listaObras)) {
                            trabajo.setPid(nuevoP);
                        } else {
                            System.out.println("Lo sentimos, no se le pudo asignar nuevo pid a la obra");
                        }
                    }
                    break;

                    case 3: {
                        int ano;
                        System.out.print("Ingrese el nuevo año");
                        entrada = new Scanner(System.in);
                        ano = entrada.nextInt();
                        Calendar fechaN = Calendar.getInstance();
                        fechaN.set(Calendar.YEAR, ano);
                        trabajo.setFecha(fechaN);
                    }
                    break;

                    case 4: {
                        System.out.print("Ingrese el nuevo precio:");
                        entrada = new Scanner(System.in);
                        double nuevoPre = entrada.nextDouble();
                        trabajo.setPrecioRef(nuevoPre);
                    }
                    break;

                    case 5: {
                        System.out.print("Ingrese las nuevas dimensiones:");
                        entrada = new Scanner(System.in);
                        String nuevoD = entrada.nextLine();
                        trabajo.setDimenciones(nuevoD);
                    }
                    break;

                    case 6: {
                        boolean esta = false;
                        do {
                            System.out.println("\n***Lista Artistas***\n");
                            int orden = 1;
                            System.out.println("0.Ingresar nuevo artista");
                            // se presenta lista de artistas
                            for (Map.Entry<Long, Artista> impri : listaArtista.entrySet()) {
                                System.out.println(orden + "." + impri.getValue().toString(1));
                                orden += 1;
                            }
                            entrada = new Scanner((System.in));
                            System.out.print("\nIngrese el artista de la obra:");
                            int selec = entrada.nextInt();
                            // se añade un nuevo artista a la lista
                            if (selec == 0) {
                                this.InserArtista(listaArtista);
                            } else {
                                esta = true;
                                // quitarle la obra al artista anterior
                                for(Artista viejo: trabajo.getArtistas())
                                {
                                    viejo.getObras().remove(trabajo);
                                }
                                // quitarle el artista a la obra
                                 trabajo.getArtistas().clear();
                                //asignarle el nuevo artista
                                Artista nuevo = listaArtista.get(selec - 1);
                                trabajo.setArtistas(nuevo);
                                // añadirle la obra al artista nuevo
                                nuevo.setObras(trabajo);
                            }
                        } while (!esta);
                    }
                    break;
                    default:
                        System.out.println("Esa opcion no esta disponible");
                        break;
                }
            }

            if(opcion >6) {
                if (trabajo instanceof Cuadro) {
                    switch (opcion) {
                        case 7:
                            System.out.println("ingrese el nuevo tema");
                            String nuevoT = entrada.nextLine();
                            ((Cuadro) trabajo).setTema(nuevoT);
                            break;
                        case 8:
                            System.out.println("describa la tecnica");
                            String tencnica = entrada.nextLine();
                            ((Cuadro) trabajo).setTecnica(tencnica);
                            break;
                        case 9:
                            System.out.println("de la nueva clasificacion");
                            System.out.println("1. Obra Maestra ");
                            System.out.println("2. Obra Representativa ");
                            int select = entrada.nextInt();
                            if(select == 1)
                                ((Cuadro) trabajo).setClasificacion(Clasificacion.OBRA_MAESTRA);
                            if(select == 2)
                                ((Cuadro) trabajo).setClasificacion(Clasificacion.OBRA_REPRESENTATIVA);
                            break;
                        default:
                            System.out.println("Esa opcion no esta disponible");
                            break;
                    }
                }
                if (trabajo.getClass().getSimpleName().equals("Escultura")) {
                    switch (opcion) {
                        case 7:
                            System.out.println("digite el nombre del material");
                            String nombreM = entrada.nextLine();
                            System.out.println("De la descripcion del material");
                            String desM = entrada.nextLine();
                            ((Escultura) trabajo).getMaterial().setDescripion(desM);
                            ((Escultura) trabajo).getMaterial().setNombre(nombreM);
                            break;
                        case 8:
                            System.out.println("escriba el nuevo peso");
                            double tencnica = entrada.nextDouble();
                            ((Escultura) trabajo).setPeso(tencnica);
                            break;
                        default:
                            System.out.println("Esa opcion no esta disponible");
                            break;
                    }
                }
                if (trabajo.getClass().getSimpleName().equals("Instalacion")) {
                    switch (opcion) {
                        case 7:
                            System.out.println("digite la descripcion de la instalacion");
                            String descripI = entrada.nextLine();
                            ((Instalacion) trabajo).setDescripcion(descripI);
                            break;
                        case 8:
                            System.out.println("escriba el nombre del material antiguo");
                            entrada.nextLine();
                            String materialA = entrada.nextLine();
                            for (Material recorrer : ((Instalacion) trabajo).getTipo()) {
                                if (recorrer.getNombre().equals(materialA)) {
                                    System.out.println("Digite el nuevo nombre del material");
                                    String nMaterial = entrada.nextLine();
                                    System.out.println("Digite la nueva descripcion del matrial");
                                    String nDescrip = entrada.nextLine();
                                    recorrer.setNombre(nMaterial);
                                    recorrer.setDescripion(nDescrip);
                                }
                            }
                            break;
                        default:
                            System.out.println("Esa opcion no esta disponible");
                            break;
                    }
                }
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
        listaArtistas.put(nuevo.getCedula(), nuevo);
    }

    public boolean checkpid(long pid, ArrayList<Obra> listaObras)
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
        Material mat1 = new Material("Cuarzo", "Material de color blanco");
        ((Instalacion)o1).getTipo().add(mat1);
        fechaAgregar2.set(Calendar.YEAR,1950);
        Material m1 = new Material("madera", "Los árboles son una creación asombrosa de la naturaleza");
        Obra o2 = new Escultura(2345671,"autorretrado con chaqueta azul",fechaAgregar2,80000.0,"grande",m1, 15.1);
        fechaAgregar3.set(Calendar.YEAR,1877);
        Obra o3 = new Cuadro(3456712,"remeros en el yernes",fechaAgregar3,60000.0,"normal","Marlborough", "Óleo",Clasificacion.OBRA_MAESTRA);
        fechaAgregar4.set(Calendar.YEAR,1931);
        Obra o4 = new Cuadro(4567123,"la persistencia de la memoria",fechaAgregar4,1000000.0,"grande","Los relojes blandos o Los relojes derretidos", "Oleo", Clasificacion.OBRA_MAESTRA);
        fechaAgregar5.set(Calendar.YEAR,1651);
        Obra o5 = new Instalacion(5671234,"Esther Arias Galerías de Arte y Taller",fechaAgregar5,200000000.0,"grande","Situado en un antiguo edificio del siglo XVIII");
        Material mat2 = new Material("madera", "Material con gran resistencia");
        ((Instalacion)o5).getTipo().add(mat2);
        fechaAgregar6.set(Calendar.YEAR,1946);
        Obra o6 = new Instalacion(6712345,"Hans Mayer",fechaAgregar6,50000000.0,"grande","famoso por ser un espacio que abre sus puertas a otros tipos de arte");
        Material mat3 = new Material("piedra negra", "Material con gran pureza");
        ((Instalacion)o6).getTipo().add(mat3);
        fechaAgregar7.set(Calendar.YEAR,1800);
        Material m2 = new Material("marmol", "es una roca metamorfica compacta formada a partir de rocas calizas");
        Obra o7 = new Escultura(7123456,"La Piedad ",fechaAgregar7,34800000.0,"grande",m2,25.7);
        fechaAgregar8.set(Calendar.YEAR,1901);
        Obra o8 = new Instalacion(2345678,"Annely Juda Fine Art ",fechaAgregar8,3000000000.0,"grande"," Artistas de todo el mundo se unen en una composición armónica y delicada que tienes que vivir");
        ((Instalacion)o8).getTipo().add(mat3);
        ((Instalacion)o8).getTipo().add(mat1);
        fechaAgregar9.set(Calendar.YEAR,1907);
        Material m3 = new Material("marmol", "es una roca metamorfica compacta formada a partir de rocas calizas");
        Obra o9 = new Escultura(3456789,"Venus de Milo",fechaAgregar9,88000.0,"grande",m3, 34.8);
        fechaAgregar16.set(Calendar.YEAR,1888);
        Obra o10 = new Instalacion(4567890,"Marlborough Fine Art",fechaAgregar16,23400000.0,"grande","está llena de los más reconocidos artistas contemporáneos.");
        ((Instalacion)o8).getTipo().add(mat3);
        ((Instalacion)o8).getTipo().add(mat1);
        ((Instalacion)o8).getTipo().add(mat2);


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
        o1.setArtistas(a1);
        a1.setObras(o2);
        o2.setArtistas(a1);
        a2.setObras(o3);
        o3.setArtistas(a2);
        a3.setObras(o4);
        o4.setArtistas(a3);
        a3.setObras(o5);
        o5.setArtistas(a3);
        a3.setObras(o6);
        o6.setArtistas(a3);
        a4.setObras(o7);
        o7.setArtistas(a4);
        a5.setObras(o8);
        o8.setArtistas(a5);
        a5.setObras(o9);
        o9.setArtistas(a5);
        a6.setObras(o10);
        o10.setArtistas(a6);

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
        listaArtistas.put(a2.getCedula(), a2);
        listaArtistas.put(a3.getCedula(), a3);
        listaArtistas.put(a4.getCedula(), a4);
        listaArtistas.put(a5.getCedula(), a5);
        listaArtistas.put(a6.getCedula(), a6);

    }

}
