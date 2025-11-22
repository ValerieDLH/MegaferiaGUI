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



public class Author extends Person {

    private final ArrayList<Book> books;

    public Author(long id, String firstname, String lastname) {
        super(id, firstname, lastname);
        this.books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public int getBookQuantity() {
        return this.books.size();
    }

    public void addBook(Book book) {
        if (book == null) 
            throw new IllegalArgumentException("Libro null.");

        if (!books.contains(book))
            this.books.add(book);
    }

    public int getPublisherQuantity() {
        ArrayList<Publisher> publishers = new ArrayList<>();

        for (Book book : this.books) {
            Publisher p = book.getPublisher();
            if (!publishers.contains(p))
                publishers.add(p);
        }

        return publishers.size();
    }
}
