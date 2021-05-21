import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.List;

public class PresidentialElectionsAnalysis {

    public List<StateVotes> read_Data(){

        ReadCsvFile file  = new ReadCsvFile();
        System.out.println("============Start to read CSV file============");
        System.out.println();

        List<StateVotes> votesList = file.readVotesCsv("resource\\president_county_candidate.csv");
        System.out.println("============Finish to read president_county_candidate file============");

        System.out.println();
        return votesList;
    }

    public Map<String ,Integer[]> trump_per(List<StateVotes> votesList){

        Map<String ,Integer[]> stateRow = new HashMap<String ,Integer[]>();

        String temp;
        Integer[] n = new Integer[2];
        Integer vote;
        for(StateVotes v: votesList){
            temp = v.getState();
            vote = v.getTotal_votes();
            if(stateRow.containsKey(temp)){
                n = stateRow.get(temp);

                if(v.getCandidate().equals("Donald Trump")){
                    n[0] += vote;
                    n[1] += vote;
                }else {
                    n[0] += vote;
                }
                stateRow.replace(temp, new Integer[]{n[0],n[1]});

            }else{
                if(v.getCandidate().equals("Donald Trump")){
                    n[0] = vote;
                    n[1] = vote;
                }else {
                    n[0] = vote;
                    n[1] = 0;
                }
                stateRow.put(temp,new Integer[]{n[0],n[1]});
            }
        }

        return stateRow;
    }


    public  Map<String ,Integer[]> biden_per(List<StateVotes> votesList){

        Map<String ,Integer[]> stateRow = new HashMap<String ,Integer[]>();

        String temp;
        Integer[] n = new Integer[2];
        Integer vote;
        for(StateVotes v: votesList){
            temp = v.getState();
            vote = v.getTotal_votes();

            if(stateRow.containsKey(temp)){

                n = stateRow.get(temp);

                if(v.getCandidate().equals("Joe Biden")){
                    n[0] += vote;
                    n[1] += vote;
                }else {
                    n[0] += vote;
                }
                stateRow.replace(temp, new Integer[]{n[0],n[1]});

            }else{
                if(v.getCandidate().equals("Joe Biden")){
                    n[0] = vote;
                    n[1] = vote;
                }else {
                    n[0] = vote;
                    n[1] = 0;
                }
                stateRow.put(temp,new Integer[]{n[0],n[1]});
            }
        }

        return stateRow;
    }


    public Integer[] result(List<StateVotes> votesList){

        Map<String ,Integer[]> stateRow = new HashMap<String ,Integer[]>();

        String temp;
        Integer[] n = new Integer[3];
        Integer vote;
        for(StateVotes v: votesList){
            temp = v.getState();
            vote = v.getTotal_votes();

            if(stateRow.containsKey(temp)){

                n = stateRow.get(temp);
                n[0] += vote;
                if(v.getCandidate().equals("Joe Biden")){
                    n[1] += vote;
                }else if(v.getCandidate().equals("Donald Trump")) {
                    n[2] += vote;
                }

                stateRow.replace(temp, new Integer[]{n[0],n[1],n[2]});

            }else{
                n[0] = vote;
                if(v.getCandidate().equals("Joe Biden")){
                    n[1] = vote;
                    n[2] = 0;
                }else if(v.getCandidate().equals("Donald Trump")) {
                    n[1] = 0;
                    n[2] = vote;
                }else {
                    n[1] = 0;
                    n[2] = 0;
                }
                stateRow.put(temp,new Integer[]{n[0],n[1],n[2]});
            }
        }


        Integer bidenTotlaVotes = 0;
        Integer trumpTotlaVotes = 0;
        Integer allTotlaVotes = 0;
        for(String st : stateRow.keySet()){
            temp = st;
            n = stateRow.get(temp);
            allTotlaVotes += n[0];
            bidenTotlaVotes += n[1];
            trumpTotlaVotes += n[2];

        }

        return  new Integer[]{allTotlaVotes,bidenTotlaVotes,trumpTotlaVotes};
    }
}
