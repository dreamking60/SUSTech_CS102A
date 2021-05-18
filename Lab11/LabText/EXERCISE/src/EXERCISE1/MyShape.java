package EXERCISE1;
import java.util.*;
public class MyShape {
    public static void main(String[] args) {
        ArrayList<Circle> CircleList = new ArrayList<Circle>();
        for(int i = 0; i < 10; i++ ){
            for( int j = 0; j < 10; j++ ){
                CircleList.add(new Circle(0.1,i*0.1,j*0.1));
            }
        }
        Collections.sort(CircleList);
        for( int i = 0; i < CircleList.size(); i++){
            CircleList.get(i).customizedColor(ColorScheme.RAINBOW, i);
        }

    }
}
