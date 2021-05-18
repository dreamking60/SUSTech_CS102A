package com.example.test;
import java.util.Random;
public class TEST3 {
    public static void main(String[] args){
        Random random = new Random();
        int[] a;
        int count, up = 0, down = 0;
        a = new int[6000];
        for( count = 0; count < 6000; count++ ){
            a[count] = random.nextInt(2);
            if(a[count] == 0)
                up = up + 1;
            else
                down += 1;
        }
        System.out.printf("The game continues %d times.\n", count);
        System.out.printf("up is %d times and down is %d times.", up, down);
    }
}
