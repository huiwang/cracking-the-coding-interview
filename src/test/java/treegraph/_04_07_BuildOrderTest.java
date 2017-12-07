package treegraph;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class _04_07_BuildOrderTest {

    private _04_07_BuildOrder s = new _04_07_BuildOrder();

    @Test
    public void withOneProject() {
        Digraph digraph = new Digraph(1);
        assertEquals(Collections.singletonList(0), s.findBuildOrder(digraph));
    }

    @Test
    public void withTwoProjects() {
        Digraph digraph = new Digraph(2);
        digraph.addEdge(1, 0);
        assertEquals(Arrays.asList(0, 1), s.findBuildOrder(digraph));
    }

    @Test
    public void withMoreProjects() {
        Digraph digraph = new Digraph(4);
        digraph.addEdge(3, 1);
        digraph.addEdge(2, 1);
        digraph.addEdge(1, 0);
        assertEquals(Arrays.asList(0, 1, 2, 3), s.findBuildOrder(digraph));
    }

    @Test
    public void withTwoGroups() {
        Digraph digraph = new Digraph(4);
        digraph.addEdge(1, 0);
        digraph.addEdge(3, 2);
        assertEquals(Arrays.asList(0, 1, 2, 3), s.findBuildOrder(digraph));
    }

    @Test
    public void withCycle() {
        Digraph digraph = new Digraph(3);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 2);
        digraph.addEdge(2, 0);
        assertNull(s.findBuildOrder(digraph));
    }
}