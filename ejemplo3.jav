import java.io.*;

class LeeFichero {
    public static void main(String[] arg) {

        File archivo = null;
        FileReader reader = null;
        BufferedReader buffer = null;

        try {
            archivo = new File("C:\\directorioArchivo\\archivo.txt");
            reader = new FileReader(archivo);
            buffer = new BufferedReader(reader);

            String linea;
            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}