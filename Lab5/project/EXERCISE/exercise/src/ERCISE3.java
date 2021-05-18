import java.util.Scanner;
public class ERCISE3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array1, array2, array3;
        int number, total = 0, min;
        System.out.print("Enter the number of the integers: ");
        number = in.nextInt();
        array1 = new int[number];
        array2 = new int[number];
        array3 = new int[number];
        System.out.print("Enter the integers: ");
        for( int i = 0; i < number; i++ ){
            array1[i] = in.nextInt();
            array2[i] = array1[i];
            if( i > 0 )
                array2[i] = Math.max( array2[i], array2[i-1]);
        }
        for( int j = 0; j < number; j++ ){
            array3[number - 1 - j] = array1[number - 1 - j];
            if( j > 0 )
                array3[number - 1 - j] = Math.max( array3[number - 1 - j], array3[number - j]);
        }
        for( int i = 0; i < number; i++ ){
            min = Math.min( array3[i], array2[i]);
            total += min - array1[i];
        }
        System.out.printf("It can store %d units of water.", total);
    }
}
