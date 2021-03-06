package xyz.chengzi.halma.view;

import xyz.chengzi.halma.controller.GameController;
import xyz.chengzi.halma.model.ChessBoard;
import xyz.chengzi.halma.music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ModifierGame extends JFrame{
    private JButton Two = new JButton("Two Player Modifier");
    private JButton Four = new JButton("Four Player Modifier");
    private JButton Return = new JButton("Return");
    private JLabel null1 = new JLabel("  ");
    private JLabel null2 = new JLabel("  ");

    public ModifierGame() {
        JPanel Play = new JPanel();
        GridBagLayout gr = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = GridBagConstraints.REMAINDER;
        Play.setLayout(gr);

        gr.addLayoutComponent(Two, c);
        gr.addLayoutComponent(null1, c);
        gr.addLayoutComponent(Four, c);
        gr.addLayoutComponent(null2, c);
        gr.addLayoutComponent(Return, c);

        Play.add(Two);
        Play.add(null1);
        Play.add(Four);
        Play.add(null2);
        Play.add(Return);
        this.add(Play, BorderLayout.CENTER);

        Two.addActionListener(new ButtonControl());
        Four.addActionListener(new ButtonControl());
        Return.addActionListener(new ButtonControl());
    }

    public class ButtonControl implements ActionListener {
        public void actionPerformed(ActionEvent event){
            dispose();
            if( event.getSource().equals(Two)){
                SwingUtilities.invokeLater(() -> {
                    ChessBoardComponent chessBoardComponent = new ChessBoardComponent(640, 16);
                    ChessBoard chessBoard = new ChessBoard(16,2);
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
                    int option = fileChooser.showSaveDialog(null);
                    File Datafile = null;
                    if(option == JFileChooser.APPROVE_OPTION){
                        File file = fileChooser.getSelectedFile();
                        Datafile = file;
                    }
                    GameController controller = new GameController(chessBoardComponent, chessBoard, Datafile, 1);
                    ModifierFrame mainFrame= new ModifierFrame(chessBoardComponent, chessBoard, Datafile);
                    mainFrame.setVisible(true);

                    new music();


                });
            }
            if( event.getSource().equals(Four)){
                ChessBoardComponent chessBoardComponent = new ChessBoardComponent(640, 16);
                ChessBoard chessBoard = new ChessBoard(16,4);
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
                int option = fileChooser.showSaveDialog(null);
                File Datafile = null;
                if(option == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    Datafile = file;
                }
                GameController controller = new GameController(chessBoardComponent, chessBoard, Datafile, 1);
                ModifierFrame mainFrame = new ModifierFrame(chessBoardComponent, chessBoard, Datafile);
                mainFrame.setVisible(true);
                new music();

            }
            if( event.getSource().equals(Return)){
                //??????
                SwingUtilities.invokeLater(() -> {
                    JFrame START = new Start();
                    START.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    START.setVisible(true);
                    START.setTitle("Halma");
                    START.setSize(600, 600);

                });
            }
            //??????????????????????????????????????????
        }
    }

}
