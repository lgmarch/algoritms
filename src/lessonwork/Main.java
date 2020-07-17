package lessonwork;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        System.out.println("Обход в глубину:");
        graph.depthTraverse();
        System.out.println("Обход в ширину:");
        graph.widthTraverse();
    }
}
