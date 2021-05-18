package com.example.test;
import java.util.Random;
public class TEST4 {
    public static void main(String[] args) {
        Random random = new Random();
        int One, Two, Three, Four, Five, Six;
        One = 0;
        Two = 0;
        Three = 0;
        Four = 0;
        Five = 0;
        Six = 0;
        int[] number = new int[6000];
        for( int i = 0; i < 6000; i++){
            number[i] = random.nextInt(6);
            switch(number[i]){
                case 0:
                    One += 1;
                    break;
                case 1:
                    Two += 1;
                    break;
                case 2:
                    Three += 1;
                    break;
                case 3:
                    Four += 1;
                    break;
                case 4:
                    Five += 1;
                    break;
                case 5:
                    Six += 1;
                    break;
            }
        }
        System.out.printf("One is %d\n", One);
        System.out.printf("Two is %d\n", Two);
        System.out.printf("Three is %d\n", Three);
        System.out.printf("Four is %d\n", Four);
        System.out.printf("Five is %d\n", Five);
        System.out.printf("Six is %d\n", Six);
    }
}
