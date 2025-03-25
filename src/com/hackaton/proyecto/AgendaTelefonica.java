

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
                System.out.println("\nAgenda de Contactos");//jaquelin
                System.out.println("1. Agregar Contacto");//aldair
                System.out.println("2. Ver Contactos");  //jaquilin
                System.out.println("3. Eliminar Contacto");//Esteban
                System.out.println("4. Modificar Telefono");// Esteban implemento
                System.out.println("5. Buscar Contacto");//Uri nueva implementacion
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

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
                    case 5:
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
                scanner.nextLine();
                opcion = 0; //osbaldo entrada no valida letra
            }
        } while (opcion != 6);
    }

    private static void agregarContacto() {
        if(contactos.size() >= lIMITE_CONTACTOS){  //osbaldo
            System.out.println("La Agenda esta llena");
            return;
        }
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        while(nombre.isEmpty()){
            System.out.print("Nombre no debe estar vacio: ");
            nombre = scanner.nextLine(); //aldair bucle entrada no existe
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


    private static void buscarContacto() {
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