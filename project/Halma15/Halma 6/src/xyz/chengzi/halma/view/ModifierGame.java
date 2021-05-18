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
    private JLayeredPane pane = new JLayeredPane();
    private ImageIcon image = new ImageIcon("src/resource/背景.jpg");
    private JLabel picture = new JLabel(image);

    public ModifierGame() {
        JPanel back = new JPanel();
        back.setBounds(0, 0, image.getIconWidth()*2/3, image.getIconHeight()*2/3);
        back.add(picture);

        JPanel Play = new JPanel();
        GridBagLayout gr = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = GridBagConstraints.REMAINDER;
        Play.setLayout(gr);

        Two.setContentAreaFilled(false);
        Two.setBorder(null);
        Four.setContentAreaFilled(false);
        Four.setBorder(null);
        Return.setContentAreaFilled(false);
        Return.setBorder(null);

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

        Play.setBounds(0, 0, 600, 600);
        Play.setOpaque(false);
        pane.add(back, JLayeredPane.DEFAULT_LAYER);
        pane.add(Play, JLayeredPane.MODAL_LAYER);
        this.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.setLayeredPane(pane);

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
                //返回
                SwingUtilities.invokeLater(() -> {
                    JFrame START = new Start();
                    START.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    START.setVisible(true);
                    START.setTitle("Halma");
                    START.setSize(600, 600);

                });
            }
            //可在此处添加网络对战的形式。
        }
    }

}
