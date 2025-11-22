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
import core.Manager;
import core.Publisher;
import utils.Response;
import utils.Validator;
import java.util.ArrayList;

public class PublisherController {

    private final LibraryModel model;

    public PublisherController(LibraryModel model) {
        this.model = model;
    }

    public Response<Publisher> crearEditorial(String nit, String name, String address, Manager manager) {

        if (nit.isBlank() || name.isBlank() || address.isBlank()) {
            return new Response<>(false, "Todos los campos son obligatorios", null);
        }

        if (!Validator.validateNitFormat(nit)) {
            return new Response<>(false, "El NIT debe tener el formato XXX.XXX.XXX-X", null);
        }

    
        if (model.existsPublisherNit(nit)) {
            return new Response<>(false, "Ya existe una editorial con ese NIT", null);
        }


        if (manager == null) {
            return new Response<>(false, "Debe seleccionar un gerente válido", null);
        }


        Publisher publisher = new Publisher(nit, name, address, manager);
        model.addPublisher(publisher);

        return new Response<>(true, "Editorial creada correctamente", publisher);
    }
}

