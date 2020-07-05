package lesson3;

import java.util.NoSuchElementException;

public class Deque {
    private int capacity;
    private int[] queue;
    private int head;
    private int tail;
    private int items;

    public Deque(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        head = 0;
        tail = -1;
        items = 0;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == capacity;
    }

    public int size() {
        return items;
    }

    public void insertTail(int value) {
        if (isFull()) increaseArray();
        if (tail == capacity - 1)
            tail = -1;
        queue[++tail] = value;
        items++;
        printDequeIncludeNulls("insertTail");
    }

    public void insertHead (int value) {
        if (isFull()) increaseArray();
        if (head == -1)
            head = capacity - 1;
        queue[--head] = value;
        items++;
        printDequeIncludeNulls("insertHead");
    }

    public int removeHead() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int temp = queue[head];
        queue [head] = 0; // исключительно для наглядности при тестировании
        head++;
        head %= capacity; // if (head == capacity) head = 0;
        items--;
        printDequeIncludeNulls("removeHead");
        return temp;
    }


    public int removeTail() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int temp = queue[tail];
        queue[tail] = 0; // исключительно для наглядности при тестировании
        tail--;
        if (tail == -1) tail = capacity - 1;
        items--;
        printDequeIncludeNulls("removeTail");
        return temp;
    }


    public int peek() {
        return queue[head];
    }

    public void printDeque() {
        if (tail >= head) {
            for (int i = head; i <= tail; i++) {
                System.out.print(queue[i] + " ");
            }
        } else {
            for (int i = head; i < capacity; i++) {
                System.out.print(queue[i] + " ");
            }
            for (int i = 0; i <= tail; i++) {
                System.out.print(queue[i] + " ");
            }
        }
        System.out.println(" - это все элементы в очереди");
    }

    public void printDequeIncludeNulls (String comment) {
        for (int element: queue){
            System.out.print(element + " " );
        }
        System.out.println(" - " + comment);
    }

    private void increaseArray() {
        capacity *= 2;
        int[] newQ = new int[capacity];
        if (tail >= head) {
            System.arraycopy(queue, 0, newQ, 0, queue.length);
        } else {
            System.arraycopy(queue, 0, newQ, 0, tail + 1);
            System.arraycopy(queue, head, newQ, capacity - (queue.length - head),queue.length - head);
            head = capacity - (queue.length - head); // из-за отсутствия этой строки код урока работал неверно
        }
        queue = newQ;
    }




    //t[h.........]
    // [h||||||t..]
    // [....h||t..]
    // [|t..h|||||]
    // [|t..................]
}
