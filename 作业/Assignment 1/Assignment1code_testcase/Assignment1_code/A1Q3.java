

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String isbn = sc.nextLine();

        int k = 1, sum = 0;
        for(int i = 0; i < 9; i++){
            sum += (isbn.charAt(i) - 48) * k;
            k += 1;
        }

        char ans;
        if( sum % 11 != 10){
            ans = (char) (48 + (sum % 11));
        }else{
            ans = 'X';
        }

        if(ans == isbn.charAt(9)){
            System.out.print("Yes");
        }else {
            System.out.print("No");
        }
    }
}
