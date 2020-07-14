package homework;

public class Node <K, L extends Comparable<L>> implements Comparable<Node<K, L>>{
    private K object;
    private L id;

    private Node<K, L> left;
    private Node<K, L> right;

    public Node(K object, L id) {
        this.object = object;
        this.id = id;
    }

    public K getObject() {
        return object;
    }

    public void setObject(K object) {
        this.object = object;
    }

    public L getId() {
        return id;
    }

    public void setId(L id) {
        this.id = id;
    }

    public Node<K, L> getLeft() {
        return left;
    }

    public void setLeft(Node<K, L> left) {
        this.left = left;
    }

    public Node<K, L> getRight() {
        return right;
    }

    public void setRight(Node<K, L> right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node<K, L> o) {
        return this.getId().compareTo(o.getId());
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("[");
        strBuilder.append(id.toString()).append(object.toString()).append("]");
        return strBuilder.toString();
    }
}
