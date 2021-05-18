import java.util.Scanner;
import java.util.TreeMap;

public class Application {

    private TreeMap<Integer, Event> events = new TreeMap<>();

    public void load(){

    }
    public void save(){

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String command = null;
        while(true){
            System.out.println("Please select a function:\n"
            + "(1) New to-do event\n"
            + "(2) Check all event\n"
            + "(3) Quit");

            command = in.nextLine();

            try{
                int number = Integer.valueOf(command);
                if( number == 1){

                }else if( number == 2){

                }else if( number ==  3){
                    break;
                }else{
                    System.out.println("Invalid command");
                }
            }catch(Exception e){
                System.out.println("Invalid command. Please enter 1 or 2.");
            }
        }
    }
}
