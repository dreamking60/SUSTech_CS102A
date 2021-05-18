public class determinant {
    public determinant() {
    }

    public int determinant(int[][] o) {
        int n = o[0].length;
        if( n == 1){
            return o[0][0];
        }
        int total = 0;
        int[] b = new int[n];

        for( int i = 0; i < n; i++ ){
            b[i] = o[0][i];
            int[][] a = new int[n-1][n-1];
            for(int j = 0; j < n-1; j++){
                for(int k = 0; k < n-1; k++){
                    if( k < i){
                        a[j][k] = o[j+1][k];
                    }else{
                        a[j][k] = o[j+1][k+1];
                    }
                }
            }
            if( i%2 == 0) {
                total += b[i] * determinant(a);
            }else{
                total -= b[i] * determinant(a);
            }
        }
        return total;
    }
}
