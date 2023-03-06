package Exceptions;


/**
 * Exception handler for when an element isn't in a collection
 * @author clatulip
 */
public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String el) {
        super("The element " + el + "was not found in the collection.");
    }
    
}
