/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.uce.edu.calendarioeventos.datos;

import ec.uce.edu.calendarioeventos.dominio.PlanificadorEvento;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author LENOVO.USER
 */
public class ArchivoCalendario {

    public static void serializarCalendario(PlanificadorEvento planificador) {

        FileOutputStream salida = null;
        try {
            salida = new FileOutputStream("Calendario.txt");
            ObjectOutputStream oss = new ObjectOutputStream(salida);
            oss.writeObject(planificador);

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("System error " + ex.getMessage());

        } catch (IOException ex) {
            System.out.println("System error  " + ex.getMessage());
        } finally {
            try {
                salida.close();
            } catch (IOException ex) {
                System.out.println("System error  " + ex.getMessage());
            }

        }

    }

    public static void deserializarCalendario() {
        FileInputStream entrada = null;
        try {
            entrada = new FileInputStream("Calendario.txt");
            ObjectInputStream ois = new ObjectInputStream(entrada);
            PlanificadorEvento planificador = (PlanificadorEvento) ois.readObject();
            ois.close();
            System.out.println("Cliente deserializada: " + planificador);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("System error: " + ex.getMessage());
        } finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException ex) {
                System.out.println("System error: " + ex.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
    //serializarCalendario(); CREAR VARIABLE Y LLAMAR CON ESE PARAMETRO
        deserializarCalendario();
    }

}
