import java.util.Scanner;

public class Main { //本题专门用于培养大家的耐心和细心
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int borrowDate = sc.nextInt();
        int returnDate = sc.nextInt();
        int borrowYear = borrowDate/10000000*1000 + borrowDate%10000000/1000000*100 + borrowDate%1000000/100000*10 + borrowDate%100000/10000*1;
        int returnYear = returnDate/10000000*1000 + returnDate%10000000/1000000*100 + returnDate%1000000/100000*10 + returnDate%100000/10000*1;
        int borrowMonth = (borrowDate-borrowYear*10000)/100;
        int returnMonth = (returnDate-returnYear*10000)/100;
        int borrowDay = (borrowDate-borrowYear*10000)%100;
        int returnDay = (returnDate-returnYear*10000)%100;
        //if you can use String.charAt/String.subString it will be much better
        //borrowYear = borrowDate(set it as a String).subString(0,4);

        int borrowDays = 0;
        int returnDays = 0;
        int temp1 = borrowMonth;
        int temp2 = borrowDay;
        int temp3 = borrowYear;
        for (int i = 0; i < 2; i++) {
            int Days = 0;
            if(temp1 == 1){
                Days+=temp2;
            }else if (temp1 == 2){
                Days+=(31+temp2);
            }else if (temp1 == 3){
                Days+=(59+temp2);
            }else if (temp1 == 4){
                Days+=(90+temp2);
            }else if (temp1 == 5){
                Days+=(120+temp2);
            }else if (temp1 == 6){
                Days+=(151+temp2);
            }else if (temp1 == 7){
                Days+=(181+temp2);
            }else if (temp1 == 8){
                Days+=(212+temp2);
            }else if (temp1 == 9){
                Days+=(243+temp2);
            }else if (temp1 == 10){
                Days+=(273+temp2);
            }else if (temp1 == 11){
                Days+=(304+temp2);
            }else if (temp1 == 12){
                Days+=(334+temp2);
            }
            if(temp3%4 == 0 && temp1 > 2){   // leap year
                Days+=1;
            }
            if(i == 0){
                borrowDays = Days;
            }else {
                returnDays = Days;
            }
            temp1 = returnMonth;
            temp2 = returnDay;
            temp3 = returnYear;
        }
        int delta;
        if(borrowYear != returnYear){
            if(borrowYear%4 == 0){
                borrowDays = 366-borrowDays;
            }else {
                borrowDays = 365-borrowDays;
            }
            delta = returnDays + borrowDays;
        }else {
            delta = returnDays - borrowDays;
        }
        if(returnYear-borrowYear >= 2){
            System.out.printf("You are late, please pay %.1f yuan!",250.0);
        }else if(delta <= 30){
            System.out.print("The return is successful!");
        }else if(delta <= 60){
            System.out.printf("You are late, please pay %.1f yuan!",(delta-30)*0.5);
        }else if(delta <= 180){
            System.out.printf("You are late, please pay %.1f yuan!",(15+(delta-60)*0.7));
        }else {
            System.out.printf("You are late, please pay %.1f yuan!",250.0);
        }
    }
}
