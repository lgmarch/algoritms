package graph;

import java.util.*;

public class Graph<T> {
    private final List<Vertex<T>> graph;
    private int nodes;
    private int links;

    public Graph() {
        this.graph = new ArrayList<>();
    }

    public Vertex<T> addVertex(Vertex<T> first) {
        graph.add(first);
        nodes++;
        return first;
    }

    public void deleteVertex(Vertex<T> vertex) {
        graph.remove(vertex);
        nodes--;
    }

    public Vertex<T> findVertex(Vertex<T> vertex) {
        int index = graph.indexOf(vertex);
        if (index < 0) return null;
        else return graph.get(index);
    }

    public Vertex<T> addOrDefault(Vertex<T> vertex) {
        Vertex<T> result = findVertex(vertex);
        if (result == null) {
            result = addVertex(vertex);
        }
        return result;
    }

    public void addLink(Vertex<T> first, Vertex<T> second) {
        if (!first.equals(second)) {
            Vertex<T> firstNode = addOrDefault(first);
            Vertex<T> secondNode = addOrDefault(second);
            firstNode.addLink(secondNode);
            secondNode.addLink(firstNode);
            links++;
        }
    }

    public void removeLink(Vertex<T> first, Vertex<T> second) {
        if (isContain(first) && isContain(second)) {
            Vertex<T> firstNode = findVertex(first);
            Vertex<T> secondNode = findVertex(second);
            if (firstNode.getLinks().contains(secondNode)) links--;
            firstNode.removeLink(secondNode);
            secondNode.removeLink(firstNode);
        }
    }

    private void removeVertex(Vertex<T> vertex) {
        if (graph.contains(vertex)) {
            removeLinks(findVertex(vertex));
            deleteVertex(vertex);
        }
    }

    private void removeLinks(Vertex<T> vertex) {
        vertex.getLinks().forEach(node->{
            node.removeLink(vertex);
            links--;
        });
    }

    private void removeAll() {
        links = 0;
        nodes = 0;
        graph.clear();
    }

    public boolean isContain(Vertex<T> vertex) {
        return graph.contains(vertex);
    }

    public void dfs(Vertex<T> startVertex) {
        if (startVertex == null) throw new IllegalArgumentException("Invalid value");

        Stack<Vertex<T>> stack = new Stack<>();
        Set<Vertex<T>> visited = new HashSet<>();
        stack.add(startVertex);
        Vertex<T> current;

        while (!stack.isEmpty()) {
            current = stack.pop();
            visited.add(current);
            System.out.print(current);
            for (Vertex<T> vertex: current.getLinks()) {
                if (!visited.contains(vertex)) {
                    stack.add(vertex);
                }
            }
        }
    }

    public void bfs(check<Vertex<T>> check, List<Vertex<T>> vertexList) {
        LinkedList<Vertex<T>> queue = new LinkedList<>(vertexList);
        Set<Vertex<T>> visited = new HashSet<>();
        Vertex<T> current;

        while (!queue.isEmpty()) {
            current = queue.pollFirst();
            visited.add(current);
            System.out.print(current);
            check.check(current);
            for (Vertex<T> v : current.getLinks()) {
                if (!visited.contains(v)) {
                    queue.addLast(v);
                }
            }
        }
    }

    public int findMinLength(Vertex<T> first, Vertex<T> second) {
        if(isContain(first) && isContain(second)) {
            if (!first.equals(second)) {
                Map<Vertex<T>, Integer> map = new HashMap<>();
                List<Vertex<T>> list = new ArrayList<>();
                list.add(findVertex(first));

                int[] deep = {0};
                bfs(vertex->{
                    deep[0] = map.getOrDefault(vertex, 0);
                    if (vertex.getValue().equals(second.getValue())) {
                        return true;
                    } else {
                        for (Vertex<T> v : vertex.getLinks()) {
                            if (!map.containsKey(v)) {
                                map.put(v, deep[0] + 1);
                            }
                        }
                        deep[0] = -1;
                        return false;
                    }
                }, list);
                return deep[0];
            } else return 0;
        } else return -1;
    }

}
