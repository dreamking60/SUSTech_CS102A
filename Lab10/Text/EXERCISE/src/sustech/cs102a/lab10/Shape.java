package sustech.cs102a.lab10;

public class Shape {
    protected double x;
    protected double y;
    protected ShapeColor color = ShapeColor.GRAY;
    protected static int screenSize = 10;

    public Shape(double x, double y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "x=" + x + ", y=" + y + ", color=" + color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public ShapeColor getColor() {
        return color;
    }

    public void setColor(ShapeColor color) {
        this.color = color;
    }

    public static int getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(int screenSize) {
        Shape.screenSize = screenSize;
    }

}
