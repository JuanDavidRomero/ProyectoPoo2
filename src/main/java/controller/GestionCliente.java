package controller;

import model.Cliente;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
public class GestionCliente
{
    Scanner scan = new Scanner(System.in);
    private Cliente cliente = new Cliente();

    public void modificarDatosDeCliente(Cliente cliente,Map<Long, Cliente> listaClientes)
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

    public Cliente eliminarUnCliente(Map<Long, Cliente> eliminar , Cliente cliente)
    {
        System.out.print("¿Esta seguro de borrar el cliente? s/n: ");

        String borra = scan.nextLine();
        char borrar = borra.charAt(0);

        if(borrar == 's')
        {
            if(eliminar.containsKey(cliente.getCedula()))
            {
                Cliente eliminado = eliminar.remove(cliente.getCedula());
                System.out.println("Cliente eliminado exitosamente");
                return eliminado;
            }

        }
        return null;

    }

    public void listarClientes(Map<Long, Cliente> listaClientes)
    {
        for(Map.Entry<Long, Cliente> recorrer: listaClientes.entrySet())
        {
            System.out.println("- "+recorrer.getValue().toString(1));
            System.out.println();
        }
    }

    public Cliente buscarCliente(long cedula, Map<Long, Cliente> listaClientes)
    {
        if(listaClientes.containsKey(cedula))
        {
            System.out.println("entra");
            for(long llave : listaClientes.keySet())
            {
                if(listaClientes.get(llave).getCedula()==cedula)
                {
                    System.out.println("\n***Datos cliente con cedula "+cedula+"***");
                    System.out.println("Cedula: "+listaClientes.get(llave).getCedula()+"\n");
                    System.out.println("Nombre completo: "+listaClientes.get(llave).getNombres()+" "+listaClientes.get(llave).getApellidos()+"\n");
                    System.out.println("Telefono: "+listaClientes.get(llave).getTelefono()+"\n");
                    return listaClientes.get(llave);
                }
            }
            System.out.println("El cliente no existe");
        }
        return null;
    }

    public Cliente buscasClienteNI(long codigo, Map<Long, Cliente> listaClientes)
    {
        for (Map.Entry<Long, Cliente> recorrer: listaClientes.entrySet())
        {
            if (recorrer.getValue().getCedula() == codigo)
            {
                return (Cliente) recorrer;
            }
        }
        System.out.println("El cliente no existe");
        return null;
    }

    public void agregarCliente(Map<Long, Cliente> listaClientes)
    {
        System.out.println("\n***Ingrese los datos del nuevo cliente***\n");
        System.out.print("Cedula: ");
        long codigoCliente=scan.nextLong();

        Cliente temp = new Cliente();
        temp.setCodigoCliente(codigoCliente);

        if(!listaClientes.containsValue(temp))
        {
            System.out.print("Codigo: ");
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
            listaClientes.put(cedula,clienteNuevo);
            System.out.println("Cliente ingresado");
        }
        else
        {
            System.out.println("El codigo ya lo tiene registrado otro cliente");
            System.out.println("No se pudo añadir cliente");
        }
    }

    public void listaClientes(Map<Long, Cliente> listaClientes)
    {
        //Clientes
        Cliente c1 = new Cliente(1111111, 876543210, "wu", "zetian" , "avenida 13", 311585424);
        Cliente c2 = new Cliente(2222222, 765432109, "charles", "talleyrand", "avenida 14", 311585422);
        Cliente c3 = new Cliente(3333333,543210987,"victor","lustig","avenida 15",311585423);

        listaClientes.put((long) 876543210,c1);
        listaClientes.put((long) 765432109, c2);
        listaClientes.put((long) 543210987, c3);

    }


}

