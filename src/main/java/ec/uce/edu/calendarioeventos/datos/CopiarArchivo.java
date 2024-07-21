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
//public class CopiarArchivo {
//    
//    public static void main(String[] args) {
//        FuenteDatos fuenteDatos = new FuenteDatos("data.txt");
//        PlanificadorEvento evento = fuenteDatos.leerDatos();
//        
//        if (evento != null) {
//            System.out.println(evento);
//        }
//        
//        // Guardar el evento en un archivo
//        guardarEvento(evento, "evento.dat");
//        
//        // Cargar el evento desde el archivo
//        PlanificadorEvento eventoCargado = cargarEvento("evento.dat");
//        
//        if (eventoCargado != null) {
//            System.out.println(eventoCargado);
//        }
//    }
//
//    public static void guardarEvento(PlanificadorEvento evento, String nombreArchivo) {
//        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
//            salida.writeObject(evento);
//        } catch (IOException ex) {
//            System.err.println("Error al guardar evento: " + ex.getMessage());
//        }
//    }
//
//    public static PlanificadorEvento cargarEvento(String nombreArchivo) {
//        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
//            return (PlanificadorEvento) entrada.readObject();
//        } catch (IOException | ClassNotFoundException ex) {
//            System.err.println("Error al cargar evento: " + ex.getMessage());
//        }
//        return null;
//    }
//    
//}
