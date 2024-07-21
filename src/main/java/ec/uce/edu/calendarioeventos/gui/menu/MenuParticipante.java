/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.uce.edu.calendarioeventos.gui.menu;

import ec.uce.edu.calendarioeventos.util.Validacion;
import java.util.Scanner;

/**
 *
 * @author LENOVO.USER
 */


import java.util.InputMismatchException;

public class MenuParticipante {

    public static void mostrarMenuParticipante() {
        System.out.println("***********************************************");
        System.out.println("*                                             *");
        System.out.println("*              MENU DE PARTICIPANTE           *");
        System.out.println("*                                             *");
        System.out.println("***********************************************");
        System.out.println("*                                             *");
        System.out.println("*  1. Gestionar Participante                  *");
        System.out.println("*  2. Gestionar Asistencia                    *");
        System.out.println("*  3. Gestionar Ubicacion                     *");
        System.out.println("*  4. Atras                                   *");
        System.out.println("*                                             *");
        System.out.println("***********************************************");
    }

    public static void elegir() {
        Scanner scanner = new Scanner(System.in);
        int opcionPartici;

        do {
            mostrarMenuParticipante();
            try {
                System.out.print("Ingrese una opción para continuar: ");
                opcionPartici = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada

                switch (opcionPartici) {
                    case 1:
                        MenuGestionarParticipante.elegir();
                        break;
                    case 2:
                        MenuGestionarAsistencia.elegir();
                        break;
                    case 3:
                        MenuGestionarUbicacion.elegir();
                        break;
                    case 4:
                        System.out.println("SALIENDO DEL MENÚ");
                        break;
                    default:
                        System.out.println("Ha elegido erróneamente. Por favor, vuelva a intentar.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero.");
                scanner.nextLine(); // Limpiar el buffer de entrada
                opcionPartici = 0; // Reiniciar la opción para que el bucle continúe
            }
        } while (opcionPartici != 4);
    }

    // Métodos para validar atributos del participante
    public static boolean validarNombreParticipante(String nombre) {
        return Validacion.validarNombre(nombre);
    }

    public static boolean validarApellidoParticipante(String apellido) {
        return Validacion.validarApellido(apellido);
    }

    public static boolean validarCorreoElectronicoParticipante(String correoElectronico) {
        return Validacion.validarCorreoElectronico(correoElectronico);
    }

    public static boolean validarClaveParticipante(String clave) {
        return Validacion.validarClave(clave);
    }

    // Métodos adicionales para la interacción con el usuario y la validación
    public static String obtenerNombreParticipante() {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        do {
            System.out.print("Ingrese el nombre del participante: ");
            nombre = scanner.nextLine();
            if (validarNombreParticipante(nombre)) {
                break;
            } else {
                System.out.println("Nombre inválido. Por favor, intente de nuevo.");
            }
        } while (true);
        return nombre;
    }

    public static String obtenerApellidoParticipante() {
        Scanner scanner = new Scanner(System.in);
        String apellido;
        do {
            System.out.print("Ingrese el apellido del participante: ");
            apellido = scanner.nextLine();
            if (validarApellidoParticipante(apellido)) {
                break;
            } else {
                System.out.println("Apellido inválido. Por favor, intente de nuevo.");
            }
        } while (true);
        return apellido;
    }

    public static String obtenerCorreoElectronicoParticipante() {
        Scanner scanner = new Scanner(System.in);
        String correoElectronico;
        do {
            System.out.print("Ingrese el correo electrónico del participante: ");
            correoElectronico = scanner.nextLine();
            if (validarCorreoElectronicoParticipante(correoElectronico)) {
                break;
            } else {
                System.out.println("Correo electrónico inválido. Por favor, intente de nuevo.");
            }
        } while (true);
        return correoElectronico;
    }

    public static String obtenerClaveParticipante() {
        Scanner scanner = new Scanner(System.in);
        String clave;
        do {
            System.out.print("Ingrese la clave del participante: ");
            clave = scanner.nextLine();
            if (validarClaveParticipante(clave)) {
                break;
            } else {
                System.out.println("Clave inválida. Por favor, intente de nuevo.");
            }
        } while (true);
        return clave;
    }
}


