import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class GraphCreatorTest {

    @Test
    public void addVerticesToGraphsTest(){
        //given
        List<PairOfNumbers> pairs = new LinkedList<>();
        pairs.add(new PairOfNumbers(1,2));
        pairs.add(new PairOfNumbers(2,3));
        pairs.add(new PairOfNumbers(4,5));
        pairs.add(new PairOfNumbers(1,2));
        GraphCreator graphCreator = new GraphCreator();
        //when
        for (PairOfNumbers pairOfNums : pairs) {
            graphCreator.addVerticesToGraphs(pairOfNums.getFirstNumber(), pairOfNums.getSecondNumber());
        }
        //then
        Assert.assertEquals(2, graphCreator.getGraphs().size());
    }

    @Test
    public void addVerticesToGraphsTestOneGraph(){
        //given
        List<PairOfNumbers> pairs = new LinkedList<>();
        pairs.add(new PairOfNumbers(1,2));
        pairs.add(new PairOfNumbers(2,3));
        pairs.add(new PairOfNumbers(1,3));
        pairs.add(new PairOfNumbers(2,4));
        GraphCreator graphCreator = new GraphCreator();
        //when
        for (PairOfNumbers pair : pairs) {
            graphCreator.addVerticesToGraphs(pair.getFirstNumber(), pair.getSecondNumber());
        }
        //then
        Assert.assertEquals(1, graphCreator.getGraphs().size());
    }

    @Test
    public void addVerticesToGraphsOnlyNewGraphs(){
        //given
        List<PairOfNumbers> pairs = new LinkedList<>();
        pairs.add(new PairOfNumbers(1,2));
        pairs.add(new PairOfNumbers(3,4));
        pairs.add(new PairOfNumbers(5,6));
        pairs.add(new PairOfNumbers(7,8));
        GraphCreator graphCreator = new GraphCreator();
        //when
        for (PairOfNumbers pair : pairs) {
            graphCreator.addVerticesToGraphs(pair.getFirstNumber(), pair.getSecondNumber());
        }
        //then
        Assert.assertEquals(4, graphCreator.getGraphs().size());
    }

    @Test
    public void addVerticesToGraphsDescendingVertices(){
        //given
        List<PairOfNumbers> pairs = new LinkedList<>();
        pairs.add(new PairOfNumbers(7,6));
        pairs.add(new PairOfNumbers(6,5));
        pairs.add(new PairOfNumbers(4,3));
        pairs.add(new PairOfNumbers(3,2));
        GraphCreator graphCreator = new GraphCreator();
        //when
        for (PairOfNumbers pair : pairs) {
            graphCreator.addVerticesToGraphs(pair.getFirstNumber(), pair.getSecondNumber());
        }
        //then
        Assert.assertEquals(2, graphCreator.getGraphs().size());
    }
}
