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
        if (isFull()) {
            capacity *= 2;
            int[] newQ = new int[capacity];
            if (tail >= head) {
                System.arraycopy(queue, 0, newQ, 0, queue.length);
            } else {
                System.arraycopy(queue, 0, newQ, 0, tail + 1);
                System.arraycopy(queue, head,
                        newQ, capacity - (queue.length - head),
                        queue.length - head - 1);
            }
            queue = newQ;
        }
        if (tail == capacity - 1)
            tail = -1;
        queue[++tail] = value;
        items++;
    }

    public int removeHead() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int temp = queue[head++];
        head %= capacity; // if (head == capacity) head = 0;
        items--;
        return temp;
    }


    public int removeTail() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int temp = queue[tail--];
        if (tail == 0) tail = capacity - 1;
        items--;
        return temp;
    }


    public int peek() {
        return queue[head];
    }

    public void printDeque() {
        if (head <= tail) {
            for (int i = head; i <= tail; i++) {
                System.out.print(queue[i] + " ");
            }
        } else
            for (int i = head; i < capacity; i++) {
                System.out.print(queue[i] + " ");
            }
            for (int i = 0; i <= tail; i++) {
                System.out.print(queue[i] + " ");
            }

    }



    //t[h.........]
    // [h||||||t..]
    // [....h||t..]
    // [|t..h|||||]
    // [|t..................]
}
