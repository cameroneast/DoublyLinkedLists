/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;
import Exceptions.*;
import ADTs.*;
/**
 *
 * @author clatulip
 * Adapted by ITCS 2214
 */
public class DoublyLinkedList<T extends Comparable> implements ListADT<T> {

    private DoublyLinkedNode<T> first;
    private DoublyLinkedNode<T> last;
    private int numNodes;

    public DoublyLinkedList() {
        first = null;
        last = null;
        numNodes = 0;
    }

    @Override
    public void addFirst(T element) {
        DoublyLinkedNode<T> temp = new DoublyLinkedNode<>(element);
        if (numNodes == 0) {
            first = temp;
            last = temp;
            numNodes++;
            return;
        }
        temp.setNext(first);
        first.setPrev(temp);
        first = temp;
        numNodes++;
    }

    @Override
    public void addLast(T element) {
        DoublyLinkedNode<T> temp = new DoublyLinkedNode<>(element);
        if (numNodes == 0) {
            first = temp;
            last = temp;
            numNodes++;
            return;
        }
        temp.setPrev(last);
        last.setNext(temp);
        last = temp;
        numNodes++;
    }

    @Override
    public void addAfter(T existing, T element) throws ElementNotFoundException, EmptyCollectionException {
        DoublyLinkedNode<T> temp = new DoublyLinkedNode<>(element);
        DoublyLinkedNode<T> curr = first;
        while (curr != null) {
            if (curr.getElement().compareTo(existing) == 0) {
                // found existing element, add temp after this
                temp.setNext(curr.getNext());
                temp.setPrev(curr);
                if (curr.getNext() != null) {
                    curr.getNext().setPrev(temp);
                } else {
                    // adding at the end
                    last = temp;
                }
                curr.setNext(temp);
                numNodes++;
                return;
            } else {
                curr = curr.getNext();
            }
        }
        // iterated through and didn't find existing element
        throw new ElementNotFoundException("DoubleLinkedList: addAfter(..) method");
    
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (numNodes == 0)
            throw new EmptyCollectionException("DoubleLinkedList");
        T result = null;
        DoublyLinkedNode<T> curr = first;
        while (curr != null) {
            if (curr.getElement().compareTo(element) == 0) {
                // found the element, so remove this node
                result = curr.getElement();
                // check special case of removing only element
                if ((curr == first) && (curr == last)) {
                    first = null;
                    last = null;
                    numNodes--;
                    return result;
                }
                // check special case of removing first element
                if (curr == first) {
                    first = curr.getNext();
                    first.setPrev(null);
                    numNodes--;
                    return result;
                }
                // check special case of removing last element
                if (curr == last) {
                    last = curr.getPrev();
                    last.setNext(null);
                    numNodes--;
                    return result;
                }
                // normal case, removing in middle
                curr.getPrev().setNext(curr.getNext());
                curr.getNext().setPrev(curr.getPrev());
                numNodes--;
                return result;
            } // end if
            curr = curr.getNext();
        } // end iteration through list
        throw new ElementNotFoundException("DoubleLinkedList, remove(element) method");
        
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
	  //TODO Complete the function to implete remove the first element in the list
       //Please handle different cases.
       //Case 1: the list is empty (namely, first == null)
       //Case 2: only one element left in the list (namely, first == last)
       //Case 3: more than one element left in the list

       if (first == null)
           throw new EmptyCollectionException("RemoveFirst from empty Double Linked List");
        
        
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        //TODO Complete the function to implete remove the first element in the list
       //Please handle different cases.
       //Case 1: the list is empty (namely, first == null)
       //Case 2: only one element left in the list (namely, first == last)
       //Case 3: more than one element left in the list

        if (first == null)
            throw new EmptyCollectionException("RemoveFirst from empty Double Linked List");
        


    }



    @Override
    public T first() throws EmptyCollectionException {
        if (numNodes == 0)
            throw new EmptyCollectionException("DoubleLinkedList");
        T element = first.getElement();
        return element;
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (numNodes == 0)
            throw new EmptyCollectionException("DoubleLinkedList");
        T element = last.getElement();
        return element;
    }

    @Override
    public boolean isEmpty() {
        return (numNodes == 0);
    }

    @Override
    public int size() {
        return numNodes;
    }

    @Override
    public boolean contains(T element) throws EmptyCollectionException {
        DoublyLinkedNode<T> temp = first;
        
        while (temp != null && temp.getElement().compareTo(element) != 0) {
            temp = temp.getNext();
        }
        
        return temp == null ? false : true;
    }

    @Override
    public T get(int index) throws EmptyCollectionException, InvalidArgumentException {
        if (numNodes == 0) {
            throw new EmptyCollectionException();
        }
        
        // validate the input
        if (index < 0 || index >= numNodes) {
            throw new InvalidArgumentException();
        }
        DoublyLinkedNode<T> temp = first;
        for (int count = 0; count < numNodes; count++) {
            temp = temp.getNext();
        }
        return temp.getElement();
    }

    @Override
    public void set(int index, T element) throws EmptyCollectionException, InvalidArgumentException {
        if (numNodes == 0) {
            throw new EmptyCollectionException();
        }
        
        // validate the input
        if (element == null || index < 0 || index >= numNodes) {
            throw new InvalidArgumentException();
        }
        
        DoublyLinkedNode<T> temp = first;
        for (int count = 0; count < numNodes; count++) {
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
        DoublyLinkedNode<T> temp = first;
        
        String result = "";
        while (temp != null) {
            result += temp.getElement()  + " -> ";
            temp = temp.getNext();
        }
        return result;
    }
}
