/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.uce.edu.calendarioeventos.datos;

/**
 *
 * @author Administrador
 */
import ec.uce.edu.calendarioeventos.dominio.Gestor;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializacionGestor {

    public static void serializarGestores(Gestor[] gestores) {
        try {
            FileOutputStream fos = new FileOutputStream("Gestores.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gestores);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Error al guardar los datos: " + ex.getMessage());
        }
    }

    public static Gestor[] deserializarGestores() {
        Gestor[] gestores = null;
        File documento = new File("Gestores.txt");

        if (documento.exists() && !documento.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(documento);
                ObjectInputStream ois = new ObjectInputStream(fis);
                gestores = (Gestor[]) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los datos: " + e.getMessage());
            }
        } else {
            // Manejar el caso cuando el archivo no existe
            System.out.println("El documento serializado no existe. Creando un nuevo array vacío.");
            gestores = new Gestor[0];
        }

        return gestores;
    }

    public static void eliminarArchivoGestor(String archivoGestores) {
        try {
            Files.deleteIfExists(Paths.get(archivoGestores));
            System.out.println("Archivo de Gestores eliminado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al eliminar el archivo de gestores: " + e.getMessage());
        }
    }
}
