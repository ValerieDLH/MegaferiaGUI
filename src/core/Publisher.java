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


public class Publisher {

    private final String nit;
    private String name;
    private String address;
    private Manager manager;
    private ArrayList<Book> books;
    private ArrayList<Stand> stands;

    public Publisher(String nit, String name, String address, Manager manager) {

        if (nit == null || !nit.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d"))
            throw new IllegalArgumentException("NIT inválido (formato XXX.XXX.XXX-X).");

        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Nombre vacío.");

        if (address == null || address.isBlank())
            throw new IllegalArgumentException("Dirección vacía.");

        if (manager == null)
            throw new IllegalArgumentException("Manager null.");

        this.nit = nit;
        this.name = name;
        this.address = address;
        this.manager = manager;

        this.books = new ArrayList<>();
        this.stands = new ArrayList<>();

        this.manager.setPublisher(this);
    }

    public String getNit() {
        return nit;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Manager getManager() {
        return manager;
    }

    public int getStandQuantity() {
        return stands.size();
    }

    public void addBook(Book book) {
        if (book == null)
            throw new IllegalArgumentException("Libro null.");

        if (!books.contains(book))
            books.add(book);
    }

    public void addStand(Stand stand) {
        if (stand == null)
            throw new IllegalArgumentException("Stand null.");

        if (!stands.contains(stand))
            stands.add(stand);
    }
}
