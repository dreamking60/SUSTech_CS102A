import java.util.Scanner;
public class EXERCISE2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array1, array2;
        int size, c = 0;
        System.out.printf("Enter the length of array: ");
        size = in.nextInt();
        array1 = new int[size];
        array2 = new int[size];
        System.out.printf("Enter the 1st integer array of size %d: ", size);
        for( int j = 0; j < size; j++){
            array1[j] = in.nextInt();
        }
        System.out.printf("Enter the 2nd integer array of size %d: ", size);
        for( int k = 0; k < size; k++){
            array2[k] = in.nextInt();
        }
        for( int i = 0; i < size; i++){
            if( array1[i] != array2[i] ){
                System.out.println("The two arrays have different values.");
                break;
            }else{
                c += 1;
            }
        }
        if( c == size ) {
            System.out.println("The two arrays have the same values.");
        }
    }
}
