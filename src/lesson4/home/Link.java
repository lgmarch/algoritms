package lesson4.home;

import lesson4.lesson.Cat;

public class Link {
    protected Cat cat;
    protected Link next;
    protected Link prev;

    public Link(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return cat.toString();
    }
}
