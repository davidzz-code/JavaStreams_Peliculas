import java.io.FileReader;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Scanner;

public class LecturaEscrituraStreams {

    public static String pedirRuta() {
        Scanner scan = new Scanner(System.in);
        String ruta;
        
        System.out.print("Escribe la ruta donde tienes guardado el fichero: ");
        ruta = scan.nextLine();
        scan.close();
        return ruta;
    }


    public static void leerEscribirCarCar() {
        // String ruta = pedirRuta();
        Peliculas pelicula = new Peliculas();

        
        try {
            FileReader fichero = new FileReader("./ficheroCartelera.txt");
            int caracter = 0;
            String texto = "";
            // char letra = ' ';

            while (caracter != -1) {
                caracter = fichero.read();
                char letra = (char) caracter;

                texto += letra;
            }
            
            String[] listaObjetos = texto.split("\\{"); // Aquí el código rompe. Revisar si está dividiendo el string correctamnte
            for (int i = 0; i < listaObjetos.length; i++) {
                String objetos = listaObjetos[i];
                String[] listaAtributos = objetos.split("#");

                pelicula.setTitle(listaAtributos[0]);
                pelicula.setYear(Integer.parseInt(listaAtributos[1]));
                System.out.println("Titulo: " + pelicula.getTitle());
                System.out.println("Año: " + pelicula.getYear());
            }


            fichero.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }
}





            // while (caracter != -1 && letra != '#') {
            //     caracter = fichero.read();
            //     letra = (char) caracter;
                
            //     texto += letra;
            // }
            
            // for (int i = 0; i < 7; i++) {
            //     switch (i) {
            //         case 0:
            //             pelicula.setTitle(texto);
            //         case 1:
            //             pelicula.setYear(texto);
            //     }
                
            // }