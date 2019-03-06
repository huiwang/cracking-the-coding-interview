package geek.math;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MathLesson15_Dijkstra {

    int size = 0;
    DijkstraVertex[] vertices;

    public MathLesson15_Dijkstra(int size) {
        this.size = size;
        vertices = new DijkstraVertex[size];
    }

    public double getBestPath(int a, int b) {
        if (a < 0 || b < 0 || a >= vertices.length || b >= vertices.length) {
            throw new IllegalArgumentException("source or target out of range");
        }
        if (vertices[a] == null || vertices[b] == null) {
            throw new IllegalArgumentException("source or target does not exist");
        }
        if (a == b) {
            System.out.println("The shortest path from " + a + " to " + b + ": 0");
            return 0.0;
        }
        Set<DijkstraVertex> set = new HashSet<>();
        Map<Integer, Double> dist = new HashMap<>();
        Map<Integer, Integer> prev = new HashMap<>();
        for (DijkstraVertex v : vertices) {
            dist.put(v.id, Double.POSITIVE_INFINITY);
            prev.put(v.id, Integer.MAX_VALUE);
            set.add(v);
        }
        dist.put(a, 0.0);
        while (!set.isEmpty()) {
            DijkstraVertex shortest = getShortestVertex(set, dist);
            if (shortest == null) {
                // cannot find connected vertex
                break;
            }
            set.remove(shortest);
            Integer id = shortest.id;
            Double p = dist.get(id);
            if (p == Double.POSITIVE_INFINITY) {
                break;
            }
            if (shortest.connections != null) {
                shortest.connections.forEach((k,v) -> {
                    Double distance = p + v;
                    if (distance < dist.get(k)) {
                        dist.put(k, distance);
                        prev.put(k, id);
                    }
                });
            }
        }
        System.out.println("The shortest path from " + a + " to " + b + ":");
        if (dist.get(b) != Double.POSITIVE_INFINITY) {
            Double result =  dist.get(b);
            List<DijkstraVertex> path = getPath(a, b, prev);
            path.forEach(v -> System.out.print(String.format("%d(%.2f) ", v.id, dist.get(v.id))));
            System.out.print("\n");
            return result;
        } else {
            System.out.println("None");
            return Double.NEGATIVE_INFINITY;
        }
    }

    private List<DijkstraVertex> getPath(int a, int b, Map<Integer, Integer> prev) {
        // assume a and b are valid here as it is a private method
        List<DijkstraVertex> path = new ArrayList<>();
        int curr = b;
        while (curr != Integer.MAX_VALUE) {
            path.add(vertices[curr]);
            curr = prev.get(curr);
        }
        Collections.reverse(path);
        return path;
    }

    private static DijkstraVertex getShortestVertex(Collection<DijkstraVertex> c, Map<Integer, Double> dist) {
        if (c == null) {
            return null;
        }
        Double min = Double.POSITIVE_INFINITY;
        DijkstraVertex chosen = null;
        for (DijkstraVertex v : c) {
            Double d = dist.get(v.id);
            if (d < min) {
                chosen = v;
                min = d;
            }
        }
        return chosen;
    }
}

class DijkstraVertex {
    int id;
    Map<Integer, Double> connections;

    public DijkstraVertex(int id) {
        this.id = id;
    }

    public void addConnection(int id, double weight) {
        if (connections == null) {
            connections = new HashMap<>();
        }
        connections.put(id, weight);
    }

    public void setConnections(Map<Integer, Double> connections) {
        this.connections = connections;
    }

    private static Pattern pattern = Pattern.compile("^(\\d+)\\s*(\\(.*\\))?$");
    private static Pattern connection_pattern = Pattern.compile("\\s*(\\(\\s*(\\d+)\\s*,\\s*([0-9]*[.]?[0-9]+)\\s*\\))\\s*");

    public static DijkstraVertex parse(String content) {
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            int id = Integer.valueOf(matcher.group(1));
            String connectionParts = matcher.group(2);
            DijkstraVertex v = new DijkstraVertex(id);
            if (connectionParts != null) {
                Matcher m2 = connection_pattern.matcher(connectionParts);
                while (m2.find()) {
                    int vid = Integer.valueOf(m2.group(2));
                    double w = Double.valueOf(m2.group(3));
                    v.addConnection(vid, w);
                }
            }
            return v;
        } else {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DijkstraVertex that = (DijkstraVertex) o;
        return id == that.id &&
                Objects.equals(connections, that.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, connections);
    }
}