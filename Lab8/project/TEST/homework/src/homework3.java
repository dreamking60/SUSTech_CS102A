import java.util.Scanner;
public class homework3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m, n, k = 1, s = 1;
        m = in.nextInt();
        n = in.nextInt();
        int[][] A = new int[m][n];
        A[m - 1][n - 1] = 1;
        for (int j = 1; j < m; j++) {
            if (m > n) {
                if (j % 2 != 0) {
                    A[j][n - 1] = A[j - 1][n - 1] + 1;
                    for (int i = 1; i < Math.min(j, n); i++) {
                        A[j - i][n - 1 - i] = A[j - i + 1][n - i] + 1;
                    }
                }
                if (j % 2 == 0) {
                    A[j][n - 1] = A[j - 1][n - 1] + Math.min(j - 1, n - 1) + Math.min(n, j);
                    for (int i = 1; i < Math.min(j, n); i++) {
                        A[j - i][n - 1 - i] = A[j - i + 1][n - i] - 1;
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (m < n) {
                if (i % 2 == 0) {
                    A[0][n - 1 - i] = A[0][n - 1] + 1;
                    for (int j = 1; i < Math.min(i, m); i++) {
                        A[j][i + j] = A[j - 1][i + j - 1] + 1;
                    }
                }
                if (i % 2 != 0) {
                    A[0][n - 1] = A[0][n - 1] + Math.min(i - 1, m - 1) + Math.min(i, m);
                    for (int j = 1; i < Math.min(i, m); i++) {
                        A[j][i + j] = A[j - 1][i + j - 1] - 1;
                    }
                }
            }
        }
        if (m > n) {
            for (int j = 1; j < n-1; j++) {
                if( m+j % 2 != 0) {
                    A[m-1][n - 1 - j] = A[m-1][n - j] + 1;
                    for( int i =1; i < n-j-1; i++){
                        A[m-1-i][n-1-j-i] = A[m-1][n-1-j] + 1;
                    }
                }
                if( m+j % 2 == 0){
                    A[m-1][n - 1 - j] = A[m-1][n-j] + Math.max(n-1-j,1) + n-1-j;
                    for( int i =1; i < n-j-1; i++){
                        A[m-1-i][n-1-j-i] = A[m-1][n-1-j] - 1;
                    }
                }
            }
        }
        if( m < n){
            for (int i = 1; i < m-1; i++) {
                if( n+i % 2 == 0) {
                    A[i][0] = A[i-1][0] + 1;
                    for( int  j=1; j < m-i ; i++){
                        A[i+j][j] = A[i+j-1][j-1] + 1;
                    }
                }
                if( n+i % 2 != 0){
                    A[i][0] = A[i-1][0] + Math.max(m-i,1) + m-i ;
                    for( int  j=1; j < m-i ; i++){
                        A[i+j][j] = A[i+j-1][j-1] - 1;
                    }
                }
            }
        }
    }
}
