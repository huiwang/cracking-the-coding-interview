package geek.math;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathLesson15_Dijkstra {

    DijkstraVertex[] vertices;

    public double getBestPaTH(int a, int b) {
        return 0;
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

    private static Pattern pattern = Pattern.compile("^(\\\\d+)\\\\s*(\\\\(.*\\\\))?$");
    private static Pattern connection_pattern = Pattern.compile("(\\\\(\\\\s*(\\\\d+)\\\\s*,\\\\s*([0-9]*[.]?[0-9]+)\\\\s*\\\\)){1,}");

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
        }
        return null;
    }
}