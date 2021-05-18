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
        if(model.Chinesechecker==2 || model.Chinesechecker==8){
            return currentPlayer = currentPlayer.toString().equals(Color.RED.toString()) ? Color.GREEN : Color.RED;
        }
        else {
            if(currentPlayer.toString().equals(Color.RED.toString())){
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
        if ((hasSelectedLocation() && model.isValidMove1(getSelectedLocation(), location)||ModifierNumber!=0)) {
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
            if(model.Chinesechecker==2 || model.Chinesechecker==8) {
            if (model.winner(model.check(Color.RED), Color.RED)) {
                StarShine.createAndShowGUI1();
            }
            if (model.winner(model.check(Color.GREEN), Color.GREEN)) {
                StarShine1.createAndShowGUI();
            }
        }
        else {
            if (model.winner(model.check(Color.RED), Color.RED)) {
                StarShine.createAndShowGUI1();
            }
            if (model.winner(model.check(Color.GREEN), Color.GREEN)) {
                StarShine1.createAndShowGUI();
            }
            if (model.winner(model.check(Color.ORANGE), Color.ORANGE)) {
                StarShine2.createAndShowGUI();
            }
            if (model.winner(model.check(Color.BLUE), Color.BLUE)) {
                StarShine3.createAndShowGUI2();
            }
        }
            if(model.Chinesechecker==2 || model.Chinesechecker==8) {
                if (model.willWin(model.check(Color.RED), Color.RED)) {
                    mainFrame.setWillWin("Red will win!");
                }
                if (model.willWin(model.check(Color.GREEN), Color.GREEN)) {
                    mainFrame.setWillWin("Green will win!");
                }
            }
            else {
                if (model.willWin(model.check(Color.RED), Color.RED)) {
                    mainFrame.setWillWin("Red will win!");
                }
                if (model.willWin(model.check(Color.GREEN), Color.GREEN)) {
                    mainFrame.setWillWin("Green will win!");
                }
                if (model.willWin(model.check(Color.ORANGE), Color.ORANGE)) {
                    mainFrame.setWillWin("Orange will win!");
                }
                if (model.willWin(model.check(Color.BLUE), Color.BLUE)) {
                    mainFrame.setWillWin("Blue will win!");
                }
            }
        renew(NowSave);
        Color a=currentPlayer;
        if(ModifierNumber==0){
            mainFrame.setPlayer(getColor(getnextPlayer(currentPlayer)));
        }
            if (model.Chinesechecker != 8) {
                nextPlayer();
                while (currentPlayer.toString().equals(a.toString())) {
                    model.setColor(nextPlayer());
                    mainFrame.setPlayer(getColor(getnextPlayer(currentPlayer)));
                    nextPlayer();
                }
            }
            else {
                ArrayList<ChessBoardLocation> A=model.ChessGot();
                ArrayList<ChessBoardLocation> B=new ArrayList<>();
                for (ChessBoardLocation chessBoardLocation : A) {
                    B.add(model.best(model.Move(chessBoardLocation), chessBoardLocation));
                }
                System.out.println(B.toString());
                model.bestPlus(A,B,0);
                model.bestPlus(A,B,1);
                model.moveChessPiece(model.bestPlus(A,B,0),model.bestPlus(A,B,1));
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
            if(model.Chinesechecker==2 || model.Chinesechecker == 8) {
                if (model.winner(model.check(Color.RED), Color.RED)) {
                    StarShine.createAndShowGUI1();
                }
                if (model.winner(model.check(Color.GREEN), Color.GREEN)) {
                    StarShine1.createAndShowGUI();
                }
            }
            else {
                if (model.winner(model.check(Color.RED), Color.RED)) {
                    StarShine.createAndShowGUI1();
                }
                if (model.winner(model.check(Color.GREEN), Color.GREEN)) {
                    StarShine1.createAndShowGUI();
                }
                if (model.winner(model.check(Color.ORANGE), Color.ORANGE)) {
                    StarShine2.createAndShowGUI();
                }
                if (model.winner(model.check(Color.BLUE), Color.BLUE)) {
                    StarShine3.createAndShowGUI2();
                }
            }
            renew(NowSave);
            Color a=currentPlayer;
            if (ModifierNumber == 0) {
                mainFrame.setPlayer(getColor(getnextPlayer(currentPlayer)));
            }
            if (model.Chinesechecker != 8) {
                nextPlayer();
                while (currentPlayer.toString().equals(a.toString())) {
                    model.setColor(nextPlayer());
                    mainFrame.setPlayer(getColor(getnextPlayer(currentPlayer)));
                    nextPlayer();
                }
            }
            else {
                ArrayList<ChessBoardLocation> A=model.ChessGot();
                ArrayList<ChessBoardLocation> B=new ArrayList<>();
                for (ChessBoardLocation chessBoardLocation : A) {
                    B.add(model.best(model.Move(chessBoardLocation), chessBoardLocation));
                }
                System.out.println(B.toString());
                model.bestPlus(A,B,0);
                System.out.println(model.bestPlus(A,B,0).toString());
                model.bestPlus(A,B,1);
                System.out.println(model.bestPlus(A,B,1).toString());
                model.moveChessPiece(model.bestPlus(A,B,0),model.bestPlus(A,B,1));
            }
        }
    }


    @Override
    public void onPlayerClickChessPiece(ChessBoardLocation location, ChessComponent component) {
        if (!Check()) {
            mainFrame.dispose();
            new cheat();
        }
        if (model.getChessPieceAt(location) != null) {
            ChessPiece piece = model.getChessPieceAt(location);
            if (getModifierNumber()!= 0 && !hasSelectedLocation() || location.equals(getSelectedLocation())) {
                if (!hasSelectedLocation()) {
                    setSelectedLocation(location);
                } else {
                    resetSelectedLocation();
                }
                component.setSelected(!component.isSelected());
                component.repaint();
            }
            else {
                if (currentPlayer.toString().equals(piece.getColor().toString()) && (!hasSelectedLocation() || location.equals(getSelectedLocation()))) {
                    if (!hasSelectedLocation()) {
                        setSelectedLocation(location);
                    } else {
                        resetSelectedLocation();
                    }
                    component.setSelected(!component.isSelected());
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

    public void renew(ArrayList<save> a) {
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
        if(model.Chinesechecker==2 || model.Chinesechecker == 8){
            if(model.check(Color.RED).size()!=19||model.check(Color.GREEN).size()!=19){
                return false;
            }
        }
        if(model.Chinesechecker==4){
            System.out.print(model.check(Color.RED).size()+" "+model.check(Color.GREEN).size());
            if( !(model.check(Color.ORANGE).size() == 13) || !(model.check(Color.BLUE).size() == 13)){
                return false;
            }
            return model.check(Color.RED).size() == 13 && model.check(Color.GREEN).size() == 13;
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
        if(model.Chinesechecker==2 || model.Chinesechecker == 8){
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
