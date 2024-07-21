/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.uce.edu.calendarioeventos.datos;

/**
 *
 * @author Administrador
 */
import ec.uce.edu.calendarioeventos.dominio.Persona;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializacionPersona {

    public static void serializarPersonas(Persona[] personas) {
        try {
            FileOutputStream fos = new FileOutputStream("Personas.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(personas);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Error al guardar los datos: " + ex.getMessage());
        }
    }

    public static Persona[] deserializarPersonas() {
        Persona[] personas = null;
        File documento = new File("Personas.txt");

        if (documento.exists() && !documento.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(documento);
                ObjectInputStream ois = new ObjectInputStream(fis);
                personas = (Persona[]) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los datos: " + e.getMessage());
            }
        } else {
            // Manejar el caso cuando el archivo no existe
            System.out.println("El documento serializado no existe. Creando un nuevo array vacío.");
            personas = new Persona[0];
        }

        return personas;
    }

    public static void eliminarArchivoPersona(String archivoPersonas) {
        try {
            Files.deleteIfExists(Paths.get(archivoPersonas));
            System.out.println("Archivo de Personas eliminado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al eliminar el archivo de personas: " + e.getMessage());
        }
    }
}
