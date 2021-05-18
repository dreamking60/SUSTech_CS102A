package com.example.EXERCISE;
import java.util.Scanner;
public class exercise3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, a = 0, b = 1;
        n = in.nextInt();
        for( int i = 0; i < n; i++ ){
            int r = b;
            b = a + b;
            a = r;
        }
        System.out.println(a);
    }
}
