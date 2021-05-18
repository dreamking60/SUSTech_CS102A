import java.util.ArrayList;
import java.util.Collections;

public class INTEGER {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(5));
        list.add(124);
        list.add(new Integer(-8));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
