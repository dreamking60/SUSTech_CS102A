import java.util.ArrayList;

public class ListRemove {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        System.out.printf("The list contains %d elements\n", list.size());
        for(int i = 0; i <= list.size(); i++){
            if(list.get(i).startsWith("W"))
                list.remove(i);
        }
        System.out.printf("After removing, the list contains %d elements", list.size());
    }
}
