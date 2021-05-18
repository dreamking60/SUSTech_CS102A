package Model;

import java.util.Random;
import Enum.*;
public class FourMode extends GameState{
    public FourMode() {
        turn = Square.of(new Random().nextInt(4));
        lastTurn = Square.of(3);

        //init square
        for (int x = 0,size = 4; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (x + y <= size) {
                    squareStore[x][y] = Square.Black;
                    squareStore[15 - x][15 - y] = Square.White;
                }
            }
        }

        for (int x = 12,xEnd = 16; x < xEnd; x++) {
            for (int y = 0; y < 4; y++) {
                if (x - y > 10) {
                    squareStore[x][y] = Square.Red;
                    squareStore[15 - x][15 - y] = Square.Green;
                }
            }
        }

        camp = squareStore.clone();
    }
}
