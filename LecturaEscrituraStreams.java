import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.UIDefaults.ProxyLazyValue;

public class LecturaEscrituraStreams {

    public static String pedirRuta() {
        Scanner scan = new Scanner(System.in);
        String ruta;

        ruta = scan.nextLine();
        return ruta;
    }


    public static void leerEscribirCarCar() {
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
            ficheroEscritura.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}