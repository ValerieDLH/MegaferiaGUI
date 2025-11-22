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


public class Stand {

    private long id;
    private double price;
    private ArrayList<Publisher> publishers;

    public Stand(long id, double price) {

        if (id < 0 || String.valueOf(id).length() > 15)
            throw new IllegalArgumentException("ID inválido.");

        if (price <= 0)
            throw new IllegalArgumentException("Precio debe ser > 0.");

        this.id = id;
        this.price = price;
        this.publishers = new ArrayList<>();
    }

    public void addPublisher(Publisher publisher) {
        if (publisher == null)
            throw new IllegalArgumentException("Publisher null.");

        if (!publishers.contains(publisher))
            publishers.add(publisher);
    }

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<Publisher> getPublishers() {
        return publishers;
    }

    public int getPublisherQuantity() {
        return publishers.size();
    }
}
