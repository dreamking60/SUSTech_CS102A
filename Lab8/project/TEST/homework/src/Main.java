import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] letter = {'I','V','X','L','C','D','M'};
        String number = in.nextLine();
        int total = 0;
        char[] num = number.toCharArray();
        for( int i = 0; i < number.length(); i++ ){
            if( num[i] == 'I' ){
                if (i < number.length() - 1 && num[i + 1] != 'I') {
                    total += -1;
                } else {
                    total += 1;
                }
            }
            if( num[i] == 'V' ){
                if( i < number.length() - 1 && num[i + 1] != 'I'){
                    total += -5;
                }else {
                    total += 5;
                }
            }
            if( num[i] == 'X' ){
                if( i < number.length() - 1 && num[i + 1] != 'X' && num[i+1] != 'I' && num[i+1] != 'V'){
                    total += -10;
                }else {
                    total += 10;
                }
            }
            if( num[i] == 'L' ){
                if( i < number.length() - 1 && num[i + 1] != 'X' && num[i+1] != 'I' && num[i+1] != 'V'){
                    total += -50;
                }else {
                    total += 50;
                }
            }
            if( num[i] == 'C' ){
                if( i < number.length() - 1 && (num[i + 1] == 'D' || num[i+1] == 'M') ){
                    total += -100;
                }else {
                    total += 100;
                }
            }
            if( num[i] == 'D' ){
                if( i < number.length() - 1 && num[i + 1] != 'X' && num[i+1] != 'I' && num[i+1] != 'V' && num[i+1] != 'C'){
                    total += -500;
                }else {
                    total += 500;
                }
            }
            if( num[i] == 'M' ){
                    total += 1000;
            }
        }
        System.out.println(total);
    }
}