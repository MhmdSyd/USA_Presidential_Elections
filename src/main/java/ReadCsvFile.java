import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCsvFile {

    // Define empty Constructor
    public ReadCsvFile(){}

    public List<StateVotes> readVotesCsv(String fileName){
        List<StateVotes> allVotes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            // read the first line from the text file which will be head column
            String line = br.readLine();
            // loop until all lines are read
            if (line != null) {
                line = br.readLine(); // the first real data
            }
            while (line != null) {
                String[] attributes = line.split(",");
                StateVotes pyr = createVotesRow(attributes);
                allVotes.add(pyr);
                line = br.readLine();
            }
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return allVotes;
    }

    public StateVotes createVotesRow(String[] attributes){
        String StateVotes = attributes[0];
        String county= attributes[1];
        String candidate = attributes[2];
        String party = attributes[3];
        String total_votes = attributes[4];
        String won = attributes[5];

        return new StateVotes(StateVotes, county, candidate, party, total_votes, won);
    }
}
