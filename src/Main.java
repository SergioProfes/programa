import java.io.*;
import java.util.Scanner;

/**
 * @author Desconocido
 * @version 1.0
 * @since 29/01/2024
 */
public class Main {
    /**
     * Menú del programa
     * @param args argumentos de linea de comandos
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        Agenda agenda = new Agenda();
        agenda.cargar(args[0]);
        int opciones = -1;

        do {
            System.out.println("AGENDA POLITÉCNICO. Opciones: ");
            System.out.println("1. Agregar un contacto.");
            System.out.println("2. Buscar un contacto.");
            System.out.println("3. Número de contactos.");
            System.out.println("4. Mostrar toda la agenda.");
            System.out.println("5. Borrar un contacto.");
            System.out.println("6. Modificar un contacto.");
            System.out.println("7. Exportar a un String[].");
            System.out.println("8. Guardar cambios.");
            System.out.println("9. Restaurar versión inicial.");
            System.out.println("0. Salir");

            opciones = teclado.nextInt();
            teclado.nextLine(); //limpiar retorno de carro del .nextInt() anterior

            switch (opciones) {
                case 1:
                    System.out.println("Nombre del contacto: ");
                    String nombre_c1 = teclado.nextLine();
                    System.out.println("Número de teléfono: ");
                    String numero_c1 = teclado.nextLine();
                    agenda.insertar(nombre_c1, numero_c1);
                    break;
                case 2:
                    System.out.println("Nombre del contacto a buscar: ");
                    String nombre_c2 = teclado.nextLine();
                    System.out.println(agenda.buscar(nombre_c2));
                    break;
                case 3:
                    System.out.println(agenda.longitud() + " contactos.");
                    break;
                case 4:
                    System.out.println(agenda.ver());
                    break;
                case 5:
                    System.out.println("Introduce el nombre del contacto a borrar: ");
                    String nombre_c5 = teclado.nextLine();
                    agenda.borrar(nombre_c5);
                    break;
                case 6:
                    System.out.println("Introduce el nombre del contacto a modificar: ");
                    String nombre_c6 = teclado.nextLine();
                    System.out.println("Introduce su nuevo número: ");
                    String numero_c6 = teclado.nextLine();
                    agenda.modificar(nombre_c6, numero_c6);
                    agenda.modificar(nombre_c6, numero_c6);
                    break;
                case 7:
                    for (int i = 0; i < agenda.exportar().length; i++) {
                        System.out.println("[" + agenda.exportar()[i][0] + ", " + agenda.exportar()[i][1] + "]");
                    }
                    break;
                case 8:
                    agenda.grabar(args[0]);
                    break;
                case 9:
                    agenda.cargar(args[0]);
                    break;
            }

        } while (opciones != 0);
        System.exit(0);
    }
}
