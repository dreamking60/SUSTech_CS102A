import java.util.Scanner;
public class Problem5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        short n;
        n = in.nextShort();
        int[][][] a;
        int[] s = new int[n];
        int[] m = new int[n];
        int[][][] total;
        total = new int[n][][];
        a = new int[n][][];
        for( int i = 0; i < n; i++ ){
            s[i] = in.nextInt();
            m[i] = in.nextInt();
            a[i] = new int[s[i]][m[i]];
            for( int j = 0; j < s[i]; j++ ){
                for( int k = 0; k < m[i]; k++ ){
                    a[i][j][k] = in.nextInt();
                }
            }
        }
        total[0] = new int[s[0]][m[0]];
        total[0] = a[0];
        for( int i = 0; i < n-1; i++ ){
            total[i+1] = new int[s[0]][m[i+1]];
            for( int j = 0; j < s[0]; j++ ){
                for( int k = 0; k < m[i+1]; k++ ){
                    int b = 0;
                    for( int l = 0; l < m[i] ; l++ ){
                        b += total[i][j][l] * a[i+1][l][k];
                    }
                    total[i+1][j][k] = b;
                }
            }
        }
        for( int i = 0; i < s[0]; i++ ){
            for( int j = 0; j < m[n-1]; j++){
                System.out.printf("%d ", total[n-1][i][j]);
            }
            System.out.println();
        }
    }
}
