package com.example.EXERCISE;
import java.util.Scanner;
public class exercise4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row, column, bingo = 0;
        row = in.nextInt();
        column = in.nextInt();
        int[][] board = new int[row][column];
        for( int i = 0; i < row; i++ ){
            for( int j = 0; j < column; j++ ){
                board[i][j] = in.nextInt();
            }
        }
        for( int i = 1; i < row - 1; i++){
            for( int j = 1; j <column - 1; j++ ){
                if( board[i][j] == 0) {
                    boolean a = check(board, i, j);
                    if( a == true ){
                        bingo += 1;
                    }
                }
            }
        }
        if( bingo > 1){
            System.out.printf("There are %d bingo girds.", bingo);
        }else if( bingo == 1){
            System.out.printf("There are  only %d bingo gird.", bingo);
        }else{
            System.out.print("There are no bingo gird.");
        }

    }
    public static boolean check(int[][] board, int row, int column){
        boolean a = false;
        if( board[row-1][column] == 1){
            if( board[row+1][column] == 1 ){
                if( board[row][column-1] == 1){
                    if( board[row][column+1] == 1){
                        a = true;
                    }
                }
            }
        }
        return a;
    }
}
