import java.util.Scanner;
public class EXERCISE1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float[] score = new float[10];
        float a = 0, b = 0, c = 100, total = 0, average;
        System.out.println("Please enter the 10 scores(0-100) of these students: ");
        for( int i = 0; i < score.length; i++ ){
            score[i] = in.nextFloat();
                a = score[i];
                if( a > b)
                    b = a;
                if( a < c)
                    c = a;
            total += score[i];
        }
        average = (total - c - b)/8;
        System.out.printf("Average score is: %.2f", average);
        in.close();
    }
}
