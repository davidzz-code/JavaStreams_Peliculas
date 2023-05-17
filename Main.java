import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println();
        System.out.println("Java Streams");
        System.out.println();
        System.out.println("Elige una opción:\n"
                + "1) Carácter a Carácter\n"
                + "2) Byte a byte\n"
                + "3) Buffers");
        
        System.out.print("Opción: ");
        int opcion = scan.nextInt();

        switch (opcion) {
            case 1:
                LecturaEscrituraStreams.leerEscribirCarCar();
                break;
            case 2:
                System.out.println("En proceso");
                break;
            case 3:
                LecturaEscrituraStreams.leerEscribirBuffer();
                break;
        }


    }
}