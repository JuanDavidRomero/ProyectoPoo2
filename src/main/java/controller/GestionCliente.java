package controller;

import model.Cliente;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
public class GestionCliente
{
    Scanner scan = new Scanner(System.in);
    private Cliente cliente = new Cliente();

    public void modificarDatosDeCliente(Cliente cliente,Map<Long, Cliente> listaClientes) {
        boolean seguir_modificando = false;
        do {
            System.out.println("\n1. Codigo de indentificacion:\t" + cliente.getCodigoCliente());
            System.out.println("2. Nombres:\t" + cliente.getNombres());
            System.out.println("3. Apellidos:\t" + cliente.getApellidos());
            System.out.println("4. Cedula:\t" + cliente.getCedula());
            System.out.println("5. Telefono:\t" + cliente.getTelefono());
            System.out.println("6. Direccion de Entrega:\t" + cliente.getDireccionEntrega());

            System.out.print("\nSeleccione el dato que desea modificar: ");
            int nDato = scan.nextInt();
            switch (nDato) {
                case 1:
                    boolean comprobante = false;
                    do {
                        System.out.print("Digite el nuevo Codigo de Identificacion:");
                        long aux = scan.nextLong();
                        Cliente unCliente = this.buscasClienteCodigo(aux, listaClientes);
                        if (unCliente != null) {
                            comprobante = true;
                            System.out.println("El codigo de identificacion solicitado ya fue asignado a otro cliente");
                        } else {
                            comprobante = false;
                            cliente.setCodigoCliente(aux);
                            System.out.println("Codigo de identificacion actualizado exitosamente.");
                        }
                    } while (comprobante);
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo nombre: ");
                    scan = new Scanner(System.in);
                    String nombre = scan.nextLine();
                    cliente.setNombres(nombre);
                    System.out.println("Nombre actualizado exitosamente.");
                    break;
                case 3:
                    System.out.print("Ingrese el nuevo apellido: ");
                    scan = new Scanner(System.in);
                    String apellido = scan.nextLine();
                    cliente.setApellidos(apellido);
                    System.out.println("Apellido actualizado exitosamente.");
                    break;
                case 4:
                    boolean comprobanteCedula = false;
                    do {
                        System.out.print("Digite la nueva cedula: ");
                        scan = new Scanner(System.in);
                        long aux = scan.nextLong();
                        Cliente unCliente = buscasClienteNI(aux, listaClientes);
                        if (unCliente != null) {
                            System.out.println("La cedula solicitada pertenece a otro Cliente.");
                            comprobanteCedula = true;
                        } else {
                            comprobanteCedula = false;
                            cliente.setCedula(aux);
                            System.out.println("Cedula actualizada exitosamente.");
                        }
                    } while (comprobanteCedula);
                    break;
                case 5:
                    System.out.print("Digite el nuevo telefono: ");
                    scan = new Scanner(System.in);
                    cliente.setTelefono(scan.nextLong());
                    System.out.println("Telefono actualizado exitosamente.");
                    break;
                case 6:
                    System.out.print("Ingrese nueva direccion: ");
                    scan = new Scanner(System.in);
                    cliente.setDireccionEntrega(scan.nextLine());
                    System.out.println("Direccion actualizada exitosamente.");
                    break;
                default:
                    System.out.println("Opcion no disponible");
                    break;
            }
            System.out.println("¿Desea modificar otro dato del mismo cliente? s/n");
            scan = new Scanner(System.in);
            String entrada = scan.nextLine();
            if(entrada.equals("n")){
                seguir_modificando = false;
            }
            else{
                seguir_modificando = true;
            }
        }while(seguir_modificando);
    }


    public Cliente eliminarUnCliente(Map<Long,Cliente> eliminar,Cliente cliente)
    {
        if(eliminar.containsKey(cliente.getCedula()))
        {
            Cliente eliminado = eliminar.remove(cliente.getCedula());
            System.out.println("Cliente eliminado exitosamente");
            return eliminado;
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

    public Cliente buscasClienteNI(long cedula, Map<Long, Cliente> listaClientes)
    {
        for(Map.Entry <Long, Cliente> entrada_mapa: listaClientes.entrySet()){
            if(entrada_mapa.getKey().equals(cedula)){
                return entrada_mapa.getValue();
            }
        }
        return null;
    }

    public Cliente buscasClienteCodigo(long codigoIdentificacion, Map <Long, Cliente> listaClientes){
        for(Map.Entry<Long, Cliente> entrada: listaClientes.entrySet()){
            if(entrada.getValue().getCodigoCliente() == codigoIdentificacion){
                return entrada.getValue();
            }
        }
        return null;
    }

    public void agregarCliente(Map<Long, Cliente> listaClientes)
    {
        System.out.println("\n***Ingrese los datos del nuevo cliente***\n");
        System.out.print("Cedula: ");
        long cedula=scan.nextLong();

        if(!listaClientes.containsKey(cedula))
        {
            System.out.print("Codigo de cliente: ");
            long codigoCliente=scan.nextLong();
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

