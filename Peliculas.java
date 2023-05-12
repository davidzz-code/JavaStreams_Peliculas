import java.sql.Time;

public class Peliculas {
    private String title;
    private int year;
    private String director;
    private int duration;
    private String sinopsis;
    private String cast;
    private Time session;


    // Constructors
    public Peliculas(String title, int year, String director, int duration, String sinopsis, String cast,
            Time session) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.duration = duration;
        this.sinopsis = sinopsis;
        this.cast = cast;
        this.session = session;
    }

    public Peliculas() {
    }

    // Getters & Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
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
    public Time getSession() {
        return session;
    }
    public void setSession(Time session) {
        this.session = session;
    }

    
}