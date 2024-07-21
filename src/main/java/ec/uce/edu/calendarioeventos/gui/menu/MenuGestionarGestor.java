package ec.uce.edu.calendarioeventos.gui.menu;

import ec.uce.edu.calendarioeventos.dominio.*;
import static ec.uce.edu.calendarioeventos.gui.menu.MenuGestionarEvento.crearGestor;
import ec.uce.edu.calendarioeventos.util.Validacion;
import java.util.Scanner;

/**
 *
 * @author LENOVO.USER
 */
public class MenuGestionarGestor {

    public static void main(String[] args) {
        elegir();
    }

    public static void mostrarsubMenuGestor() {
        System.out.println("***********************************************");
        System.out.println("*                                             *");
        System.out.println("*        SUBMENU DE GESTION DE GESTOR         *");
        System.out.println("*                                             *");
        System.out.println("*  1. Crear Gestor                            *");
        System.out.println("*  2. Modificar Gestor                        *");
        System.out.println("*  3. Eliminar Gestor                         *");
        System.out.println("*  4. Consultar Gestor                        *");
        System.out.println("*  5. Atras                                   *");
        System.out.println("*                                             *");
        System.out.println("***********************************************");
    }

    public static void elegir() {
        int opcionGestor;

        do {
            mostrarsubMenuGestor();
            Scanner elegir = new Scanner(System.in);
            System.out.print("Ingrese una opcion para continuar: ");
            opcionGestor = elegir.nextInt();

            switch (opcionGestor) {
                case 1:
                    crearGestor();
                    System.out.println("*****************");
                    System.out.println("*                                             *");
                    System.out.println("*          GESTOR CREADO CON ÉXITO             *");
                    System.out.println("*                                             *");
                    System.out.println("*****************");
                    break;
                case 2:
                    modificarGestor();
                    break;
                case 3:
                    eliminarGestor();
                    break;
                case 4:
                    consultarGestores();
                    break;
                case 5:
                    System.out.println("*****************");
                    System.out.println("*                                             *");
                    System.out.println("*             SALIENDO DEL MENÚ                *");
                    System.out.println("*                                             *");
                    System.out.println("*****************");
                    break;
                default:
                    System.out.println("Opción incorrecta. Intente nuevamente.");
                    break;
            }
        } while (opcionGestor != 5);
    }

    public static void crearGestor() {

        String nombre = crearNombre();
        String apellido = crearApellido();
        String correoElectronico = crearCorreo();
        String clave = crearClave();
        
        Gestor nuevoGestor = new Gestor(nombre, apellido, correoElectronico, clave);
        
        PlanificadorEvento.agregarPersona(TipoPersona.GESTOR,nuevoGestor);
    
        
    }

    public static void modificarGestor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el índice del Gestor que desea modificar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después del nextInt()

//        String idGestor = crearIDGestor();
        String nombre = crearNombre();
        String apellido = crearApellido();
        String correoElectronico = crearCorreo();
        String clave = crearClave();
        
        Gestor nuevoGestor = new Gestor(nombre, apellido, correoElectronico, clave);
        
        PlanificadorEvento.modificarPersona(indice, nuevoGestor);
    }

    public static void eliminarGestor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el índice del Gestor que desea eliminar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después del nextInt()

        PlanificadorEvento.eliminarPersona(indice);

        System.out.println("*****************");
        System.out.println("*                                             *");
        System.out.println("*        GESTOR ELIMINADO CON ÉXITO            *");
        System.out.println("*                                             *");
        System.out.println("*****************");
    }

    public static void consultarGestores() {
        System.out.println("------ LISTA DE PERSONAS ------");
        System.out.println(PlanificadorEvento.consultarPersona());
        System.out.println("-------------------------------");
    }

    public static String crearIDGestor() {
        Scanner scanner = new Scanner(System.in);
        String id;

        while (true) {
            System.out.print("Ingrese un ID para el Gestor: ");
            id = scanner.nextLine();

            if (Validacion.validarIDGestor(id)) {
                break;
            } else {
                System.out.println("ID inválido. Intente nuevamente.");
            }
        }

        return id;
    }

    public static String crearNombre() {
        Scanner scanner = new Scanner(System.in);
        String nombre;

        while (true) {
            System.out.print("Ingrese un Nombre: ");
            nombre = scanner.nextLine();

            if (Validacion.validarNombre(nombre)) {
                break;
            } else {
                System.out.println("Nombre invalido. Intente nuevamente.");
            }
        }

        return nombre;
    }

    public static String crearApellido() {
        Scanner scanner = new Scanner(System.in);
        String apellido;

        while (true) {
            System.out.print("Ingrese un Apellido: ");
            apellido = scanner.nextLine();

            if (Validacion.validarNombre(apellido)) {
                break;
            } else {
                System.out.println("Apellido invalido. Intente nuevamente.");
            }
        }

        return apellido;
    }

    public static String crearCorreo() {
        Scanner scanner = new Scanner(System.in);
        String correo;

        while (true) {
            System.out.print("Ingrese un Correo: ");
            correo = scanner.nextLine();

            if (Validacion.validarCorreoElectronico(correo)) {
                break;
            } else {
                System.out.println("Correo Electrónico inválido. Intente nuevamente.");
            }
        }

        return correo;

    }

    public static String crearClave() {
        Scanner scanner = new Scanner(System.in);
        String clave;

        while (true) {
            System.out.print("Ingrese una Clave: ");
            clave = scanner.nextLine();

            if (Validacion.validarClave(clave)) {
                break;
            } else {
                System.out.println("Clave inválida. Intente nuevamente.");
            }
        }

        return clave;
    }

  }
