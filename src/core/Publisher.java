/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author valeriedelahoz
 */

import java.util.ArrayList;

public class Publisher {

    private String nit;
    private String name;
    private String address;
    private Manager manager;
    private ArrayList<Book> books;
    private ArrayList<Stand> stands;

    public Publisher(String nit, String name, String address, Manager manager) {
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.manager = manager;
        this.books = new ArrayList<>();
        this.stands = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void addStand(Stand stand) {
        this.stands.add(stand);
    }

    public int getStandQuantity() {
        return stands.size();
    }

    public int getBookQuantity() {
        return books.size();
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

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Stand> getStands() {
        return stands;
    }
}


