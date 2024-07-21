/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.uce.edu.calendarioeventos.dominio;

import ec.uce.edu.calendarioeventos.util.Validacion;
import java.util.Date;

/**
 *
 * @author Sebastian Llulluna
 */
import java.util.Date;

public class Asistencia {

    private final int idAsistencia;
    private final Participante participante;
    private Date fechaAsistencia;
    private Date fechaReserva;
    private int calificacion;
    private boolean estadoAsistencia;
    private boolean estadoReserva;
    public static int contador = 0;

    public Asistencia() {
        this(new Participante(), new Date("12/02/2024"), 0, false, false);
    }

    public Asistencia(Participante participante, Date fechaAsistencia, int calificacion, boolean estado, boolean estadoReserva) {
        contador++;
        this.idAsistencia = contador;
        this.participante = participante;
        this.fechaAsistencia = fechaAsistencia;
        this.calificacion = calificacion;
        this.estadoAsistencia = estado;
        this.estadoReserva = estadoReserva;
    }

    // Getters and Setters for fechaAsistencia, fechaReserva, calificacion, estadoAsistencia, estadoReserva
    public Date getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(Date fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isEstadoAsistencia() {
        return estadoAsistencia;
    }

    public void setEstadoAsistencia(boolean estadoAsistencia) {
        this.estadoAsistencia = estadoAsistencia;
    }

    public boolean isEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(boolean estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public Participante getParticipante() {
        return participante;
    }

    public boolean validarCalificacion(int calificacion) {
        return calificacion >= 0 && calificacion <= 10;
    }
     @Override
    public boolean equals(Object o) {
        Asistencia aux = new Asistencia();
        boolean resp=false;
        
        if(o != null && o instanceof Asistencia){
            aux=(Asistencia)aux;
            if(this.participante.equals(aux.participante) || this.fechaAsistencia.equals(aux.fechaAsistencia)){
                resp=true;
            }
        }
        return resp;
    }

    public boolean validarDuplicado(Object o) {
        if (o instanceof Asistencia otraAsistencia) {
            return this.equals(otraAsistencia);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Asistencia:"
                + "\nIdAsistencia=" + idAsistencia
                + "\nParticipantes=" + participante + "\nFechaAsistencia=" + fechaAsistencia
                + "\nFechaReserva=" + fechaReserva + "\nCalificacion=" + calificacion
                + "\nEstadoAsistencia=" + estadoAsistencia + "\nEstadoReserva=" + estadoReserva;
    }

}

