package com.example.test;

public class TEST2 {
    public static void main(String[] args) {
        System.out.println("using command-line arguments.");
        for( int i = 0; i < args.length; i++ ){
            System.out.printf("argument%d: %s", i+1, args[i]);
        }
    }
}

