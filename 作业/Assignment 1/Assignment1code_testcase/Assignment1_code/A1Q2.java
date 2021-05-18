

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double borrowNum = sc.nextDouble();
        double bookNum = sc.nextDouble();
        if(borrowNum == 0.0) {
            System.out.print("No");
        }else {
            int q = (int)(bookNum / borrowNum + 0.5);
            double v = q * borrowNum;
            double r = Math.abs(bookNum - v);
            if(r == 0.0) {
                System.out.print("Yes");
            }else {
                System.out.print("No");
            }
        }
    }
}
