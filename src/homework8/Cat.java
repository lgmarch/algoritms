package homework8;

public class Cat<K extends Comparable<K>, V> implements Comparable<Cat<K, V>> {
    K key;
    V value;

    public Cat(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Cat<K, V> cat) {
        return this.key.compareTo(cat.key);
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
