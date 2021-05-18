import java.util.Scanner;
public class EXERCISE5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grade;
        float[] average, Average;
        int snum = 0, cnum = 0;
        System.out.print("Please enter the number of subjects: ");
        cnum = in.nextInt();
        System.out.print("Please enter the number of students: ");
        snum = in.nextInt();
        grade = new int[cnum][snum];
        average = new float[cnum];
        Average = new float[snum];
        for( int i = 0; i < cnum; i++ ){
            int total = 0;
            for( int j = 0; j < snum; j++){
                grade[i][j] = in.nextInt();
                total += grade[i][j];
            }
            average[i] =  (float)total/snum;
        }
        for( int j = 0; j < snum; j++ ){
            int total = 0;
            for( int i = 0; i < cnum; i++ ){
                total += grade[i][j];
            }
            Average[j] = (float)total/cnum;
        }
        System.out.println();
        System.out.print("       ");
        for( int i = 0; i < cnum; i++ ){
            System.out.printf("   Course%d", i+1);
        }
        System.out.println("   Average");
        for( int j = 0; j < snum; j++){
            System.out.printf("Student%d  ", j);
            for( int i = 0; i < cnum; i++){
                System.out.printf("%5d     ", grade[i][j]);
            }
            System.out.printf(" %.2f\n", Average[j]);
        }
        System.out.printf("Average   ");
        for( int j = 0; j < cnum; j++){
            System.out.printf("  %.2f   ", average[j]);
        }
    }
}
