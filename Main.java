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
                + "3) Buffers\n"
                + "4) Tratamiento de objetos\n"
                + "5) Salir");

        boolean salir = false;

        while (!salir) {
            System.out.print("Opción: ");
            int opcion = scan.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        LecturaEscrituraStreams.leerEscribirCarCar();
                        break;
                    case 2:
                        LecturaEscrituraStreams.leerEscribirByteByte();
                        break;
                    case 3:
                        LecturaEscrituraStreams.leerEscribirBuffer();
                        break;
                    case 4:
                        tratamientoDeObjetos();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (RutaInvalida ex) {
                System.out.println("Mensaje:" + ex.getMessage());
                ex.impError();
            }
        }
    }
    
    public static void tratamientoDeObjetos() throws RutaInvalida {

        boolean salir = false;
        while (!salir) {
            switch (pedirOpcionObjetos()) {
                case 1:
                    LecturaEscrituraStreams.leerLineaEscribirObj();
                    break;
                case 2:
                    LecturaEscrituraStreams.leerObjEscribirObj();
                    break;
                case 3:
                    LecturaEscrituraStreams.leerObjEscribirCons();
                    break;
                case 4:
                    LecturaEscrituraStreams.leerConsEscribirObj();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static int pedirOpcionObjetos() {
        Scanner leer = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("1) Lectura línea a línea y escritura con objetos.");
        System.out.println("2) Lectura de objetos y escritura de objetos.");
        System.out.println("3) Lectura de objetos y escritura por consola.");
        System.out.println("4) Lectura por consola y escritura de objetos. (añadirá objetos al final del fichero existente)");
        System.out.println("5) Volver al menú principal.");
        System.out.println("---------------------------");
        System.out.println("Introduce una opción: ");
        return leer.nextInt();
    }
}