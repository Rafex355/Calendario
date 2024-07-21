package ec.uce.edu.calendarioeventos.dominio;

import java.util.Arrays;
import java.util.Date;

public class Evento {
    private Date fechaReserva;
    private final int idEvento;
    private String nombreEvento;
    private String descripcionEvento;
    private Date fechaEvento;
    private Gestor gestorEvento;
    private Ubicacion ubicacionesEvento;
    private Asistencia [] asistencias;
    private int numAsistencias;
    public static int contador = 0;
    
    public Evento() {
        this("", "", new Date(2024, 1, 5), new Gestor(), new Ubicacion(), new Asistencia[3], 0);
    }

    public Evento(String nombreEvento, String descripcionEvento, Date fechaEvento, Gestor gestorEvento, Ubicacion ubicacionesEvento, Asistencia[] asistencias, int numAsistencias) {
        contador++;
        this.idEvento = contador;
        this.nombreEvento = nombreEvento;
        this.descripcionEvento = descripcionEvento;
        this.fechaEvento = fechaEvento;
        this.gestorEvento = gestorEvento;
        this.ubicacionesEvento = ubicacionesEvento;
        this.asistencias = asistencias;
        this.numAsistencias = numAsistencias;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        if (nombreEvento != null) {
            this.nombreEvento = nombreEvento;
        } else {
            System.out.println("Nombre de evento no puede ser nulo.");
        }
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        if (descripcionEvento != null) {
            this.descripcionEvento = descripcionEvento;
        } else {
            System.out.println("Descripción de evento no puede ser nula.");
        }
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        if (fechaEvento != null) {
            this.fechaEvento = fechaEvento;
        } else {
            System.out.println("Fecha de evento no puede ser nula.");
        }
    }

    public Gestor getGestorEvento() {
        return gestorEvento;
    }

    public void setGestoresEvento(Gestor gestorEvento) {
        if (gestorEvento != null) {
            this.gestorEvento = gestorEvento;
        } else {
            System.out.println("Arreglo de gestores de evento no puede ser nulo.");
        }
    }

    public Ubicacion getUbicacionesEvento() {
        return ubicacionesEvento;
    }

    public Asistencia[] getAsistencias() {
        return asistencias;
    }

    public int getNumAsistencias() {
        return numAsistencias;
    }

    public void setUbicacionesEvento(Ubicacion ubicacionesEvento) {
        this.ubicacionesEvento = ubicacionesEvento;
    }

    public void setAsistencias(Asistencia[] asistencias) {
        this.asistencias = asistencias;
    }

    public void setNumAsistencias(int numAsistencias) {
        this.numAsistencias = numAsistencias;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public void setGestorEvento(Gestor gestorEvento) {
        this.gestorEvento = gestorEvento;
    }
    
    //Metodos CRUD de Asistencia
   public void agregarAsistencia(Asistencia asistencia) {
        if (!validarDuplicado(asistencia)) {
            if (numAsistencias == asistencias.length) {
                asistencias = Arrays.copyOf(asistencias, numAsistencias + 1);
            }
            asistencias[numAsistencias++] = asistencia;
            System.out.println("Asistencia agregada correctamente.");
        } else {
            System.out.println("Asistencia duplicada, no se puede agregar.");
        }
    }


    public String consultarAsistencias() {
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < numAsistencias; i++) {
            texto.append("Asistencia [").append(i + 1).append("] ").append(asistencias[i]).append("\n");
        }
        return texto.toString();
    }
    
    public String consultarReservas() {
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < numAsistencias; i++) {
            if (asistencias[i].isEstadoReserva()) {
                texto.append("Reserva [").append(i + 1).append("] ").append(asistencias[i]).append("\n");
            }
        }
        return texto.length() > 0 ? texto.toString() : "No hay reservas.";
    }
    
    public void modificarAsistencia(int indice, Asistencia asistencia) {
        if (indice >= 0 && indice < numAsistencias) {
            if (!validarDuplicado(asistencia)) {
                asistencias[indice] = asistencia;
                System.out.println("Asistencia editada correctamente.");
            } else {
                System.out.println("Asistencia duplicada, no se puede editar.");
            }
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    public void eliminarAsistencia(int indice) {
        if (indice >= 0 && indice < numAsistencias) {
            Asistencia[] aux = new Asistencia[numAsistencias - 1];
            if (indice > 0) {
                System.arraycopy(asistencias, 0, aux, 0, indice);
            }
            if (indice < numAsistencias - 1) {
                System.arraycopy(asistencias, indice + 1, aux, indice, numAsistencias - indice - 1);
            }
            asistencias = aux;
            numAsistencias--;
        }
    }
   
    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        Evento aux = new Evento();
        boolean resp=false;
        
        if(o != null && o instanceof Evento){
            aux=(Evento)aux;
            if(this.nombreEvento.equals(aux.nombreEvento) || this.descripcionEvento.equals(aux.descripcionEvento)
               || this.fechaEvento.equals(aux.fechaEvento) || this.ubicacionesEvento.equals(aux.ubicacionesEvento)){
                resp=true;
            }
        }
        return resp;
    }
   public boolean validarDuplicado(Object o) {
        if (o instanceof Asistencia) {
            Asistencia asistencia = (Asistencia) o;
            for (int i = 0; i < numAsistencias; i++) {
                if (asistencias[i].equals(asistencia)) {
                    return true;
                }
            }
        }
        return false;
    }
   
    public void inicializarA(){
        Participante participante = new Participante();
        Asistencia asistencia1 = new Asistencia(participante, new Date("09/07/2024"), numAsistencias, true, true);
        Asistencia asistencia2 = new Asistencia(participante, new Date("12/06/2024"), numAsistencias, false, true);
        Asistencia asistencia3 = new Asistencia(participante, new Date("02/07/2024"), numAsistencias, true, false);
        agregarAsistencia(asistencia1);
        agregarAsistencia(asistencia2);
        agregarAsistencia(asistencia3);
    }
    
    @Override
    public String toString() {
        return "Evento:" + "\nIdEvento=" + idEvento + "\nNombreEvento=" + nombreEvento +
               "\nDescripcionEvento=" + descripcionEvento + "\nFechaEvento=" + fechaEvento + 
               "\nGestorEvento=" + gestorEvento + "\nUbicacionesEvento=" + ubicacionesEvento +
               "\nAsistencias=" + asistencias + "\nNumAsistencias=" + numAsistencias;
    }

}
