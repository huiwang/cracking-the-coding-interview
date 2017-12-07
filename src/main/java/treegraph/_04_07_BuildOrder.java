package treegraph;

import java.util.LinkedList;
import java.util.List;

/**
 * You are given a list of projects and a list of dependencies
 * (which is a list of pairs of projects, where the second project is dependent on the first project).
 * All of a project's dependencies must be built before the project is.
 * Find a build order that will allow the projects to be built.
 * If there is no valid build order, return an error.
 */
class _04_07_BuildOrder {

    private boolean onStack[];
    private boolean visited[];
    private Digraph digraph;
    private LinkedList<Integer> topological = new LinkedList<>();

    List<Integer> findBuildOrder(Digraph digraph) {
        this.digraph = digraph;
        onStack = new boolean[digraph.size()];
        visited = new boolean[digraph.size()];
        for (int i = 0; i < digraph.size(); i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        if (topological.size() != digraph.size()) return null;
        return topological;
    }

    private void dfs(int v) {
        onStack[v] = true;
        visited[v] = true;
        for (Integer adj : digraph.adjacent(v)) {
            if (visited[adj] && onStack[adj]) {
                return;
            }
            if (!visited[adj]) {
                dfs(adj);
            }
        }
        onStack[v] = false;
        topological.add(v);
    }
}
