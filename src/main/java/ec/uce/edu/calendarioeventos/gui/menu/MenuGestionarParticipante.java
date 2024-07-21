/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.uce.edu.calendarioeventos.gui.menu;
import ec.uce.edu.calendarioeventos.dominio.Participante;
import ec.uce.edu.calendarioeventos.dominio.Persona;
import ec.uce.edu.calendarioeventos.util.Validacion;
import ec.uce.edu.calendarioeventos.dominio.PlanificadorEvento;
import ec.uce.edu.calendarioeventos.dominio.TipoPersona;

/**
 *
 * @author Administrador
 */
import java.util.Scanner;

public class MenuGestionarParticipante {

    public static void main(String[] args) {
        elegir();
    }

    public static void mostrarsubMenuPersona() {
        System.out.println("***********************************************");
        System.out.println("*                                             *");
        System.out.println("*      SUBMENU DE GESTION DE PERSONAS         *");
        System.out.println("*                                             *");
        System.out.println("*  1. Crear Participante                      *");
        System.out.println("*  2. Modificar Participante                  *");
        System.out.println("*  3. Eliminar Participante                   *");
        System.out.println("*  4. Consultar Participante                  *");
        System.out.println("*  5. Atras                                   *");
        System.out.println("*                                             *");
        System.out.println("***********************************************");
    }

    public static void elegir() {
        Scanner scanner = new Scanner(System.in);
        int opcionPersona;

        do {
            mostrarsubMenuPersona();
            System.out.print("Ingrese una opción para continuar: ");

            // Verificar si el siguiente token es un entero
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Ingrese una opción para continuar: ");
            }

            opcionPersona = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del nextInt()

            switch (opcionPersona) {
                case 1:
                    crearParticipante();
                    System.out.println("***********************************************");
                    System.out.println("*                                             *");
                    System.out.println("*           PERSONA CREADA CON ÉXITO           *");
                    System.out.println("*                                             *");
                    System.out.println("***********************************************");
                    break;
                case 2:
                    modificarParticipante();
                    break;
                case 3:
                    eliminarParticipante();
                    break;
                case 4:
                    consultarParticipante();
                    break;
                case 5:
                    System.out.println("***********************************************");
                    System.out.println("*                                             *");
                    System.out.println("*             SALIENDO DEL MENÚ                *");
                    System.out.println("*                                             *");
                    System.out.println("***********************************************");
                    break;
                default:
                    System.out.println("Opción incorrecta. Intente nuevamente.");
                    break;
            }
        } while (opcionPersona != 5);

     
    }
    
    public static void crearParticipante() {        
        try {
            String nombre = crearNombre();            
            String apellido = crearApellido();
            String CorreoElectronico = crearCorreo();            
            String clave = crearClave();
            
            Participante nuevoParticipante = new Participante(nombre, apellido, CorreoElectronico, clave);
            
           PlanificadorEvento.agregarPersona(TipoPersona.PARTICIPANTE,nuevoParticipante);   
        } catch (Exception e) {  
            System.out.println("Error al crear el participante:");
        }
    }
//
//    public static void crearPersona() {
//        String nombre = crearNombre();
//        String apellido = crearApellido();
//        String correoElectronico = crearCorreo();
//        String clave = crearClave();
//
//        objetoPersona.agregarPersona(nombre, apellido, correoElectronico, clave);
//    }

    public static void modificarParticipante() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el índice de la Persona que desea modificar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después del nextInt()
        try{
        String nombre = crearNombre();
        String apellido = crearApellido();
        String correoElectronico = crearCorreo();
        String clave = crearClave();
        
        Participante nuevoParticipante = new Participante(nombre, apellido, correoElectronico, clave);
        
        PlanificadorEvento.modificarPersona(indice, nuevoParticipante);
        } catch(Exception e){ 
         System.out.println("Error al modificar el participante: " + e.getMessage());
        }
    }

    public static void eliminarParticipante() {
     // Mostrar los participantes actuales
        System.out.println("Lista de participantes:");
        PlanificadorEvento.consultarPersona();

        // Solicitar al usuario que ingrese el índice de la persona a eliminar
        System.out.print("Ingrese el índice de la Persona que desea eliminar: ");
        Scanner scanner=new Scanner(System.in);
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después del nextInt()

        PlanificadorEvento.eliminarPersona(indice);

        System.out.println("***********************************************");
        System.out.println("*                                             *");
        System.out.println("*           PERSONA ELIMINADA CON ÉXITO        *");
        System.out.println("*                                             *");
        System.out.println("***********************************************");
    }

    public static void consultarParticipante() {
        System.out.println("***********************************************");
        System.out.println("*                                             *");
        System.out.println("*             LISTA DE PERSONAS                *");
        System.out.println("*                                             *");
        System.out.println("***********************************************");
        System.out.println(PlanificadorEvento.consultarPersona());
        System.out.println("***********************************************");
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
                System.out.println("Nombre inválido. Intente nuevamente.");
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
                System.out.println("Apellido inválido. Intente nuevamente.");
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
