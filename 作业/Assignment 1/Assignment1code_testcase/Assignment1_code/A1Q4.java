import java.util.Scanner;

public class Main{
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int m = sc.nextInt();
       int d = sc.nextInt();
       int ans = 0;
       
       if(m < 1){
           
           m = 1;
           ans += 1;
           
       }else if(m >12){
           
           int tmp = m % 10;
           if(m / 10 == 1 || tmp == 0 || tmp == 1 || tmp == 2 || tmp == 3 || tmp == 5 || tmp == 7 || tmp == 8){
               
               ans += 1;
               m = 1;
               
           }else{
               
               m = 6;
               ans += 1;
               
           }
        }
        if(d < 1){
            
            ans += 1;
            
        }else if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){
            
            if(d > 31){
                ans += 1;
            }
            
        }else if(m == 4 || m == 6 || m == 9 || m == 11){
            
            if(d > 30){
                ans += 1;
            }
            
        }else if(d > 28){
            
            ans += 1;
        }
       System.out.print(ans);
   }
}