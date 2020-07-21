import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        List<PairOfNumbers> numbersPairs = getDatFromInput();
        GraphsHolder graphsHolder = new GraphsHolder();
        graphsHolder.addEdgesToGraphs(numbersPairs);
        System.out.println(graphsHolder.getGraphs().size());
    }

    private static List<PairOfNumbers> getDatFromInput() {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int pairsCounter = Integer.parseInt(firstLine);
        List<PairOfNumbers> pairsOfNums = new LinkedList<>();
        for (int i = 1; i<=pairsCounter; i++){
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            pairsOfNums.add(new PairOfNumbers(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }
        return pairsOfNums;
    }
}
