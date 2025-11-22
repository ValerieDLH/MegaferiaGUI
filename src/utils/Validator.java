/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author valeriedelahoz
 */


public class Validator {

    
    public static boolean validateMaxDigits(long number, int maxDigits) {
        return String.valueOf(number).length() <= maxDigits;
    }

    public static boolean validateNitFormat(String nit) {
        return nit.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d");
    }
    
    public static boolean validateISBNFormat(String isbn) {
    return isbn.matches("\\d{3}-\\d-\\d{2}-\\d{6}-\\d");
}

}

