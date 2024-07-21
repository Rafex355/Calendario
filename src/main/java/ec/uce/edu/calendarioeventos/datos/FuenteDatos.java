package ec.uce.edu.calendarioeventos.datos;

import ec.uce.edu.calendarioeventos.dominio.Asistencia;
import ec.uce.edu.calendarioeventos.dominio.Evento;
import ec.uce.edu.calendarioeventos.dominio.Gestor;
import ec.uce.edu.calendarioeventos.dominio.Participante;
import ec.uce.edu.calendarioeventos.dominio.Persona;
import ec.uce.edu.calendarioeventos.dominio.PlanificadorEvento;
import ec.uce.edu.calendarioeventos.dominio.Ubicacion;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author LENOVO.USER
 */
//public class FuenteDatos {
//
//    private final String dataFile;
//
//    public FuenteDatos(String filePath) {
//        this.dataFile = filePath;
//    }
//
//    public PlanificadorEvento leerDatos() {
//        PlanificadorEvento planificador = new PlanificadorEvento();
//
//        try (Scanner entrada = new Scanner(new File(dataFile))) {
//            // Leer y agregar personas
//            int numPersonas = entrada.nextInt();
//            entrada.nextLine(); // Consume newline
//            Persona[] personas = new Persona[numPersonas];
//            for (int i = 0; i < numPersonas; i++) {
//                String nombre = entrada.nextLine();
//                String apellido = entrada.nextLine();
//                String email = entrada.nextLine();
//                String clave = entrada.nextLine();
//                personas[i] = new Persona(nombre, apellido, email, clave);
//            }
//            planificador.setPersonas(personas);
//            planificador.setNumPersonas(numPersonas);
//
//            // Leer y agregar ubicaciones
//            int numUbicaciones = entrada.nextInt();
//            entrada.nextLine(); // Consume newline
//            Ubicacion[] ubicaciones = new Ubicacion[numUbicaciones];
//            for (int i = 0; i < numUbicaciones; i++) {
//                String nombre = entrada.nextLine();
//                String direccion = entrada.nextLine();
//                int capacidad = entrada.nextByte();
//                ubicaciones[i] = new Ubicacion(nombre, direccion, capacidad);
//            }
//            planificador.setUbicacionesEvento(ubicaciones);
//            planificador.setNumUbicaciones(numUbicaciones);
//
//            // Leer y agregar eventos
//            int numEventos = entrada.nextInt();
//            entrada.nextLine(); // Consume newline
//            Evento[] eventos = new Evento[numEventos];
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            
//            for (int i = 0; i < numEventos; i++) {
//                String nombreEvento = entrada.nextLine();
//                String descripcionEvento = entrada.nextLine();
//                Date fechaEvento = dateFormat.parse(entrada.nextLine());
//                
//                String gestorNombre = entrada.nextLine();
//                String gestorApellido = entrada.nextLine();
//                String gestorEmail = entrada.nextLine();
//                String gestorTelefono = entrada.nextLine();
//                Gestor gestorEvento = new Gestor(gestorNombre, gestorApellido, gestorEmail, gestorTelefono);
//                
//                String nombre = entrada.nextLine();
//                String direccion = entrada.nextLine();
//                int capacidad = entrada.nextByte();
//                Ubicacion ubicacionEvento = new Ubicacion(nombre, direccion, capacidad);
//                
//                int numAsistencias = entrada.nextInt();
//                entrada.nextLine(); // Consume newline
//                Asistencia[] asistencias = new Asistencia[numAsistencias];
//                
//                for (int j = 0; j < numAsistencias; j++) {
//                    String participanteNombre = entrada.nextLine();
//                    String participanteApellido = entrada.nextLine();
//                    String participanteEmail = entrada.nextLine();
//                    String participanteTelefono = entrada.nextLine();
//                    Participante participante = new Participante(participanteNombre, participanteApellido, participanteEmail, participanteTelefono);
//                    Date fechaReserva = dateFormat.parse(entrada.nextLine());
//                    int idAsistencia = entrada.nextInt();
//                    boolean estadoReserva = entrada.nextBoolean();
//                    boolean estadoAsistencia = entrada.nextBoolean();
//                    entrada.nextLine(); // Consume newline
//                    asistencias[j] = new Asistencia(participante, fechaReserva, idAsistencia, estadoReserva, estadoAsistencia);
//                }
//                eventos[i] = new Evento(nombreEvento, descripcionEvento, fechaEvento, gestorEvento, ubicacionEvento, asistencias, numAsistencias);
//            }
//            planificador.setEventos(eventos);
//            planificador.setNumEventos(numEventos);
//
//        } catch (FileNotFoundException | ParseException ex) {
//            System.err.println("Error al leer datos: " + ex.getMessage());
//        }
//
//        return planificador;
//    }
//
//}
