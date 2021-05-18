import java.util.ArrayList;

public class Stack<E> {
    private ArrayList<E> Ar = new ArrayList<E>();

    public void push( E o ){
        Ar.add(o);
    }

    public E pop() {
        E o = Ar.get(Ar.size()-1);
        Ar.remove(Ar.size()-1);
        return o;
    }

    public boolean hasItems(){
        return !Ar.isEmpty();
    }

}
