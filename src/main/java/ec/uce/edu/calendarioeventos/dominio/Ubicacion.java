/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.uce.edu.calendarioeventos.dominio;


import java.util.Objects;


/**
 *
 * @author Sergio Guanopatin, Bryan Perez
 */

public class Ubicacion {
    private final int idUbicacion;
    private final String nombreUbicacion;
    private final String direccionUbicacion;
    private final int capacidadUbicacion;
    public static int contador = 0;

    public Ubicacion() {
        this.idUbicacion = 0;
        this.nombreUbicacion = "";
        this.direccionUbicacion = "";
        this.capacidadUbicacion = 10;

    }

    public Ubicacion(String nombreUbicacion, String direccionUbicacion, int capacidadUbicacion) {
        contador++;
        this.idUbicacion = contador;
        this.nombreUbicacion = nombreUbicacion;
        this.direccionUbicacion = direccionUbicacion;
        this.capacidadUbicacion = capacidadUbicacion;

    }

    public final int getIdUbicacion() {
        return idUbicacion;
    }

    public final String getNombreUbicacion() {
        return nombreUbicacion;
    }

    public final void setNombreUbicacion(String nombreUbicacion) {
        if (nombreUbicacion != null) {
            System.out.println("Nombre de ubicación no puede ser nulo.");
        }
    }

    public final String getDireccionUbicacion() {
        return direccionUbicacion;
    }

    public final void setDireccionUbicacion(String direccionUbicacion) {
        if (direccionUbicacion != null) {
            System.out.println("Dirección de ubicación no puede ser nula.");
        }
    }

    public final int getCapacidadUbicacion() {
        return capacidadUbicacion;
    }

    public final void setCapacidadUbicacion(int capacidadUbicacion) {
        if (capacidadUbicacion >= 0) {
            System.out.println("Capacidad de ubicación debe ser positiva.");
        }
    }


    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ubicacion)) return false;
        Ubicacion ubicacion = (Ubicacion) o;
        return Objects.equals(nombreUbicacion, ubicacion.nombreUbicacion) &&
               Objects.equals(direccionUbicacion, ubicacion.direccionUbicacion);
    }

    public final boolean validarDuplicado(Object o) {
        return this.equals(o);
    }

    @Override
    public final String toString() {
        return "Ubicacion" +
                "\nIdUbicacion=" + idUbicacion +
                "\nNombreUbicacion='" + nombreUbicacion +
                "\nDireccionUbicacion='" + direccionUbicacion +
                "\nCapacidadUbicacion=" + capacidadUbicacion;
    }
}
