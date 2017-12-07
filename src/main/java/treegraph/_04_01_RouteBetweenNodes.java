package treegraph;

/**
 * Given a directed graph, design an algorithm to find out whether
 * there is a route between two nodes.
 */
class _04_01_RouteBetweenNodes {

    private final Digraph digraph;
    private boolean[] visited;

    _04_01_RouteBetweenNodes(Digraph digraph) {
        this.digraph = digraph;
    }

    boolean hasRoute(int source, int target) {
        visited = new boolean[digraph.size()];
        dfs(source);
        return visited[target];
    }

    private void dfs(int node) {
        visited[node] = true;
        for (int n : digraph.adjacent(node)) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }
}
