package xyz.chengzi.halma.model;

import java.awt.*;
import java.io.Serializable;
import java.util.Objects;

public class save implements Serializable {
    ChessBoardLocation chessBoardLocation;
    Color color;
    public save(ChessBoardLocation a,Color b){
        chessBoardLocation=a;
        color=b;
    }

    public ChessBoardLocation getChessBoardLocation() {
        return chessBoardLocation;
    }

    public void setChessBoardLocation(ChessBoardLocation chessBoardLocation) {
        this.chessBoardLocation = chessBoardLocation;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        save save = (save) o;
        return Objects.equals(chessBoardLocation, save.chessBoardLocation) &&
                Objects.equals(color, save.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chessBoardLocation, color);
    }
}
