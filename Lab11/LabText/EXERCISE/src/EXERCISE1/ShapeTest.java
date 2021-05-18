package EXERCISE1;
import java.util.*;

public class ShapeTest {
    public static void main(String[] args) {
        List<Circle> circleList = new ArrayList<Circle>();
        Circle.setScreenSize(9);
        StdDraw.setScale(-Shape.getScreenSize(),Shape.getScreenSize());
        for( int i = 1; i <= Shape.getScreenSize(); i += 2){
            circleList.add(new Circle(i,0, i));
        }
        Collections.sort(circleList);
        for( int i = 0; i < circleList.size(); i++ ){
            circleList.get(i).customizedColor(ColorScheme.SKY,i);
        }
    }
}
