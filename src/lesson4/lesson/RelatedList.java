package lesson4.lesson;

import java.util.Objects;

public class RelatedList {
    private class Node {
        Cat cat;
        Node next;

        public Node(Cat cat) {
            this.cat = cat;
        }

        @Override
        public String toString() {
            return cat.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return cat.equals(node.cat);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cat);
        }
    }

    private Node head;
    private int size;

    public RelatedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(Cat c) {
        Node n = new Node(c);
        n.next = head;
        head = n;
        size++;
    }

    public Cat pop() {
        if (isEmpty()) return null;
        Cat temp = head.cat;
        head = head.next;
        size--;
        return temp;
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
        while (!current.cat.equals(c)) {
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
        while (!current.cat.equals(c)) {
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
