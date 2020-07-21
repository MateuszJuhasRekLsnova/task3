
public class GraphImpl<T> {

    private final Vertex<T> firstVertex;

    public GraphImpl(T firstVertexValue) {
        this.firstVertex = new Vertex<>(firstVertexValue);
    }

    public boolean addEdgeIfPossible(T value1, T value2){
        return firstVertex.addEdge(value1, value2, firstVertex);
    }

    public boolean containsValue(T value){
        return firstVertex.isFound(value, firstVertex);
    }

    public void addGraph(GraphImpl<T> graphToMerge, T valueIn1stGraph, T valueIn2ndGraph) {
        Vertex<T> vertexWith1stVal = this.getVertexWithValue(valueIn1stGraph);
        Vertex<T> vertexWith2ndValue = graphToMerge.getVertexWithValue(valueIn2ndGraph);
        vertexWith1stVal.addVertex(vertexWith2ndValue);
    }

    private Vertex<T> getVertexWithValue(T requiredValue) {
        return firstVertex.findVertexWithVal(requiredValue, firstVertex);
    }

}
