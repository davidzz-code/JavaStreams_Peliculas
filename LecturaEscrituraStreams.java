import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class LecturaEscrituraStreams {

    public static String pedirRuta() throws RutaInvalida {
        Scanner scan = new Scanner(System.in);
        String ruta;

        ruta = scan.nextLine();
        if ("".equals(ruta)) {
            throw new RutaInvalida("Ruta inválida");
        }
        return ruta;
    }

    public static String formatoEscritura(String texto) {
        String formato = "Cartelera:\n\n";
        String[] listaObjetos = texto.split("\\{");

        for (int i = 0; i < listaObjetos.length; i++) {
            String objetos = listaObjetos[i];
            String[] listaAtributos = objetos.split("#");

            formato += "-----" + listaAtributos[0] + "-----\n";
            formato += "Año: " + listaAtributos[1] + "\n";
            formato += "Director: " + listaAtributos[2] + "\n";
            formato += "Duración: " + listaAtributos[3] + " minutos\n";
            formato += "Sinopsis: " + listaAtributos[4] + "\n";
            formato += "Reparto: " + listaAtributos[5] + "\n";
            formato += "Sesión: " + listaAtributos[6] + " horas\n\n";
        }
        return formato;
    }

    public static void leerEscribirCarCar() throws RutaInvalida {
        // Leer carácter a carácter
        try {
            System.out.print("Ruta del fichero para LEER el texto: ");
            String rutaLeer = pedirRuta();
            System.out.print("Ruta de un nuevo fichero para ESCRIBIR el texto: ");
            String rutaEscribir = pedirRuta();

            int caracter = 0;
            String texto = "";

            FileReader ficheroLectura = new FileReader(rutaLeer);
            FileWriter ficheroEscritura = new FileWriter(rutaEscribir);

            while (caracter != -1) {
                caracter = ficheroLectura.read();
                char letra = (char) caracter;
                texto += letra;
            }

            // Escribir carácter a carácter
            ficheroEscritura.write(formatoEscritura(texto));

            ficheroLectura.close();
            ficheroEscritura.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }

    public static void leerEscribirBuffer() throws RutaInvalida {
        // Leer bufer
        try {
            System.out.print("Ruta del fichero para LEER el texto: ");
            String rutaLeer = pedirRuta();
            System.out.print("Ruta de un nuevo fichero para ESCRIBIR el texto: ");
            String rutaEscribir = pedirRuta();

            BufferedReader bufferLeer = new BufferedReader(new FileReader(rutaLeer));
            BufferedWriter bufferEscribir = new BufferedWriter(new FileWriter(rutaEscribir));

            String linea = "";
            while (linea != null) {
                try {
                    linea = bufferLeer.readLine();

                    if (linea != null) {
                        // Escribir buffer
                        bufferEscribir.write(formatoEscritura(linea));
                        bufferEscribir.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            bufferLeer.close();
            bufferEscribir.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }

    public static void leerEscribirByteByte() throws RutaInvalida {
        // Leer byte a byte
        try {
            System.out.print("Ruta del fichero para LEER el texto: ");
            String rutaLeer = pedirRuta();
            System.out.print("Ruta de un nuevo fichero para ESCRIBIR el texto: ");
            String rutaEscribir = pedirRuta();

            String textoByte = "";

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
            }

            // Escribir Byte a byte
            String textoFinal = formatoEscritura(textoByte);
            ficheroEscritura.write(textoFinal.getBytes());

            ficheroLectura.close();
            ficheroEscritura.close();
        } catch (IOException e) {
            System.out.println("No se encuentra el archivo");
        }
    }

    public static void leerLineaEscribirObj() throws RutaInvalida {

        try {
            System.out.print("Ruta del fichero para LEER el texto: ");
            String rutaLeer = pedirRuta();
            System.out.print("Ruta de un nuevo fichero para ESCRIBIR el texto: ");
            String rutaEscribir = pedirRuta();

            BufferedReader lectorBuffer = new BufferedReader(new FileReader(rutaLeer));
            ObjectOutputStream objectSalida = new ObjectOutputStream(new FileOutputStream(rutaEscribir));

            boolean eof = false;
            String lineaLeida;
            String[] peliculas;
            String[] texto;
            int i = 0; //indice de campos
            Pelicula p = new Pelicula(); //inicializa una película
            while (!eof) {
                lineaLeida = lectorBuffer.readLine(); //lee una línea
                if (lineaLeida != null) {
                    peliculas = lineaLeida.split("\\{"); //divide la línea por '{' (películas)
                    for (int j = 0; j < peliculas.length; j++) {
                        texto = peliculas[j].split("#"); //divide la línea por '#' (campos)
                        for (int k = 0; k < texto.length; k++) {
                            switch (i) { // añade el texto en el campo que toque (atributos del objeto)
                                case 0:
                                    p.setTitle(p.getTitle() + texto[k] + " ");
                                    break;
                                case 1:
                                    p.setYear(p.getYear() + texto[k] + " ");
                                    break;
                                case 2:
                                    p.setDirector(p.getDirector() + texto[k] + " ");
                                    break;
                                case 3:
                                    p.setDuration(p.getDuration() + texto[k] + " ");
                                    break;
                                case 4:
                                    p.setSinopsis(p.getSinopsis() + texto[k] + " ");
                                    break;
                                case 5:
                                    p.setCast(p.getCast() + texto[k] + " ");
                                    break;
                                case 6:
                                    p.setSession(p.getSession() + texto[k] + " ");
                                    break;
                            }
                            //si hay más de un elemento en el array "texto" y no es el último elemento del array (pasar al siguiente campo)
                            if (k < texto.length - 1) {
                                i++;
                            }
                        }
                        //si hay más de un elemento en el array "peliculas" y no es el último elemento del array (pasamos a la siguiente película)
                        if (j < peliculas.length - 1) {
                            objectSalida.writeObject(p);
                            //p.mostrarPelicula();
                            p = new Pelicula();
                            i = 0;
                        }
                    }
                } else {
                    eof = true;
                }
            }
            objectSalida.writeObject(p);
            //p.mostrarPelicula();
        } catch (EOFException ex) {
            System.out.println("FIN DE FICHERO");
        } catch (IOException ex) {
            System.out.println("Error de lectura/escritura");
        }
    }

    public static void leerObjEscribirObj() throws RutaInvalida {
        try {
            System.out.print("Ruta del fichero para LEER el texto: ");
            String rutaLeer = pedirRuta();
            System.out.print("Ruta de un nuevo fichero para ESCRIBIR el texto: ");
            String rutaEscribir = pedirRuta();

            ObjectInputStream objectEntrada = new ObjectInputStream(new FileInputStream(rutaLeer));
            ObjectOutputStream objectSalida = new ObjectOutputStream(new FileOutputStream(rutaEscribir));

            boolean eof = false;
            while (!eof) {
                objectSalida.writeObject(new Pelicula((Pelicula) objectEntrada.readObject()));
            }
        } catch (EOFException e) {
            System.out.println("fin de fichero");
        } catch (IOException ex) {
            System.out.println("Error de lectura/escritura");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de clase");
        }
    }

    public static void leerObjEscribirCons() throws RutaInvalida {
        try {
            System.out.print("Ruta del fichero para LEER el texto: ");
            String rutaLeer = pedirRuta();
            System.out.print("Ruta de un nuevo fichero para ESCRIBIR el texto: ");
            String rutaEscribir = pedirRuta();

            ObjectInputStream objectEntrada = new ObjectInputStream(new FileInputStream(rutaLeer));

            boolean eof = false;
            Pelicula p = new Pelicula();
            while (!eof) {
                p = (Pelicula) objectEntrada.readObject();
                p.mostrarPelicula();
            }
        } catch (EOFException e) {
            System.out.println("fin de fichero");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de clase");
        } catch (IOException ex) {
            System.out.println("Error de lectura");
        }
    }

    public static void leerConsEscribirObj() throws RutaInvalida {
        try {
            System.out.print("Ruta del fichero para LEER el texto: ");
            String rutaLeer = pedirRuta();

            ObjectOutputStream objectSalida = new ObjectOutputStream(new FileOutputStream(rutaLeer));

            Pelicula p = new Pelicula(); //crea una nueva película  
            p.pedirPelicula(); //llenamos sus atributos pidiendolos por pantalla
            objectSalida.writeObject(p); //lo guardamos en un fichero
        } catch (IOException ex) {
            System.out.println("Error de escritura");
        }
    }
}