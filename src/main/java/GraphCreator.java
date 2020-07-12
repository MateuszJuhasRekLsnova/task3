import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GraphCreator {
    private List<Graph> graphs;

    public GraphCreator() {
        graphs = new LinkedList<>();
    }

    public List<Graph> getGraphs() {
        return graphs;
    }

    public void setGraphs(List<Graph> graphs) {
        this.graphs = graphs;
    }

    public void addVerticesToGraphs(int firsNum, int secondNum){
        GraphIndexesHolder indexesHolder = findGraphsWithGivenVertices(firsNum, secondNum);
        if(indexesHolder.firstGraphIndex==-1 && indexesHolder.secondGraphIndex==-1){
            createNewGraph(firsNum, secondNum);
            return;
        }
        if(indexesHolder.firstGraphIndex!=-1 && indexesHolder.secondGraphIndex==-1){
            addVertexToExistingGraph(indexesHolder.firstGraphIndex, secondNum);
            return;
        }
        if(indexesHolder.firstGraphIndex==1 && indexesHolder.secondGraphIndex!=-1){
            addVertexToExistingGraph(indexesHolder.secondGraphIndex, firsNum);
            return;
        }
        if(indexesHolder.firstGraphIndex!=indexesHolder.secondGraphIndex){
            mergeGraphs(indexesHolder);
        }
    }

    private void mergeGraphs(GraphIndexesHolder indexesHolder) {
        Graph firstGraph = graphs.get(indexesHolder.firstGraphIndex);
        Graph secondGraph = graphs.get(indexesHolder.secondGraphIndex);
        Set<Integer> firstGraphVertices = firstGraph.getVertices();
        secondGraph.getVertices().addAll(firstGraphVertices);
        graphs.remove(firstGraph);
    }

    private void addVertexToExistingGraph(int graphIndex, int numberToAdd) {
        graphs.get(graphIndex).addVertex(numberToAdd);
    }

    private void createNewGraph(int firsNum, int secondNum) {
        Graph newGraph = new Graph();
        newGraph.addVertex(firsNum);
        newGraph.addVertex(secondNum);
        graphs.add(newGraph);
    }

    private GraphIndexesHolder findGraphsWithGivenVertices(int firsNum, int secondFound) {
        GraphIndexesHolder graphIndexesHolder = new GraphIndexesHolder();
        int i = 0;
        for (Graph graph : graphs){
            if(graph.contains(firsNum)){
                graphIndexesHolder.firstGraphIndex = i;
            }
            if(graph.contains(secondFound)){
                graphIndexesHolder.secondGraphIndex = i;
            }
            if(graphIndexesHolder.firstGraphIndex!=-1 && graphIndexesHolder.secondGraphIndex!=-1){
                break;
            }
            i++;
        }
        return graphIndexesHolder;
    }

    private static class GraphIndexesHolder{
        int firstGraphIndex;
        int secondGraphIndex;

        public GraphIndexesHolder() {
            firstGraphIndex = -1;
            secondGraphIndex = -1;
        }
    }
}
