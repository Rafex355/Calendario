/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.uce.edu.calendarioeventos.util;

import java.util.Scanner;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Bryan Perez, Sergio Guanopatin, Rafaela Toledo y Sebastian Llulluna
 */
public class Validacion {

    public static boolean validarClave(String clave) {
        boolean validacion = false;

        // La expresión regular para validar la clave
        Pattern patC = Pattern.compile("^(?=.*[A-Z])[a-zA-Z0-9]{9}$");
        Matcher matC = patC.matcher(clave);

        // Verificar si la clave cumple con el patrón
        if (matC.find()) {
            validacion = true;
        }

        return validacion;
    }

    public static boolean validarCorreoElectronico(String correoElectronico) {
        boolean validacion = false;

        Pattern patE = Pattern.compile("^[a-zA-Z0-9]{1,100}\\@(uce.edu||gmail||hotmail)\\.[a-zA-Z]{2,3}$");
        Matcher matE = patE.matcher(correoElectronico);

        if (matE.find()) {
            validacion = true;
        }

        return validacion;
    }

    public static boolean validarNumeros(int numeros) {
        boolean validacion = false;

        Pattern patN = Pattern.compile("^\\d+$");
        Matcher matN = patN.matcher(Integer.toString(numeros));

        if (matN.find()) {
            validacion = true;
        }

        return validacion;
    }

    public static boolean validarCalificacion(int calificacion) {
        boolean validacion = false;

        // Verifica si el número es solo dígitos
        Pattern patN = Pattern.compile("^\\d+$");
        Matcher matN = patN.matcher(Integer.toString(calificacion));

        if (matN.find()) {
            // Verifica si el número está en el rango de 0 a 10
            if (calificacion >= 0 && calificacion <= 10) {
                validacion = true;
            }
        }

        return validacion;
    }

    public static boolean validarIDGestor(String id) {
        boolean validacion = false;

        Pattern patD = Pattern.compile("^[a-zA-Z0-9]{1,15}$");
        Matcher matD = patD.matcher(id);

        if (matD.find()) {
            validacion = true;
        }

        return validacion;
    }

    public static boolean validarNombre(String nombre) {
        boolean validacion = false;

        Pattern patD = Pattern.compile("^[a-zA-Z0-9]{1,15}$");
        Matcher matD = patD.matcher(nombre);

        if (matD.find()) {
            validacion = true;
        }

        return validacion;
    }

    public static boolean validarApellido(String apellido) {
        boolean validacion = false;

        Pattern patD = Pattern.compile("^[a-zA-Z0-9]{1,15}$");
        Matcher matD = patD.matcher(apellido);

        if (matD.find()) {
            validacion = true;
        }

        return validacion;
    }

    public static boolean validarFechaInicio(Date fechaInicio) {
        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Verificar si la fecha registrada es anterior a la fecha actual
        if (fechaInicio.before(fechaActual)) {
            return true; // Fecha válida
        } else {
            System.out.println("La fecha debe ser anterior a la fecha actual.");
            return false; // Fecha no válida
        }
    }

    public static boolean validarFechaFin(Date fechaFin) {
        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Verificar si la fecha registrada es anterior a la fecha actual
        if (fechaFin.before(fechaActual)) {
            return true; // Fecha válida
        } else {
            System.out.println("La fecha debe ser anterior a la fecha actual.");
            return false; // Fecha no válida
        }
    }

    public static boolean validarFechas(Date fechaRegistrada) {
        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Verificar si la fecha registrada es anterior a la fecha actual
        if (fechaRegistrada.before(fechaActual)) {
            return true; // Fecha válida
        } else {
            System.out.println("La fecha debe ser anterior a la fecha actual.");
            return false; // Fecha no válida
        }
    }

}
