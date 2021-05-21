import java.util.Map;

public class DisplayData {

    public static void displayMap(Map<String ,Integer[]> hashData,String title){

        System.out.println("=====================" + title + "=======================");

        for(String st: hashData.keySet()){

            System.out.println(st + " => " + (hashData.get(st)[1] *100 /  hashData.get(st)[0]) + "%");
        }
        System.out.println();
    }
    public static void displayWinner(Integer[] votes){
        if(votes[1] > votes[0]){
            System.out.println("====Biden is The Winner in USA Election====");
        }else {
            System.out.println("====Trump is The Winner in USA Election====");
        }
    }
}
