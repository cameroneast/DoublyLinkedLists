/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import ADTs.ListADT;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidArgumentException;
import java.util.Arrays;

/**
 *
 * @author ITCS2214
 */
public class CArrayList<T extends Comparable> implements ListADT<T>{
    private static final int DEFAULT_SIZE = 5;
    T [] list;
    private int length;
    
    /**
     * Default constructor with no arguments.
     */
    public CArrayList() { 
        list = (T[]) new Object[DEFAULT_SIZE];
        length = 0;
    }
    
    /**
     * Constructor with initial capacity.
     */
    public CArrayList(int size){//init_capacity) {
        //TODO 
        list = (T[]) new Object[size];//init_capacity];
        this.length = 0;
    }
    
    @Override
    public void addFirst(T element) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (element == null) return;
        if (length == list.length) {
            this.expandCapacity();
        }
        for (int i = length - 1; i >= 0; i--)
            list[i + 1] = list[i];
        list[0] = element;
    }

    @Override
    public void addLast(T element) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (element == null) return;
        if (size() == list.length)
            expandCapacity();
        list[length++] = element;
    }

    @Override
    public void addAfter(T existing, T element) throws ElementNotFoundException, EmptyCollectionException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //TODO
        if ((existing == null) || (element == null)) return;
        if (! contains(existing)) throw new ElementNotFoundException(existing.toString());
        if (size() == list.length)
            expandCapacity();        
        //find existing
        int i = 0;
        for (i = 0; i < length; i++)
            if (list[i].compareTo(existing) == 0)
                break;
        //shift over later elements
        for (int j = length - 1; j >= i; i--)
            list[j + 1] = list[j];
        //place given element
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //TODO 
        if (isEmpty()) throw new EmptyCollectionException();
        int i = 0;
        while ((i < length) && (list[i].compareTo(element) != 0))
            i++;
        
        if (i == length) 
            throw new ElementNotFoundException(element.toString());
        
        for (int j = i+1; j < length; j++)
            list[j - 1] = list[j];
        list[length-1] = null;
        length--;
        return list[i];
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (isEmpty()) throw new EmptyCollectionException();
        T element = list[0];
        for (int i = 1; i < this.length; i++)
            list[i-1] = list[i];
        list[size()-1] = null;
        this.length--;
        return element;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (isEmpty()) throw new EmptyCollectionException();
        T element = list[size() - 1];
        list[size()-1] = null;
        this.length--;
        return element;
    }

    @Override
    public T first() throws EmptyCollectionException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (isEmpty()) throw new EmptyCollectionException();
        
        return list[0];
    }

    @Override
    public T last() throws EmptyCollectionException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (isEmpty()) throw new EmptyCollectionException();
        return list[size()-1];
    }

    @Override
    public boolean contains(T element) throws EmptyCollectionException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (isEmpty()) throw new EmptyCollectionException();
        for (int i = 0; i < size(); i++)
            if (list[i].compareTo(element) == 0)
                return true;
        
        return false;
    }

    @Override
    public T get(int index) throws EmptyCollectionException, InvalidArgumentException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (isEmpty()) throw new EmptyCollectionException();
        if (index < 0 || index >= size()) throw new InvalidArgumentException();
        return list[index];
    }

    @Override
    public void set(int index, T element) throws EmptyCollectionException, InvalidArgumentException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //Todo
        if (isEmpty()) throw new EmptyCollectionException();
        if (element == null || index < 0 || index >= size()) throw new InvalidArgumentException();
        list[index] = element;
    }

    @Override
    public boolean isEmpty() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return length > 0? true : false;
    }

    @Override
    public int size() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return length;
    }
    
    /**
     * Expands the capacity of the collection.
     */
    private void expandCapacity() {
        list = Arrays.copyOf(list, length * 2);
        /*
        java.util.Arrays.copyOf() method is in java.util.Arrays class. 
        It copies the specified array, truncating or padding with false 
        (if necessary) so the copy has the specified length.
            Syntax:
            copyOf(int[] original, int newLength) 
                original – original array
                newLength – copy of original array
        */
    }
}
