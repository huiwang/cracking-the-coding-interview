package geek.math;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MathLesson15_DijkstraTest {

    MathLesson15_Dijkstra dijkstra;

    @Before
    public void setUp() throws Exception {
        dijkstra = new MathLesson15_Dijkstra(10);
        /**
         * append(new Node(0, new int[]{1, 8}))
         *                 .append(new Node(1, new int[]{0, 6, 7, 9}))
         *                 .append(new Node(2, new int[]{4, 9}))
         *                 .append(new Node(3, new int[]{5}))
         *                 .append(new Node(4, new int[]{2, 6, 7}))
         *                 .append(new Node(5, new int[]{3}))
         *                 .append(new Node(6, new int[]{1, 4}))
         *                 .append(new Node(7, new int[]{1, 4, 8, 9}))
         *                 .append(new Node(8, new int[]{0, 7}))
         *                 .append(new Node(9, new int[]{1, 2, 7}));
         */
        dijkstra.vertices[0] = DijkstraVertex.parse("0(1, 0.3)(8, 0.1)");
        dijkstra.vertices[1] = DijkstraVertex.parse("1(0, 0.2)(6, 0.4)(7, 0.3)(9, 0.1)");
        dijkstra.vertices[2] = DijkstraVertex.parse("2(4, 0.5)");
        dijkstra.vertices[3] = DijkstraVertex.parse("3(5, 1)");
        dijkstra.vertices[4] = DijkstraVertex.parse("4(2,0.4)(6,0.6)(7,0.3)");
        dijkstra.vertices[5] = DijkstraVertex.parse("5(3,1)");
        dijkstra.vertices[6] = DijkstraVertex.parse("6(4,0.3)");
        dijkstra.vertices[7] = DijkstraVertex.parse("7(1, 0.3)(4, 0.1)(8, 0.15)(9, 0.05)");
        dijkstra.vertices[8] = DijkstraVertex.parse("8(0, 0.1)(7, 0.15)");
        dijkstra.vertices[9] = DijkstraVertex.parse("9(1, 0.1)(2, 0.1)(7, 0.05)");
    }

    @Test
    public void parse() {
        DijkstraVertex v = new DijkstraVertex(0);
        DijkstraVertex v1 = DijkstraVertex.parse("0");
        assertEquals(v, v1);
        v.addConnection(1, 0.5);
        DijkstraVertex v2 = DijkstraVertex.parse("0(1, 0.5)");
        assertEquals(v, v2);
        DijkstraVertex v3 = DijkstraVertex.parse("0(1,0.5)(3,0.3)(9,0.2)(5,0.1)");
        Map<Integer, Double> newConnections = new HashMap<>();
        newConnections.put(1, 0.5);
        newConnections.put(3, 0.3);
        newConnections.put(9, 0.2);
        newConnections.put(5, 0.1);
        v.setConnections(newConnections);
        assertEquals(v, v3);
    }

    @Test
    public void getBestPath() {
        assertEquals(0.0, dijkstra.getBestPath(1, 1), 0.0001);
        assertEquals(Double.NEGATIVE_INFINITY, dijkstra.getBestPath(0, 3), 0.0001);
        assertEquals(Double.NEGATIVE_INFINITY, dijkstra.getBestPath(2, 5), 0.0001);
        assertEquals(0.3, dijkstra.getBestPath(0, 1), 0.0001);
        assertEquals(0.2, dijkstra.getBestPath(1, 0), 0.0001);
        assertEquals(0.25, dijkstra.getBestPath(1, 4), 0.0001);
        assertEquals(0.45, dijkstra.getBestPath(4, 1), 0.0001);
        assertEquals(0.35, dijkstra.getBestPath(0, 4), 0.0001);
        assertEquals(0.55, dijkstra.getBestPath(4, 0), 0.0001);
        assertEquals(0.3, dijkstra.getBestPath(0, 9), 0.0001);
        assertEquals(0.3, dijkstra.getBestPath(9, 0), 0.0001);
        assertEquals(0.2, dijkstra.getBestPath(1, 2), 0.0001);
        assertEquals(0.95, dijkstra.getBestPath(2, 1), 0.0001);
        assertEquals(0.65, dijkstra.getBestPath(6, 9), 0.0001);
        assertEquals(0.5, dijkstra.getBestPath(9, 6), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidArguments() {
        dijkstra.getBestPath(0, dijkstra.size);
    }
}