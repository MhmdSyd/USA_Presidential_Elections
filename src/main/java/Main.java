import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        PresidentialElectionsAnalysis test = new PresidentialElectionsAnalysis();
        List<StateVotes> votes = test.read_Data();

        Map<String ,Integer[]> trumpPer = test.trump_per(votes);

        DisplayData.displayMap(trumpPer,"Display Trump Percentage in each State");

        DisplayData.displayMap(test.biden_per(votes),"Display Biden Percentage in each State");

        Integer[] result = test.result(votes);

        DisplayData.displayWinner(result);

        Chart chat = new Chart();
        String[] candidate = new String[]{"Trump","Biden","Other"};

        chat.pieChartPlot(new Integer[]{result[1],result[2],result[0]-(result[1] + result[2])},candidate,"USA Election");

    }
}
