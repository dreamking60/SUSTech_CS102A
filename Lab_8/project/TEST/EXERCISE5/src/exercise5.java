import java.util.Scanner;
public class exercise5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1, s2;
        int occurrences = 0;
        System.out.print("s1: ");
        s1 = in.nextLine();
        System.out.print("s2: ");
        s2 = in.nextLine();
        int i = 0;
        while( i < s1.length()-3){
            if( s1.indexOf(s2,i) != -1){
                System.out.printf("Found at index: %d\n", s1.indexOf(s2,i));
                occurrences +=1;
                i = s1.indexOf(s2,i) + s2.length();
            }
            if( s1.indexOf(s2,i) == -1){
                i += 1;
            }
        }
        System.out.printf("Total occurrences: %d", occurrences);
    }
}
