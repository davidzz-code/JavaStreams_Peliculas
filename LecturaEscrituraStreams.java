import java.io.FileReader;
import java.io.IOException;
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
        String ruta = pedirRuta();
        ArrayList<String> listaAux;
        
        try {
            FileReader fichero = new FileReader(ruta);
            
            int caracter = 0;

            while (caracter != -1) {
                caracter = fichero.read();
                char letra = (char) caracter;
                System.out.print  (letra);
            }
            fichero.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }
}
