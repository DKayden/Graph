package graphNode;

import java.util.*;
public class demo {
    private Map<Integer, List<Integer>> adjacencyList;

    public demo() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

//    public int[] getVertices() {
//        return ;
//    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public void removeVertex(int vertex) {
        adjacencyList.values().forEach(e -> e.remove(vertex));
        adjacencyList.remove(vertex);
    }

    public void removeEdge(int source, int destination) {
        List<Integer> sourceList = adjacencyList.get(source);
        List<Integer> destinationList = adjacencyList.get(destination);

        if (sourceList != null) {
            sourceList.remove(Integer.valueOf(destination));
        }

        if (destinationList != null) {
            destinationList.remove(Integer.valueOf(source));
        }
    }

    public List<Integer> getAdjacentVertices(int vertex) {
        return adjacencyList.get(vertex);
    }

}
