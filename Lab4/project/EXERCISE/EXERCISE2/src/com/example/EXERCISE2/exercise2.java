package com.example.EXERCISE2;
import java.util.Scanner;
import java.util.Random;
public class exercise2 {
    public static void main(String[] args){
        Random random = new Random();
        int magicNum = random.nextInt(10);
        int Guessingnumber;
        Scanner input = new Scanner(System.in);

        System.out.println("The game is running! There is a number from 0 to 9. Try to find it!");
        System.out.println("Please enter an integer between 0 to 9");
        Guessingnumber = input.nextInt();

            while (Guessingnumber != magicNum) {
                if (Guessingnumber > magicNum) {
                    System.out.println("Too big!Please try again:");
                } else {
                    System.out.println("Too small!Please try again:");
                }
                Guessingnumber = input.nextInt();
            }
            System.out.println("Congratulations!");

        input.close();
    }
}
