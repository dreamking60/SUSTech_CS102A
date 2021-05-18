import java.util.Scanner;
public class EXERCISE4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = new int[101];
        int number;
        for( int k = 0; k < 100; k++){
            array[k] = 0;
        }
        System.out.print("Enter the integers between 1 and 100: ");
        do{
            number = in.nextInt();
            array[number] += 1;
        }while( number != 0);
        for( int j = 1; j <= 99; j++){
            if( array[j] != 0)
                System.out.printf("%d occurs %d times.\n", j, array[j]);
        }
    }
}
