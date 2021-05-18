import java.util.Scanner;
public class exercise5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float gpa = 0;
        int score, tent;
        System.out.println("Please enter the score:");
        score = input.nextInt();
        tent = score/10;
        if(tent >=6)
        switch(tent) {
            case 10:
                gpa = 4.0f;
                System.out.println("You pass the exam.");
                break;
            case 9:
                gpa = 4.0f;
                System.out.println("You pass the exam.");
                break;
            case 8:
                gpa = 3.0f;
                System.out.println("You pass the exam.");
                break;
            case 7:
                gpa = 2.0f;
                System.out.println("You pass the exam.");
                break;
            case 6:
                gpa = 1.0f;
                System.out.println("You pass the exam.");
                break;
        }
        else {
            gpa = 0.0f;
            System.out.println("You fail the exam.");
        }
        System.out.printf("Your score is %d, the GPA is %.1f.\n", score, gpa);
    }
  }
