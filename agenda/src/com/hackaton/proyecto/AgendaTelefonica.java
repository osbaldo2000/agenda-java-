

package com.hackaton.proyecto;
import java.util.ArrayList;
import java.util.Scanner;

public class AgendaTelefonica extends Contacto {
    public AgendaTelefonica(String nombre, String apellido, String telefono) {
        super(nombre, apellido, telefono);
    }

    public class Agenda {
        private static ArrayList<Contacto> contactos = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int opcion;
            do {
                System.out.println("\nAgenda de Contactos");
                System.out.println("1. Agregar Contacto");
                System.out.println("2. Ver Contactos");
                System.out.println("3. Eliminar Contacto");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        agregarContacto();
                        break;
                    case 2:
                        verContactos();
                        break;
                    case 3:
                        eliminarContacto();
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } while (opcion != 4);
        }

        private static void agregarContacto() {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Correo: ");
            String correo = scanner.nextLine();
            contactos.add(new Contacto(nombre, telefono, correo));
            System.out.println("Contacto agregado correctamente.");
        }

        private static void verContactos() {
            if (contactos.isEmpty()) {
                System.out.println("No hay contactos guardados.");
            } else {
                for (int i = 0; i < contactos.size(); i++) {
                    System.out.println((i + 1) + ". " + contactos.get(i));
                }
            }
        }

        private static void eliminarContacto() {
            verContactos();
            if (!contactos.isEmpty()) {
                System.out.print("Ingrese el número del contacto a eliminar: ");
                int indice = scanner.nextInt();
                scanner.nextLine();
                if (indice > 0 && indice <= contactos.size()) {
                    contactos.remove(indice - 1);
                    System.out.println("Contacto eliminado correctamente.");
                } else {
                    System.out.println("Número inválido.");
                }
            }
        }
    }
}
