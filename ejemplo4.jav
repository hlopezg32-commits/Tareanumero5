import java.io.*;

public class EscribirFichero {

    public static void main(String[] args) {

        File fichero = null;
        FileWriter writer = null;
        PrintWriter pw = null;

        try {
            fichero = new File("C:\\directorioArchivo\\archivo.txt");
            writer = new FileWriter(fichero);
            pw = new PrintWriter(writer);

            for (int i = 0; i < 10; i++) {
                pw.println("Linea " + i);
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}