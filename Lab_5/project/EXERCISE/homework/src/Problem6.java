import java.util.Scanner;
public class Problem6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m, n;
        m = in.nextInt();
        n = in.nextInt();
        String[] str = new String[m];
        char[][] a = new char[m][n];
        char[][] b = new char[m][n];
        for( int i = 0; i < m; i++ ){
            str[i] = in.next();
            for( int j = 0; j < n; j++ ){
                a[i][j] = str[i].charAt(j);
                if( a[i][j] == '*' )
                    b[i][j] = 'F';
            }
        }
        for( int i = 0; i < m; i++){
            for( int j = 0; j < n; j++){
                if( b[i][j] != 'F' ) {
                    int c = 0;
                    for (int k = Math.max(0, i - 1); k <= Math.min(i + 1, m - 1); k++) {
                        for (int l = Math.max(0, j - 1); l <= Math.min(j + 1, n - 1); l++) {
                            if (a[k][l] == '*')
                                c += 1;
                        }
                    }
                    if (c == 0)
                        b[i][j] = '-';
                    else
                        b[i][j] = (char)(c+48);
                }
                System.out.print(b[i][j]);
            }
            System.out.println(" ");
        }
    }
}
