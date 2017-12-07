package treegraph;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _04_01_RouteBetweenNodesTest {

    @Test
    public void withTwoVertex() {
        Digraph digraph = new Digraph(2);
        digraph.addEdge(0, 1);
        _04_01_RouteBetweenNodes routeBetweenNodes = new _04_01_RouteBetweenNodes(digraph);
        assertTrue(routeBetweenNodes.hasRoute(0, 1));
        assertFalse(routeBetweenNodes.hasRoute(1, 0));
    }

    @Test
    public void withMoreVertex() {
        Digraph digraph = new Digraph(5);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 2);
        digraph.addEdge(2, 3);
        digraph.addEdge(2, 4);
        _04_01_RouteBetweenNodes routeBetweenNodes = new _04_01_RouteBetweenNodes(digraph);
        assertTrue(routeBetweenNodes.hasRoute(0, 4));
    }

    @Test
    public void withCycle() {
        Digraph digraph = new Digraph(3);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 2);
        digraph.addEdge(2, 0);
        _04_01_RouteBetweenNodes routeBetweenNodes = new _04_01_RouteBetweenNodes(digraph);
        assertTrue(routeBetweenNodes.hasRoute(0, 1));
        assertTrue(routeBetweenNodes.hasRoute(0, 2));
    }
}