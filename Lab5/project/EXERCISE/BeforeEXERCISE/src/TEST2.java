import java.util.Arrays;
public class TEST2 {
    public static void main(String[] args) {
        int[] array3 = null;
        System.out.println( array3 );
        int[] array2 = new int[5];
        array2[0] = 6;
        array2[1] = 7;
        array2[2] = 8;
        array2[3] = 9;
        array2[4] = 10;
        array3 = array2;
        System.out.println( array3 );
        System.out.println( array2 );
        for( int e:array3 ){
            e = 1;
        }
        System.out.println( "array3: " + Arrays.toString(array3));
        for(int i = 0; i < array3.length; i++){
            array3[i] = 1;
        }
        System.out.println("array3: " + Arrays.toString(array3));
        System.out.println("array2: " + Arrays.toString(array2));

    }
}
