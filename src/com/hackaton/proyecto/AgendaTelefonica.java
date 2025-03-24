

package com.hackaton.proyecto;
import java.util.ArrayList;
import java.util.Scanner;

    public class AgendaTelefonica {
        private static ArrayList<Contacto> contactos = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);

        public void iniciarAgenda() {
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
            while(nombre.isEmpty()){
                System.out.print("Nombre no debe estar vacio: ");
                nombre = scanner.nextLine();
            }
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            while(apellido.isEmpty()){
                System.out.print("Apellido no debe estar vacio: ");
                apellido = scanner.nextLine();
            }
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            while(telefono.isEmpty()){
                System.out.print("Telefono no debe estar vacio: ");
                telefono = scanner.nextLine();
            }

            if(existeContacto(nombre, apellido, telefono)){
                System.out.println("Este contacto ya existe");
            }else {
                contactos.add(new Contacto(nombre, apellido, telefono));
                System.out.println("Contacto agregado correctamente.");
            }
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

        private static boolean existeContacto(String nombre, String apellido, String telefono){
            for (int i = 0; i < contactos.size(); i++) {
                boolean nom = contactos.get(i).getNombre().contains(nombre);
                boolean app = contactos.get(i).getApellido().contains(apellido);
                if (nom && app){
                    return true;
                }
            }
            return false;
        }
    }

