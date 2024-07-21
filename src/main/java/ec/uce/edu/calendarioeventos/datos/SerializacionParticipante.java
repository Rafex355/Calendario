/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.uce.edu.calendarioeventos.datos;

/**
 *
 * @author Administrador
 */
import ec.uce.edu.calendarioeventos.dominio.Participante;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializacionParticipante {

    public static void serializarParticipantes(Participante[] participantes) {
        try {
            FileOutputStream fos = new FileOutputStream("Participantes.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(participantes);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Error al guardar los datos: " + ex.getMessage());
        }
    }

    public static Participante[] deserializarParticipantes() {
        Participante[] participantes = null;
        File documento = new File("Participantes.txt");

        if (documento.exists() && !documento.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(documento);
                ObjectInputStream ois = new ObjectInputStream(fis);
                participantes = (Participante[]) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los datos: " + e.getMessage());
            }
        } else {
            // Manejar el caso cuando el archivo no existe
            System.out.println("El documento serializado no existe. Creando un nuevo array vacío.");
            participantes = new Participante[0];
        }

        return participantes;
    }

    public static void eliminarArchivoParticipante(String archivoParticipantes) {
        try {
            Files.deleteIfExists(Paths.get(archivoParticipantes));
            System.out.println("Archivo de Participantes eliminado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al eliminar el archivo de participantes: " + e.getMessage());
        }
    }
}
