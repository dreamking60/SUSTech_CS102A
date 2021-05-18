import java.util.Random;
public class CircleTest {
    public static void main(String[] args) {
        Random r = new Random(1);
        int N = r.nextInt(5) + 5;
        double[] radius = new double[N];
        double[] x = new double[N];
        double[] y = new double[N];
        double smallestArea = 0, distance = 0;
        Circle[] circle = new Circle[N];
        for( int i = 0; i < N; i++ ){
            radius[i] = 2 * (r.nextDouble() + 0.50);
            x[i] = 3 * r.nextDouble() + 2;
            y[i] = 3 * r.nextDouble() + 2;
            circle[i] = new Circle(radius[i],x[i],y[i]);
            circle[i].cPrint(i);
            if( i == 0){
                smallestArea = circle[i].area();
                distance = circle[i].distanceToOrigin();
            }
            if( i > 0) {
                smallestArea = Math.min(circle[i].area(), smallestArea);
                distance = Math.max(circle[i].distanceToOrigin(), distance);
            }
        }
        for( int i = 0; i < N; i++ ){
            if( smallestArea == circle[i].area() ) {
                System.out.printf("Circle #%d is the smallest circle, area = %.2f\n", i + 1, smallestArea);
            }
            if( distance == circle[i].distanceToOrigin() ) {
                System.out.printf("Circle #%d is the farthest circle, distance to origin = %.2f", i + 1, distance);
            }
        }
    }
}
