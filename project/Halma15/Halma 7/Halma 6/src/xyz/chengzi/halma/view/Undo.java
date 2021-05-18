package xyz.chengzi.halma.view;

import xyz.chengzi.halma.model.ChessBoardLocation;

public class Undo {
    public ChessBoardLocation a;
    public ChessBoardLocation b;
    public Undo(ChessBoardLocation src, ChessBoardLocation dest){
        a=src;
        b=dest;
    }

    public void setA(ChessBoardLocation a) {
        this.a = a;
    }

    public void setB(ChessBoardLocation b) {
        this.b = b;
    }

    public ChessBoardLocation getA() {
        return a;
    }

    public ChessBoardLocation getB() {
        return b;
    }
}
