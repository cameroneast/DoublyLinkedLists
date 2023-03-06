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

/**
 *
 * @author ITCS 2214
 */
public class SinglyLinkedList<T extends Comparable> implements ListADT<T> {
    protected SinglyLinkedNode<T> first;
    protected SinglyLinkedNode<T> last;
    protected int numNodes;
    
    public SinglyLinkedList() {
        //TODO
        first = null;
        numNodes = 0;
    }

    /**
     * Insert a new node which holds the reference to the given element into the beginning of the list.
     * 
     * Note: the SinglyLinkedList class uses the data member variable first, last, 
 and numNodes to maintain the status of a SinglyLinkedList instance.
 When the method addFirst is invoked, we need to make sure that the
 data member variable first, last, and numNodes are changed properly.
 
 and numNodes
     * @param element 
     */
    @Override
    public void addFirst(T element) {
        //TODO
        // Create a new node holding the given element.
        SinglyLinkedNode node = new SinglyLinkedNode(element);
        
        // Case 1: the current list is empty
        if (numNodes == 0) {
            first = node;
            last = node;
        } else {// Case 2: the current list is not empty
            node.setNext(first);
            first = node;
        }
        numNodes++;
    }

    /**
     * Append a new node which holds the reference to the given element  in the end of the list.
     * 
     * Note: the SinglyLinkedList class uses the data member variable first, last, 
 and numNodes to maintain the status of a SinglyLinkedList instance.
 When the method addLast is invoked, we need to make sure that the
 data member variable first, last, and numNodes are changed properly.
     * 
     * @param element 
     */
    @Override
    public void addLast(T element) {
        //TODO
        // Create a new node holding the given element.
        SinglyLinkedNode node = new SinglyLinkedNode(element);
        
        // Case 1: the current list is empty
        if (numNodes == 0) {
            first = node;
            last = node;
        } else {// Case 2: the current list is not empty
            last.setNext(node);
            last = node;
        }
        numNodes++;
    }

    /**
     * Insert a new node which holds the reference to the given element 
     * after the node which holds the given existing.
     * Namely insert the given element after the existing element in the list
 If the given existing is not found, throw an 
 ElementNotFoundException.
 
 Note: the SinglyLinkedList class uses the data member variable first, last, 
 and numNodes to maintain the status of a SinglyLinkedList instance.
 When the method addAfter is invoked, we need to make sure that the
 data member variable first, last, and numNodes are changed properly.
 Do we need to change the data member variable last?
 And when?
     * 
     * @param existing
     * @param element
     * @throws ElementNotFoundException 
     */
    @Override
    public void addAfter(T existing, T element) throws ElementNotFoundException, EmptyCollectionException {
        //TODO
        SinglyLinkedNode<T> temp = first;
        
        while (temp != null && temp.getElement().compareTo(existing) != 0) {
            temp = temp.getNext();
        }
        
        if (temp == null) {
            throw new ElementNotFoundException("SingleLinkedList throws an ElementNotFoundException");
        }
        
        // Create a new node holding the given element.
        SinglyLinkedNode node = new SinglyLinkedNode(element);
        node.setNext(temp.getNext());
        temp.setNext(node);
        if (temp == last) {
            last = node;
        }
        numNodes++;
    }

    /**
     * Remove the given element in the list.
     * Details: Find a node which holds the given element
 and remove it from the list.
 
 Note: the SinglyLinkedList class uses the data member variable first, last, 
 and numNodes to maintain the status of a SinglyLinkedList instance.
 When the method remove is invoked, we need to make sure that the
 data member variable first, last, and numNodes are changed properly.
 Do we need to change the data member variable first?
 And when?
     * 
     * @param element
     * @return
     * @throws EmptyCollectionException
     * @throws ElementNotFoundException 
     */
    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        //TODO
        if (numNodes == 0) {
            throw new EmptyCollectionException();
        }
        
        // search for the giving existing element
        SinglyLinkedNode<T> cur = first;
        SinglyLinkedNode<T> pre = first;
        while (cur != null && cur.getElement().compareTo(element) != 0) {
            pre = cur;
            cur = cur.getNext();
        }
        
        if (cur == null) {
            throw new ElementNotFoundException("SingleLinkedList throws an ElementNotFoundException");
        }
        
        if (first == pre) {// case 1: found in the beginning of the list
            if (last == first) { // case 1.a: only one node in the list
                last = first = null;
            } else { // case 1.b: more than one nodes in the list
                first = first.getNext();
            }
        } else {// case 2: found after the beginning of the list
            pre.setNext(cur.getNext());
            if (last == cur) {// case 3: found in the end of the list
                last = pre;
            }
        }
        numNodes--;
        return cur.getElement();
    }

    /**
     * Remove and return the first node in the list
     * @return
     * @throws EmptyCollectionException 
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        //TODO
        if (numNodes == 0) {
            throw new EmptyCollectionException();
        }
        
        SinglyLinkedNode<T> temp = first;
        first = first.getNext();
        if (temp == last) {
            last = first;
        }
        numNodes--;
        temp.setNext(null);
        
        return temp.getElement();
    }

    /**
    * Remove and return the last element in the list
    * 
    * @return the last element in the list
    * @throws EmptyCollectionException 
    */
    @Override
    public T removeLast() throws EmptyCollectionException {
        //TODO
        if (numNodes == 0) {
            throw new EmptyCollectionException();
        }
        
        SinglyLinkedNode<T> cur = first;
        SinglyLinkedNode<T> pre = first;
        while (cur != null && cur != last){
            pre = cur;
            cur = cur.getNext();
        }
        
        pre.setNext(null);
        if (pre == first) {
            first = null;
            last = null;
        } else {
            last = pre;
        }
        numNodes--;
        
        return cur.getElement();
    }

    /**
     * Return the first element in the list (without removing it).
     * If the list is empty, throw an EmptyCollectionException instance.
     * @return
     * @throws EmptyCollectionException 
     */
    @Override
    public T first() throws EmptyCollectionException {
        //TODO
        if (numNodes == 0) {
            throw new EmptyCollectionException();
        }
        
        return this.first.getElement();
    }

    /**
     * Return the last element in the list (without removing it)
     * If the list is empty, throw an EmptyCollectionException instance.
     * @return
     * @throws EmptyCollectionException 
     */
    @Override
    public T last() throws EmptyCollectionException {
        //TODO
        if (numNodes == 0) {
            throw new EmptyCollectionException();
        }
        
        return this.last.getElement();        
    }

    /**
     * Evaluate whether the list is empty or not.
     * @return 
     */
    @Override
    public boolean isEmpty() {
        //TODO
        return numNodes == 0? true : false; 
    }

    /**
     * Retrieve the number of elements in the list.
     * @return 
     */
    @Override
    public int size() {
        //TODO
        return numNodes;
    }
    
    /**
     * Return whether the list contains the given element.
     * Details: Scan the whole list until the given element is found in the list
     * 
     * @param element
     * @return
     * @throws EmptyCollectionException 
     */
    public boolean contains(T element) throws EmptyCollectionException {
        //TODO
        SinglyLinkedNode<T> temp = first;
        
        // scan the list
        while (temp != null && temp.getElement().compareTo(element) != 0) {
            temp = temp.getNext();
        }
        
        return temp == null ? false : true;
    }   
    
    public void walkList(){
        walk(this.first);
    }
    public void walk(SinglyLinkedNode<T> node){
        //TODO
        if (node == null) {
            System.out.println();
            return;
        }
        
        System.out.print(node.getElement() + "-@>");
        walk(node.getNext());
    }
    
    /**
     * Return the element at the given index of a list.
     * @param element
     * @return
     * @throws EmptyCollectionException 
    */
    public T get(int index) throws EmptyCollectionException, InvalidArgumentException{
        //TODO
        if (numNodes == 0) {
            throw new EmptyCollectionException();
        }
        
        // validate the input
        if (index < 0 || index >= numNodes) {
            throw new InvalidArgumentException();
        }
        
        // scan the list and locate the node at the given index
        int i = 0;
        SinglyLinkedNode<T> temp = first;
        while (i < index) {
            temp = temp.getNext();
            i++;
        }
        return temp.getElement();
    }
    
    /**
     * Set the element at the given index of a list.
     * @param element
     * @return
     * @throws EmptyCollectionException 
    */
    public void set(int index, T element) throws EmptyCollectionException, InvalidArgumentException {
        //TODO
        if (numNodes == 0) {
            throw new EmptyCollectionException();
        }
        
        // validate the input
        if (index < 0 || index >= numNodes) {
            throw new InvalidArgumentException();
        }
        
        // locate the node at the given index 
        SinglyLinkedNode<T> temp = first;
        for (int count = 0; count < index; count++) {
            temp = temp.getNext();
        }
        temp.setElement(element);
    }
    
    /**
     * Returns a string representation of the collection
     * @return a string representation of the collection
     */
    @Override
    public String toString(){
        //TODO
        SinglyLinkedNode<T> temp = first;
        
        // scan and list each element in the list
        String result = "";
        while (temp != null) {
            result += temp.getElement() + " -> ";
            temp = temp.getNext();
        }
        return result;
    }
    
    private void reverse(SinglyLinkedList<Integer> list, int k){
        SinglyLinkedList<Integer> newlist = new SinglyLinkedList();
        if (k < 0 || k >= list.size()) return;
        try{
            Integer item = list.get(0);
            newlist.addFirst(item);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    /*
    public T getNth(int N){
        if (isEmpty()) return null;
        if (N < 0 || N >= size()) return null;
        SinglyLinkedNode<T> cur = this.first;
        for (int i = 0; i < N; i++)
            cur = cur.getNext();
        return cur.getElement();
    }
    */
    public static void main(String argv[]){
        SinglyLinkedList<Integer> instance = new SinglyLinkedList();
        Integer element1 = 3;
        Integer element2 = 4;
        Integer element3 = 5;
        Integer element4 = 6;
        try {
            instance.addFirst(element1);
            instance.addLast(element2);
            instance.addAfter(element2, element3);
            instance.addLast(element4);
            //System.out.println("The Nth element is " + instance.getNth(2));
            
            SinglyLinkedList<Integer> newlist = new SinglyLinkedList<Integer> ();
            
            instance.addFirst(element1);
            System.out.println("After instance.addFirst(" + element1
                    + "), we have " + instance.toString());

            instance.addLast(element2);
            System.out.println("After instance.addLast(" + element2
                    + "), we have " + instance.toString());
            
            instance.addAfter(element1, element3);
            System.out.println("After instance.addAfter(" + element1
                    + ", " + element3 + "), we have " + instance.toString());
            
            instance.addLast(element4);
            System.out.println("After instance.addLast(" + element4
                    + "), we have " + instance.toString());
        
            instance.remove(element3);
            System.out.println("After instance.remove(" + element3
                    + "), we have " + instance.toString());
            
            instance.removeLast();
            System.out.println("After instance.removeLast(), we have " + instance.toString());
            
            instance.addAfter(element2, element4);
            System.out.println("After instance.addAfter(" + element2
                    + ", " + element4 + "), we have " + instance.toString());
            
            instance.removeFirst();
            System.out.println("After instance.removeFirst(), we have " + instance.toString());
            
            System.out.println("Does the instance contain " + element4 + 
                    "? " + (instance.contains(element4) ? "Yes" : "No"));
            
            System.out.println("get(0) returns " + element1 );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
