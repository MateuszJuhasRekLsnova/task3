import java.util.LinkedList;
import java.util.List;

public class GraphsHolder {
    private List<GraphImpl<Integer>> graphs;

    public List<GraphImpl<Integer>> getGraphs() {
        return graphs;
    }

    public void addEdgesToGraphs(List<PairOfNumbers> pairsOfNumbers){
        graphs = new LinkedList<>();
        graphs.add(createGraphWithPairOfNumbers(pairsOfNumbers.get(0)));
        pairsOfNumbers.remove(0);
        for (PairOfNumbers pair : pairsOfNumbers) {
            int i =0;
            List<Integer> graphsIndexes = new LinkedList<>();
            for (GraphImpl<Integer> graph : graphs) {
                if(graph.addEdgeIfPossible(pair.getFirstNumber(), pair.getSecondNumber())){
                    graphsIndexes.add(i);
                }
                i++;
            }
            if(graphsIndexes.size()==0){
                graphs.add(createGraphWithPairOfNumbers(pair));
            }
            if(graphsIndexes.size()>1){
                mergeGraphsByPair(graphsIndexes.get(0), graphsIndexes.get(1), pair);
            }
        }
    }

    private void addPairToGraphs(int graph1Index, int graph2Index, PairOfNumbers pair) {
        if(graph1Index==-1 && graph2Index!=-1){
            graphs.get(graph2Index).addEdgeIfPossible(pair.getFirstNumber(), pair.getSecondNumber());
            return;
        }
        if(graph1Index!=-1 && graph2Index==-1) {
            graphs.get(graph1Index).addEdgeIfPossible(pair.getFirstNumber(), pair.getSecondNumber());
            return;
        }
        if(graph1Index == -1) {
            graphs.add(createGraphWithPairOfNumbers(pair));
            return;
        }
        if(graph1Index!=graph2Index){
            mergeGraphsByPair(graph1Index, graph2Index, pair);
        }
    }

    private void mergeGraphsByPair(int graph1Index, int graph2Index, PairOfNumbers pair) {
        GraphImpl<Integer> graph1 = graphs.get(graph1Index);
        GraphImpl<Integer> graph2 = graphs.get(graph2Index);
        graph1.addGraph(graph2,pair.getFirstNumber(), pair.getSecondNumber());
        graphs.remove(graph2Index);
    }

    private GraphImpl<Integer> createGraphWithPairOfNumbers(PairOfNumbers pair) {
        GraphImpl<Integer> newGraph = new GraphImpl<>(pair.getFirstNumber());
        newGraph.addEdgeIfPossible(pair.getFirstNumber(), pair.getSecondNumber());
        return newGraph;
    }
}
