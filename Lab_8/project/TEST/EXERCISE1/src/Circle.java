public class Circle {
    private double radius, x = 0, y = 0;
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius, double x, double y){
        this.radius = radius;
        this.x = x;
        this.y = y;
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
    public void cPrint(int number){
        System.out.printf("Circle #%d: radius = %.2f, x = %.2f, y = %.2f\n", number+1, radius, x, y);
    }
}
