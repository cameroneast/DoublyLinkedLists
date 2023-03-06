package Exceptions;

/**
 * An Empty Collection Exception class
 * Prints out what type of collection is empty
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2016
 * @author clatulip
 */
public class EmptyCollectionException extends Exception {

    public EmptyCollectionException() {
        super("The collection is empty.");
    }
    
    public EmptyCollectionException(String collection) {
        super("The " + collection + " is empty.");
    }
    
}
