package lesson3;

import java.util.NoSuchElementException;

public class PriorityQueue<T extends ElemForQueue> {
    private T[] arr;
    private int capacity;
    private int head; //указатель на последний элемент

    public PriorityQueue(int capacity, T[] arr) {
        this.capacity = capacity;
        this.head = -1;
        this.arr = arr;
    }

    public boolean isEmpty() {
        return this.head == -1;
    }

    public boolean isFull() {
        return this.head == this.capacity - 1;
    }

    public void push(T value) {
        if (isFull()) {
            capacity *= 2;
//            T[] newArr = createArr(capacity);
//            System.arraycopy(arr, 0, newArr, 0, arr.length);
//            arr = newArr;
        }
        arr[++head] = value;
        MaxQueue.max(arr, head);
    }

    public void printArr(){
        for (int j = 0; j <= head; j++) {
            System.out.print(" * " + arr[j].toString() + " ");
        }
        System.out.println();
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return arr[head--];
    }

    public T peek() {
        return arr[head];
    }
}
