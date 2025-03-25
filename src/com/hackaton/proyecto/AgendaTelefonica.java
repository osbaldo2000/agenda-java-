

package com.hackaton.proyecto;
import java.util.ArrayList;
import java.util.Scanner;

    public class AgendaTelefonica {
        private static final int lIMITE_CONTACTOS = 10;
        private static ArrayList<Contacto> contactos = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);


        public void iniciarAgenda() {
            int opcion;
            do {
                try {
                    System.out.println("\nAgenda de Contactos");
                    System.out.println("1. Agregar Contacto");
                    System.out.println("2. Ver Contactos");
                    System.out.println("3. Eliminar Contacto");
                    System.out.println("4. Modificar Telefono");
                    System.out.println("5. Buscar Contacto");//Uri nueva implementacion
                    System.out.println("6. Salir");
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
                            modificarTelefono();
                            break;
                        case 5://Llama al metodo de busqueda
                            buscarContacto();
                            break;
                        case 6:
                            System.out.println("Saliendo...");
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Entrada no válida. Intente nuevamente.");
                    scanner.nextLine(); // Limpiar el buffer para evitar bucles infinitos
                    opcion = 0; // Evita salir inesperadamente del bucle
                }
            } while (opcion != 6);
        }

        private static void agregarContacto() {
            if(contactos.size() >= lIMITE_CONTACTOS){
                System.out.println("La Agenda esta llena");
                return;
            }
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
            contactos.add(new Contacto(nombre, apellido, telefono));
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

        private static void modificarTelefono() {
            verContactos();
            if (!contactos.isEmpty()) {
                System.out.print("Ingrese el número del contacto a modificar: ");
                int indice = scanner.nextInt();
                scanner.nextLine();
                if (indice > 0 && indice <= contactos.size()) {
                    System.out.print("Ingrese el nuevo teléfono: ");
                    String nuevoTelefono = scanner.nextLine();
                    while (nuevoTelefono.isEmpty()) {
                        System.out.print("Teléfono no debe estar vacío: ");
                        nuevoTelefono = scanner.nextLine();
                    }
                    contactos.get(indice - 1).setTelefono(nuevoTelefono);
                    System.out.println("Teléfono actualizado correctamente.");
                } else {
                    System.out.println("Número inválido.");
                }
            }
        }
    }

    private static void buscaContacto() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos guardados.");
            return;
        }

        System.out.print("Ingrese el nombre del contacto: ");
        String nombreBuscar = scanner.nextLine();

        System.out.print("Ingrese el apellido del contacto: ");
        String apellidoBuscar = scanner.nextLine();

        boolean contactoEncontrado = false;

        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombreBuscar) &&
                    contacto.getApellido().equalsIgnoreCase(apellidoBuscar)) {
                System.out.println("Contacto encontrado:");
                System.out.println("Teléfono: " + contacto.getTelefono());
                contactoEncontrado = true;
                break;
            }
        }

        if (!contactoEncontrado) {
            System.out.println("Contacto no encontrado.");
        }
    }
}
