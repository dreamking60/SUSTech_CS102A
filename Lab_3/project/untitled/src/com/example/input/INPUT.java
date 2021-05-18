package com.example.input;
import java.util.Scanner;
public class INPUT {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        float c = 0;
        System.out.printf("a / b = %f", c = a/b);
        input.close();
    }
}
