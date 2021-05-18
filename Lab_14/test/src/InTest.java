import java.util.ArrayList;
import java.util.Collections;

public class InTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(5));
        list.add(new Integer(124));
        list.add(new Integer(-8));
        printList(list);
        Collections.sort(list);
        printList(list);
    }

    public static void printList(ArrayList<Integer> a){
        for( int s : a){
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
