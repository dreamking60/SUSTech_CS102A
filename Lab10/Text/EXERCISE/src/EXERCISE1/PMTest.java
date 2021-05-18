package EXERCISE1;
import java.util.Scanner;
import java.util.EnumSet;
public class PMTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Your budget: ");
        int money = in.nextInt(), n = 0;
        for( PhoneModel PM : PhoneModel.values()){
            if(PM.getPrice() <= money ){
                System.out.printf("%-12s%7s%d\n", PM, "price:", PM.getPrice());
                n += 1;
            }
        }
        if( n == 0 ){
            System.out.println("You do have sufficient money");
        }
    }
}
