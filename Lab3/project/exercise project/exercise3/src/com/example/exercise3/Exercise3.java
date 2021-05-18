package com.example.exercise3;
import java.util.Scanner;
public class Exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int second, hour, minute;
        System.out.print("Enter the number of seconds: ");
        second = input.nextInt();
        hour = second/3600;
        minute = second/60;
        second = second%60;
        minute = minute%60;
        System.out.printf("The equivalent time is %d hours %d minutes and %d seconds.", hour, minute, second);
        //事实上如果更准确的话，这道题可以分为27种情况，不同情况输出结果的句子不同，例如 1 second；
    }
}
