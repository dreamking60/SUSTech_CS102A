package EXERCISE1;

import java.awt.*;

public class Rectangle extends Shape implements Comparable<Rectangle>, ColorDraw{
    private double width;
    private double height;

    public Rectangle(double x, double y) {
        super(x, y);
    }

    public Rectangle(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;

    }

    public void checkColor() {
        if (isInBoundary()) {
            color = ShapeColor.GREEN;
        } else {
            color = ShapeColor.RED;
        }
    }

    public boolean isInBoundary() {
        if (-1 * Rectangle.screenSize > x - this.width / 2 || Rectangle.screenSize < x + this.width / 2) {
            return false;
        }
        if (-1 * Rectangle.screenSize > y - this.height / 2 || Rectangle.screenSize < y + this.height / 2) {
            return false;
        }
        return true;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {
        return "Rectangle{" + "width=" + width + ", height=" + height + " x=" + x +
                ", y=" + y + ", color=" + color + "}\n";
    }

    public void draw() {
        StdDraw.setPenColor(color.getColor());
        StdDraw.filledRectangle(x, y, this.width / 2, this.height / 2);
    }

    @Override
    public int compareTo( Rectangle o){
        double area = this.height * this.width;
        double oArea = o.height * o.width;
        if( area > oArea ){
            return -1;
        }else if( area < oArea){
            return 1;
        }else if( this.x < o.x){
            return -1;
        }else if( this.x > o.x){
            return 1;
        }
        return 0;
    }

    @Override
    public void customizedColor( ColorScheme colorScheme, int index){
        Color[] colorList = colorScheme.getColorScheme();
        if( index < 0 ){
            index = 0;
        }
        if( index >= colorList.length){
            index = index % colorList.length;
        }
        StdDraw.setPenColor(colorList[index]);
        StdDraw.filledRectangle(x, y, width/2, height/2);
    }
}

