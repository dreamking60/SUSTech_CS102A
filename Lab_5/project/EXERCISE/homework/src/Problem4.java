import java.util.Scanner;
public class Problem4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] array;
        int n;
        long total = 0;
        n = in.nextInt();
        array = new long[n];
        for( int i = 0; i < n; i++ ){
            array[i] = in.nextLong();
        }
        for( int i = 0; i < n-1; i++ ){
            for( int j = i+1; j < n; j++ ){
                if( array[i] >= array[j] ){
                    total += array[i] * array[j];
                }
            }
        }
        System.out.println(total);
    }
}