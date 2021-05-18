package com.example.EXERCISE;
import java.util.Scanner;
public class Lab6E2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double bottom, height, area;
        System.out.println("Please input two numbers of bottom and height: ");
        bottom = in.nextDouble();
        height = in.nextDouble();
        area = MyTriangle.area(bottom, height);
        System.out.printf("The area is %.3f\n", area);
        int angle;
        double a, b;
        System.out.println("Please input two numbers of a and b: ");
        a = in.nextDouble();
        b = in.nextDouble();
        System.out.println("Please input a number in (0,180) for angle(angle is a float variable): ");
        angle = in.nextInt();
        area = MyTriangle.area(a, b, angle);
        System.out.printf("The area is %.3f", area);
    }
}
