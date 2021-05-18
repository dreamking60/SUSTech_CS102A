import java.util.Scanner;
public class exercise5_ {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float gpa = 4.0f;
        int score;
        score = input.nextInt();
        switch(score/10){
            case 10:
            case 9:
                gpa = 4.0f;
                break;
            case 8:
                gpa =3.0f;
                break;
            case 7:
                gpa = 2.0f;
                break;
            case 6:
                gpa = 1.0f;
                break;
            default:
                gpa = 0.0f;
                break;
        }
        switch(gpa){

        }
    }
}
