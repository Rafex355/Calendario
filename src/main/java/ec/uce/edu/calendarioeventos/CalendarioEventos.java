package ec.uce.edu.calendarioeventos;

import ec.uce.edu.calendarioeventos.gui.Menu;

import java.util.Scanner;
import java.util.InputMismatchException;

public class CalendarioEventos {

    public static void main(String[] args) {
        System.out.println("**********************************************************");
        System.out.println("*                                                        *");
        System.out.println("*                       Inicio                           *");
        System.out.println("*                                                        *");
        System.out.println("*  1. Entrar al Programa de Calendario de Eventos        *");
        System.out.println("*  2. Salir del Programa                                 *");
        System.out.println("*                                                        *");
        System.out.println("**********************************************************");
        elegir();
    }

    public static void elegir() {
        Scanner elegir = new Scanner(System.in);
        int opcion = -1; // Inicializamos opción con un valor no válido para asegurar que el bucle se ejecute al menos una vez

        do {
            System.out.print("Ingrese una opcion para continuar: ");
            try {
                opcion = elegir.nextInt();

                switch (opcion) {
                    case 1:
                        Menu.elegir();
                        break;
                    case 2:
                        System.out.println("***********************************************");
                        System.out.println("*                                             *");
                        System.out.println("*             SALIENDO DEL PROGRAMA           *");
                        System.out.println("*                                             *");
                        System.out.println("***********************************************");
                        break;
                    default:
                        System.out.println("********************************************************");
                        System.out.println("*                                                      *");
                        System.out.println("*  HA ELEGIDO ERRONEAMENTE POR FAVOR VOLVER A INTENTAR *");
                        System.out.println("*                                                      *");
                        System.out.println("********************************************************");
                }
            } catch (InputMismatchException e) {
                System.out.println("*****************************************************");
                System.out.println("*                                                   *");
                System.out.println("*           Error: Debe ingresar un número entero.  *");
                System.out.println("*                                                   *");
                System.out.println("*****************************************************");
                elegir.nextLine(); // Limpiar el buffer de entrada
            }
        } while (opcion != 2);
    }
}

