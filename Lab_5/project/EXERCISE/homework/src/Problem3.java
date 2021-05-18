import java.util.Scanner;
public class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = {0,0,0,0,0,0,0,0,0,0};
        String NB;
        NB = in.nextLine();
        char[] NBN = NB.toCharArray();
        for( int i = 0; i < NBN.length; i++ ){
            int num = (int)NBN[i] - (int)'0';
            array[num] += 1;
        }
        for( int i = 0; i < 10; i++ ){
            System.out.printf("%d ", array[i]);
        }
    }
}

