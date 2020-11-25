package view;

import controller.ControlGaleria;
import model.Instalacion;

import java.util.Scanner;

public class PantallaGaleria
{

    public static void main(String[] args)
    {

        System.out.println("ok si funciona");
        ControlGaleria galeria = new ControlGaleria();
        galeria.datosPrueba();

        boolean seguir = true;
        do {
            System.out.println("\n***MENU GALERIA***\n");
            System.out.println
                    (
                            "1.Ver listado de Obras disponibles" +
                                    "\n2.Buscar una Obra por título, artista o año" +
                                    "\n3.Insertar una Obra" +
                                    "\n4.Modificar una Obra" +
                                    "\n5.Eliminar una Obra" +
                                    "\n6.Ver listado de Clientes registrados en el sistema" +
                                    "\n7.Buscar un Cliente" +
                                    "\n8.Insertar Cliente" +
                                    "\n9.Modificar datos de Cliente" +
                                    "\n10.Eliminar un Cliente" +
                                    "\n11.Realizar compra de una Obra" +
                                    "\n12.Eliminar compra de obra" +
                                    "\n13.Ver listado de Compras existentes" +
                                    "\n14.Ver listado de Compras para un mes y año específico insertado por el usuario" +
                                    "\n15.Ver listado de Artistas más vendidos" +
                                    "\n16.Salir"

                    );

            Scanner ingreso = new Scanner(System.in);
            System.out.print("\nIngrese la opcion que desea realizar:");
            int respuesta = ingreso.nextInt();
            for (int i = 0; i < 100; ++i) System.out.println();

            switch (respuesta)
            {
                case 1:{galeria.opcion1();}break;
                case 2:{galeria.opcion2();}break;
                case 3:{galeria.opcion3(); }break;
                case 4:{galeria.opcion4();}break;
                case 5:{galeria.opcion5();}break;
                case 6:{galeria.opcion6();}break;
                case 7:{galeria.opcion7();}break;
                case 8:{galeria.opcion8();}break;
                case 9:{galeria.opcion9();}break;
                case 10:{galeria.opcion10();}break;
                case 11:{galeria.opcion11();}break;
                case 12:{galeria.opcion12();}break;
                case 13:{galeria.opcion13();}break;
                case 14:{galeria.opcion14();}break;
                case 15:{galeria.opcion15();}break;
                case 16:{seguir=false; }break;

                default:
                    System.out.println("opcion no disponible");
            }
        }while(seguir);
        galeria.interaccionObjetos();
    }
}

