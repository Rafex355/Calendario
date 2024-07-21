package ec.uce.edu.calendarioeventos.gui.menu;

import ec.uce.edu.calendarioeventos.dominio.PlanificadorEvento;
import ec.uce.edu.calendarioeventos.dominio.Asistencia;
import ec.uce.edu.calendarioeventos.dominio.Evento;
import ec.uce.edu.calendarioeventos.dominio.Gestor;
import ec.uce.edu.calendarioeventos.dominio.Participante;
import ec.uce.edu.calendarioeventos.dominio.Ubicacion;
import static ec.uce.edu.calendarioeventos.gui.menu.MenuIngresoPlataforma.asignarNumero;
import ec.uce.edu.calendarioeventos.util.Validacion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MenuGestionarEvento {
    
    public static void main(String[] args) {
        elegir();
    }

    public static void mostrarMenuEvento() {
        System.out.println("************************************");
        System.out.println("*         MENÚ GESTIÓN EVENTO       *");
        System.out.println("************************************");
        System.out.println("* 1. Crear evento                   *");
        System.out.println("* 2. Modificar evento               *");
        System.out.println("* 3. Eliminar evento                *");
        System.out.println("* 4. Consultar eventos              *");
        System.out.println("* 5. Salir                          *");
        System.out.println("************************************");
    }

    public static void elegir() {
        Scanner scanner = new Scanner(System.in);
        int opcionEvento;

        do {
            mostrarMenuEvento();
            System.out.print("Ingrese una opción para continuar: ");
            opcionEvento = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del nextInt()

            switch (opcionEvento) {
                case 1:
                    crearEvento();
                    System.out.println("************************************");
                    System.out.println("*         Evento creado con éxito!  *");
                    System.out.println("************************************");
                    break;
                case 2:
                    modificarEvento();
                    break;
                case 3:
                    eliminarEvento();
                    break;
                case 4:
                    consultarEventos();
                    break;
                case 5:
                    System.out.println("************************************");
                    System.out.println("*        SALIENDO DEL MENÚ          *");
                    System.out.println("************************************");
                    break;
                default:
                    System.out.println("************************************");
                    System.out.println("* Opción incorrecta. Intente nuevamente. *");
                    System.out.println("************************************");
                    break;
            }
        } while (opcionEvento != 5);
    }

    public static void crearEvento() {
        String nombre = crearNombre();
        String descripcion = crearDescripcion();
        Date fechaEvento = crearFecha();
        Gestor gestoresEvento = crearGestor();
        Ubicacion ubicaciones = crearUbicacion();
        Asistencia[] asistencias = crearAsistencia();
        int numAsistencias = asignarNumero();

        Evento nuevoEvento = new Evento(nombre, descripcion, fechaEvento, gestoresEvento, ubicaciones, asistencias, numAsistencias);

        PlanificadorEvento.agregarEvento(nuevoEvento);
    }

    public static void modificarEvento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("************************************");
        System.out.print("* Ingrese el índice del evento que desea modificar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después del nextInt()

        String nombre = crearNombre();
        String descripcion = crearDescripcion();
        Date fechaEvento = crearFecha();
        Gestor gestoresEvento = crearGestor();
        Ubicacion ubicaciones = crearUbicacion();
        Asistencia[] asistencias = crearAsistencia();
        int numAsistencias = asignarNumero();

        Evento nuevoEvento = new Evento(nombre, descripcion, fechaEvento, gestoresEvento, ubicaciones, asistencias, numAsistencias);

        PlanificadorEvento.modificarEvento(indice, nuevoEvento);
    }

    public static void eliminarEvento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("************************************");
        System.out.print("* Ingrese el índice del evento que desea eliminar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después del nextInt()

        PlanificadorEvento.eliminarEvento(indice);
    }

    public static void consultarEventos() {
        System.out.println("************************************");
        System.out.println("*        LISTA DE EVENTOS          *");
        System.out.println("************************************");
        System.out.println(PlanificadorEvento.consultarEvento());
        System.out.println("************************************");
    }

    public static String crearID() {
        Scanner scanner = new Scanner(System.in);
        String id;

        while (true) {
            System.out.print("Ingrese un ID: ");
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
                System.out.println("Nombre inválido. Intente nuevamente.");
            }
        }

        return nombre;
    }

    public static String crearDescripcion() {
        Scanner scanner = new Scanner(System.in);
        String descripcion;

        while (true) {
            System.out.print("Ingrese una descripción: ");
            descripcion = scanner.nextLine();

            if (Validacion.validarNombre(descripcion)) {
                break;
            } else {
                System.out.println("Descripción inválida. Intente nuevamente.");
            }
        }

        return descripcion;
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
                    System.out.println("Fecha inválida. Intente nuevamente.");
                }
            } catch (ParseException e) {
                System.out.println("Error en la fecha. Asegúrese de ingresar en el formato correcto (DD/MM/YYYY).");
            }
        }

        return fechaRegistrada;
    }

    public static Gestor crearGestor() {
        Scanner scanner = new Scanner(System.in);

        Gestor gestores;

        System.out.println("Ingrese los datos para el gestor: ");

        System.out.print("Ingrese un Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese un Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese un Correo Electrónico: ");
        String correoElectronico = scanner.nextLine();

        System.out.print("Ingrese una Clave: ");
        String clave = scanner.nextLine();

        gestores = new Gestor(nombre, apellido, correoElectronico, clave);

        return gestores;
    }

    public static Ubicacion crearUbicacion() {
        Scanner scanner = new Scanner(System.in);

        Ubicacion ubicaciones;
        System.out.println("Ingrese los datos para la ubicación: ");

        System.out.print("Ingrese el Nombre de la Ubicación: ");
        String nombreUbicacion = scanner.nextLine();

        System.out.print("Ingrese la Dirección de la Ubicación: ");
        String direccionUbicacion = scanner.nextLine();

        System.out.print("Ingrese la Capacidad de la Ubicación: ");
        int capacidadUbicacion = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        ubicaciones = new Ubicacion(nombreUbicacion, direccionUbicacion, capacidadUbicacion);

        return ubicaciones;
    }
    
    public static Asistencia[] crearAsistencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de asistencias a crear: ");
        int cantidadAsistencias = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Asistencia[] asistencias = new Asistencia[cantidadAsistencias];
        for (int l = 0; l < cantidadAsistencias; l++) {
            System.out.println("Ingrese los datos para la asistencia " + (l + 1) + ":");

            // Crear participante
            Participante participante = crearPersona();

            // Crear fecha de asistencia
            java.util.Date fechaAsistencia = crearFecha();

            // Ingresar calificación
            System.out.print("Ingrese una calificación: ");
            int calificacion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            // Validar calificación
            boolean verificacion = Validacion.validarCalificacion(calificacion);

            System.out.print("¿Verificación de Asistencia Reservada? (true/false): ");
            boolean verificacionReserva = scanner.nextBoolean();
            scanner.nextLine(); // Consumir el salto de línea después del nextBoolean()

            // Crear objeto Asistencia y agregarlo al arreglo
            asistencias[l] = new Asistencia(participante, fechaAsistencia, calificacion, verificacion, verificacionReserva);
        }
        return asistencias;
    }

    public static Participante crearPersona() {

        String nombre = crearNombre();
        String apellido = crearApellido();
        String correoElectronico = crearCorreo();
        String clave = crearClave();

        Participante persona = new Participante(nombre, apellido, correoElectronico, clave);
        return persona;
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
