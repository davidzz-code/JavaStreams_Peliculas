import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LecturaEscrituraStreams {

    public static String pedirRuta() {
        Scanner scan = new Scanner(System.in);
        String ruta;

        ruta = scan.nextLine();
        return ruta;
    }

    public static String formatoEscritura(String[] listaAtributos) {
        String formato = "-----" + listaAtributos[0] + "-----\n";
        formato += "Año: " + listaAtributos[1] + "\n";
        formato += "Director: " + listaAtributos[2] + "\n";
        formato += "Duración: " + listaAtributos[3] + " minutos\n";
        formato += "Sinopsis: " + listaAtributos[4] + "\n";
        formato += "Reparto: " + listaAtributos[5] + "\n";
        formato += "Sesión: " + listaAtributos[6] + " horas\n\n";

        return formato;
    }
    
    public static void leerEscribirCarCar() {
        // LEER CARACTER A CARACTER
        System.out.print("Ruta del fichero para LEER el texto: ");
        String rutaLeer = pedirRuta();
        System.out.print("Ruta de un nuevo fichero para ESCRIBIR el texto: ");
        String rutaEscribir = pedirRuta();

        try {
            int caracter = 0;
            String texto = "";

            FileReader ficheroLectura = new FileReader(rutaLeer);
            FileWriter ficheroEscritura = new FileWriter(rutaEscribir);

            while (caracter != -1) {
                caracter = ficheroLectura.read();
                char letra = (char) caracter;
                texto += letra;
            }

            String[] listaObjetos = texto.split("\\{");

            for (int i = 0; i < listaObjetos.length; i++) {
                String objetos = listaObjetos[i];
                String[] listaAtributos = objetos.split("#");
                // ESCRIBIR CARACTER A CARACTER
                ficheroEscritura.write(formatoEscritura(listaAtributos));
            }
            ficheroLectura.close();
            ficheroEscritura.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }

    public static void leerEscribirBuffer() {
        // LEER BUFFER
        System.out.print("Ruta del fichero para LEER el texto: ");
        String rutaLeer = pedirRuta();
        System.out.print("Ruta de un nuevo fichero para ESCRIBIR el texto: ");
        String rutaEscribir = pedirRuta();
        try {
            FileReader ficheroLectura = new FileReader(rutaLeer);
            BufferedReader bufferLeer = new BufferedReader(ficheroLectura);

            FileWriter ficheroEscritura = new FileWriter(rutaEscribir);
            BufferedWriter bufferEscribir = new BufferedWriter(ficheroEscritura);

            String linea = "";
            while (linea != null) {
                try {
                    linea = bufferLeer.readLine();

                    if (linea != null) {

                        String[] listaObjetos = linea.split("\\{");

                        for (int i = 0; i < listaObjetos.length; i++) {
                            String objetos = listaObjetos[i];
                            String[] listaAtributos = objetos.split("#");
                            // ESCRIBIR CARACTER A CARACTER
                            bufferEscribir.write(formatoEscritura(listaAtributos));
                            bufferEscribir.flush();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ficheroLectura.close();
            ficheroEscritura.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }

    public static void leerEscribirByteByte() {
        // LEER BYTE A BYTE
        int[] datos_entrada = new int[735];

        System.out.print("Ruta del fichero para LEER el texto: ");
        String rutaLeer = pedirRuta();
        System.out.print("Ruta de un nuevo fichero para ESCRIBIR el texto: ");
        String rutaEscribir = pedirRuta();
        
        int contador = 0;
        String textoByte = "";

        try {
            FileInputStream ficheroLectura = new FileInputStream(rutaLeer);
            FileOutputStream ficheroEscritura = new FileOutputStream(rutaEscribir);

            boolean final_ar = false;
            
            while (!final_ar) {
                int byte_entrada = ficheroLectura.read();

                if (byte_entrada == -1) {
                    final_ar = true;
                }

                char caracterByte = (char) byte_entrada;
                textoByte += caracterByte;
                contador++;
            }
            
            String[] listaObjetos = textoByte.split("\\{");

            for (int i = 0; i < listaObjetos.length; i++) {
                String objetos = listaObjetos[i];
                String[] listaAtributos = objetos.split("#");
                ficheroEscritura.write(formatoEscritura(listaAtributos).getBytes());
            }
            ficheroLectura.close();
            ficheroEscritura.close();
        } catch (IOException e) {
            System.out.println("No se encuentra el archivo");
        }
    }

    public static void leerEscribirObjCarCar() {
        // LEER CARACTER A CARACTER
        ArrayList<Peliculas> listaPeliculas = new ArrayList<>();

        System.out.print("Ruta del fichero para LEER el texto: ");
        String ruta = pedirRuta();

        try {
            int caracter = 0;
            String texto = "";

            FileReader ficheroLectura = new FileReader(ruta);

            while (caracter != -1) {
                caracter = ficheroLectura.read();
                char letra = (char) caracter;
                texto += letra;
            }

            String[] listaObjetos = texto.split("\\{");

            for (int i = 0; i < listaObjetos.length; i++) {
                Peliculas pelicula = new Peliculas();
                String objetos = listaObjetos[i];
                String[] listaAtributos = objetos.split("#");

                pelicula.setTitle(listaAtributos[0]);
                pelicula.setYear(Integer.parseInt(listaAtributos[1]));
                pelicula.setDirector(listaAtributos[2]);
                pelicula.setDuration(Integer.parseInt(listaAtributos[3]));
                pelicula.setSinopsis(listaAtributos[4]);
                pelicula.setCast(listaAtributos[5]);
                pelicula.setSession(listaAtributos[6]);

                listaPeliculas.add(pelicula);
            }
            ficheroLectura.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }

        // ESCRIBIR CARACTER A CARACTER
        System.out.print("Ruta de un nuevo fichero para ESCRIBIR el texto: ");
        ruta = pedirRuta();

        try {
            FileWriter ficheroEscritura = new FileWriter(ruta);
            for (Peliculas peli : listaPeliculas) {
                ficheroEscritura.write(peli.toString());
            }

            System.out.println("Lectura y escritura por CARACTERES realizada correctamente!");
            ficheroEscritura.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerEscribirObjBuffer() {
        // LEER BUFFER
        ArrayList<Peliculas> listaPeliculas = new ArrayList<>();

        System.out.print("Ruta del fichero para LEER el texto: ");
        String ruta = pedirRuta();
        try {
            FileReader ficheroLectura = new FileReader(ruta);
            BufferedReader bufferPeliculas = new BufferedReader(ficheroLectura);

            String linea = "";
            while (linea != null) {
                try {
                    linea = bufferPeliculas.readLine();

                    if (linea != null) {

                        String[] listaObjetos = linea.split("\\{");

                        for (int i = 0; i < listaObjetos.length; i++) {
                            Peliculas pelicula = new Peliculas();
                            String objetos = listaObjetos[i];
                            String[] listaAtributos = objetos.split("#");

                            pelicula.setTitle(listaAtributos[0]);
                            pelicula.setYear(Integer.parseInt(listaAtributos[1]));
                            pelicula.setDirector(listaAtributos[2]);
                            pelicula.setDuration(Integer.parseInt(listaAtributos[3]));
                            pelicula.setSinopsis(listaAtributos[4]);
                            pelicula.setCast(listaAtributos[5]);
                            pelicula.setSession(listaAtributos[6]);

                            listaPeliculas.add(pelicula);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ficheroLectura.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }

        // ESCRIBIR Buffer
        System.out.print("Ruta de un nuevo fichero para ESCRIBIR el texto: ");
        ruta = pedirRuta();

        try {
            FileWriter ficheroEscritura = new FileWriter(ruta);
            BufferedWriter bufferPeliculas = new BufferedWriter(ficheroEscritura);

            for (Peliculas peli : listaPeliculas) {
                bufferPeliculas.write(peli.toString());
            }
            bufferPeliculas.flush();
            System.out.println("Lectura y escritura por BUFFERS realizada correctamente!");

            ficheroEscritura.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerEscribirObjByteByte() {
        // LEER BYTE A BYTE
        ArrayList<Peliculas> listaPeliculas = new ArrayList<>();

        int[] datos_entrada = new int[735];

        System.out.print("Ruta del fichero para LEER el texto: ");
        String ruta = pedirRuta();
        int contador = 0;
        String textoByte = "";

        try {
            FileInputStream ficheroLectura = new FileInputStream(ruta);

            boolean final_ar = false;

            while (!final_ar) {
                int byte_entrada = ficheroLectura.read();

                if (byte_entrada == -1) {
                    final_ar = true;
                }

                char caracterByte = (char) byte_entrada;
                textoByte += caracterByte;
                contador++;
            }

            String[] listaObjetos = textoByte.split("\\{");

            for (int i = 0; i < listaObjetos.length; i++) {
                Peliculas pelicula = new Peliculas();
                String objetos = listaObjetos[i];
                String[] listaAtributos = objetos.split("#");

                pelicula.setTitle(listaAtributos[0]);
                pelicula.setYear(Integer.parseInt(listaAtributos[1]));
                pelicula.setDirector(listaAtributos[2]);
                pelicula.setDuration(Integer.parseInt(listaAtributos[3]));
                pelicula.setSinopsis(listaAtributos[4]);
                pelicula.setCast(listaAtributos[5]);
                pelicula.setSession(listaAtributos[6]);

                listaPeliculas.add(pelicula);
            }

            ficheroLectura.close();
        } catch (IOException e) {
            System.out.println("No se encuentra el archivo");
        }

        // ESCRIBIR Byte a Byte
        System.out.print("Ruta de un nuevo fichero para ESCRIBIR el texto: ");
        ruta = pedirRuta();

        try {
            FileOutputStream ficheroEscritura = new FileOutputStream(ruta);

            for (int i = 0; i < datos_entrada.length; i++) {
                ficheroEscritura.write(datos_entrada[i]);
            }
        } catch (IOException e) {

        }
    }

}