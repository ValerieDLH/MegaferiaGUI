/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author valeriedelahoz
 */

import core.*;
import utils.Response;
import java.util.ArrayList;

public class BookController {

    private final LibraryModel model;

    public BookController(LibraryModel model) {
        this.model = model;
    }

    // ------------ VALIDACIONES COMUNES --------------
    private Response<Book> validateCommonFields(String title, ArrayList<Long> authorIds,
                                                String isbn, String genre, double value,
                                                String publisherNit) {

        if (title.isBlank() || isbn.isBlank() || genre.isBlank() || publisherNit.isBlank()) {
            return new Response<>(false, "Todos los campos son obligatorios.", null);
        }

        if (!utils.Validator.validateISBNFormat(isbn)) {
            return new Response<>(false, "Formato ISBN inválido (XXX-X-XX-XXXXXX-X)", null);
        }

        if (value <= 0) {
            return new Response<>(false, "El valor debe ser mayor a 0", null);
        }

        if (model.existsISBN(isbn)) {
            return new Response<>(false, "Ya existe un libro con ese ISBN", null);
        }

        Publisher publisher = model.getPublisherByNit(publisherNit);
        if (publisher == null) {
            return new Response<>(false, "Editorial inválida", null);
        }

        // Validar autores
        ArrayList<Author> authors = new ArrayList<>();
        for (Long id : authorIds) {
            Author a = model.getAuthorById(id);
            if (a == null) return new Response<>(false, "Autor inválido: " + id, null);
            if (authors.contains(a)) return new Response<>(false, "No se permiten autores repetidos", null);
            authors.add(a);
        }

        return new Response<>(true, "OK", null);
    }

    // ------------ IMPRESO --------------
    public Response<Book> createPrintedBook(String title, ArrayList<Long> authorIds, String isbn,
                                            String genre, String format, double value,
                                            String publisherNit, int pages, int copies) {

        Response<Book> validation =
                validateCommonFields(title, authorIds, isbn, genre, value, publisherNit);
        if (!validation.isSuccess()) return validation;

        Publisher publisher = model.getPublisherByNit(publisherNit);
        Book book = new PrintedBook(title, model.getAuthorsByIds(authorIds), isbn,
                genre, format, value, publisher, pages, copies);

        model.addBook(book);
        return new Response<>(true, "Libro impreso creado exitosamente", book);
    }

    // ------------ DIGITAL --------------
    public Response<Book> createDigitalBook(String title, ArrayList<Long> authorIds, String isbn,
                                            String genre, String format, double value,
                                            String publisherNit, String hyperlink) {

        Response<Book> validation =
                validateCommonFields(title, authorIds, isbn, genre, value, publisherNit);
        if (!validation.isSuccess()) return validation;

        Publisher publisher = model.getPublisherByNit(publisherNit);
        Book book = new DigitalBook(title, model.getAuthorsByIds(authorIds),
                isbn, genre, format, value, publisher, hyperlink);

        model.addBook(book);
        return new Response<>(true, "Libro digital creado exitosamente", book);
    }

    // ------------ AUDIOBOOK --------------
    public Response<Book> createAudioBook(String title, ArrayList<Long> authorIds, String isbn,
                                          String genre, String format, double value,
                                          String publisherNit, int duration, long narratorId) {

        Response<Book> validation =
                validateCommonFields(title, authorIds, isbn, genre, value, publisherNit);
        if (!validation.isSuccess()) return validation;

        Publisher publisher = model.getPublisherByNit(publisherNit);
        Narrator narrator = model.getNarratorById(narratorId);
        if (narrator == null) return new Response<>(false, "Narrador inválido", null);

        Book book = new Audiobook(title, model.getAuthorsByIds(authorIds),
                isbn, genre, format, value, publisher, duration, narrator);

        model.addBook(book);
        return new Response<>(true, "Audiolibro creado exitosamente", book);
    }
    
    
}


