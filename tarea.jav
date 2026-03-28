import java.io.*;
import java.util.Scanner;

public class MenuArchivos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Ver informacion de un archivo");
            System.out.println("2. Mostrar restaurantes con CP que empiece con 6");
            System.out.println("3. Agregar restaurante al CSV");
            System.out.println("4. Crear copia sin CP que empiece con 6");
            System.out.println("5. Borrar archivo");
            System.out.println("6. Salir");
            System.out.print("Seleccione opcion: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese ruta del archivo: ");
                    String ruta = sc.nextLine();

                    File archivo = new File(ruta);

                    if (archivo.exists()) {
                        System.out.println("Existe");

                        if (archivo.isDirectory()) {
                            System.out.println("Es carpeta");
                        } else {
                            System.out.println("Es archivo");
                            System.out.println("Nombre: " + archivo.getName());
                            System.out.println("Tamaño: " + archivo.length());
                            System.out.println("Lectura: " + archivo.canRead());
                            System.out.println("Escritura: " + archivo.canWrite());
                        }
                    } else {
                        System.out.println("No existe");
                    }
                    break;

                case 2:
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("restaurantes.csv"));
                        String linea;

                        while ((linea = br.readLine()) != null) {
                            String[] datos = linea.split(",");
                            String cp = datos[2];

                            if (cp.startsWith("6")) {
                                System.out.println(linea);
                            }
                        }

                        br.close();

                    } catch (Exception e) {
                        System.out.println("Error al leer archivo");
                    }
                    break;

                case 3:
                    try {
                        FileWriter fw = new FileWriter("restaurantes.csv", true);
                        PrintWriter pw = new PrintWriter(fw);

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Ciudad: ");
                        String ciudad = sc.nextLine();

                        System.out.print("Codigo Postal: ");
                        String cp = sc.nextLine();

                        pw.println(nombre + "," + ciudad + "," + cp);

                        pw.close();
                        System.out.println("Dato agregado");

                    } catch (Exception e) {
                        System.out.println("Error al escribir");
                    }
                    break;

                case 4:
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("restaurantes.csv"));
                        PrintWriter pw = new PrintWriter(new FileWriter("Restaurants2.csv"));

                        String linea;

                        while ((linea = br.readLine()) != null) {
                            String[] datos = linea.split(",");
                            String cp = datos[2];

                            if (!cp.startsWith("6")) {
                                pw.println(linea);
                            }
                        }

                        br.close();
                        pw.close();

                        System.out.println("Archivo creado");

                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese ruta del archivo a borrar: ");
                    String rutaBorrar = sc.nextLine();

                    File borrar = new File(rutaBorrar);

                    if (borrar.exists()) {
                        borrar.delete();
                        System.out.println("Archivo eliminado");
                    } else {
                        System.out.println("No existe");
                    }
                    break;

            }

        } while (opcion != 6);

        System.out.println("Fin del programa");
    }
}