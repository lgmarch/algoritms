package lesson4.home;

import lesson4.lesson.Cat;

public class DoubleList {
    private Link head;
    private Link tail;

    public DoubleList() {
        this.head = null;
        this.tail = null;
    }

    public DoubleListIter getIterator() {
        return new DoubleListIter(this);
    }

    public Link getHead() {
        return head;
    }

    public Link getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertHead(Cat cat){
        Link link = new Link(cat);
        if (isEmpty()) tail = link;
        else head.prev = link;
        link.next = head;
        head = link;
    }

    public Link deleteHead(){
        if (isEmpty()) return null;
        Link delElem = head;
        if (head.next == null) tail = null;
        else delElem.prev = null;
        head = head.next;
        return delElem;
    }

    public void insertTail(Cat cat){
        Link link = new Link(cat);
        if (isEmpty()) head = link;
        else {
            link.prev = tail;
            tail.next = link;
        }
        tail = link;
    }

    public Link deleteTail() {
        Link delElem = tail;
        if (isEmpty()) return null;
        if (head.next == null) return head = null;
        else tail.prev.next = null;
        tail = tail.prev;

        return delElem;
    }

    public Link findLink(Cat cat) {
        if (isEmpty()) return null;

        Link current = head;
        while (!current.cat.equals(cat)) {
            current = current.next;
            if (current == null) return null;
        }
        return current;
    }

    public Link insertAfter(Cat afterCat, Cat insCat) {
        Link current;
        if ((current = findLink(afterCat)) == null) return null;

        Link link = new Link(insCat);
        if (current == tail) {
            link.next = null;//TODO
            tail = link;
        }
        else {
            link.next = current.next;
            current.next.prev = link;
        }
        link.prev = current;
        current.next = link;

        return link;
    }

    public Link insertBefore(Cat beforeCat, Cat insCat){
        Link current;
        if ((current = findLink(beforeCat)) == null) return null;

        Link link = new Link(insCat);
        if (current == head) {
            head = link;
            link.prev = null;
        }
        else {
            link.prev = current.prev;
            current.prev.next = link;
        }
        link.next = current;
        current.prev = link;

        return link;
    }

    public boolean deleteElem(Cat cat) {
        if (isEmpty()) return false;
        Link current;
        if ((current = findLink(cat)) == null) return false;

        if (current.next == null) {
            deleteTail();
            return true;
        }
        if (current.prev == null) {
            deleteHead();
            return true;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Link current = head;
        while(current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
        return str.toString();
    }
}
