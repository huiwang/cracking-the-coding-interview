package geek.math;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MathLesson14_GraphTest {

    private MathLesson14_Graph userGraph;

    @Before
    public void setUp() throws Exception {
        userGraph = new MathLesson14_Graph(10);
        userGraph.append(new Node(0, new int[]{1, 8}))
                .append(new Node(1, new int[]{0, 6, 7, 9}))
                .append(new Node(2, new int[]{4, 9}))
                .append(new Node(3, new int[]{5}))
                .append(new Node(4, new int[]{2, 6, 7}))
                .append(new Node(5, new int[]{3}))
                .append(new Node(6, new int[]{1, 4}))
                .append(new Node(7, new int[]{1, 4, 8, 9}))
                .append(new Node(8, new int[]{0, 7}))
                .append(new Node(9, new int[]{1, 2, 7}));
        System.out.println(userGraph.toString());
    }

    @Test
    public void testBfs() {
        List<Integer[]> friendOfDegree = userGraph.bfs(0);
        System.out.println("friend list of user 0: ");
        friendOfDegree.forEach(d -> System.out.println(Arrays.deepToString(d)));
        assertEquals(3, friendOfDegree.size());
        friendOfDegree = userGraph.bfs(3);
        assertEquals(1, friendOfDegree.size());
    }

    @Test
    public void randomBfs() {
        MathLesson14_Graph r = new MathLesson14_Graph();
        System.out.println(r.toString());
        List<Integer[]> f = r.bfs(1);
    }

    @Test
    public void distance() {
        assertEquals(0, userGraph.distance(0, 0));
        assertEquals(1, userGraph.distance(0, 1));
        assertEquals(2, userGraph.distance(0, 6));
        assertEquals(3, userGraph.distance(0, 4));
        assertEquals(-1, userGraph.distance(0, 3));
    }

    public int lengthOfLongestSubstring(String s) {
        if ( s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        Set<Character> set = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if (set.contains(c)) {
                int count = queue.size();
                if (count > max) {
                    max = count;
                }
                while (queue.remove() != c) {}
                queue.add(c);
            } else {
                set.add(c);
                queue.add(c);
            }
        }
        return Math.max(max, queue.size());
    }
}