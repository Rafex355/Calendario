/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.uce.edu.calendarioeventos.dominio;

import ec.uce.edu.calendarioeventos.util.Validacion;

/**
 *
 * @author Rafaela Toledo
 */
public final class Participante extends Persona {

    private final int idUsuario;
    private static final int MAX_PARTICIPANTES = 100; // Ejemplo de atributo estático final
    private static int contador = 0;

    public Participante() {
        super();
        this.idUsuario = 0;
    }

    public Participante(String nombre, String apellido, String correoElectronico, String clave) {
        super(nombre, apellido, correoElectronico, clave);
        contador++;
        this.idUsuario = contador;
    }

    // Constructor sobrecargado para copiar los datos de otra instancia
    public Participante(Participante otroParticipante) {
        super(otroParticipante.getNombre(),
                otroParticipante.getApellido(),
                otroParticipante.getCorreoElectronico(),
                otroParticipante.getClave());
        this.idUsuario = otroParticipante.getIdUsuario();
    }

    public final int getIdUsuario() { // Método final
        return idUsuario;
    }

    // No se puede definir este método como final porque modifica un atributo final
    public void setIdUsuario(int idUsuario) {
        if (Validacion.validarNumeros(idUsuario)) {
            // No se puede asignar a atributo final 'idUsuario'
            System.out.println("El ID de usuario ingresado es incorrecto.");
        }
    }

    @Override
    public final boolean equals(Object o) { // Método final
        boolean resp = false;

        if (o != null && o instanceof Participante) {
            Participante aux = (Participante) o;
            if (super.equals(aux) && this.idUsuario == aux.idUsuario) {
                resp = true;
            }
        }
        return resp;
    }

    @Override
    public final String toString() { // Método final
        return "Participante"
                + "\nIdUsuario='" + idUsuario + super.toString();
    }

}
