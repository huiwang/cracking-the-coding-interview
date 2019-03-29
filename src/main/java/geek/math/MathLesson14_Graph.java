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
        StringBuilder sb = new StringBuilder("MathLesson14_Graph size : " + size + "\n");
        for (Node node : nodes) {
            sb.append(node.toString()).append("\n");
        }
        return sb.toString();
    }

    public int distance(int a, int b) {
        if (a >= this.size || b >= this.size) {
            return -1;
        }
        if (a == b) {
            return 0;
        }
        Map<Integer, Integer> degreeMapA = new HashMap<>();
        degreeMapA.put(a, 0);
        Map<Integer, Integer> degreeMapB = new HashMap<>();
        degreeMapB.put(b, 0);
        Queue<Integer> queueA = new LinkedList<>();
        Queue<Integer> queueB = new LinkedList<>();
        queueA.offer(a);
        queueB.offer(b);
        final int MAX_DEGREE = 10;
        int degreeA = 0, degreeB = 0;
        while ((degreeA + degreeB) < MAX_DEGREE && (!queueA.isEmpty() || !queueB.isEmpty())) {
            degreeA = getNextDegreeFriends(queueA, degreeA, degreeMapA);
            if (!Collections.disjoint(degreeMapA.keySet(), degreeMapB.keySet())) {
                return degreeA + degreeB;
            }
            degreeB = getNextDegreeFriends(queueB, degreeB, degreeMapB);
            if (!Collections.disjoint(degreeMapA.keySet(), degreeMapB.keySet())) {
                return degreeA + degreeB;
            }
        }
        return -1;
    }

    private int getNextDegreeFriends(Queue<Integer> queue, int degree, Map<Integer, Integer> map) {
        int count = queue.size();
        if (count == 0) {
            return degree;
        }
        int newDegree = degree;
        for (int i = 0; i < count; ++i) {
            int id = queue.poll();
            Node node = nodes[id];
            if (node.friends != null) {
                Iterator<Integer> iter = node.friends.iterator();
                while (iter.hasNext()) {
                    int uid = iter.next();
                    if (map.get(uid) != null) {
                        continue;
                    } else {
                        newDegree = degree + 1;
                        queue.offer(uid);
                        map.put(uid, newDegree);
                    }
                };
            }
        }
        return newDegree;
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