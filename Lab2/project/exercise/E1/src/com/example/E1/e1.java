package com.example.E1;
import java.util.Scanner;
public class e1 {
    public static void main(String[] args){
        System.out.println("Welcome to CS102A!");
        Scanner input = new Scanner(System.in);
        int number1, number2, sum; //定义三个变量
        System.out.print("Enter the first integer: ");
        number1 = input.nextInt();
        System.out.print("Enter the second integer: ");
        number2 = input.nextInt();
        sum = number1 + number2;
        System.out.printf("Sum is %d\n", sum);
        System.out.print(input);
        input.close();
    }
}
