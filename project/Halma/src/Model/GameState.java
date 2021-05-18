package Model;
import Enum.*;
import ViewAndCtrl.Main;
import javafx.scene.control.Alert;
import javafx.util.Pair;

import java.io.Serializable;

public abstract class GameState implements Serializable {
    public Square turn;
    public Operation operation;
    Square lastTurn = null;
    public Pair<Integer, Integer> select;
    public Square[][] squareStore = new Square[16][16];
    Square[][] camp;
    public void nextTurn(){
        select = null;
        operation = null;

        if (lastTurn == Square.White) {
            if (turn == lastTurn)
                turn = Square.Black;
            else
                turn = Square.White;
        }else{
            if (turn == lastTurn)
                turn = Square.of(0);
            else
                turn= Square.of(turn.ordinal() + 1);
        }

        Main.primaryStage.setTitle(turn.toString());
    }

    public boolean canJump(int destX, int destY) {
        if (squareStore[destX][destY] != null)
            return false;

        int sourX = select.getKey();
        if (destX != sourX && destX != sourX + 2 && destX != sourX - 2)
            return false;
        int sourY = select.getValue();
        if (destY != sourY && destY != sourY + 2 && destY != sourY - 2)
            return false;

        int middleX = sourX;
        int middleY = sourY;

        if (destX > sourX)
            middleX++;
        if (destX < sourX)
            middleX--;

        if (destY > sourY)
            middleY++;
        if (destY < sourY)
            middleY--;

        if (squareStore[middleX][middleY] != null)
            return true;
        else
            return false;
    }
    public boolean canMove(int x, int y) {
        if (squareStore[x][y] != null)
            return false;
        if (x == select.getKey() || x == select.getKey() + 1 || x == select.getKey() - 1)
            if (y == select.getValue() || y == select.getValue() + 1 || y == select.getValue() - 1)
                return true;

        return false;
    }
    public boolean inOpposingCamp() {
        int x = select.getKey();
        int y = select.getValue();
        return inOpposingCamp(x, y);
    }

    public boolean inOpposingCamp(int x, int y) {
        if (turn == Square.Black)
            return camp[x][y] == Square.White;
        else if (turn == Square.White)
            return camp[x][y] == Square.Black;
        else if (turn == Square.Red)
            return camp[x][y] == Square.Green;
        else
            return camp[x][y] == Square.Red;
    }

    public void op(int x, int y) {
        squareStore[x][y] = squareStore[select.getKey()][select.getValue()];
        squareStore[select.getKey()][select.getValue()] = null;
        select = new Pair<>(x, y);

        if (win()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Win!");
            alert.setContentText("Win!");

            alert.show();
        }
    }

    private boolean win() {
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                if (squareStore[x][y] == turn && inOpposingCamp(x,y))
                    continue;

                return false;
            }
        }

        return true;
    }
    static public boolean check(GameState gameState) {
        if (gameState.squareStore.length != 16)
            return false;

        for (Square[] squares : gameState.squareStore) {
            if (squares.length != 16)
                return false;
        }
        if (gameState.camp.length != 16)
            return false;

        for (Square[] squares : gameState.camp) {
            if (squares.length != 16)
                return false;
        }

        return true;
    }
}
