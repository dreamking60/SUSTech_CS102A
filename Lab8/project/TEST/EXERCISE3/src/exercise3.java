import java.util.Scanner;
public class exercise3 {
    public static void palindrome() {
        Scanner in = new Scanner(System.in);
        StringBuffer s = new StringBuffer();
        System.out.print("Type a String(quit to finish): ");
        s.append(in.next());
        String a = s.toString();
        a = a.toUpperCase();
        String b = s.reverse().toString();
        b = b.toUpperCase();
        if( a.equals(b)){
            System.out.printf("%s is a palindrome\n", s.reverse());
        }else if( a.equals("QUIT")) {
            return;
        }else{
            System.out.printf("%s is not a palindrome\n", s.reverse());
        }
        palindrome();
    }

    public static void main(String[] args) {
        palindrome();
    }
}
