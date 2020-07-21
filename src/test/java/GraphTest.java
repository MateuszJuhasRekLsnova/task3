import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

    @Test
    public void addVerticesTest(){
        //given
        GraphImpl<Integer> graph = new GraphImpl<>(1);
        //when
        boolean addPossible1 = graph.addEdgeIfPossible(2, 1);
        boolean addPossible2 = graph.addEdgeIfPossible(3, 2);
        boolean addNotPossible1 = graph.addEdgeIfPossible(4, 5);
        boolean addPossible3 = graph.addEdgeIfPossible(1, 6);
        //then
        Assert.assertTrue(addPossible1);
        Assert.assertTrue(addPossible2);
        Assert.assertFalse(addNotPossible1);
        Assert.assertTrue(addPossible3);
        Assert.assertTrue(graph.containsValue(3));
        Assert.assertFalse(graph.containsValue(4));


    }
}
