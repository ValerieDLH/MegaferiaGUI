/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author valeriedelahoz
 */

public class ModelEvent {

    public static final String STAND_CREATED = "stand_created";
    public static final String PUBLISHER_CREATED = "publisher_created";
    public static final String STAND_BOUGHT = "stand_bought";
    public static final String BOOK_CREATED = "book_created"; 
    public static final String MANAGER_CREATED = "manager_created";
    public static final String NARRATOR_CREATED = "manager_created";


    private final Object source;
    private final String type;

    public ModelEvent(Object source, String type) {
        this.source = source;
        this.type = type;
    }

    public Object getSource() {
        return source;
    }

    public String getType() {
        return type;
    }
}

