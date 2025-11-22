/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author valeriedelahoz
 */

import core.LibraryModel;
import core.Author;
import core.Manager;
import core.Narrator;
import utils.Response;

public class PersonController {

    private final LibraryModel model;

    public PersonController(LibraryModel model) {
        this.model = model;
    }

    public Response<Manager> crearManager(Manager manager) {
        model.addManager(manager);
        return new Response<>(true, "Gerente creado correctamente", manager);
    }

    public Response<Author> crearAuthor(Author author) {
        model.addAuthor(author);
        return new Response<>(true, "Autor creado correctamente", author);
    }

    public Response<Narrator> crearNarrator(Narrator narrator) {
        model.addNarrator(narrator);
        return new Response<>(true, "Narrador creado correctamente", narrator);
    }
}

