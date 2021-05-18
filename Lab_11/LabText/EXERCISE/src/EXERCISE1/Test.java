package EXERCISE1;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        ArrayList<Rectangle> RectangleList = new ArrayList<Rectangle>();
        RectangleList.add(new Rectangle(2, 2,5,4));
        RectangleList.add(new Rectangle(2, 2,4,3));
        RectangleList.add(new Rectangle(2, 2,6,7));
        for( Rectangle i : RectangleList){
            System.out.print(i.toString());
        }
        Collections.sort(RectangleList);
        for( Rectangle i : RectangleList){
            System.out.print(i.toString());
        }
    }
}
