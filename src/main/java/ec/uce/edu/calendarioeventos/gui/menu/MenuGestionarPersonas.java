package ec.uce.edu.calendarioeventos.gui.menu;

/**
 *
 * @author LENOVO.USER
 */
import java.util.Scanner;

public class MenuGestionarPersonas {

    public static void mostrarMenuPersona() {
        System.out.println("*********************************");
        System.out.println("*  SUBMENU DE PERSONAS          *");
        System.out.println("*  1. Gestion de Persona        *");
        System.out.println("*  2. Gestion de Gestores       *");
        System.out.println("*  3. Atras                     *");
        System.out.println("*********************************");
    }

    public static void elegir() {
        Scanner scanner = new Scanner(System.in);
        int opcionEvento = 0;

        do {
            mostrarMenuPersona();
            System.out.print("Ingrese una opción para continuar: ");

            opcionEvento = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del nextInt()

            switch (opcionEvento) {
                case 1:
                    MenuGestionarParticipante.elegir();
                    break;
                case 2:
                    MenuGestionarGestor.elegir();
                    break;
                case 3:
                    System.out.println("************************");
                    System.out.println("*   SALIENDO DEL MENÚ  *");
                    System.out.println("************************");
                    break;
                default:
                    System.out.println("******************************************");
                    System.out.println("* Opción incorrecta. Intente nuevamente. *");
                    System.out.println("******************************************");
                    break;
            }
        } while (opcionEvento != 3);

    }
}
