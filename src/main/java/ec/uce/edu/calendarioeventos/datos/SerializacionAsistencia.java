/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.uce.edu.calendarioeventos.datos;

/**
 *
 * @author Administrador
 */
import ec.uce.edu.calendarioeventos.dominio.Asistencia;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializacionAsistencia {

    public static void serializarAsistencias(Asistencia[] asistencias) {
        try {
            FileOutputStream fos = new FileOutputStream("Asistencias.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(asistencias);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Error al guardar los datos: " + ex.getMessage());
        }
    }

    public static Asistencia[] deserializarAsistencias() {
        Asistencia[] asistencias = null;
        File documento = new File("Asistencias.txt");

        if (documento.exists() && !documento.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(documento);
                ObjectInputStream ois = new ObjectInputStream(fis);
                asistencias = (Asistencia[]) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los datos: " + e.getMessage());
            }
        } else {
            // Manejar el caso cuando el archivo no existe
            System.out.println("El documento serializado no existe. Creando un nuevo array vacío.");
            asistencias = new Asistencia[0];
        }

        return asistencias;
    }

    public static void eliminarArchivoAsistencia(String archivoAsistencias) {
        try {
            Files.deleteIfExists(Paths.get(archivoAsistencias));
            System.out.println("Archivo de Asistencias eliminado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al eliminar el archivo de asistencias: " + e.getMessage());
        }
    }
}
