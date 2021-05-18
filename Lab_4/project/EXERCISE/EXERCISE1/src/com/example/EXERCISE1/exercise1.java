package com.example.EXERCISE1;
public class exercise1 {
    public static void main(String[] args) {
        int a;
        for(int i = 1 ; i <=9 ; i++){
            for( int j = 1 ; j <= i ; j++){
                a = i * j;
                if( a < 10) {
                    System.out.printf("%2d *%2d =%2d ", j, i, a);
                }else{
                    System.out.printf("%2d *%2d = %2d", j, i, a);
                }
            }
            System.out.println("");
        }
    }
}
