import java.util.Scanner;
public class exercise4_2 {
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int k = 1;
    double precision;
    float pi = 4, i = 3;
    System.out.println("Please input the precision:");
    precision = input.nextDouble();
    for( ;4/(i-2) > precision; i += 2){
        if( k % 2 == 0)
            pi = pi + 4/i;
        else
            pi = pi - 4/i;
        k += 1;
    } ;
    System.out.printf("The estimation of pi is %f\n", pi);
    System.out.printf("It computed %d times.", k);
}
}
