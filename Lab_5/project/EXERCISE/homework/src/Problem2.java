import java.util.Scanner;
public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long  m, t = 0, result;
        long[] s, k, a;
        s = new long[1000001];
        k = new long[1000001];
        a = new long[1000002];
        a[0] = in.nextLong();
        m = in.nextLong();
        for( int i = 1; i <=1000002; i++ ){
            s[i] = in.nextLong();
            if(s[i]!=-1){
                k[i] = in.nextLong();
            }else{
                t = i;
                break;
            }
            a[i] = ((s[i] * a[i - 1]) + k[i]) % m;
        }
        result = a[0];
        for( int j = 1; j <= t-1; j++ ){
            result ^= a[j];
        }
        System.out.println(result);
    }
}
