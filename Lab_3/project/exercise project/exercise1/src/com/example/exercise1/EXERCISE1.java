package com.example.exercise1;
import java.util.Scanner;
public class EXERCISE1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String name;
        int age;
        float weight;
        char grade;
        System.out.print("Enter your name: ");
        name = input.next();
        System.out.print("Enter your age: ");
        age = input.nextInt();
        System.out.print("Enter your weight KG: ");
        weight = input.nextFloat();
        System.out.print("Enter your highest grade in last semester: ");
        grade = input.next().charAt(0);
        System.out.printf("You are %s.\nYou are %d years old.\n", name, age);
        System.out.printf("You weigh %.1f.\nThe highest grade you got is %c.\n", weight, grade);
    }
}
