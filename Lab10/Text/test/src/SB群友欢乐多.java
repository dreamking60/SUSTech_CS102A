import java.util.Scanner;
public class SB群友欢乐多 {
    public static void main(String[] args) {
        turn();
    }

    public static void turn() {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append(in.nextLine());
        while (sb.toString().equals("0")){
            return;
        }
        System.out.println(sb.reverse().toString());
        turn();
    }
}
