package ec.uce.edu.calendarioeventos.dominio;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Sebastian Llulluna
 */
public abstract class PlanificadorEvento implements Serializable {
    private static Persona[] personas;
    private static int numPersonas;
    private static Ubicacion[] ubicacionesEvento;
    private static int numUbicaciones;
    private static Evento[] eventos;
    private static int numEventos;

    static {
        personas = new Persona[2];
        numPersonas = 0;
        ubicacionesEvento = new Ubicacion[3];
        numUbicaciones = 0;
        eventos = new Evento[3];
        numEventos = 0;
    }

    public PlanificadorEvento(Persona[] personas, int numPersonas, Ubicacion[] ubicacionesEvento, int numUbicaciones, Evento[] eventos, int numEventos) {
        this.personas = personas;
        this.numPersonas = numPersonas;
        this.ubicacionesEvento = ubicacionesEvento;
        this.numUbicaciones = numUbicaciones;
        this.eventos = eventos;
        this.numEventos = numEventos;
    }

    public Persona[] getPersonas() {
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public Ubicacion[] getUbicacionesEvento() {
        return ubicacionesEvento;
    }

    public void setUbicacionesEvento(Ubicacion[] ubicacionesEvento) {
        this.ubicacionesEvento = ubicacionesEvento;
    }

    public int getNumUbicaciones() {
        return numUbicaciones;
    }

    public void setNumUbicaciones(int numUbicaciones) {
        this.numUbicaciones = numUbicaciones;
    }

    public Evento[] getEventos() {
        return eventos;
    }

    public void setEventos(Evento[] eventos) {
        this.eventos = eventos;
    }

    public int getNumEventos() {
        return numEventos;
    }

    public void setNumEventos(int numEventos) {
        this.numEventos = numEventos;
    }

    // Métodos CRUD de Evento
    public static String consultarEvento() {
        StringBuilder texto = new StringBuilder();
        for (Evento evento : eventos) {
            if (evento != null) {
                texto.append(evento.toString()).append("\n");
            }
        }
        return texto.toString();
    }

    public static void agregarEvento(Evento evento) {
        if (numEventos == eventos.length) {
            Evento[] nuevoArray = new Evento[numEventos + 1];
            System.arraycopy(eventos, 0, nuevoArray, 0, numEventos);
            eventos = nuevoArray;
        }
        eventos[numEventos++] = evento;
    }

    public static void modificarEvento(int indice, Evento evento) {
        if (indice < 0 || indice >= numEventos) {
            System.out.println("Índice inválido");
        } else {
            eventos[indice] = evento;
        }
    }

    public static void eliminarEvento(int indice) {
        if (indice < 0 || indice >= numEventos) {
            System.out.println("El índice que ha elegido no existe");
        } else {
            Evento[] nuevoArray = new Evento[numEventos - 1];
            System.arraycopy(eventos, 0, nuevoArray, 0, indice);
            System.arraycopy(eventos, indice + 1, nuevoArray, indice, numEventos - indice - 1);
            eventos = nuevoArray;
            numEventos--;
        }
    }

    // Métodos CRUD de Persona
    public static String consultarPersona() {
        StringBuilder texto = new StringBuilder();
        for (Persona persona : personas) {
            if (persona != null) {
                texto.append(persona.toString()).append("\n");
            }
        }
        return texto.length() > 0 ? texto.toString() : "No hay personas registradas.\n";
    }

    public static void agregarPersona(TipoPersona tipo, Persona persona) {
        if (numPersonas == personas.length) {
            Persona[] nuevoArray = new Persona[numPersonas + 1];
            System.arraycopy(personas, 0, nuevoArray, 0, numPersonas);
            personas = nuevoArray;
        }
        personas[numPersonas++] = persona;
    }

    public static void modificarPersona(int indice, Persona persona) {
        if (indice < 0 || indice >= numPersonas) {
            System.out.println("Índice inválido");
        } else {
            personas[indice] = persona;
        }
    }

    public static void eliminarPersona(int indice) {
        if (indice < 0 || indice >= numPersonas) {
            System.out.println("El índice que ha elegido no existe");
        } else {
            Persona[] nuevoArray = new Persona[numPersonas - 1];
            System.arraycopy(personas, 0, nuevoArray, 0, indice);
            System.arraycopy(personas, indice + 1, nuevoArray, indice, numPersonas - indice - 1);
            personas = nuevoArray;
            numPersonas--;
        }
    }

    // Métodos CRUD de Ubicacion
    public static void agregarUbicacion(Ubicacion ubicacion) {
        if (numUbicaciones >= ubicacionesEvento.length) {
            Ubicacion[] nuevoArray = new Ubicacion[numUbicaciones * 2];
            System.arraycopy(ubicacionesEvento, 0, nuevoArray, 0, numUbicaciones);
            ubicacionesEvento = nuevoArray;
        }
        ubicacionesEvento[numUbicaciones++] = ubicacion;
    }

    public static void modificarUbicacion(int indice, Ubicacion ubicacion) {
        if (indice < 0 || indice >= numUbicaciones) {
            System.out.println("Índice inválido");
        } else {
            ubicacionesEvento[indice] = ubicacion;
        }
    }

    public static void eliminarUbicacion(int indice) {
        if (indice < 0 || indice >= numUbicaciones) {
            System.out.println("El índice que ha elegido no existe");
        } else {
            Ubicacion[] nuevoArray = new Ubicacion[numUbicaciones - 1];
            System.arraycopy(ubicacionesEvento, 0, nuevoArray, 0, indice);
            System.arraycopy(ubicacionesEvento, indice + 1, nuevoArray, indice, numUbicaciones - indice - 1);
            ubicacionesEvento = nuevoArray;
            numUbicaciones--;
        }
    }

    public static Ubicacion consultarUbicacion(String nombreUbicacion) {
        for (int i = 0; i < numUbicaciones; i++) {
            if (ubicacionesEvento[i].getNombreUbicacion().equals(nombreUbicacion)) {
                return ubicacionesEvento[i];
            }
        }
        return null;
    }
    
    public static String consultarUbicaciones() {
        StringBuilder texto = new StringBuilder();
        for (Ubicacion ubicacion : ubicacionesEvento) {
            if (ubicacion != null) {
                texto.append(ubicacion.toString()).append("\n");
            }
        }
        return texto.length() > 0 ? texto.toString() : "No hay personas registradas.\n";
    }

    public static boolean validarDuplicado(Object o) {
        if (o instanceof Persona) {
            for (Persona persona : personas) {
                if (persona != null && persona.equals(o)) {
                    return true;
                }
            }
        } else if (o instanceof Ubicacion) {
            for (Ubicacion ubicacion : ubicacionesEvento) {
                if (ubicacion != null && ubicacion.equals(o)) {
                    return true;
                }
            }
        } else if (o instanceof Evento) {
            for (Evento evento : eventos) {
                if (evento != null && evento.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void inicializar() {
        agregarPersona(TipoPersona.GESTOR, new Gestor("Norman", "Paterson", "norpat@gmail.com", "Normalia123"));
        agregarPersona(TipoPersona.GESTOR, new Gestor("Albert", "Paterson", "albpat@gmail.com", "Normalia321"));
        agregarPersona(TipoPersona.GESTOR, new Gestor("Link", "Paterson", "linpat@gmail.com", "Normalia423"));
        agregarPersona(TipoPersona.PARTICIPANTE, new Participante("Mario", "Bros", "mabros@gmail.com", "Luigui098"));
        agregarPersona(TipoPersona.PARTICIPANTE, new Participante("Luis", "Felipe", "lufe@gmail.com", "Sexto678"));
        agregarPersona(TipoPersona.PARTICIPANTE, new Participante("Pedro", "Pedral", "pepe@gmail.com", "Pepas416"));
        agregarEvento(new Evento("Fiesta", "baile", new Date("01/07/2024"), new Gestor(), new Ubicacion(), new Asistencia[3], numPersonas));
        agregarEvento(new Evento("Reunion", "retos y mas", new Date("01/07/2024"), new Gestor(), new Ubicacion(), new Asistencia[3], numPersonas));
        agregarEvento(new Evento("Exposiones", "Casas Abiertas", new Date("01/07/2024"), new Gestor(), new Ubicacion(), new Asistencia[3], numPersonas));
        agregarUbicacion(new Ubicacion("Universidad", "EdificioA", 100));
        agregarUbicacion(new Ubicacion("Universidad", "EdificioB", 150));
        agregarUbicacion(new Ubicacion("Universidad", "EdificioC", 140));
    }

    @Override
    public String toString() {
        return "PlanificadorEvento "
                + "\nNúmero de personas: " + numPersonas
                + "\nPersonas: " + Arrays.toString(personas)
                + "\nNúmero de ubicaciones: " + numUbicaciones
                + "\nUbicaciones: " + Arrays.toString(ubicacionesEvento)
                + "\nNúmero de eventos: " + numEventos
                + "\nEventos: " + Arrays.toString(eventos);
    }
}
