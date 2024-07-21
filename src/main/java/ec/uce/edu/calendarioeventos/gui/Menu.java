package ec.uce.edu.calendarioeventos.gui;

import ec.uce.edu.calendarioeventos.gui.menu.MenuGestionarPersonas;
import ec.uce.edu.calendarioeventos.gui.menu.MenuIngresoPlataforma;
import ec.uce.edu.calendarioeventos.gui.menu.MenuGestionarUbicacion;

import java.util.Scanner;
import ec.uce.edu.calendarioeventos.gui.menu.*;

public class Menu {

    public static void main(String[] args) {
        elegir();
    }

    public static void mostrarMenu() {
        System.out.println("****************************************");
        System.out.println("*                                      *");
        System.out.println("*         BIENVENIDO AL MENU PRINCIPAL *");
        System.out.println("*                                      *");
        System.out.println("*  1. Ingresar a la plataforma         *");
        System.out.println("*  2. Participantes y Gestores         *");
        System.out.println("*  3. Gestionar Evento                 *");
        System.out.println("*  4. Gestionar Asistencia             *");
        System.out.println("*  5. Gestionar Ubicacion              *");
        System.out.println("*  6. Salir                            *");
        System.out.println("*                                      *");
        System.out.println("****************************************");
    }

    public static void elegir() {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal = 0;

        do {
            mostrarMenu();
            System.out.print("Ingrese una opcion para continuar: ");
            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    MenuIngresoPlataforma.elegir();
                    break;
                case 2:
                    MenuGestionarPersonas.elegir();
                    break;
                case 3:
                    MenuGestionarEvento.elegir();
                    break;
                case 4:
                    MenuGestionarAsistencia.elegir();
                    break;
                case 5:
                    MenuGestionarUbicacion.elegir();
                    break;
                case 6:
                    System.out.println("****************************************");
                    System.out.println("*                                      *");
                    System.out.println("*           SALIENDO DEL MENU          *");
                    System.out.println("*                                      *");
                    System.out.println("****************************************");
                    break;
                default:
                    System.out.println("****************************************");
                    System.out.println("*                                      *");
                    System.out.println("*   Opción no reconocida. Saliendo del *");
                    System.out.println("*   menú.                              *");
                    System.out.println("*                                      *");
                    System.out.println("****************************************");
            }
        } while (opcionPrincipal != 6);
    }
}
