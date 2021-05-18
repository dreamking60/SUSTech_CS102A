import java.util.Scanner;
public class homework1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String t = "abcdefghijklmnopqrstuvwxyz";
        char[] tablet = t.toCharArray();
        char[] Tablet = t.toUpperCase().toCharArray();
        String s = in.nextLine();
        char[] array = s.toCharArray();
        char[] Array = s.toUpperCase().toCharArray();
        String letter = in.nextLine();
        char[] L = letter.toCharArray();
        for( int i = 0; i < letter.length(); i++){
            for( int j = 0; j < 26; j++){
                if( L[i] == tablet[j] ){
                    L[i] = array[j];
                    break;
                }
                if( L[i] == Tablet[j] ){
                    L[i] = Array[j];
                    break;
                }
            }
            System.out.print(L[i]);
        }

    }
}
