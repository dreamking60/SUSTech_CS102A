package xyz.chengzi.halma.model;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class information implements Serializable {
    private ArrayList<save> a;
    private Color color;
    private int Chinesechecker;
    public information(ArrayList<save> a,Color color,int Chinesechecker){
        this.a=a;
        this.color=color;
        this.Chinesechecker=Chinesechecker;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<save> getA() {
        return a;
    }

    public int getChinesechecker() {
        return Chinesechecker;
    }
}
