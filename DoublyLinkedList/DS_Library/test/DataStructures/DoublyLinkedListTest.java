/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Exceptions.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author clatulip
 */
public class DoublyLinkedListTest {

//<editor-fold defaultstate="collapsed" desc="Other Tests">
    /**
     * Test of addFirst method, of class DoublyLinkedList.
     */
    @Test
    public void testAddFirst() {

        System.out.println("addFirst");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertEquals(list.size(), 0);
        assertTrue(list.isEmpty());
        list.addFirst(7);
        assertEquals(list.size(), 1);
        assertFalse(list.isEmpty());
        try {
            assertEquals(list.first(), (Integer) 7);
            assertEquals(list.last(), (Integer) 7);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoublyLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addFirst(3);
        assertEquals(list.size(), 2);
        try {
            assertEquals(list.first(), (Integer) 3);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoublyLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of addLast method, of class DoublyLinkedList.
     */
    @Test
    public void testAddLast() {
        System.out.println("addLast");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertEquals(list.size(), 0);
        assertTrue(list.isEmpty());
        list.addLast(7);
        assertEquals(list.size(), 1);
        assertFalse(list.isEmpty());
        try {
            assertEquals(list.first(), (Integer) 7);
            assertEquals(list.last(), (Integer) 7);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoublyLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addLast(3);
        assertEquals(list.size(), 2);
        try {
            assertEquals(list.last(), (Integer) 3);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoublyLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of addAfter method, of class DoublyLinkedList.
     */
    @Test
    public void testAddAfter() throws Exception {
        System.out.println("addAfter");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(7);

        try {
            list.addAfter(7, 18);
            assertEquals(list.size(), 2);
            assertFalse(list.isEmpty());
            assertEquals(list.first(), (Integer) 7);
            assertEquals(list.last(), (Integer) 18);
        } catch (EmptyCollectionException | ElementNotFoundException ex) {
            Logger.getLogger(DoublyLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        list.addFirst(3);
        list.addFirst(22);
        list.addFirst(45);

        try {
            list.addAfter(22, 4);
            assertEquals(list.first(), (Integer) 45);
            assertEquals(list.size(), 6);
            assertEquals(list.last(), (Integer) 18);
            Integer result = list.remove(4);
            assertEquals(result, (Integer) 4);
        } catch (EmptyCollectionException | ElementNotFoundException ex) {
            Logger.getLogger(DoublyLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of remove method, of class DoublyLinkedList.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertEquals(list.size(), 0);
        list.addFirst(7);
        assertEquals(list.size(), 1);
        try {
            assertEquals(list.remove(7), new Integer(7));
            assertEquals(list.size(), 0);
            assertTrue(list.isEmpty());
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoublyLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addFirst(3);
        list.addFirst(22);
        list.addFirst(45);
        try {
            assertEquals(list.remove(22), (Integer) 22);
            assertEquals(list.size(), 2);
            assertEquals(list.first(), (Integer) 45);
            assertEquals(list.last(), (Integer) 3);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoublyLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of first method, of class DoublyLinkedList.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFirst() throws Exception {
        System.out.println("first");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertEquals(list.size(), 0);
        list.addFirst(7);
        assertEquals(list.size(), 1);
        try {
            assertEquals(list.first(), (Integer) 7);
            assertEquals(list.size(), 1);
            assertFalse(list.isEmpty());
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoublyLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addFirst(3);
        list.addFirst(22);
        list.addFirst(45);
        try {
            assertEquals(list.first(), (Integer) 45);
            assertEquals(list.size(), 4);

        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoublyLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of last method, of class DoublyLinkedList.
     */
    @Test
    public void testLast() throws Exception {
        System.out.println("last");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertEquals(list.size(), 0);
        list.addFirst(7);
        assertEquals(list.size(), 1);
        try {
            assertEquals(list.last(), (Integer) 7);
            assertEquals(list.size(), 1);
            assertFalse(list.isEmpty());
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoublyLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addFirst(3);
        list.addFirst(22);
        list.addFirst(45);
        try {
            assertEquals(list.last(), (Integer) 7);
            assertEquals(list.size(), 4);

        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoublyLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of isEmpty method, of class DoublyLinkedList.
     */
    @Test
    public void testIsEmpty() throws EmptyCollectionException, ElementNotFoundException {
        System.out.println("isEmpty");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        //Check initial state
        assertTrue(list.isEmpty());

        //Increase size to 1
        list.addFirst(7);

        //Assert new size
        assertFalse(list.isEmpty());

        //Change state
        assertEquals(new Integer(7), list.remove(7));

        //Assert new size
        assertTrue(list.isEmpty());
    }

    /**
     * Test of size method, of class DoublyLinkedList.
     */
    @Test
    public void testSize() throws EmptyCollectionException, ElementNotFoundException {
        System.out.println("size");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        //Check initial state
        assertEquals(0, list.size());

        //Increase size to 1
        list.addFirst(7);

        //Assert new size
        assertEquals(1, list.size());

        //Change state
        assertEquals(new Integer(7), list.remove(7));

        //Assert new size
        assertEquals(0, list.size());

    }
//</editor-fold>

    /**
     * Test of removeFirst method, of class DoublyLinkedList.
     */
    @Test
    public void testRemoveFirst() throws Exception {
        System.out.println("removeFirst");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        //Check initial states
        assertEquals(list.size(), 0);

        //Test exception
        try {
            list.removeFirst();
            fail("Didn't throw exception");
        } catch (Exception e) {
            assertTrue(e instanceof EmptyCollectionException);
        }

        //Add one item
        //Check new size
        list.addFirst(7);
        assertEquals(list.size(), 1);

        //Test case - removeFirst when only one item is stored
        try {
            assertEquals(list.removeFirst(), new Integer(7));
            assertEquals(list.size(), 0);
            assertTrue(list.isEmpty());
        } catch (EmptyCollectionException ex) {
            fail("Shouldn't throw exception");
        }

        //Add three more items
        list.addFirst(3);
        list.addFirst(22);
        list.addFirst(45);

        //Test case - removeFirst general case
        try {
            assertEquals(list.removeFirst(), new Integer(45));
            assertEquals(list.size(), 2);
            assertEquals(list.first(), new Integer(22));
            assertEquals(list.last(), new Integer(3));
        } catch (EmptyCollectionException ex) {
            fail("Shouldn't throw exception");
        }
    }

    /**
     * Test of removeLast method, of class DoublyLinkedList.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveLast() throws Exception {
        System.out.println("removeLast");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        //Check initial states
        assertEquals(list.size(), 0);

        //Test exception
        try {
            list.removeFirst();
            fail("Didn't throw exception");
        } catch (Exception e) {
            assertTrue(e instanceof EmptyCollectionException);
        }

        //Add one item
        //Check new size
        list.addFirst(7);
        assertEquals(list.size(), 1);
        try {
            assertEquals(list.removeLast(), new Integer(7));
            assertEquals(list.size(), 0);
            assertTrue(list.isEmpty());
        } catch (EmptyCollectionException ex) {
            fail("Shouldn't throw exception");
        }
        list.addFirst(3);
        list.addFirst(22);
        list.addFirst(45);
        try {
            assertEquals(list.removeLast(), new Integer(3));
            assertEquals(list.size(), 2);
            assertEquals(list.first(), new Integer(45));
            assertEquals(list.last(), new Integer(22));
        } catch (EmptyCollectionException ex) {
            fail("Shouldn't throw exception");
        }
    }

}
