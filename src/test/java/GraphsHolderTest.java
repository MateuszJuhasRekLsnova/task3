import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class GraphsHolderTest {

    @Test
    public void addEdgesToGraphsOneGraphTest(){
        //given
        GraphsHolder graphsHolder = new GraphsHolder();
        List<PairOfNumbers> pairs = new LinkedList<>();
        pairs.add(new PairOfNumbers(1,2));
        pairs.add(new PairOfNumbers(2,3));
        pairs.add(new PairOfNumbers(3,5));
        //when
        graphsHolder.addEdgesToGraphs(pairs);
        //then
        Assert.assertEquals(1, graphsHolder.getGraphs().size());
    }

    @Test
    public void addEdgesToGraphsTwoGraphsTest(){
        //given
        GraphsHolder graphsHolder = new GraphsHolder();
        List<PairOfNumbers> pairs = new LinkedList<>();
        pairs.add(new PairOfNumbers(1,2));
        pairs.add(new PairOfNumbers(4,3));
        pairs.add(new PairOfNumbers(3,5));
        //when
        graphsHolder.addEdgesToGraphs(pairs);
        //then
        Assert.assertEquals(2, graphsHolder.getGraphs().size());
    }

    @Test
    public void addEdgesToGraphsOneGraphWithMerge(){
        //given
        GraphsHolder graphsHolder = new GraphsHolder();
        List<PairOfNumbers> pairs = new LinkedList<>();
        pairs.add(new PairOfNumbers(1,2));
        pairs.add(new PairOfNumbers(2,3));
        pairs.add(new PairOfNumbers(3,5));
        pairs.add(new PairOfNumbers(3,1));
        //when
        graphsHolder.addEdgesToGraphs(pairs);
        //then
        Assert.assertEquals(1, graphsHolder.getGraphs().size());
    }

    @Test
    public void addEdgesToGraphsThreeGraphsMergedToOne(){
        //given
        GraphsHolder graphsHolder1 = new GraphsHolder();
        GraphsHolder graphsHolder2 = new GraphsHolder();
        List<PairOfNumbers> pairs = new LinkedList<>();
        pairs.add(new PairOfNumbers(1,2));
        pairs.add(new PairOfNumbers(3,4));
        pairs.add(new PairOfNumbers(3,5));
        pairs.add(new PairOfNumbers(5,6));
        pairs.add(new PairOfNumbers(7,8));
        pairs.add(new PairOfNumbers(8,9));
        List<PairOfNumbers> pairsMergedToOne = new LinkedList<>(pairs);
        pairsMergedToOne.add(new PairOfNumbers(1,4));
        pairsMergedToOne.add(new PairOfNumbers(4,7));

        //when
        graphsHolder1.addEdgesToGraphs(pairs);
        int notMergedSize = graphsHolder1.getGraphs().size();
        graphsHolder2.addEdgesToGraphs(pairsMergedToOne);
        int mergedSize = graphsHolder2.getGraphs().size();

        //then
        Assert.assertEquals(3, notMergedSize);
        Assert.assertEquals(1, mergedSize);
    }
}
