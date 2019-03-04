package geek.math;

import java.util.*;

public class MathLesson14_Graph {

    public MathLesson14_Graph(int size) {
        nodes = new Node[size];
        this.size = size;
    }

    public MathLesson14_Graph() {
        init(10, 15);
    }

    Node[] nodes;

    int size;

    public void init(int size, int relationCount) {
        nodes = new Node[size];
        this.size = size;
        for (int i = 0; i < size; ++i) {
            nodes[i] = new Node(i);
        }
        Random random = new Random();
        for (int i = 0; i < relationCount; ++i) {
            int idA = random.nextInt(size);
            int idB = random.nextInt(size);
            if (idA == idB) {
                continue;
            }
            Node nodeA = nodes[idA];
            Node nodeB = nodes[idB];
            nodeA.friends.add(idB);
            nodeB.friends.add(idA);
        }
    }

    public MathLesson14_Graph append(Node user) {
        if (user == null || user.userId < 0) {
            throw new IllegalArgumentException("illegal user");
        }
        if (user.userId >= this.size) {
            throw new IllegalStateException("limit on capability");
        }
        nodes[user.userId] = user;
        return this;
    }

    public List<Integer[]> bfs(int userId) {
        if (userId > nodes.length) {
            throw new IllegalArgumentException(userId + " is out of range");
        }
        List<Integer[]> result = new ArrayList<>();
        Node user = nodes[userId];
        System.out.println("Get friends of user " + userId);
        Queue<Integer> people = new LinkedList<>();
        people.offer(userId);
        // record each visited user's degree
        Map<Integer, Integer> degrees = new HashMap<>();
        degrees.put(userId, 0);
        List<Integer> friends = new ArrayList<>();
        int lastDegree = 1;
        while (!people.isEmpty()) {
            Node curr = nodes[people.poll()];
            // all nodes under this node will have the same degree, adding by 1 from the current node
            int degree = degrees.get(curr.userId) + 1;
            if (degree > lastDegree && !friends.isEmpty()) {
                result.add(friends.toArray(new Integer[friends.size()]));
                System.out.println("Friends of degree #" + lastDegree + ": " + friends.toString());
                friends.clear();
                lastDegree = degree;
            }
            curr.friends.stream().filter(id -> !degrees.containsKey(id)).forEach(id -> {
                degrees.put(id, degree);
                people.offer(id);
                friends.add(id);
            });
        }
        if (!friends.isEmpty()) {
            result.add(friends.toArray(new Integer[friends.size()]));
            System.out.println("Friends of degree #" + lastDegree + ": " + friends.toString());
        }
        return result;
    }

    @Override
    public String toString() {
        return "MathLesson14_Graph{" +
                "nodes=" + Arrays.deepToString(nodes) +
                ", size=" + size +
                '}';
    }
}

class Node {
    public int userId;
    public HashSet<Integer> friends = null;

    public Node(int id) {
        this.userId = id;
        this.friends = new HashSet<>();
    }

    public Node(int userId, int[] friends) {
        this.userId = userId;
        this.friends = new HashSet<>();
        for (int i : friends) {
            this.friends.add(i);
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "userId=" + userId +
                ", friends=" + friends +
                '}';
    }
}