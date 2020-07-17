package graph;

public class MainGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();

        Vertex ver1 = new Vertex(1);
        Vertex ver2 = new Vertex(2);
        Vertex ver3 = new Vertex(3);
        Vertex ver4 = new Vertex(4);
        Vertex ver5 = new Vertex(5);

        graph.addLink(ver1, ver2);
        graph.addLink(ver1, ver5);
        graph.addLink(ver1, ver3);
        graph.addLink(ver5, ver4);
        graph.addLink(ver5, ver2);

//        graph.bfs(ver1);
//        System.out.println();
        graph.dfs(ver1);
        System.out.println();

        int length = graph.findMinLength(ver1, ver4);
        System.out.println(length);

        System.out.println("Кратчайшее расстояние между двумя вершинами: ");
        if (length > 0) {
            System.out.println(String.format(" равно = %s", length));
        } else if (length == 0) {
            System.out.println(" A == B");
        } else {
            System.out.println(String.format("A = %s %s", ver1, graph.isContain(ver1) ? "содержится в графе" : " не содержится в графе"));
            System.out.println(String.format("B = %s %s", ver4, graph.isContain(ver4) ? "содержится в графе" : " не содержится в графе"));
        }
    }
}
