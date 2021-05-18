import java.util.*;
public class Arraylist {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        printList(list);
        list.add("Hello");
        printList(list);
        list.add("World");
        printList(list);
        list.add(1,"java");
        printList(list);
    }
    public static void printList(ArrayList<String> s){
        System.out.println(s);
        for(String a:s){
            System.out.printf("%s\n",a);
        }

    }
}
