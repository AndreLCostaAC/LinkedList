package org.academiadecodigo.bootcamp.containers;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import sun.awt.image.ImageWatched;
import sun.launcher.resources.launcher_it;

import java.util.List;

public class LinkedList {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param data the element to add
     */
    public void add(Object data) {

        Node node = new Node(data);
        Node iterator = head;

        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }

        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     *
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {
        Node iterator = head;
        int counter = 0;
        // percorrer os nodes até encontrar o ultimo node
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
            if (counter == index) {
                return iterator.getData();
            }
            counter++;
        }
        return null;
    }


    /**
     * Returns the index of the element in the list
     *
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {
        int counter = 0;
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
            if (iterator.getData().equals(data)) {
                return counter;
            }
            counter ++;
        }
        return -1;
    }


    /**
     * Removes an element from the list
     *
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {
        Node iterator = head;
        Node lastNode;
        while (iterator.getNext() != null) {
            lastNode = iterator;
            iterator = iterator.getNext();
            if (iterator.getData().equals(data)) {
                lastNode.setNext(iterator.getNext());
                // remover um dos nodes, necessito de automaticamente retirar uma posicao da lenght
                length--;
                // como é um boolean tera de ter um retorno true ou false
                return true;


            }
        }
        return false;
    }
    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
