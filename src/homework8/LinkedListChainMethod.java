package homework8;

import java.util.LinkedList;

public class LinkedListChainMethod<K, V> {
    private int capacity;
    private int size = 0;

    private LinkedList<Cat>[] hashList;

    public LinkedListChainMethod(int capacity) {
        this.capacity = capacity;
        hashList = new LinkedList[capacity];
        for (int i = 0; i < hashList.length; i++) {
            hashList[i] = new LinkedList<>();
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < hashList.length; i++) {
            str.append(i).append(": ");
            for (int j = 0; j < hashList[i].size(); j++) {
                Cat cat = hashList[i].get(j);
                str.append(cat.key).append(", ").append(cat.value).append("; ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public int hashCode(K key) {
        return (key.hashCode()& 0x7fffffff) % capacity;
    }

    public Cat put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Error! Key is null!");
        }
        int hashCode = hashCode(key);
        for (Cat cat : hashList[hashCode]) {
            if (key.equals(cat.key)) {
                cat.value = value;
                return cat;
            }
        }
        Cat cat = new Cat((Comparable) key, value);
        hashList[hashCode].add(cat);
        size++;
        return cat;
    }

    public Cat get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Error! Key is null!");
        }
        int hashCode = hashCode(key);
        for (Cat cat : hashList[hashCode]) {
            if (key.equals(cat.key)) {
                return cat;
            }
        }
        return null;
    }
}
