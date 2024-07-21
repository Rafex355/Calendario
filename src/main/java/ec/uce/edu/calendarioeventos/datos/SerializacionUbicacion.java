/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.uce.edu.calendarioeventos.datos;

/**
 *
 * @author Administrador
 */
import ec.uce.edu.calendarioeventos.dominio.Ubicacion;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializacionUbicacion {

    public static void serializarUbicaciones(Ubicacion[] ubicaciones) {
        try {
            FileOutputStream fos = new FileOutputStream("Ubicaciones.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ubicaciones);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Error al guardar los datos: " + ex.getMessage());
        }
    }

    public static Ubicacion[] deserializarUbicaciones() {
        Ubicacion[] ubicaciones = null;
        File documento = new File("Ubicaciones.txt");

        if (documento.exists() && !documento.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(documento);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ubicaciones = (Ubicacion[]) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los datos: " + e.getMessage());
            }
        } else {
            // Manejar el caso cuando el archivo no existe
            System.out.println("El documento serializado no existe. Creando un nuevo array vacío.");
            ubicaciones = new Ubicacion[0];
        }

        return ubicaciones;
    }

    public static void eliminarArchivoUbicacion(String archivoUbicaciones) {
        try {
            Files.deleteIfExists(Paths.get(archivoUbicaciones));
            System.out.println("Archivo de Ubicaciones eliminado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al eliminar el archivo de ubicaciones: " + e.getMessage());
        }
    }
}
