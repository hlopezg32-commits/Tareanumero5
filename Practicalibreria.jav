import java.io.*;

public class proy {

    public static class pelicula {
        String Titulopelicula, Detallepelicula, Generopelicula;
        String Nombre, Apellido;
    }

    public static class musica {
        String Titulomusica, Detallemusica, Generomusica;
        String Nombre, Apellido;
    }

    public static class pdf {
        String Titulopdf, Detallepdf, Generopdf;
        String Nombre, Apellido;
    }

    public static class foto {
        String Titulofoto, Detallefoto, Generofoto;
        String Nombre, Apellido;
    }

    public static class programa {
        String Tituloprograma, Detalleprograma, Generoprograma;
        String Nombre, Apellido;
    }

    public static void main(String[] args) throws IOException {

        pelicula[] pel = new pelicula[200];
        musica[] mus = new musica[200];
        pdf[] pd = new pdf[200];
        foto[] fot = new foto[200];
        programa[] pro = new programa[200];

        int narchivosaingresar = 0, opcion, tipo;

        do {
            System.out.println(" LIBRERIA DE ARCHIVOS");
            System.out.println("*****************************************************************************");
            System.out.println("Lista de actos a ejecutar :");
            System.out.println(" 1. Registrar Datos o Informacion\n 2. Borra Datos o Informacion\n 3. Corregir Datos o Informacion\n 4. Listado General de acuerdo al numero");
            System.out.println(" 5. Listado Ordenado por Titulo\n 6. Buscar por Titulo\n 7. Buscar por el Numero\n 8. Salir");

            opcion = leerint("Seleccione su Opcion");

            switch (opcion) {

                case 1:
                    do {
                        narchivosaingresar = leerint(" Numero Total de Archivos a Ingresar");
                    } while (narchivosaingresar < 0 || narchivosaingresar > 1000);

                    for (int i = 0; i < narchivosaingresar; i++) {

                        System.out.println("Contenido del Archivo a Ingresar Nº" + (i + 1));
                        System.out.println("1. Peliculas\n 2. Musica\n 3. Pdf\n 4. Fotografias\n 5. Programacion");

                        tipo = leerint("Seleccione el Contenido del Archivo");

                        switch (tipo) {
                            case 1:
                                pel[i] = leer(i + 1);
                                break;
                            case 2:
                                mus[i] = leer2(i + 1);
                                break;
                            case 3:
                                pd[i] = leer3(i + 1);
                                break;
                            case 4:
                                fot[i] = leer4(i + 1);
                                break;
                            case 5:
                                pro[i] = leer5(i + 1);
                                break;
                        }
                    }
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    System.out.println("Elija el listado que desee");
                    System.out.println(" 1. Peliculas\n 2. Musica\n 3. Pdf's\n 4. Fotografias\n 5. Programacion");

                    tipo = leerint("Seleccione la lista de su Preferencia");

                    switch (tipo) {
                        case 1:
                            listadopel(pel, narchivosaingresar);
                            break;
                        case 2:
                            listadomus(mus, narchivosaingresar);
                            break;
                        case 3:
                            listadopdf(pd, narchivosaingresar);
                            break;
                        case 4:
                            listadofot(fot, narchivosaingresar);
                            break;
                        case 5:
                            listadoprog(pro, narchivosaingresar);
                            break;
                    }
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;
            }

        } while (opcion != 8);

        System.out.println("Gracias por su preferencia");
    }

    public static int leerint(String k) throws IOException {
        BufferedReader w = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(k);
        int aux = Integer.parseInt(w.readLine());
        return aux;
    }

    public static pelicula leer(int t) throws IOException {
        pelicula aux1 = new pelicula();
        BufferedReader w = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el titulo de la pelicula ");
        aux1.Titulopelicula = w.readLine();

        System.out.println("Ingrese detalles de la misma ");
        aux1.Detallepelicula = w.readLine();

        System.out.println("Ingrese el genero de la misma ");
        aux1.Generopelicula = w.readLine();

        return aux1;
    }

    public static musica leer2(int t) throws IOException {
        musica aux2 = new musica();
        BufferedReader w = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el titulo de la cancion ");
        aux2.Titulomusica = w.readLine();

        System.out.println("Ingrese detalles de la cancion ");
        aux2.Detallemusica = w.readLine();

        System.out.println("Ingrese el genero de la cancion ");
        aux2.Generomusica = w.readLine();

        return aux2;
    }

    public static pdf leer3(int t) throws IOException {
        pdf aux3 = new pdf();
        BufferedReader w = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el titulo del archivo PDF ");
        aux3.Titulopdf = w.readLine();

        System.out.println("Ingrese detalles del archivo PDF ");
        aux3.Detallepdf = w.readLine();

        System.out.println("Ingrese el tipo de archivo PDF (Libro, Revista, Periodico, etc.) ");
        aux3.Generopdf = w.readLine();

        return aux3;
    }

    public static foto leer4(int t) throws IOException {
        foto aux4 = new foto();
        BufferedReader w = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el titulo de la foto ");
        aux4.Titulofoto = w.readLine();

        System.out.println("Ingrese detalles de la foto ");
        aux4.Detallefoto = w.readLine();

        System.out.println("Ingrese el estilo de la foto (Retrato, Paisaje, Varios) ");
        aux4.Generofoto = w.readLine();

        return aux4;
    }

    public static programa leer5(int t) throws IOException {
        programa aux5 = new programa();
        BufferedReader w = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el nombre del archivo/programa ");
        aux5.Tituloprograma = w.readLine();

        System.out.println("Ingrese detalles del archivo/programa ");
        aux5.Detalleprograma = w.readLine();

        System.out.println("Ingrese el tipo de archivo/programa(Tutorial, programa, instalador,etc.)");
        aux5.Generoprograma = w.readLine();

        return aux5;
    }

    public static void listadopel(pelicula z[], int ta) {
        for (int i = 0; i < ta; i++) {
            System.out.println("Numero " + (i + 1) + " => " + z[i].Titulopelicula + ", " + z[i].Detallepelicula + ", " + z[i].Generopelicula);
        }
    }

    public static void listadomus(musica z[], int ta) {
        for (int i = 0; i < ta; i++) {
            System.out.println("Numero " + (i + 1) + " => " + z[i].Titulomusica + ", " + z[i].Detallemusica + ", " + z[i].Generomusica);
        }
    }

    public static void listadopdf(pdf z[], int ta) {
        for (int i = 0; i < ta; i++) {
            System.out.println("Numero " + (i + 1) + " => " + z[i].Titulopdf + ", " + z[i].Detallepdf + ", " + z[i].Generopdf);
        }
    }

    public static void listadofot(foto z[], int ta) {
        for (int i = 0; i < ta; i++) {
            System.out.println("Numero " + (i + 1) + " => " + z[i].Titulofoto + ", " + z[i].Detallefoto + ", " + z[i].Generofoto);
        }
    }

    public static void listadoprog(programa z[], int ta) {
        for (int i = 0; i < ta; i++) {
            System.out.println("Numero " + i + " => " + z[i].Tituloprograma + ", " + z[i].Detalleprograma + ", " + z[i].Generoprograma);
        }
    }
}