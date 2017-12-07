package treegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Digraph {

    private final List<List<Integer>> adjacent;

    Digraph(int vertexCount) {
        adjacent = new ArrayList<>(vertexCount);
        for (int i = 0; i < vertexCount; i++) {
            adjacent.add(new LinkedList<>());
        }
    }

    void addEdge(int from, int to) {
        adjacent.get(from).add(to);
    }

    Iterable<Integer> adjacent(int v) {
        return adjacent.get(v);
    }

    int size() {
        return adjacent.size();
    }

}
