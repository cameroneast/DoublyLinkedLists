/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Exceptions.EmptyCollectionException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Qiong
 */
public class SinglyLinkedListTest {
    
    public SinglyLinkedListTest() {
    }

    /**
     * Test of addFirst method, of class SinglyLinkedList.
     */
    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        String element = new String("abc");
        SinglyLinkedList<String> instance = new SinglyLinkedList();
        instance.addFirst(element);
        assertTrue(instance.size() == 1);
        try{
            assertTrue(instance.first().equals(element));
            assertTrue(instance.last().equals(element));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        String element2 = new String("123");
       instance.addFirst(element2);
        assertTrue(instance.size() == 2);
        try{
            assertTrue(instance.first().equals(element2));
            assertTrue(instance.last().equals(element));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Test of addLast method, of class SinglyLinkedList.
     */
    @Test
    public void testAddLast() {
        System.out.println("addLast");
        String element = new String("abc");
        SinglyLinkedList<String> instance = new SinglyLinkedList();
        instance.addLast(element);
        assertTrue(instance.size() == 1);
        try{
            assertTrue(instance.first().equals(element));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        String element2 = new String("123");
        instance.addLast(element2);
        assertTrue(instance.size() == 2);
        try{
            assertTrue(instance.first().equals(element));
            assertTrue(instance.last().equals(element2));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Test of addAfter method, of class SinglyLinkedList.
     */
    @Test
    public void testAddAfter() {
        System.out.println("addAfter");
        Integer element = 3;
        Integer element2 = 4;
        Integer element3 = 5;
        Integer element4 = 6;
        SinglyLinkedList<Integer> instance = new SinglyLinkedList();
        instance.addLast(element);
        instance.addLast(element2);
        System.out.println(instance.toString());
        
        try {
            instance.addAfter(element, element3);
            System.out.println(instance.toString());
            assertTrue(instance.size() == 3);
            assertTrue(instance.get(0).equals(element));
            assertTrue(instance.get(1).equals(element3));
            assertTrue(instance.get(2).equals(element2));
            
            instance.addAfter(element2, element4);
            assertTrue(instance.size() == 4);
            assertTrue(instance.get(0).equals(element));
            assertTrue(instance.get(1).equals(element3));
            assertTrue(instance.get(2).equals(element2));
            assertTrue(instance.get(3).equals(element4));
            assertTrue(instance.last().equals(element4));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Test of remove method, of class SinglyLinkedList.
     */
    @Test
    public void testRemove()  {
        System.out.println("testRemove");
        Integer element = 3;
        Integer element2 = 4;
        Integer element3 = 5;
        Integer element4 = 6;
        SinglyLinkedList<Integer> instance = new SinglyLinkedList();
                //Test exception
        try {
            instance.removeFirst();
            fail("Didn't throw exception");
        } catch (Exception e) {
            assertTrue(e instanceof EmptyCollectionException);
        }
        
        instance.addLast(element);
        try {
            assertTrue(instance.remove(element).equals(element));
            assertTrue(instance.size() == 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        instance.addLast(element);
        instance.addLast(element2);
        instance.addLast(element3);
        instance.addLast(element4);
        System.out.println(instance.toString());
        try {
            assertTrue(instance.remove(element).equals(element));
            assertTrue(instance.size() == 3);
            assertTrue(instance.first().equals(element2));
            assertTrue(instance.last().equals(element4));
            assertTrue(instance.remove(element4).equals(element4));
            assertTrue(instance.first().equals(element2));
            assertTrue(instance.last().equals(element3));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    /**
     * Test of removeFirst method, of class SinglyLinkedList.
     */
    @Test
    public void testRemoveFirst() throws Exception {
        System.out.println("removeFirst");
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

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
        
        System.out.println("Walk the list:");
        list.walkList();

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
     * Test of removeLast method, of class SinglyLinkedList.
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
