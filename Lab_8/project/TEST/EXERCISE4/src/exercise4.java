import java.util.Scanner;
public class exercise4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder s = new StringBuilder();
        System.out.print("Please type a String: ");
        s.append(in.nextLine());
        if (s.toString().equals("")) {
            System.out.println("Empty String, exit…");
            return;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            char word = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == word) {
                    s.replace(j, j + 1, " ");
                }
            }
        }
        delete(s);
        System.out.printf("After removing repeating chars and space: %s", s);
    }
    public static StringBuilder delete(StringBuilder s){
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                s.delete(i, i + 1);
            }
        }
        for( int i = 0; i < s.length(); i++){
            if( s.charAt(i) == ' '){
                return delete(s);
            }
        }
        return s;
    }
}
