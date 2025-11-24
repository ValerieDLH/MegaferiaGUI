/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author valeriedelahoz
 */

//Libreria modelo
import java.util.ArrayList;
import java.util.List;

public class LibraryModel {

    private ArrayList<Stand> stands;
    private ArrayList<Publisher> publishers;
    private ArrayList<Manager> managers;
    private ArrayList<Author> authors;
    private ArrayList<Narrator> narrators;
    private ArrayList<Book> books;

    private List<ModelObserver> observers = new ArrayList<>();

    public LibraryModel() {
        this.stands = new ArrayList<>();
        this.publishers = new ArrayList<>();
        this.managers = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.narrators = new ArrayList<>();
        this.books = new ArrayList<>();
    }

    // ------------------- OBSERVERS ------------------------
    public void addObserver(ModelObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ModelObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String type) {
    ModelEvent event = new ModelEvent(this, type);
    for (ModelObserver obs : observers) {
        obs.modelChanged(event);
    }
}


    // ------------------- STANDS ------------------------
    public boolean existsStandId(long id) {
        for (Stand s : stands) {
            if (s.getId() == id) return true;
        }
        return false;
    }

    public void addStand(Stand stand) {
        stands.add(stand);
        notifyObservers(ModelEvent.STAND_CREATED);
    }

    public Stand getStandById(long id) {
        for (Stand s : stands) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public void buyStand(long standId, ArrayList<Publisher> editoriales) {
        Stand stand = getStandById(standId);
        if (stand != null) {
            stand.setPublishers(editoriales);
            notifyObservers(ModelEvent.STAND_BOUGHT);
        }
    }

    public ArrayList<Stand> getStands() {
        return stands;
    }

    // ------------------- MANAGERS ------------------------
    public void addManager(Manager manager) {
        managers.add(manager);
    }

    public Manager getManagerById(long id) {
        for (Manager m : managers) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    public ArrayList<Manager> getManagers() {
        return managers;
    }

    // ------------------- PUBLISHERS ------------------------
    public boolean existsPublisherNit(String nit) {
        for (Publisher p : publishers) {
            if (p.getNit().equals(nit)) return true;
        }
        return false;
    }

    public Publisher getPublisherByNit(String nit) {
        for (Publisher p : publishers) {
            if (p.getNit().equals(nit)) return p;
        }
        return null;
    }

    public void addPublisher(Publisher publisher) {
        publishers.add(publisher);
        notifyObservers(ModelEvent.PUBLISHER_CREATED);
    }

    public ArrayList<Publisher> getPublishers() {
        return publishers;
    }

    // ------------------- AUTHORS ------------------------
    public void addAuthor(Author author) {
        authors.add(author);
    }

    public Author getAuthorById(long id) {
        for (Author a : authors) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    public ArrayList<Author> getAuthorsByIds(ArrayList<Long> ids) {
        ArrayList<Author> result = new ArrayList<>();
        for (long id : ids) {
            Author a = getAuthorById(id);
            if (a != null) {
                result.add(a);
            }
        }
        return result;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    // ------------------- NARRATORS ------------------------
    public void addNarrator(Narrator narrator) {
        narrators.add(narrator);
    }

    public Narrator getNarratorById(long id) {
        for (Narrator n : narrators) {
            if (n.getId() == id) return n;
        }
        return null;
    }

    public ArrayList<Narrator> getNarrators() {
        return narrators;
    }

    // ------------------- BOOKS ------------------------
    public void addBook(Book book) {
        books.add(book);
        notifyObservers(ModelEvent.BOOK_CREATED);
    }

    public boolean existsISBN(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) return true;
        }
        return false;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}








