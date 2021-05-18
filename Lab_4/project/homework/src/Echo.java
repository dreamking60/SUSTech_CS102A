import java.util.Scanner;
public class Echo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input;
        System.out.print("Please enter a number: ");
        input = in.nextInt();
        System.out.printf("The number is %d.", input);
    }
}
