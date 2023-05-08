import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

class Vertex {
    private final String station;

    Vertex(final String station) {
        this.station = station;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Vertex vertex = (Vertex) o;
        return Objects.equals(station, vertex.station);
    }

    @Override
    public int hashCode() {
        return Objects.hash(station);
    }

    @Override
    public String
    toString() {
        return "Vertex{" +
                "station='" + station + '\'' +
                '}';
    }

    public String getStation() {
        return station;
    }
}


class Graph {
    private final Map<Vertex, List<Vertex>> adjVertices = new HashMap<>();

    public void addVertex(final String station) {
        adjVertices.putIfAbsent(new Vertex(station), new ArrayList<>());
    }

    // 양방향
    public void addEdge(final String from, final String to) {
        final Vertex fromVertex = new Vertex(from);
        final Vertex toVertex = new Vertex(to);
        adjVertices.get(fromVertex).add(toVertex);
        adjVertices.get(toVertex).add(fromVertex);
    }

    public void removeEdge(final String from, final String to) {
        final Vertex fromVertex = new Vertex(from);
        final Vertex toVertex = new Vertex(to);
        final List<Vertex> adjFromVertex = adjVertices.get(fromVertex);
        final List<Vertex> adjToVertex = adjVertices.get(toVertex);
        if (adjFromVertex != null) {
            adjFromVertex.remove(toVertex);
        }
        if (adjToVertex != null) {
            adjToVertex.remove(fromVertex);
        }
    }

    public List<Vertex> getAdjVertices(final String station) {
        return adjVertices.get(new Vertex(station));
    }
}


class Solution {
    public static void main(String[] args) {
        final Graph graph = initGraph();
        final List<Vertex> 잠실새내 = graph.getAdjVertices("잠실새내");
        System.out.println(잠실새내);

        final List<Vertex> 잠실 = graph.getAdjVertices("잠실");
        System.out.println(잠실);

        System.out.println("------------------------------------------------------------------------");

        final Set<Vertex> dfs = dfs(graph, "잠실나루");
        System.out.println(dfs);

        System.out.println("------------------------------------------------------------------------");

        final Set<Vertex> shortestBfs = shortestBfs(graph, "잠실나루", "송파");
        System.out.println(shortestBfs);

    }

    private static Set<Vertex> dfs(final Graph graph, final String root) {
        final Set<Vertex> visited = new LinkedHashSet<>();
        final Deque<String> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final String pop = stack.pop();
            if (!visited.contains(new Vertex(pop))) {
                visited.add(new Vertex(pop));
                for (Vertex adjVertex : graph.getAdjVertices(pop)) {
                    stack.push(adjVertex.getStation());
                }
            }
        }
        return visited;
    }

    private static Set<Vertex> bfs(final Graph graph, final String root) {
        final Set<Vertex> visited = new LinkedHashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final String poll = queue.poll();
            for (Vertex adjVertex : graph.getAdjVertices(poll)) {
                if (!visited.contains(adjVertex)) {
                    visited.add(adjVertex);
                    queue.offer(adjVertex.getStation());
                }
            }
        }
        return visited;
    }

    private static Set<Vertex> shortestBfs(final Graph graph, final String root, final String destination) {
        final Set<Vertex> visited = new LinkedHashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        final List<Vertex> adjRoot = graph.getAdjVertices(root);
        visited.add(new Vertex(root));
        for (Vertex vertex : adjRoot) {
            queue.offer(vertex.getStation());
        }

        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final String poll = queue.poll();
                visited.add(new Vertex(poll));
                if (poll.equals(destination)) {
                    return visited;
                }
                for (Vertex adjVertex : graph.getAdjVertices(poll)) {
                    queue.offer(adjVertex.getStation());
                    visited.add(adjVertex);
                }

            }
        }

        return visited;
    }

    private static Graph initGraph() {
        final Graph graph = new Graph();
        // 2호선
        graph.addVertex("강변");
        graph.addVertex("잠실나루");
        graph.addVertex("잠실");
        graph.addVertex("잠실새내");

        graph.addEdge("강변", "잠실나루");
        graph.addEdge("잠실나루", "잠실");
        graph.addEdge("잠실", "잠실새내");

        // 8호선
        graph.addVertex("몽촌토성");
        graph.addVertex("석촌");
        graph.addVertex("송파");

        graph.addEdge("몽촌토성", "잠실");
        graph.addEdge("잠실", "석촌");
        graph.addEdge("석촌", "송파");

        return graph;
    }
}