package com.example.test;
public class TEST1 {
    public static void main(String[] args) {
        int a, b, c;
        a = 1;
        b = 2;
        c = plus( a, b);
        System.out.println(c);
        System.out.println(a);
    }
    public static int plus(int a, int b){
        a = a + b;
        System.out.println(a);
        return a;
    }
}
