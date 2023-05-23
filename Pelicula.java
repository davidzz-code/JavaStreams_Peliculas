import java.util.Scanner;

public class Pelicula {
    private String title;
    private String year;
    private String director;
    private String duration;
    private String sinopsis;
    private String cast;
    private String session;


    // Constructors
    public Pelicula(String title, String year, String director, String duration, String sinopsis, String cast,
            String session) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.duration = duration;
        this.sinopsis = sinopsis;
        this.cast = cast;
        this.session = session;
    }

    public Pelicula(Pelicula pelicula) {
    }

    public Pelicula() {
    }
    
    // Getters & Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getCast() {
        return cast;
    }
    public void setCast(String cast) {
        this.cast = cast;
    }
    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
    
    @Override
    public String toString() {
        return "\n-----" + title + "-----\n"
                + "Año: " + year + "\n"
                + "Director: " + director + "\n"
                + "Duración: " + duration + " minutos\n"
                + "Sinopsis: " + sinopsis + "\n"
                + "Reparto: " + cast + "\n"
                + "Sesión: " + session + " horas\n";
    }
    
    public void mostrarPelicula() {
        System.out.println("Título: " + this.getTitle());
        System.out.println("Año: " + this.getYear());
        System.out.println("Duración: " + this.getDuration());
        System.out.println("Sinopsis: " + this.getSinopsis());
        System.out.println("Reparto: " + this.getCast());
        System.out.println("Sesión: " + this.getSession());
    }

    public void pedirPelicula() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce el título: ");
        this.setTitle(leer.nextLine());
        System.out.println("Introduce el año: ");
        this.setYear(leer.nextLine());
        System.out.println("Introduce la duración: ");
        this.setDuration(leer.nextLine());
        System.out.println("Introduce la sinopsis: ");
        this.setSinopsis(leer.nextLine());
        System.out.println("Introduce el reparto: ");
        this.setCast(leer.nextLine());
        System.out.println("Introduce la sesion: ");
        this.setSession(leer.nextLine());
    }


    
}
