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
import core.Stand;
import core.Publisher;
import utils.Response;
import utils.Validator;
import java.util.ArrayList;

public class StandController {

    private final LibraryModel model;

    public StandController(LibraryModel model) {
        this.model = model;
    }


    public Response<Stand> crearStand(long id, double price) {

        if (id < 0) {
            return new Response<>(false, "El ID debe ser mayor o igual que 0", null);
        }


        if (!Validator.validateMaxDigits(id, 15)) {
            return new Response<>(false, "El ID debe tener máximo 15 dígitos", null);
        }

        if (model.existsStandId(id)) {
            return new Response<>(false, "Ya existe un stand con ese ID", null);
        }

        if (price <= 0) {
            return new Response<>(false, "El precio debe ser mayor que 0", null);
        }

        Stand stand = new Stand(id, price);
        model.addStand(stand);

        return new Response<>(true, "Stand creado exitosamente", stand);
    }


    public Response<Stand> comprarStand(long standId, ArrayList<String> editorialNits) {


        Stand stand = model.getStandById(standId);
        if (stand == null) {
            return new Response<>(false, "El stand seleccionado no existe", null);
        }

        ArrayList<Publisher> editorialesSeleccionadas = new ArrayList<>();
        for (String nit : editorialNits) {

            Publisher p = model.getPublisherByNit(nit);
            if (p == null) {
                return new Response<>(false, "La editorial con NIT " + nit + " no existe", null);
            }

            if (editorialesSeleccionadas.contains(p)) {
                return new Response<>(false, "Las editoriales no pueden repetirse", null);
            }

            editorialesSeleccionadas.add(p);
        }

        model.buyStand(standId, editorialesSeleccionadas);

        return new Response<>(true, "Compra realizada exitosamente", stand);
    }
}



