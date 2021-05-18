public class Circle {
    private double radius, x = 0, y = 0;
    private static int id = 0;
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius, double x, double y){
        this.radius = radius;
        this.x = x;
        this.y = y;
        id++;
    }
    public double distanceToOrigin(){
        double distance;
        distance = Math.sqrt(x*x+y*y);
        return distance;
    }
    public double area(){
        double area = Math.PI * radius * radius;
        return area;
    }
    public String toString(){
        return "Circle #" +
                id +
            ": radius = " +
                String.format("%.2f",radius) +
            ", x = " +
                String.format("%.2f",x) +
            ", y = "
            + String.format("%.2f",y);
    }
}
