package Exceptions;

/**
 * An Invalid Argument Exception class
 * Prints out what argument is invalid
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2016
 * @author clatulip
 */
public class InvalidArgumentException extends Exception {

    public InvalidArgumentException() {
        super("The collection is empty.");
    }
    
    public InvalidArgumentException(String collection) {
        super("The " + collection + " is empty.");
    }
    
}
