import java.util.LinkedList;
import java.util.List;

public class GraphCreator {
    private List<Graph> graphs;

    public GraphCreator() {
        graphs = new LinkedList<>();
    }

    public GraphCreator(List<Graph> graphs) {
        this.graphs = graphs;
    }

    public List<Graph> getGraphs() {
        return graphs;
    }

    public void setGraphs(List<Graph> graphs) {
        this.graphs = graphs;
    }

    public void addVerticesToGraphs(int firsNum, int secondNum){

    }
}
