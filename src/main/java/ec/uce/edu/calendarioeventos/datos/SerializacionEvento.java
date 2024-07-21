/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.uce.edu.calendarioeventos.datos;

/**
 *
 * @author Administrador
 */
import ec.uce.edu.calendarioeventos.dominio.Evento;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;

public class SerializacionEvento {

    public static void serializarEventos(Evento[] eventos) {
        try {
            FileOutputStream fos = new FileOutputStream("Eventos.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(eventos);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Error al guardar los datos: " + ex.getMessage());
        }
    }

    public static Evento[] deserializarEventos() {
        Evento[] eventos = null;
        File documento = new File("Eventos.txt");

        if (documento.exists() && !documento.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(documento);
                ObjectInputStream ois = new ObjectInputStream(fis);
                eventos = (Evento[]) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los datos: " + e.getMessage());
            }
        } else {
            // Manejar el caso cuando el archivo no existe
            System.out.println("El documento serializado no existe. Creando un nuevo array vacío.");
            eventos = new Evento[0];
        }

        return eventos;
    }

    public static void eliminarArchivoEvento(String archivoEventos) {
        try {
            Files.deleteIfExists(Paths.get(archivoEventos));
            System.out.println("Archivo de Eventos eliminado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al eliminar el archivo de eventos: " + e.getMessage());
        }
    }
}
