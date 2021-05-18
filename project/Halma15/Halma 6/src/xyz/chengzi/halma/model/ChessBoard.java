package xyz.chengzi.halma.model;

import xyz.chengzi.halma.listener.GameListener;
import xyz.chengzi.halma.listener.Listenable;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChessBoard implements Listenable<GameListener>, Serializable {
    private List<GameListener> listenerList = new ArrayList<>();
    private Square[][] grid;
    private int dimension;
    public int Chinesechecker;
    private Color color;
    private ArrayList<save> a=new ArrayList<>();
    public ChessBoard(int dimension,int Chinesechecker) {
        this.grid = new Square[dimension][dimension];
        this.dimension = dimension;
        this.Chinesechecker=Chinesechecker;
        initGrid();
    }


    public int getChinesechecker() {
        return Chinesechecker;
    }

    private void initGrid() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                grid[i][j] = new Square(new ChessBoardLocation(i, j));
            }
        }
    }

    public void setPieceOn(ArrayList<save> A){
        for (xyz.chengzi.halma.model.save save : A) {
            grid[save.getChessBoardLocation().getRow()][save.getChessBoardLocation().getColumn()].setPiece(new ChessPiece(save.getColor()));
        }

        listenerList.forEach(listener -> listener.onChessBoardReload(this));
    }

    public void placeInitialPieces() {
        if(Chinesechecker==2) {
            for (int x = 0,size = 5; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    if (x + y <= size) {
                        grid[x][y].setPiece(new ChessPiece(Color.RED));
                        grid[15 - x][15 - y].setPiece(new ChessPiece(Color.GREEN));

                    }
                }
            }
            listenerList.forEach(listener -> listener.onChessBoardReload(this));
        }
        else {
            for (int x = 0,size = 4; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    if (x + y <= size) {
                        grid[x][y].setPiece(new ChessPiece(Color.RED));
                        grid[15 - x][15 - y].setPiece(new ChessPiece(Color.GREEN));
                    }
                }
            }
            for (int x = 12; x < 16; x++) {
                for (int y = 0;y < 4; y++) {
                    if (x - y > 10) {
                        grid[x][y].setPiece(new ChessPiece(Color.BLUE));
                        grid[15 - x][15 - y].setPiece(new ChessPiece(Color.ORANGE));
                    }
                }
            }
            listenerList.forEach(listener -> listener.onChessBoardReload(this));
        }
        System.out.println(Chinesechecker);
    }
    public ArrayList<save> set() {
        ArrayList<save>b=new ArrayList<>();
        if(Chinesechecker==2) {
            for (int x = 0,size = 5; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    if (x + y <= size) {
                        if(!b.contains(new save(new ChessBoardLocation(x,y),Color.RED))){
                            b.add(new save(new ChessBoardLocation(x,y),Color.RED));
                        }
                        if(!b.contains(new save(new ChessBoardLocation(15-x,15-y),Color.GREEN))){
                            b.add(new save(new ChessBoardLocation(15-x,15-y),Color.GREEN));
                        }
                    }
                }
            }
            listenerList.forEach(listener -> listener.onChessBoardReload(this));
        }
        else {
            for (int x = 0,size = 4; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    if (x + y <= size) {
                        if(!b.contains(new save(new ChessBoardLocation(x,y),Color.RED))){
                            b.add(new save(new ChessBoardLocation(x,y),Color.RED));
                        }
                        if(!b.contains(new save(new ChessBoardLocation(15-x,15-y),Color.GREEN))){
                            b.add(new save(new ChessBoardLocation(15-x,15-y),Color.GREEN));
                        }
                    }
                }
            }
            for (int x = 12; x < 16; x++) {
                for (int y = 0;y < 4; y++) {
                    if (x - y > 10) {
                        if(!b.contains(new save(new ChessBoardLocation(x,y),Color.BLUE))){
                            b.add(new save(new ChessBoardLocation(x,y),Color.BLUE));
                        }
                        if(!b.contains(new save(new ChessBoardLocation(15-x,15-y),Color.ORANGE))){
                            b.add(new save(new ChessBoardLocation(15-x,15-y),Color.ORANGE));
                        }
                    }
                }
            }
            listenerList.forEach(listener -> listener.onChessBoardReload(this));
        }
        return b;
    }
    public ArrayList<ChessBoardLocation> get(ArrayList<save> b,Color a){
        ArrayList<ChessBoardLocation>A=new ArrayList<>();
        for (xyz.chengzi.halma.model.save save : b) {
            if (save.getColor().toString().equals(a.toString())) {
                A.add(save.getChessBoardLocation());
            }
        }
        return A;
    }

    public Square getGridAt(ChessBoardLocation location) {
        return grid[location.getRow()][location.getColumn()];
    }

    public ChessPiece getChessPieceAt(ChessBoardLocation location) {
        return getGridAt(location).getPiece();
    }

    public void setChessPieceAt(ChessBoardLocation location, ChessPiece piece) {
        getGridAt(location).setPiece(piece);
        listenerList.forEach(listener -> listener.onChessPiecePlace(location, piece));
    }

    public ChessPiece removeChessPieceAt(ChessBoardLocation location) {
        ChessPiece piece = getGridAt(location).getPiece();
        getGridAt(location).setPiece(null);
        listenerList.forEach(listener -> listener.onChessPieceRemove(location));
        return piece;
    }

    public void moveChessPiece(ChessBoardLocation src, ChessBoardLocation dest) {
        //if (!(isValidMove1(src, dest)||isValidMove2(src, dest))) {
            //throw new IllegalArgumentException("Illegal halma move");
        //}
        setChessPieceAt(dest, removeChessPieceAt(src));
    }
    public int getDimension() {
        return dimension;
    }
    public ArrayList<ChessBoardLocation> library(ChessBoardLocation src){
        ArrayList<ChessBoardLocation>a=new ArrayList<>();
        ArrayList<ChessBoardLocation>b=new ArrayList<>();
        a.add(src);
        for (int i=0;i<16;i++){
            for (int j=0;j<16;j++){
                for (ChessBoardLocation chessBoardLocation : a) {
                    if (isVaild(chessBoardLocation, new ChessBoardLocation(i, j))) {
                        b.add(new ChessBoardLocation(i, j));
                    }
                }
            }
        }
        ArrayList<ChessBoardLocation>c= new ArrayList<>();
        while (!b.equals(c)) {
            a.addAll(b);
            b = new ArrayList<>();
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    for (ChessBoardLocation chessBoardLocation : a) {
                        if (isVaild2(chessBoardLocation, new ChessBoardLocation(i, j))&&!a.contains(new ChessBoardLocation(i,j))&&getChessPieceAt(new ChessBoardLocation(i,j))==null) {
                            b.add(new ChessBoardLocation(i, j));
                        }
                    }
                }
            }
        }
        return a;
    }


    public boolean isVaild2(ChessBoardLocation src, ChessBoardLocation dest){
        if ( getChessPieceAt(dest) != null) {
            return false;
        }
        int srcRow = src.getRow(), srcCol = src.getColumn(), destRow = dest.getRow(), destCol = dest.getColumn();
        if(srcRow >16&&srcCol>16&& destRow >16&& destCol >16){
            return false;
        }
        if(srcRow <0&&srcCol<0&& destRow <0&& destCol <0){
            return false;
        }
        int rowDistance = destRow - srcRow, colDistance = destCol - srcCol;
        if((srcRow+destRow)%2==0&&(srcCol+destCol)%2==0) {
            ChessBoardLocation middle = new ChessBoardLocation((srcRow + destRow) / 2, (srcCol + destCol) / 2);
            if (rowDistance <= 2 && colDistance <= 2) {
                return getChessPieceAt(middle) != null;
            }
        }
        return false;
    }
    public boolean isVaild(ChessBoardLocation src,ChessBoardLocation dest){
        if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
            return false;
        }
        int srcRow = src.getRow(), srcCol = src.getColumn(), destRow = dest.getRow(), destCol = dest.getColumn();
        if(srcRow >16&&srcCol>16&& destRow >16&& destCol >16){
            return false;
        }
        if(srcRow <0&&srcCol<0&& destRow <0&& destCol <0){
            return false;
        }
        int rowDistance = destRow - srcRow, colDistance = destCol - srcCol;
        if((srcRow+destRow)%2==0&&(srcCol+destCol)%2==0) {
            ChessBoardLocation middle = new ChessBoardLocation((srcRow + destRow) / 2, (srcCol + destCol) / 2);
            if (rowDistance <= 2 && colDistance <= 2) {
                return getChessPieceAt(middle) != null;
            }
        }
        return false;
    }
    public ArrayList<ChessBoardLocation> Move(ChessBoardLocation a){
        ArrayList<ChessBoardLocation>b=new ArrayList<>();
        for (int i=0;i<dimension;i++){
            for (int j=0;j<dimension;j++){
                if(isValidMove1(a,new ChessBoardLocation(i,j))||isValidMove2(a,new ChessBoardLocation(i,j))){
                    b.add(new ChessBoardLocation(i,j));
                }
            }
        }
        return b;
    }
    public ArrayList<ChessBoardLocation> ChessGot(){//获得所有棋子
        ArrayList<ChessBoardLocation> b = new ArrayList<>();
        for (int i=0;i<dimension;i++){
            for (int j=0;j<dimension;j++){
                if(getChessPieceAt(new ChessBoardLocation(i,j))!=null&&getChessPieceAt(new ChessBoardLocation(i,j)).getColor().toString().equals(Color.RED.toString())&&!b.contains(new ChessBoardLocation(i,j))){
                    b.add(new ChessBoardLocation(i,j));
                }
            }
        }
        return b;
    }
    public int max(int[]a){
        int b=a[0];
        int j=0;
        for (int i=0;i<a.length;i++) {
            if (a[i] >= b) {
                b =a[i] ;
                j=i;
            }
        }
        return j;
    }

    public ChessBoardLocation best(ArrayList<ChessBoardLocation> a,ChessBoardLocation b){//判断对于任意的棋子，哪一个最合适
        int[] c=new int[a.size()];
        for (int i=0;i<a.size();i++){
            c[i]=Math.abs(a.get(i).getColumn()-b.getColumn())+Math.abs(a.get(i).getRow()-b.getRow());
        }
        int i=max(c);
        return a.get(i);
    }
    public ChessBoardLocation bestPlus(ArrayList<ChessBoardLocation> a,ArrayList<ChessBoardLocation> b,int d){//判断每一个棋子，哪一个最合适
        int[] c=new int[a.size()];
        for (int i=0;i<a.size();i++){
            c[i]=Math.abs(a.get(i).getColumn()-b.get(i).getColumn())+Math.abs(a.get(i).getRow()-b.get(i).getRow());
        }
        int i=max(c);
        if(d==0){
            return a.get(i);
        }
        else return b.get(i);
    }

    public boolean isValidMove1(ChessBoardLocation src, ChessBoardLocation dest) {
        if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
            return false;
        }
        int srcRow = src.getRow(), srcCol = src.getColumn(), destRow = dest.getRow(), destCol = dest.getColumn();
        int rowDistance = destRow - srcRow, colDistance = destCol - srcCol;
        if (rowDistance != 0 && colDistance != 0 && Math.abs((double) rowDistance / colDistance) != 1.0) {
            return false;
        }
        if(getChessPieceAt(src).getColor().toString().equals(Color.RED.toString())){
            if(Chinesechecker==2){
                if(src.getColumn()+src.getRow()>=25&&dest.getRow()+dest.getColumn()<25){
                    return false;
                }
            }
            if(Chinesechecker==4){
                if(src.getColumn()+src.getRow()>=27&&dest.getRow()+dest.getColumn()<27){
                    return false;
                }
            }
        }
        if(getChessPieceAt(src).getColor().toString().equals(Color.GREEN.toString())){
            if(Chinesechecker==2){
                if(src.getColumn()+src.getRow()<=5&&dest.getRow()+dest.getColumn()>5){
                    return false;
                }
            }
            if(Chinesechecker==4){
                if(src.getColumn()+src.getRow()<=4&&dest.getRow()+dest.getColumn()>4){
                    return false;
                }
            }
        }
        if(getChessPieceAt(src).getColor().toString().equals(Color.ORANGE.toString())){
            if(Chinesechecker==4){
                if(-src.getColumn()+src.getRow()>=11&&dest.getRow()-dest.getColumn()<11){
                    return false;
                }
            }
        }
        if(getChessPieceAt(src).getColor().toString().equals(Color.BLUE.toString())){
            if(Chinesechecker==4){
                if(src.getColumn()-src.getRow()>=11&&-dest.getRow()+dest.getColumn()<11){
                    return false;
                }
            }
        }
        return  Math.abs(rowDistance) <= 1 && Math.abs(colDistance) <= 1;
    }
    public boolean isValidMove2(ChessBoardLocation src, ChessBoardLocation dest) {
        if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
            return false;
        }
        if (src == dest) {
            return false;
        }
        if(getChessPieceAt(src).getColor().toString().equals(Color.RED.toString())){
            if(Chinesechecker==2){
                if(src.getColumn()+src.getRow()>=25&&dest.getRow()+dest.getColumn()<25){
                    return false;
                }
            }
            if(Chinesechecker==4){
                if(src.getColumn()+src.getRow()>=27&&dest.getRow()+dest.getColumn()<27){
                    return false;
                }
            }
        }
        return library(src).contains(dest);
    }
    public ArrayList<ChessBoardLocation> check(Color a){
        ArrayList<ChessBoardLocation> b=new ArrayList<>();
        for (int i=0;i<dimension;i++ ){
            for (int j=0;j<dimension;j++){
                if(getChessPieceAt(new ChessBoardLocation(i,j))!=null&& getChessPieceAt(new ChessBoardLocation(i, j)).getColor().toString().equals(a.toString()) &&!b.contains(new ChessBoardLocation(i,j))){
                    b.add(new ChessBoardLocation(i,j));
                }
            }
        }
        return b;
    }
    public ArrayList<save> checkPlus(Color a,Color b,Color c,Color d){
        ArrayList<ChessBoardLocation>A=check(a);
        ArrayList<ChessBoardLocation>B=check(b);
        ArrayList<ChessBoardLocation>C=check(c);
        ArrayList<ChessBoardLocation>D=check(d);
        ArrayList<save> X=new ArrayList<>();
        for (ChessBoardLocation chessBoardLocation : A) {
            X.add(new save(chessBoardLocation, a));
        }
        for (ChessBoardLocation chessBoardLocation : B) {
            X.add(new save(chessBoardLocation, b));
        }
        for (ChessBoardLocation chessBoardLocation : C) {
            X.add(new save(chessBoardLocation, c));
        }
        for (ChessBoardLocation chessBoardLocation : D) {
            X.add(new save(chessBoardLocation, d));
        }
        return X;
    }
    public boolean winner(ArrayList<ChessBoardLocation> A,Color a) {
        if (a == Color.GREEN) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4 && (i + j < 5); j++) {
                    if (!A.contains(new ChessBoardLocation(i, j))) {
                        return false;
                    }
                }
            }
        }
        if (a == Color.RED) {
            for (int i = 15; i > 11; i--) {
                for (int j = 15; j > 11 && i + j > 26; j--) {
                    if (!A.contains(new ChessBoardLocation(i, j))) {
                        return false;
                    }
                }
            }
        }
        if (a == Color.ORANGE) {
            for (int x = 12; x < 16; x++) {
                for (int y = 0; y < 4; y++) {
                    if (x - y > 10) {
                        if (!A.contains(new ChessBoardLocation(x, y))) {
                            return false;
                        }
                    }
                }
            }
        }
            if (a == Color.BLUE) {
                for (int x = 12; x < 16; x++) {
                    for (int y = 0; y < 4; y++) {
                        if (x - y > 10) {
                            if (!A.contains(new ChessBoardLocation(15-x, 15-y))) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }


    public String getColor() {
        if(color.toString().equals(Color.RED.toString())){
            return "Red";
        }else if( color.toString().equals(Color.GREEN.toString())){
            return "Green";
        }else if( color.toString().equals(Color.BLUE.toString())){
            return "Blue";
        }else{
            return "Orange";
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }


    @Override
    public void registerListener(GameListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void unregisterListener(GameListener listener) {
        listenerList.remove(listener);
    }
}