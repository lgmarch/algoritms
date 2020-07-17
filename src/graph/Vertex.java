package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    private T value;
    private List<Vertex<T>> links;

    public Vertex(T value) {
        this.value = value;
        this.links = new ArrayList<>();
    }

    public List<Vertex<T>> getLinks() {
        return links;
    }

    @Override
    public boolean equals(Object element) {
        if (element instanceof Vertex) {
            return this.value.equals(((Vertex<T>)element).getValue());
        } else {
            return false;
        }
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void addLink(Vertex<T> element) {
        if(!this.links.contains(element)) {
            this.links.add(element);
        }
    }

    public void removeLink(Vertex<T> element) {
        this.links.remove(element);
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}

