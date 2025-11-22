/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author valeriedelahoz
 */

import utils.Response;
import core.Book;
import java.util.ArrayList;

public interface IBookController {
    Response<Book> createPrintedBook(String title, ArrayList<Long> authorIds, String isbn, String genre,
                                     double value, String publisherNit, int pages, int copies);

    Response<Book> createDigitalBook(String title, ArrayList<Long> authorIds, String isbn, String genre,
                                     double value, String publisherNit, String hyperlink);

    Response<Book> createAudioBook(String title, ArrayList<Long> authorIds, String isbn, String genre,
                                   double value, String publisherNit, int duration, long narratorId);
}
