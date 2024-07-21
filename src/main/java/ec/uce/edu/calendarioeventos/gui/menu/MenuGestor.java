/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.uce.edu.calendarioeventos.gui.menu;


/**
 *
 * @author LENOVO.USER
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuGestor {

    public static void mostrarMenuGestor() {
        System.out.println("***********************************************");
        System.out.println("*                                             *");
        System.out.println("*                MENU DE GESTOR               *");
        System.out.println("*                                             *");
        System.out.println("***********************************************");
        System.out.println("*                                             *");
        System.out.println("*  1. Gestionar Evento                        *");
        System.out.println("*  2. Generar reporte eventos                 *");
        System.out.println("*  3. Gestionar Asistencia                    *");
        System.out.println("*  4. Generar reporte de asistencia           *");
        System.out.println("*  5. Generar reporte de ubicación            *");
        System.out.println("*  6. Gestionar Personas                      *");
        System.out.println("*  7. Atras                                   *");
        System.out.println("*                                             *");
        System.out.println("***********************************************");
    }

    public static void elegir() {
        int opcionGestor = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            mostrarMenuGestor();
            System.out.print("Ingrese una opción para continuar: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next(); // Consumir la entrada inválida
            }
            opcionGestor = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (opcionGestor) {
                case 1:
                    subMenuEvento.elegir();
                    break;
                case 2:
                    System.out.println("**************************************************");
                    System.out.println("*                                                *");
                    System.out.println("*         Generando reporte de eventos...         *");
                    System.out.println("*                                                *");
                    System.out.println("**************************************************");
                    break;
                case 3:
                    subMenuAsistencia.elegir();
                    break;
                case 4:
                    System.out.println("**************************************************");
                    System.out.println("*                                                *");
                    System.out.println("*     Generando reporte de asistencia...         *");
                    System.out.println("*                                                *");
                    System.out.println("**************************************************");
                    break;
                case 5:
                    System.out.println("**************************************************");
                    System.out.println("*                                                *");
                    System.out.println("*      Generando reporte de ubicación...         *");
                    System.out.println("*                                                *");
                    System.out.println("**************************************************");
                    break;
                case 6:
                    subMenuPersona.elegir();
                    break;
                case 7:
                    System.out.println("**************************************************");
                    System.out.println("*                                                *");
                    System.out.println("*                SALIENDO DEL MENU               *");
                    System.out.println("*                                                *");
                    System.out.println("**************************************************");
                    break;
                default:
                    System.out.println("Opción incorrecta. Por favor, vuelva a intentar.");
                    break;
            }
        } while (opcionGestor != 7);
    }

    // Clase subMenuEvento
    static class subMenuEvento {
        public static void elegir() {
            System.out.println("Submenú de Evento seleccionado.");
            // Aquí implementar la lógica del submenú de evento si es necesario
        }
    }

    // Clase subMenuAsistencia
    static class subMenuAsistencia {
        public static void elegir() {
            System.out.println("Submenú de Asistencia seleccionado.");
            // Aquí implementar la lógica del submenú de asistencia si es necesario
        }
    }

    // Clase subMenuPersona
    static class subMenuPersona {
        public static void elegir() {
            System.out.println("Submenú de Persona seleccionado.");
            // Aquí implementar la lógica del submenú de persona si es necesario
        }
    }

    // Clase Validacion
    static class Validacion {
        public static boolean validarNombre(String nombre) {
            return nombre.matches("[a-zA-Z]+");
        }

        public static boolean validarApellido(String apellido) {
            return apellido.matches("[a-zA-Z]+");
        }

        public static boolean validarCorreoElectronico(String correoElectronico) {
            return correoElectronico.matches("^[A-Za-z0-9+_.-]+@(.+)$");
        }

        public static boolean validarClave(String clave) {
            return clave.length() >= 6;
        }
    }

    // Método main para probar el menú de gestor
    public static void main(String[] args) {
        elegir();
    }

    // Métodos adicionales para validar atributos del gestor
    public static boolean validarNombreGestor(String nombre) {
        return Validacion.validarNombre(nombre);
    }

    public static boolean validarApellidoGestor(String apellido) {
        return Validacion.validarApellido(apellido);
    }

    public static boolean validarCorreoElectronicoGestor(String correoElectronico) {
        return Validacion.validarCorreoElectronico(correoElectronico);
    }

    public static boolean validarClaveGestor(String clave) {
        return Validacion.validarClave(clave);
    }

    // Métodos adicionales para la interacción con el usuario y la validación
    public static String obtenerNombreGestor() {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        do {
            System.out.print("Ingrese el nombre del gestor: ");
            nombre = scanner.nextLine();
            if (validarNombreGestor(nombre)) {
                break;
            } else {
                System.out.println("Nombre inválido. Por favor, intente de nuevo.");
            }
        } while (true);
        return nombre;
    }

    public static String obtenerApellidoGestor() {
        Scanner scanner = new Scanner(System.in);
        String apellido;
        do {
            System.out.print("Ingrese el apellido del gestor: ");
            apellido = scanner.nextLine();
            if (validarApellidoGestor(apellido)) {
                break;
            } else {
                System.out.println("Apellido inválido. Por favor, intente de nuevo.");
            }
        } while (true);
        return apellido;
    }

    public static String obtenerCorreoElectronicoGestor() {
        Scanner scanner = new Scanner(System.in);
        String correoElectronico;
        do {
            System.out.print("Ingrese el correo electrónico del gestor: ");
            correoElectronico = scanner.nextLine();
            if (validarCorreoElectronicoGestor(correoElectronico)) {
                break;
            } else {
                System.out.println("Correo electrónico inválido. Por favor, intente de nuevo.");
            }
        } while (true);
        return correoElectronico;
    }

    public static String obtenerClaveGestor() {
        Scanner scanner = new Scanner(System.in);
        String clave;
        do {
            System.out.print("Ingrese la clave del gestor: ");
            clave = scanner.nextLine();
            if (validarClaveGestor(clave)) {
                break;
            } else {
                System.out.println("Clave inválida. Por favor, intente de nuevo.");
            }
        } while (true);
        return clave;
    }
}

