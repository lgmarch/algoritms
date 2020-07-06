package lesson3;

import java.util.NoSuchElementException;

public class Stack {
    private String[] stack;
    private int capacity;
    private int head; //указатель на последний элемент

    public Stack(int capacity) {
        this.capacity = capacity;
        this.stack = new String[capacity];
        this.head = -1;
    }

    public boolean isEmpty() {
        return this.head == -1;
    }

    public boolean isFull() {
        return this.head == this.capacity - 1;
    }

    public void push(String value) {
        if (isFull()) {
            capacity *= 2;
            String[] newStack = new String[capacity];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++head] = value;
    }

    public String pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return stack[head--];
    }

    public String peek() {
        return stack[head];
    }
}
