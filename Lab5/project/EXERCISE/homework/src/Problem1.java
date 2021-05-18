import java.util.Scanner;
public class Problem1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] a;
        int n;
        long m;
        n = in.nextInt();
        a = new long[n];
        m = in.nextLong();
        for( int i = 0; i < n; i++ ){
            a[i] = in.nextLong();
        }
        for( int i = 0; i < n-1; i++ ){
            for( int j = i + 1; j < n; j++ ){
                if( a[i] + a[j] == m ){
                    System.out.printf("%d %d", i+1, j+1);
                }
            }
        }
    }
}