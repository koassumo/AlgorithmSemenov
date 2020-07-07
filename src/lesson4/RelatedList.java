package lesson4;

import java.util.Objects;

public class RelatedList {
    
    private class IteratorClass implements IteratorTry {
        Node current;

        public IteratorClass () {
            this.current = head;
        }

        @Override
        public void reset () {
            current = head;
        }

        @Override
        public Node next () {
            current = current.next;
            return current;
        }

        @Override
        public Node previous () {
            current = current.previous;
            return current;
        }

        @Override
        public Node getCurrent() {
            return current;
        }

        @Override
        public boolean hasNext () {
            return current.next == null ? false : true;
        }

        @Override
        public boolean hasPrevious () {
            return current.previous == null ? false : true;
        }

        @Override
        public void atEnd () {
            current = tail;
        }

        @Override
        public void insertAfter() {
            current = tail;
        }

        @Override
        public void insertBefore() {
            
        }

        @Override
        public void deleteCurrent () {
            current = tail;
        }

        public void setIterator(Node iterator) {
            this.current = iterator;
        }
    }

    private class Node {
        Cat c;
        Node next;
        Node previous;

        public Node(Cat c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return c.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return c.equals(node.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(c);
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public RelatedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void pushHead (Cat c) {
        Node n = new Node(c);
        n.next = head;
        if (head != null) head.previous = n;
        head = n;
        if (size == 0) tail = n;
        size++;
    }

    public void pushTail (Cat c) {
        Node n = new Node(c);
        n.previous = tail;
        if (tail != null) tail.next = n;
        tail = n;
        size++;
    }

    public Cat popHead () {
        if (isEmpty()) return null;
        Cat temp = head.c;
        head = head.next;
        head.previous = null;
        size--;
        return temp;
    }

    public Cat popTail () {
        if (isEmpty()) return null;
        Cat temp = tail.c;
        tail = tail.previous;
        tail.next = null;
        size--;
        return temp;
    }

    public void printFromHead() {
        IteratorClass iterator = new IteratorClass();
        System.out.print(iterator.getCurrent());
        while (iterator.hasNext()) {
            System.out.print(", " + iterator.next());
        }
        System.out.println(" --- printFromHead");
    }

    public void printFromTail() {
        IteratorClass iterator = new IteratorClass();
        iterator.atEnd();
        System.out.print(iterator.getCurrent());
        while (iterator.hasPrevious()) {
            System.out.print(", " + iterator.previous());
        }
        System.out.println(" --- printFromTail");
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? "]" : ", ");
        }
        return sb.toString();
    }

    public boolean contains(Cat c) {
        return find(c) == null;
    }

    private Node find(Cat c) {
        if (isEmpty()) return null;
        Node current = head;
        while (!current.c.equals(c)) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public boolean delete(Cat c) {
        Node current = head;
        Node previous = head;
        while (!current.c.equals(c)) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        return true;
    }
}
