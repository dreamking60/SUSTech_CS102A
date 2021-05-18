
import java.util.Scanner;
public class Test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a sentence:");
        String s1 = in.nextLine();
        String[] s2 = s1.split(" ");
        for( String token:s2){
            System.out.println(token);
        }
        in.close();
    }
}
