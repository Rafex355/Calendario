/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ec.uce.edu.calendarioeventos.dominio;

/**
 *
 * @author LENOVO.USER
 */
public enum TipoPersona {
    PARTICIPANTE("Participante","p"),
    GESTOR("Gestor","g");
    
    private final String nombre;
    private final String abreviacion;

    private TipoPersona(String nombre, String abreviacion) {
        this.nombre = nombre;
        this.abreviacion = abreviacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAbreviacion() {
        return abreviacion;
    }
}
