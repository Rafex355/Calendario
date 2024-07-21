
package ec.uce.edu.calendarioeventos.gui.menu;

import ec.uce.edu.calendarioeventos.dominio.Gestor;
import ec.uce.edu.calendarioeventos.dominio.Participante;
import ec.uce.edu.calendarioeventos.dominio.Persona;
import ec.uce.edu.calendarioeventos.util.Validacion;

import java.util.Scanner;


public class MenuIngresoPlataforma {

    private static Persona participante = new Participante("Sergio", "participante", "sergio@uce.edu", "Monotono9");
    private static Persona gestor = new Gestor("Bryan", "gestor", "bryan@uce.edu", "Monotono5");

    public static void mostrarMenuIngresoPlataforma() {
        System.out.println("**************************************************");
        System.out.println("*                                                *");
        System.out.println("*       SUBMENU DE INGRESO A LA PLATAFORMA       *");
        System.out.println("*                                                *");
        System.out.println("**************************************************");
        System.out.println("*                                                *");
        System.out.println("*  1. Ingresar como Persona                      *");
        System.out.println("*  2. Ingresar como Gestor                       *");
        System.out.println("*  3. Salir                                      *");
        System.out.println("*                                                *");
        System.out.println("**************************************************");
    }

    public static void elegir() {
        Scanner input = new Scanner(System.in);
        int opcionIngresoPlataforma;

        do {
            mostrarMenuIngresoPlataforma();
            System.out.print("Ingrese una opción para continuar: ");
            opcionIngresoPlataforma = input.nextInt();
            input.nextLine();  // Consumir el salto de línea después de nextInt()

            switch (opcionIngresoPlataforma) {
                case 1:
                    System.out.println("**************************************************");
                    System.out.println("*                                                *");
                    System.out.println("*       Ingresar como Persona                    *");
                    System.out.println("*                                                *");
                    System.out.println("**************************************************");
                    iniciarSesion(participante);
                    MenuParticipante.elegir();
                    break;
                case 2:
                    System.out.println("**************************************************");
                    System.out.println("*                                                *");
                    System.out.println("*       Ingresar como Gestor                     *");
                    System.out.println("*                                                *");
                    System.out.println("**************************************************");
                    iniciarSesion(gestor);
                    MenuGestor.elegir();
                    break;
                case 3:
                    System.out.println("**************************************************");
                    System.out.println("*                                                *");
                    System.out.println("*                 SALIENDO DEL MENU               *");
                    System.out.println("*                                                *");
                    System.out.println("**************************************************");
                    break;
                default:
                    System.out.println("Opción incorrecta. Por favor, intente de nuevo.");
            }
        } while (opcionIngresoPlataforma != 3);
    }

    public static void iniciarSesion(Persona persona) {
        Scanner input = new Scanner(System.in);
        System.out.println("**************************************************");
        System.out.println("*                                                *");
        System.out.println("*           Ingrese su usuario y contraseña       *");
        System.out.println("*                                                *");
        System.out.println("**************************************************");

        System.out.print("Usuario: ");
        String usuario = input.nextLine();

        System.out.print("Contraseña: ");
        String contrasena = input.nextLine();

        if (usuario.equals(persona.getNombre()) && contrasena.equals(persona.getClave())) {
            System.out.println("\nInicio de sesión como " + (persona == participante ? "Persona" : "Gestor") + " exitoso.");
        } else {
            System.out.println("\nUsuario o contraseña incorrecta.");
        }
    }

    // Método de arranque, si es necesario
    public static void arranque() {
        // Método de arranque, si es necesario
    }

    public static Persona crearPersona() {
        Persona persona = new Participante();

        String nombre = crearNombre();
        String email = crearCorreo();
        String contrasena = crearContrasena();

        persona.setNombre(nombre);
        persona.setCorreoElectronico(email);
        persona.setClave(contrasena);

        return persona;
    }

    public static String crearNombre() {
        Scanner input = new Scanner(System.in);
        String nombre;

        do {
            System.out.print("Ingrese su nombre: ");
            nombre = input.nextLine();

            if (Validacion.validarNombre(nombre)) {
                break;
            } else {
                System.out.println("Nombre inválido. Intente nuevamente.");
            }
        } while (true);

        return nombre;
    }

    public static String crearCorreo() {
        Scanner input = new Scanner(System.in);
        String correo;

        do {
            System.out.print("Ingrese su correo electrónico: ");
            correo = input.nextLine();

            if (Validacion.validarCorreoElectronico(correo)) {
                break;
            } else {
                System.out.println("Correo electrónico inválido. Intente nuevamente.");
            }
        } while (true);

        return correo;
    }

    public static String crearId() {
        Scanner input = new Scanner(System.in);
        String id;

        do {
            System.out.print("Ingrese su ID: ");
            id = input.nextLine();

            if (Validacion.validarIDGestor(id)) {
                break;
            } else {
                System.out.println("ID inválido. Intente nuevamente.");
            }
        } while (true);

        return id;
    }

    public static String crearContrasena() {
        Scanner input = new Scanner(System.in);
        String contrasena;

        do {
            System.out.print("Ingrese su contraseña: ");
            contrasena = input.nextLine();

            if (Validacion.validarClave(contrasena)) {
                break;
            } else {
                System.out.println("Contraseña inválida. Intente nuevamente.");
            }
        } while (true);

        return contrasena;
    }

    public static int asignarNumero() {
        Scanner input = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Ingrese un número: ");
            numero = input.nextInt();

            if (Validacion.validarNumeros(numero)) {
                break;
            } else {
                System.out.println("Número incorrecto. Intente nuevamente.");
            }
        } while (true);

        return numero;
    }
}

