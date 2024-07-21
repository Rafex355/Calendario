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

public final class Gestor extends Persona {

    private final int idGestor;
    private static final int MAX_GESTORES = 100; // Ejemplo de atributo estático final
    private static int contador = 0;

    public Gestor() {
        super();
        this.idGestor = 0;
    }

    public Gestor(String nombre, String apellido, String correoElectronico, String clave) {
        super(nombre, apellido, correoElectronico, clave);
        contador++;
        this.idGestor = contador;
    }
   

    public final int getIdGestor() { // Método final
        return idGestor;
    }

    // No se puede definir este método como final porque modifica un atributo final
    public void setIdGestor(int idGestor) {
        if (Validacion.validarNumeros(idGestor)) {
            // No se puede asignar a atributo final 'idGestor'
            System.out.println("El Id ingresado es incorrecto");
        }
    }

    @Override
    public final boolean equals(Object o) { // Método final
        boolean resp = false;
        
        if (o != null && o instanceof Gestor) {
            Gestor aux = (Gestor) o;
            if (super.equals(aux) && this.idGestor == aux.idGestor) {
                resp = true;
            }
        }
        return resp;
    }

   @Override
    public String toString() {
        return "Gestor" +
                "idGestor=" + idGestor +super.toString();
    }

}
