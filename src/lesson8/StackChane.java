package lesson8;

import java.util.NoSuchElementException;

public class StackChane {
    private int capacity;
    private int[] stack;
    private int head;

    public StackChane(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.head = -1;
    }

    public boolean isEmpty() {
        return this.head == -1;
    }

    public boolean isFull() {
        return this.head == this.capacity - 1;
    }

    @Override
    public String toString() {
        if (head == -1)
            return "null only";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= head; i++) {
            sb.append(stack[i]);
            if (i < head) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void push(int value) {
        if (isFull()) {
            capacity *= 2;
            int[] newStack = new int[capacity];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++head] = value;
    }

    public int pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return stack[head--];
    }

    public int peek() {
        return stack[head];
    }
}
