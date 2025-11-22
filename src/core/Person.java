/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author edangulo
 */

public abstract class Person {

    protected long id;
    protected String firstname;
    protected String lastname;

    public Person(long id, String firstname, String lastname) {

        if (id < 0 || String.valueOf(id).length() > 15)
            throw new IllegalArgumentException("ID inválido.");

        if (firstname == null || firstname.isBlank())
            throw new IllegalArgumentException("Nombre vacío.");

        if (lastname == null || lastname.isBlank())
            throw new IllegalArgumentException("Apellido vacío.");

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullname() {
        return firstname + " " + lastname;
    }
}
