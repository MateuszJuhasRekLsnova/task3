import java.util.LinkedHashSet;

import java.util.Set;

public class Graph {
    Set<Integer> vertices;

    public Graph() {
        vertices = new LinkedHashSet<>();
    }

    public Graph(Set<Integer> vertices) {
        this.vertices = vertices;
    }

    public Set<Integer> getVertices() {
        return vertices;
    }

    public void setVertices(Set<Integer> vertices) {
        this.vertices = vertices;
    }
}
