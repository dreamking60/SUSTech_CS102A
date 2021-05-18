package xyz.chengzi.halma;

import xyz.chengzi.halma.controller.GameController;
import xyz.chengzi.halma.model.ChessBoard;
import xyz.chengzi.halma.view.ChessBoardComponent;
import xyz.chengzi.halma.view.GameFrame;
import xyz.chengzi.halma.view.Start;

import javax.swing.*;

public class Halma {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame START = new Start();
            START.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            START.setVisible(true);
            START.setTitle("Halma");
            START.setSize(600, 600);
        });
    }
}
