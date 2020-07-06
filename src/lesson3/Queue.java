package lesson3;

import java.util.NoSuchElementException;

public class Queue {
    protected int capacity;
    protected int[] arr;
    protected int items;
    protected int head;
    protected int tail;

    public Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
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

    public void put(int value) {
        if (isFull()) {
            increaseCapacity();
        }
        if (tail == capacity - 1)
            tail = -1;
        arr[++tail] = value;
        items++;
    }

    public int get() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int temp = arr[head++];
        head %= capacity; // if (head == capacity) head = 0;
        items--;
        return temp;
    }

    public void increaseCapacity(){
        capacity *= 2;
        int[] newQ = new int[capacity];

        if (tail >= head) {
            System.arraycopy(arr, 0, newQ, 0, arr.length);
        } else {
            System.arraycopy(arr, 0, newQ, 0, tail + 1);
            System.arraycopy(arr, head, newQ, capacity - (arr.length - head),
                    arr.length - head - 1);
        }
        arr = newQ;
    }

    public int peek() {
        return arr[head];
    }
}
