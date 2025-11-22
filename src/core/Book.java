/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
/**public abstract class Book {
    
    protected String title;
    protected ArrayList<Author> authors;
    protected final String isbn;
    protected String genre;
    protected String format;
    protected double value;
    protected Publisher publisher;

    public Book(String title, ArrayList<Author> authors, String isbn, String genre, String format, double value, Publisher publisher) {
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.genre = genre;
        this.format = format;
        this.value = value;
        this.publisher = publisher;
        
        for (Author autor : this.authors) {
            autor.addBook(this);
        }
        this.publisher.addBook(this);
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public String getFormat() {
        return format;
    }

    public double getValue() {
        return value;
    }

    public Publisher getPublisher() {
        return publisher;
    }
    
}
*/


public abstract class Book {

    protected String title;
    protected ArrayList<Author> authors;
    protected final String isbn;
    protected String genre;
    protected String format;
    protected double value;
    protected Publisher publisher;

    public Book(String title, ArrayList<Author> authors, String isbn,
            String genre, String format, double value, Publisher publisher) {

        if (title == null || title.isBlank())
            throw new IllegalArgumentException("Título vacío.");

        if (authors == null || authors.isEmpty())
            throw new IllegalArgumentException("Debe haber autores.");

        if (isbn == null || !isbn.matches("\\d{3}-\\d-\\d{2}-\\d{6}-\\d"))
            throw new IllegalArgumentException("ISBN inválido.");

        if (genre == null || genre.isBlank())
            throw new IllegalArgumentException("Género vacío.");

        if (format == null || format.isBlank())
            throw new IllegalArgumentException("Formato vacío.");

        if (value <= 0)
            throw new IllegalArgumentException("Valor inválido.");

        if (publisher == null)
            throw new IllegalArgumentException("Editorial null.");

        // evitar autores repetidos
        ArrayList<Author> clean = new ArrayList<>();
        for (Author a : authors) {
            if (!clean.contains(a))
                clean.add(a);
        }

        this.title = title;
        this.authors = clean;
        this.isbn = isbn;
        this.genre = genre;
        this.format = format;
        this.value = value;
        this.publisher = publisher;

        for (Author autor : this.authors)
            autor.addBook(this);

        this.publisher.addBook(this);
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public String getFormat() {
        return format;
    }

    public double getValue() {
        return value;
    }

    public Publisher getPublisher() {
        return publisher;
    }
}
