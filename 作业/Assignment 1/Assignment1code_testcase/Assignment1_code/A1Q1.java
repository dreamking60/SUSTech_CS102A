import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        double unitPrice = sc.nextDouble();
        int count = sc.nextInt();
        int totalPrice = (int) Math.round(unitPrice*count);
        int digitFour = number%10000000%1000000%100000%10000;
        if(digitFour < 10){
            System.out.printf("2020000%d %d",digitFour,totalPrice);
        }else if(digitFour < 100){
            System.out.printf("202000%d %d",digitFour,totalPrice);
        }else if(digitFour < 1000){
            System.out.printf("20200%d %d",digitFour,totalPrice);
        }else {
            System.out.printf("2020%d %d",digitFour,totalPrice);
        }
//        String num = args[0].substring(4,8);                  if you learn by yourself before the class, you can use this effective way
//        System.out.printf("2020%s %d",num,totalPrice);
    }
}
