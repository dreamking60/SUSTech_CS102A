import java.util.ArrayList;

public class ALTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        printList(list);
        list.add("Hello");
        printList(list);
        list.add("World");
        printList(list);
        list.add(1, "Java");
        printList(list);
    }

    public static void printList(ArrayList<String> a){
        for( String s : a){
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
