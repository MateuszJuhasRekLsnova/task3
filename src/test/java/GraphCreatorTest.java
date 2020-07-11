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
}
