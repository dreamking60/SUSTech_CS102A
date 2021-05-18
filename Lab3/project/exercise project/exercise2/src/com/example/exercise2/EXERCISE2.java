package com.example.exercise2;
import java.util.Scanner;
public class EXERCISE2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float width, height, area, perimeter;
        System.out.print("Enter the width of a rectangle: ");
        width = input.nextFloat();
        System.out.print("Enter the height of a rectangle: ");
        height = input.nextFloat();
        area = width * height;
        perimeter = ( width + height ) * 2;
        System.out.printf("The area is %.2f.\n The perimeter is %.2f", area, perimeter);

    }
}
