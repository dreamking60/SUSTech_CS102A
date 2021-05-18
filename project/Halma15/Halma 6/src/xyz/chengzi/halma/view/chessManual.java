package xyz.chengzi.halma.view;

import xyz.chengzi.halma.model.ChessBoardLocation;

import java.util.ArrayList;

public class chessManual {
    public ArrayList<Undo> Manual=new ArrayList<>();
    public chessManual(ChessBoardLocation a,ChessBoardLocation b,ArrayList<Undo> c){
        c.add(new Undo(a,b));
        Manual=c;
    }

    public ArrayList<Undo> getManual() {
        return Manual;
    }

    public void setManual(ArrayList<Undo> manual) {
        Manual = manual;
    }
}
