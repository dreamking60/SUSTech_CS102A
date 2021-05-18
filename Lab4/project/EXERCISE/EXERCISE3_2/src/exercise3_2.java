import java.util.Scanner;
public class exercise3_2 {
        public static void main(String[] args){
            Scanner input = new Scanner(System.in);
            int k = 0;
            double precision;
            float pi = 0, i = 1;
            System.out.println("Please input the precision:");
            precision = input.nextDouble();
            do{
                if( k % 2 == 0)
                    pi = pi + 4/i;
                else
                    pi = pi - 4/i;
                i += 2;
                k += 1;
            } while( 4/(i-2) >= precision);
            System.out.printf("The estimation of pi is %f\n", pi);
            System.out.printf("It computed %d times.", k);
        }
    }