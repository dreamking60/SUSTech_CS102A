import java.util.Scanner;
public class exercise4_1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n, k = 0;
        float pi = 0, i = 1;
        System.out.println("Please input n:");
        n = input.nextInt();
        for( ; k < n ; k++){
            if( k % 2 == 0)
                pi = pi + 1/i;
            else
                pi = pi - 1/i;
            i += 2;
        }
        pi = pi * 4;
        System.out.printf("The estimation of pi is %f", pi);
    }
}
