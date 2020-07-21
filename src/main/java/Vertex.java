import java.util.HashSet;
import java.util.Set;

public class Vertex<T> {
    private Set<Vertex<T>> vertices;
    private final T value;

    public Vertex(T value) {
        vertices = new HashSet<>();
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public boolean addEdge(T value1, T value2, Vertex<T> previous) {
        if(value.equals(value1)){
            addNewVertex(value2);
            return true;
        }else if(value.equals(value2)){
            addNewVertex(value1);
            return true;
        }else {
            for (Vertex<T> vertex : vertices) {
                if(vertex.equals(previous)){
                    continue;
                }
                if(vertex.addEdge(value1, value2, this)){
                    return true;
                }
            }
        }
        return false;
    }

    private void addNewVertex(T value) {
        Vertex<T> newVertex = new Vertex<>(value);
        newVertex.addVertex(this);
        vertices.add(newVertex);
    }

    public void addVertex(Vertex<T> vertex) {
        this.vertices.add(vertex);
    }

    public boolean isFound(T value, Vertex<T> previous) {
        if(this.value.equals(value)){
            return true;
        }
        for (Vertex<T> vertex : vertices) {
            if(vertex.equals(previous)){
                continue;
            }
            if(vertex.isFound(value, this)){
                return true;
            }
        }
        return false;
    }



    public Vertex<T> findVertexWithVal(T requiredValue, Vertex<T> previous) {
        if (value.equals(requiredValue)){
            return this;
        }
        for (Vertex<T> vertex : vertices) {
            if(vertex.equals(previous)){
                continue;
            }
            Vertex<T> vertexFound = vertex.findVertexWithVal(requiredValue, this);
            if(vertexFound!=null){
                return vertexFound;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vertex){
            Vertex vertex = (Vertex) obj;
            return vertex.getValue().equals(value);
        }else {
            return false;
        }
    }
}
