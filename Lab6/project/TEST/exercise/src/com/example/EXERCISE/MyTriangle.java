package com.example.EXERCISE;
import java.lang.String;
import java.util.Scanner;
public class MyTriangle {
    public static void main(String[] args) {
        fA();
    }
    static void fA() {
        Scanner in = new Scanner(System.in);
        double a, b, c, area, perimeter;
        boolean result;
        System.out.println("Please input three numbers for a, b, c:");
        a = in.nextDouble();
        if (a == -1) {
            System.out.println("Bye~");
            System.exit(0);
        }
        b = in.nextDouble();
        c = in.nextDouble();
        result = isValid(a, b, c);
        if (result == true) {
            area = area(a, b, c);
            System.out.printf("The area is %.3f\n", area);
            perimeter = perimeter(a, b, c);
            System.out.printf("The perimeter is %.3f\n", perimeter);
            fA();
        } else {
            System.out.println("The input is invalid.");
            fA();
        }
    }
    public static boolean isValid(double a, double b, double c){
        if( a < b + c && b < c + a && c < a + b){
            return true;
        }else{
            return false;
        }
    }
    public static double area(double a, double b, double c){
        double area, p;
        p = (a + b + c)/2;
        area = Math.sqrt(p*(p -a)*(p - b)*(p - c));
        return area;
    }
    public static double perimeter(double a, double b, double c){
        double perimeter;
        perimeter = a + b + c;
        return perimeter;
    }
    public static double area(double bottom, double height){
        double area;
        area = bottom * height * ((double)1/2);
        return area;
    }
    public static double area(double a, double b, int angle){
        double area;
        area = a * b * Math.sin(angle*Math.PI/180) * ((double)1/2);
        return area;
    }
}
