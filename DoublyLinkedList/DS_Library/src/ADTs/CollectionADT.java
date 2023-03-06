/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADTs;

/**
 * An interface for an AbstractDataType
 * Specific ADT interfaces will extend this
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2016
 * @author clatulip
 */
public interface CollectionADT<T> {
    
    /**
     * Returns true if the collection contains no elements
     * @return true if the collection is empty
     */
    public boolean isEmpty();
    
    /**
     * Returns the number of elements in the collection
     * @return the number of elements as an int
     */
    public int size();
    
    /**
     * Returns a string representation of the collection
     * @return a string representation of the collection
     */
    @Override
    public String toString();
}
