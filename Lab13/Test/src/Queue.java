import java.util.ArrayList;

public class Queue<E> {
    private ArrayList<E> Ar = new ArrayList<E>();

    public void enqueue(E e){
        Ar.add(e);
    }

    public E dequeue(){
        E e = Ar.get(0);
        Ar.remove(0);
        return e;
    }

    public boolean hasItems(){
        return !Ar.isEmpty();
    }
}
