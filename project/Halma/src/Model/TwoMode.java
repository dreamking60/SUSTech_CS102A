package Model;

import java.util.Random;
import Enum.*;
public class TwoMode extends GameState{
    public TwoMode() {
        if (new Random().nextInt(2) == 0)
            turn = Square.White;
        else
            turn = Square.Black;

        lastTurn = Square.White;

        //init square
        for (int x = 0,size = 5; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (x + y <= size) {
                    squareStore[x][y] = Square.Black;
                    squareStore[15 - x][15 - y] = Square.White;
                }
            }
        }

        camp = squareStore.clone();
    }
}
