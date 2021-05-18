package xyz.chengzi.halma.controller;

import xyz.chengzi.halma.listener.InputListener;
import xyz.chengzi.halma.model.*;
import xyz.chengzi.halma.view.*;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class GameController implements InputListener, Serializable {
    private ChessBoardComponent view;
    private ChessBoard model;
    private ChessBoardLocation selectedLocation;
    public Color currentPlayer;
    private chessManual Manual;
    public File Datafile;
    private ArrayList<save> AgoSave = new ArrayList<save>();//前数组
    private ArrayList<save> NowSave = new ArrayList<save>();//后数组，两个数组的差异用于悔棋
    private information message;
    private int ModifierNumber = 0;
    private GameFrame mainFrame;
    public GameController(ChessBoardComponent chessBoardComponent, ChessBoard chessBoard, File file) {
        this.view = chessBoardComponent;
        this.model = chessBoard;
        this.currentPlayer = Color.RED;
        model.setColor(currentPlayer);
        view.registerListener(this);
        model.registerListener(view);
        model.placeInitialPieces();
        Datafile = file;
        setNowSave(NowSave);
        message = new information(NowSave, currentPlayer, chessBoard.getChinesechecker());
        try{
            FileOutputStream IN = new FileOutputStream(Datafile);
            ObjectOutputStream out = new ObjectOutputStream(IN);
            out.writeObject(message);
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public GameController(ChessBoardComponent chessBoardComponent, ChessBoard chessBoard, File file, int a) {
        this.view = chessBoardComponent;
        this.model = chessBoard;
        this.currentPlayer = Color.RED;
        this.ModifierNumber = a;
        model.setColor(currentPlayer);
        view.registerListener(this);
        model.registerListener(view);
        model.placeInitialPieces();
        Datafile = file;
        setNowSave(NowSave);
        ModifierNumber=a;
        message = new information(NowSave, currentPlayer, chessBoard.getChinesechecker());
        try{
            FileOutputStream IN = new FileOutputStream(Datafile);
            ObjectOutputStream out = new ObjectOutputStream(IN);
            out.writeObject(message);
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public GameController(ChessBoardComponent chessBoardComponent, ChessBoard chessBoard, File file, information A) {
        this.view = chessBoardComponent;
        this.model = chessBoard;
        this.currentPlayer = A.getColor();
        model.setColor(currentPlayer);
        view.registerListener(this);
        model.registerListener(view);
        model.setPieceOn(A.getA());
        setNowSave(NowSave);
        Datafile = file;
        message = new information(NowSave, currentPlayer, chessBoard.getChinesechecker());
        try{
            FileOutputStream IN = new FileOutputStream(Datafile);
            ObjectOutputStream out = new ObjectOutputStream(IN);
            out.writeObject(message);
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public GameController(ChessBoardComponent chessBoardComponent, ChessBoard chessBoard, File file, information A, int a) {
        this.view = chessBoardComponent;
        this.model = chessBoard;
        this.currentPlayer = A.getColor();
        this.ModifierNumber = a;
        model.setColor(currentPlayer);
        view.registerListener(this);
        model.registerListener(view);
        model.setPieceOn(A.getA());
        setNowSave(NowSave);
        Datafile = file;
        message = new information(NowSave, currentPlayer, chessBoard.getChinesechecker());
        try{
            FileOutputStream IN = new FileOutputStream(Datafile);
            ObjectOutputStream out = new ObjectOutputStream(IN);
            out.writeObject(message);
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public ChessBoardLocation getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(ChessBoardLocation location) {
        this.selectedLocation = location;
    }

    public void resetSelectedLocation() {
        setSelectedLocation(null);
    }

    public boolean hasSelectedLocation() {
        return selectedLocation != null;
    }

    public Color nextPlayer() {
        if(model.Chinesechecker==2){
            return currentPlayer = currentPlayer == Color.RED ? Color.GREEN : Color.RED;
        }
        else {
            if(currentPlayer==Color.RED){
                return currentPlayer=Color.BLUE;
            }
            if(currentPlayer==Color.BLUE){
                return currentPlayer=Color.GREEN;
            }
            if(currentPlayer==Color.GREEN){
                return currentPlayer=Color.ORANGE;
            }
            else {
                return currentPlayer=Color.RED;
            }
        }
    }

    public int getModifierNumber() {
        return ModifierNumber;
    }

    @Override
    public void onPlayerClickSquare(ChessBoardLocation location, SquareComponent component) {
        String A="红方胜利";
        char[] cs = { '红','方','胜', '利' };
        String A1="绿方胜利";
        char[] cs1 = { '绿','方','胜', '利' };
        String A2="蓝方胜利";
        char[] cs2 = { '蓝','方','胜', '利' };
        String A3="橙方胜利";
        char[] cs3 = { '橙','方','胜', '利' };
        if (hasSelectedLocation() && model.isValidMove1(getSelectedLocation(), location)||ModifierNumber!=0) {
            try{
                FileOutputStream file = new FileOutputStream(Datafile);
                ObjectOutputStream out = new ObjectOutputStream(file);
                message.setColor(getCurrentPlayer());
                out.writeObject(message);
                out.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            model.moveChessPiece(selectedLocation, location);
            resetSelectedLocation();
            if(model.Chinesechecker==2) {
            if (model.winner(model.check(Color.RED), Color.RED)) {
                win.print(A,cs);
            }
            if (model.winner(model.check(Color.GREEN), Color.GREEN)) {
                win.print(A1,cs1);
            }
        }
        else {
            if (model.winner(model.check(Color.RED), Color.RED)) {
                win.print(A,cs);
            }
            if (model.winner(model.check(Color.GREEN), Color.GREEN)) {
                win.print(A1,cs1);
            }
            if (model.winner(model.check(Color.ORANGE), Color.ORANGE)) {
                win.print(A2,cs2);
            }
            if (model.winner(model.check(Color.BLUE), Color.BLUE)) {
                win.print(A3,cs3);
            }
        }
        renew(NowSave);
        Color a=currentPlayer;
        mainFrame.setPlayer(getColor(getnextPlayer(currentPlayer)));
        nextPlayer();
            if(currentPlayer.toString().equals(a.toString())){
                model.setColor(nextPlayer());
                mainFrame.setPlayer(getColor(getnextPlayer(currentPlayer)));
                nextPlayer();
            }
         }
        if (hasSelectedLocation() && model.isValidMove2(getSelectedLocation(), location)) {
            try{
                FileOutputStream file = new FileOutputStream(Datafile);
                ObjectOutputStream out = new ObjectOutputStream(file);
                message.setColor(getCurrentPlayer());
                out.writeObject(message);
                out.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            model.moveChessPiece(selectedLocation, location);
            resetSelectedLocation();
            if(model.Chinesechecker==2) {
                if (model.winner(model.check(Color.RED), Color.RED)) {
                    win.print(A,cs);
                }
                if (model.winner(model.check(Color.GREEN), Color.GREEN)) {
                    win.print(A1,cs1);
                }
            }
            else {
                if (model.winner(model.check(Color.RED), Color.RED)) {
                    win.print(A,cs);
                }
                if (model.winner(model.check(Color.GREEN), Color.GREEN)) {
                    win.print(A1,cs1);
                }
                if (model.winner(model.check(Color.ORANGE), Color.ORANGE)) {
                    win.print(A2,cs2);
                }
                if (model.winner(model.check(Color.BLUE), Color.BLUE)) {
                    win.print(A3,cs3);
                }
            }
            renew(NowSave);
            Color a=currentPlayer;
            mainFrame.setPlayer(getColor(getnextPlayer(currentPlayer)));
            nextPlayer();
            if(currentPlayer.toString().equals(a.toString())){
                model.setColor(nextPlayer());
                mainFrame.setPlayer(getColor(getnextPlayer(currentPlayer)));
                nextPlayer();
            }
        }
    }


    @Override
    public void onPlayerClickChessPiece(ChessBoardLocation location, ChessComponent component) {
        if (!Check()) {
            System.out.println("You cheated!");
            System.exit(0);
        }
        if (model.getChessPieceAt(location) == null) {
            return;
        } else {
            ChessPiece piece = model.getChessPieceAt(location);
            if (ModifierNumber != 0 && !hasSelectedLocation() || location.equals(getSelectedLocation())) {
                if (!hasSelectedLocation()) {
                    setSelectedLocation(location);
                } else {
                    resetSelectedLocation();
                }
                System.out.print(ModifierNumber);
                component.setSelected(!component.isSelected());
                component.repaint();
            } else {
                if (currentPlayer.toString().equals(piece.getColor().toString()) && (!hasSelectedLocation() || location.equals(getSelectedLocation()))) {
                    if (!hasSelectedLocation()) {
                        setSelectedLocation(location);
                    } else {
                        resetSelectedLocation();
                    }
                    component.setSelected(!component.isSelected());
                    System.out.println("101" + component.isSelected());
                    component.repaint();
                }
            }
        }
    }
    public ArrayList<save> getNowSave() {
        return NowSave;
    }

    public void setNowSave(ArrayList<save> nowSave) {
        for(int i = 0; i < 16; i++ ){
            for(int j = 0; j < 16; j++){
                if( model.getChessPieceAt(new ChessBoardLocation(i,j)) != null){
                    save Save = new save(new ChessBoardLocation(i,j), model.getChessPieceAt(new ChessBoardLocation(i, j)).getColor());
                    NowSave.add(Save);
                }
            }
        }
    }

    public save[] change(ArrayList<save> a){
        save[] b = new save[a.size()];
        for( int i = 0; i < a.size(); i++ ){
            b[i] = a.get(i);
        }
        return b;
    }

    public void renew(ArrayList<save> a) { //对数组进行更新
        AgoSave = a;
        if (NowSave.size() > 0) {
            NowSave.subList(0, NowSave.size()).clear();
        }
        for(int i = 0; i < 16; i++ ){
            for(int j = 0; j < 16; j++){
                if( model.getChessPieceAt(new ChessBoardLocation(i,j)) != null){
                    save Save = new save(new ChessBoardLocation(i,j), model.getChessPieceAt(new ChessBoardLocation(i, j)).getColor());
                    NowSave.add(Save);
                }
            }
        }
    }


    public Color getCurrentPlayer() {
        return currentPlayer;
    }
    public boolean Check(){
        if(model.Chinesechecker==2){
            if(model.check(Color.RED).size()!=19||model.check(Color.GREEN).size()!=19){
                return false;
            }
        }
        if(model.Chinesechecker==4){
            return model.check(Color.ORANGE).size() == 13 && model.check(Color.BLUE).size() == 13;
        }
        return true;
    }


    public GameFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(GameFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public String getColor(Color color) {
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

    public Color getnextPlayer(Color color) {
        if(model.Chinesechecker==2){
            return color = color == Color.RED ? Color.GREEN : Color.RED;
        }
        else {
            if(color==Color.RED){
                return color=Color.BLUE;
            }
            if(color==Color.BLUE){
                return color=Color.GREEN;
            }
            if(color==Color.GREEN){
                return color=Color.ORANGE;
            }
            else {
                return color=Color.RED;
            }
        }
    }

}
