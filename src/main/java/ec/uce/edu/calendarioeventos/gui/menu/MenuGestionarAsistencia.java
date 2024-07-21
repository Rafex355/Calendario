package ec.uce.edu.calendarioeventos.gui.menu;

import ec.uce.edu.calendarioeventos.dominio.Asistencia;
import java.text.ParseException;
import ec.uce.edu.calendarioeventos.dominio.Evento;
import ec.uce.edu.calendarioeventos.dominio.Participante;
import ec.uce.edu.calendarioeventos.util.Validacion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author LENOVO.USER
 */
public class MenuGestionarAsistencia {

    public static Evento eventos;

    public static void main(String[] args) {
        arranque();
        elegir();
    }

    public static void mostrarMenuAsistencia() {
        System.out.println("****");
        System.out.println("*    MENU GESTION ASISTENCIA     *");
        System.out.println("****");
        System.out.println("* 1. Agregar asistencia         *");
        System.out.println("* 2. Modificar asistencia       *");
        System.out.println("* 3. Eliminar asistencia        *");
        System.out.println("* 4. Consultar asistencia       *");
        System.out.println("* 5. Consultar Reserva          *");
        System.out.println("* 6. Salir                      *");
        System.out.println("****");
    }

    public static void elegir() {
        Scanner scanner = new Scanner(System.in);
        int opcionAsistencia;

        do {
            mostrarMenuAsistencia();
            System.out.print("Ingrese una opcion para continuar: ");
            opcionAsistencia = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del nextInt()

            switch (opcionAsistencia) {
                case 1:
                    agregarAsistencia();
                    System.out.println("****");
                    System.out.println("*   Asistencia agregada con exito!  *");
                    System.out.println("****");
                    break;
                case 2:
                    modificarAsistencia();
                    break;
                case 3:
                    eliminarAsistencia();
                    break;
                case 4:
                    consultarAsistencias();
                    break;
                case 5:
                    consultarReservas();
                    break;
                case 6:
                    System.out.println("****");
                    System.out.println("*      SALIENDO DEL MENU        *");
                    System.out.println("****");
                    break;
                default:
                    System.out.println("****");
                    System.out.println("* Opcion incorrecta. Intente nuevamente. *");
                    System.out.println("****");
                    break;
            }
        } while (opcionAsistencia != 6);
    }

    public static void arranque() {
        eventos = new Evento();
        
        // Aquí puedes inicializar cualquier otra cosa que necesites al arrancar el menú
    }

    public static void agregarAsistencia() {
        Scanner scanner = new Scanner(System.in);
        Date fechaAsistencia = crearFecha();
        int calificacion = crearCalificacion();
        Participante participante = crearParticipante();
        boolean asistio = crearAsistio();
        boolean asistioReserva = crearAsistio();
        
        Asistencia nuevaAsistencia = new Asistencia(participante, fechaAsistencia, calificacion, asistio, asistioReserva);
        eventos.agregarAsistencia(nuevaAsistencia);
    }

    public static void modificarAsistencia() {
        Scanner scanner = new Scanner(System.in);
        Date fechaAsistencia = crearFecha();

        System.out.println("****");
        System.out.print("* Ingrese el índice del evento al que desea modificar la asistencia: ");
        int indiceEvento = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después del nextInt()

        int calificacion = crearCalificacion();
        Participante participante = crearParticipante();
        boolean asistio = crearAsistio();
        boolean asistioReserva = crearAsistio();

        Asistencia nuevaAsistencia = new Asistencia(participante, fechaAsistencia, calificacion, asistio, asistioReserva);
        
        eventos.modificarAsistencia(indiceEvento, nuevaAsistencia);
    }

    public static void eliminarAsistencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****");
        System.out.print("* Ingrese el índice del evento al que desea eliminar la asistencia: ");
        int indiceEvento = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después del nextInt()

        eventos.eliminarAsistencia(indiceEvento);
    }

    public static void consultarAsistencias() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****");
        System.out.println(eventos.consultarAsistencias());
        System.out.println("****");
    }
    
    public static void consultarReservas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****************************");
        eventos.consultarReservas();
        System.out.println("****************************");
    }

    public static Participante crearParticipante() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del participante:");

        String nombre = crearNombre();
        String apellido = crearApellido();
        String correoElectronico = crearCorreo();
        String clave = crearClave();

        return new Participante(nombre, apellido, correoElectronico, clave);
    }

    public static boolean crearAsistio() {
        Scanner scanner = new Scanner(System.in);
        String respuesta;

        while (true) {
            System.out.print("¿Asistio el participante? (sí/no): ");
            respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("sí") || respuesta.equals("si")) {
                return true;
            } else if (respuesta.equals("no")) {
                return false;
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese 'sí' o 'no'.");
            }
        }
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
        System.out.print("Ingrese el Apellido: ");
        return scanner.nextLine();
    }

    public static String crearCorreo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el Correo Electronico: ");
        return scanner.nextLine();
    }

    public static String crearClave() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la Clave: ");
        return scanner.nextLine();
    }

    public static Date crearFecha() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);
        Date fechaRegistrada;

        while (true) {
            try {
                System.out.print("Ingrese una fecha (DD/MM/YYYY): ");
                String fechaString = scanner.nextLine();
                fechaRegistrada = formatoFecha.parse(fechaString);

                if (Validacion.validarFechas(fechaRegistrada)) {
                    break;
                } else {
                    System.out.println("Fecha invalida. Intente nuevamente.");
                }
            } catch (ParseException e) {
                System.out.println("Error en la fecha. Asegurese de ingresar en el formato correcto (DD/MM/YYYY).");
            }
        }

        return fechaRegistrada;
    }
    
    public static int crearCalificacion() {
        Scanner scanner = new Scanner(System.in);
        int calificacion;

        while (true) {
            System.out.print("Ingrese una calificacion (0-10): ");
            calificacion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del nextInt()

            if (Validacion.validarNumeros(calificacion)) {
                break;
            } else {
                System.out.println("Calificacion invalida. Intente nuevamente.");
            }
        }

        return calificacion;
    }
}