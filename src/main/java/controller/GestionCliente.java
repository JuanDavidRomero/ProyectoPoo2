package controller;

import model.Cliente;

import java.util.ArrayList;
import java.util.Scanner;
public class GestionCliente
{
    Scanner scan = new Scanner(System.in);
    private Cliente cliente = new Cliente();

    public void modificarDatosDeCliente(Cliente cliente,ArrayList<Cliente> listaClientes)
    {

        System.out.println("\n1. Codigo de indentificacion: " + cliente.getCodigoCliente());
        System.out.println("2. Nombres: " + cliente.getNombres());
        System.out.println("3. Apellidos : " + cliente.getApellidos());
        System.out.println("4. Cedula : " + cliente.getCedula());
        System.out.println("5. Telefono : " + cliente.getTelefono());
        System.out.println("6. Entrega : " + cliente.getDireccionEntrega());

        System.out.print("\nSeleccione el dato que desea modificar: ");
        int nDato = scan.nextInt();
        switch (nDato)
        {
            case 1:
                System.out.print("Digite el nuevo codigo de identificacion:");
                long aux = scan.nextLong();
                if(buscasClienteNI(aux,listaClientes) == null)
                {
                    cliente.setCodigoCliente(aux);
                    System.out.println("Codigo agregado");
                }
                else
                    System.out.println("Este codigo ya lo tiene asignado otro cliente");
                System.out.println("No me se pudo modificar el cliente");

                break;
            case 2:
                System.out.print("Ingrese nuevo nombre: ");
                scan = new Scanner(System.in);
                String nombre= scan.nextLine();
                cliente.setNombres(nombre);
                System.out.println("Nombre cliente modificado");
                break;
            case 3:
                System.out.print("Ingrese nuevo apellido: ");
                scan = new Scanner(System.in);
                String apellido= scan.nextLine();
                cliente.setApellidos(apellido);
                System.out.println("Apellido cliente modificado");
                break;
            case 4:
                System.out.print("Ingrese nueva cedula: ");
                scan = new Scanner(System.in);
                cliente.setCedula(scan.nextLong());
                System.out.println("Cedula cliente modificado");
                break;
            case 5:
                System.out.print("Ingrese nuevo telefono: ");
                scan = new Scanner(System.in);
                cliente.setTelefono(scan.nextLong());
                System.out.println("Telefono cliente modificado");
                break;
            case 6:
                System.out.print("Ingrese nueva direccion: ");
                scan = new Scanner(System.in);
                cliente.setDireccionEntrega(scan.nextLine());
                System.out.println("Direccion cliente modificado");
                break;

            default:  System.out.println("Opcion no disponible"); break;

        }
    }

    public Cliente eliminarUnCliente(ArrayList<Cliente>  eliminar, Cliente clientE)
    {
        System.out.print("¿Esta seguro de borrar el cliente? si/no: ");

        String borrar = scan.nextLine();
        if(borrar.equals("si"))
        {
            Cliente eliminado = eliminar.remove(eliminar.indexOf(clientE));
            System.out.println("Cliente eliminado exitosamente");
            return eliminado;
        }
        return null;

    }

    public void listarClientes(ArrayList<Cliente> listaClientes)
    {
        for(Cliente recorrer: listaClientes)
        {
            System.out.println("- "+recorrer.toString(1));
            System.out.println();
        }
    }

    public Cliente buscarCliente(long codigo, ArrayList<Cliente> listaClientes)
    {
        for (Cliente recorrer: listaClientes)
        {
            if (recorrer.getCodigoCliente() == codigo)
            {
                System.out.println("\n***Datos cliente con cedula "+codigo+"***");
                System.out.println("Cedula: "+recorrer.getCedula());
                System.out.println("Nombre completo: "+recorrer.getNombres()+" "+recorrer.getApellidos());
                System.out.println("Telefono: "+recorrer.getTelefono()+"\n");
                return recorrer;
            }
        }
        System.out.println("El cliente no existe");
        return null;
    }

    public Cliente buscasClienteNI(long codigo, ArrayList<Cliente> listaClientes)
    {
        for (Cliente recorrer: listaClientes)
        {
            if (recorrer.getCodigoCliente() == codigo)
            {
                return recorrer;
            }
        }
        System.out.println("El cliente no existe");
        return null;
    }

    public void agregarCliente(ArrayList<Cliente> listaClientes)
    {
        System.out.println("\n***Ingrese los datos del nuevo cliente***\n");
        System.out.print("Codigo: ");
        long codigoCliente=scan.nextLong();

        Cliente temp = new Cliente();
        temp.setCodigoCliente(codigoCliente);

        if(!listaClientes.contains(temp))
        {
            System.out.print("Cedula: ");
            long cedula=scan.nextLong();
            System.out.print("Nombre: ");
            scan.nextLine();
            String nombres=scan.nextLine();
            System.out.print("Apellido: ");
            String apellidos=scan.nextLine();
            System.out.print("Direccion de entrega: ");
            String direccion=scan.nextLine();
            System.out.print("Telefono: ");
            long telefono=scan.nextLong();
            Cliente clienteNuevo=new Cliente(codigoCliente,cedula,nombres,apellidos,direccion,telefono);
            listaClientes.add(clienteNuevo);
            System.out.println("Cliente ingresado");
        }
        else
        {
            System.out.println("El codigo ya lo tiene registrado otro cliente");
            System.out.println("No se pudo añadir cliente");
        }
    }

    public void listaClientes(ArrayList<Cliente> listaClientes)
    {
        //Clientes
        Cliente c1 = new Cliente(1111111, 876543210, "wu", "zetian" , "avenida 13", 311585424);
        Cliente c2 = new Cliente(2222222, 765432109, "charles", "talleyrand", "avenida 14", 311585422);
        Cliente c3 = new Cliente(3333333,543210987,"victor","lustig","avenida 15",311585423);

        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);

    }


}

