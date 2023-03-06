
package DataStructures;

/**
 * A simple Linear Node for use in linked structures such as lists
 * @author clatulip
 * Adapted by ITCS 2214
 */
public class DoublyLinkedNode<T> {
    private DoublyLinkedNode<T> next;
    private DoublyLinkedNode<T> prev;
    private T element;

    /**
     * Default constructor creates an empty node
     */
    public DoublyLinkedNode() {
        next = null;
        prev = null;
        element = null;
    }

    /** 
     * Creates a node containing element
     * @param elem element to be stored
     */
    public DoublyLinkedNode(T elem) {
        next = null;
        prev = null;
        element = elem;
    }
    
    /**
     * Gets the node that follows this one 
     * @return next linear node
     */
    public DoublyLinkedNode<T> getNext()
    {
        return next;
    }
    
    /**
     * Sets the node that follows this one
     * @param n LinearNode to follow this one
     */
    public void setNext(DoublyLinkedNode<T> n) 
    {
        next = n;
    }

    /** 
     * Gets the node that is before this one
     * @return prev LinearNode<T>
     */
    public DoublyLinkedNode<T> getPrev() 
    {
        return prev;
    }

    /**
     * Sets the node that is before this one
     * @param p LinearNode to put before this one
     */
    public void setPrev(DoublyLinkedNode<T> p) 
    {
        prev = p;
    }

    /**
     * Returns the element stored in this node
     * @return element stored in the node
     */
    public T getElement() {
        return element;
    }
    
    public void setElement(T elem) {
        element = elem;
    }

    @Override
    public String toString() {
        return "{el=" + element + ", next=" + next + ", prev=" + prev +  "}";
    }

    
    
    
}
