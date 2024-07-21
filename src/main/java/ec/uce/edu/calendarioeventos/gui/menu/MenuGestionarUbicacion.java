package ec.uce.edu.calendarioeventos.gui.menu;

/**
 *
 * @author LENOVO.USER
 */
import ec.uce.edu.calendarioeventos.dominio.PlanificadorEvento;
import ec.uce.edu.calendarioeventos.dominio.Ubicacion;

import java.util.Scanner;

public class MenuGestionarUbicacion {
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        elegir();
    }

    public static void mostrarMenuUbicacion() {
        System.out.println("*****************************************");
        System.out.println("*                                       *");
        System.out.println("*          SUBMENU DE GESTION           *");
        System.out.println("*                  DE                   *");
        System.out.println("*              UBICACIONES              *");
        System.out.println("*                                       *");
        System.out.println("*****************************************");
        System.out.println("*                                       *");
        System.out.println("*  1. Crear Ubicacion                   *");
        System.out.println("*  2. Modificar Ubicacion               *");
        System.out.println("*  3. Eliminar Ubicacion                *");
        System.out.println("*  4. Consultar Ubicacion               *");
        System.out.println("*  5. Generar reporte de ubicaciones    *");
        System.out.println("*  6. Consultar por nombre de Ubicacion *");
        System.out.println("*  7. Atras                             *");
        System.out.println("*                                       *");
        System.out.println("*****************************************");
    }

    public static void elegir() {
        int opcionUbicacion;

        do {
            mostrarMenuUbicacion();
            opcionUbicacion = obtenerEntero("Ingrese una opcion para continuar: ");

            switch (opcionUbicacion) {
                case 1:
                    crearUbicacion();
                    break;
                case 2:
                    modificarUbicacion();
                    break;
                case 3:
                    eliminarUbicacion();
                    break;
                case 4:
                    consultarUbicacion();
                    break;
                case 5:
                    generarReporteUbicaciones();
                    break;
                case 6:
                    consultarPorNombreUbicacion();
                    break;
                case 7:
                    System.out.println("*****************************************");
                    System.out.println("*                                       *");
                    System.out.println("*             SALIENDO DEL MENU          *");
                    System.out.println("*                                       *");
                    System.out.println("*****************************************");
                    break;
                default:
                    System.out.println("Opción incorrecta. Por favor, vuelva a intentar.");
                    break;
            }
        } while (opcionUbicacion != 7);
    }

    public static void crearUbicacion() {

        String nombre = obtenerTexto("Ingrese el nombre de la Ubicacion: ");
        String direccion = obtenerTexto("Ingrese la direccion de la Ubicacion: ");
        int capacidad = obtenerEntero("Ingrese la capacidad de la Ubicacion: ");

        PlanificadorEvento.agregarUbicacion(new Ubicacion(nombre, direccion, capacidad));
        System.out.println("*****************************************");
        System.out.println("*                                       *");
        System.out.println("*     UBICACION CREADA CON ÉXITO        *");
        System.out.println("*                                       *");
        System.out.println("*****************************************");
    }

    public static void modificarUbicacion() {
        int id = obtenerEntero("Ingrese el ID de la Ubicacion que desea modificar: ");
        String nombre = obtenerTexto("Ingrese el nuevo nombre de la Ubicacion: ");
        String direccion = obtenerTexto("Ingrese la nueva direccion de la Ubicacion: ");
        int capacidad = obtenerEntero("Ingrese la nueva capacidad de la Ubicacion: ");

        PlanificadorEvento.modificarUbicacion(id, new Ubicacion(nombre, direccion, capacidad));
        
        System.out.println("*****************************************");
        System.out.println("*                                       *");
        System.out.println("*   UBICACION MODIFICADA CON ÉXITO      *");
        System.out.println("*                                       *");
        System.out.println("*****************************************");
                
    }

    public static void eliminarUbicacion() {
        int id = obtenerEntero("Ingrese el ID de la Ubicacion que desea eliminar: ");
        
        PlanificadorEvento.eliminarUbicacion(id);

        System.out.println("*****************************************");
        System.out.println("*                                       *");
        System.out.println("*    UBICACION ELIMINADA CON ÉXITO      *");
        System.out.println("*                                       *");
        System.out.println("*****************************************");
    }

    public static void consultarUbicacion() {
        System.out.println("*****************************************");
        System.out.println("*                                       *");
        System.out.println("*        LISTA DE UBICACIONES           *");
        System.out.println("*                                       *");
        System.out.println("*****************************************");
        PlanificadorEvento.consultarUbicaciones();
        System.out.println("*****************************************");
    }

    public static void generarReporteUbicaciones() {
        System.out.println("*****************************************");
        System.out.println("*                                       *");
        System.out.println("*    REPORTE DE UBICACIONES             *");
        System.out.println("*                                       *");
        System.out.println("*****************************************");
        PlanificadorEvento.consultarUbicaciones();
        System.out.println("*****************************************");
    }

    public static void consultarPorNombreUbicacion() {
        String nombre = obtenerTexto("Ingrese el nombre de la Ubicacion que desea consultar: ");

        System.out.println("*****************************************");
        System.out.println("*                                       *");
        System.out.println("*    RESULTADOS DE LA BÚSQUEDA           *");
        System.out.println("*                                       *");
        System.out.println("*****************************************");
        PlanificadorEvento.consultarUbicacion(nombre);
        System.out.println("*****************************************");
    }

    public static int obtenerEntero(String mensaje) {
        int numero = 0;
        boolean entradaValida = false;

        do {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                entradaValida = true;
            } else {
                System.out.println("Error: Debes ingresar un número entero válido.");
                scanner.nextLine(); // Consumir la entrada incorrecta
            }
        } while (!entradaValida);

        return numero;
    }

    public static String obtenerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}




