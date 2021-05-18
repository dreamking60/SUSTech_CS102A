package xyz.chengzi.halma.view;

import xyz.chengzi.halma.Halma;
import xyz.chengzi.halma.controller.GameController;
import xyz.chengzi.halma.model.ChessBoard;
import xyz.chengzi.halma.model.information;
import xyz.chengzi.halma.music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Start extends JFrame {
    private JButton CP = new JButton("Computer Player Game");
    private JButton Player = new JButton("Player Game");
    private JButton Load = new JButton("Load the game");
    private JButton Modifier = new JButton("Modifier");
    private JButton rule = new JButton("Game Rule");
    private JLabel topic = new JLabel("Halma",JLabel.CENTER);
    private JLabel null1 = new JLabel("  ", JLabel.CENTER);
    private JLabel null2 = new JLabel("  ", JLabel.CENTER);
    private JLabel null0 = new JLabel("  ", JLabel.CENTER);
    private JLabel null3 = new JLabel("  ", JLabel.CENTER);
    private JLabel null4 = new JLabel("  ", JLabel.CENTER);
    private JLabel null5 = new JLabel("  ", JLabel.CENTER);
    private JLabel null6 = new JLabel("  ", JLabel.CENTER);
    private JLayeredPane pane = new JLayeredPane();
    private ImageIcon image = new ImageIcon("src/resource/背景.jpg");
    private JLabel picture = new JLabel(image);

    public Start(){

        JPanel back = new JPanel();
        back.setBounds(0, 0, image.getIconWidth()*2/3, image.getIconHeight()*2/3);
        back.add(picture);
        JPanel StartPanel = new JPanel();
        GridBagLayout gr = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = GridBagConstraints.REMAINDER;
        StartPanel.setLayout(gr);

        Font font = new Font("微软雅黑",Font.BOLD,30);
        topic.setFont(font);

        CP.setContentAreaFilled(false);
        CP.setBorder(null);
        Player.setContentAreaFilled(false);
        Player.setBorder(null);
        Load.setContentAreaFilled(false);
        Load.setBorder(null);
        Modifier.setContentAreaFilled(false);
        Modifier.setBorder(null);
        rule.setContentAreaFilled(false);
        rule.setBorder(null);


        gr.addLayoutComponent(topic, c);
        gr.addLayoutComponent(null0, c);
        gr.addLayoutComponent(null5, c);
        gr.addLayoutComponent(null6, c);
        gr.addLayoutComponent(CP, c);
        gr.addLayoutComponent(null1, c);
        gr.addLayoutComponent(Player,c );
        gr.addLayoutComponent(null2, c);
        gr.addLayoutComponent(Load, c);
        gr.addLayoutComponent(null4, c);
        gr.addLayoutComponent(Modifier, c);
        gr.addLayoutComponent(null3, c);
        gr.addLayoutComponent(rule,c );


        StartPanel.add(topic);
        StartPanel.add(null0);
        StartPanel.add(null5);
        StartPanel.add(null6);
        StartPanel.add(CP);
        StartPanel.add(null1);
        StartPanel.add(Player);
        StartPanel.add(null2);
        StartPanel.add(Load);
        StartPanel.add(null4);
        StartPanel.add(Modifier);
        StartPanel.add(null3);
        StartPanel.add(rule);

        StartPanel.setBounds(0, 0, 600, 600);
        StartPanel.setOpaque(false);
        pane.add(back, JLayeredPane.DEFAULT_LAYER);
        pane.add(StartPanel, JLayeredPane.MODAL_LAYER);
        this.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.setLayeredPane(pane);

        CP.addActionListener(new ButtonAction());
        Player.addActionListener(new ButtonAction());
        rule.addActionListener(new ButtonAction());
        Load.addActionListener(new ButtonAction());
        Modifier.addActionListener(new ButtonAction());
    }

    public class ButtonAction implements ActionListener{
        public void actionPerformed (ActionEvent event){

            if( event.getSource().equals(CP)){
                //玩家与电脑对战的窗口
                SwingUtilities.invokeLater(() ->{
                    JFrame CPGame = new CPGame();
                    CPGame.setVisible(true);
                    CPGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    CPGame.setSize(600, 600);
                });
            }

            if( event.getSource().equals(Player)){
                dispose();
                //玩家与玩家对战的窗口列表
                SwingUtilities.invokeLater(() ->{
                JFrame PlayerGame = new PlayerGame();
                PlayerGame.setVisible(true);
                PlayerGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                PlayerGame.setSize(600, 600);
                });
            }

            if( event.getSource().equals(Load)){
                dispose();
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int option = fileChooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (file != null) {
                        try {
                            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                            information message = (information)in.readObject();
                            ChessBoard chessBoard = new ChessBoard(16, message.getChinesechecker());
                            ChessBoardComponent chessBoardComponent = new ChessBoardComponent(640, 16);
                            GameController gameController = new GameController(chessBoardComponent, chessBoard, file, message);
                            GameFrame mainFrame = new GameFrame(chessBoardComponent, chessBoard, file);
                            gameController.setMainFrame(mainFrame);
                            mainFrame.setVisible(true);;
                            new music();
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }else if(option == JFileChooser.CANCEL_OPTION){
                    JFrame START = new Start();
                    START.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    START.setVisible(true);
                    START.setTitle("Halma");
                    START.setSize(600, 600);
                }
            }

            if( event.getSource().equals(rule)){
                dispose();
                //规则的窗口
                SwingUtilities.invokeLater(() ->{
                  JFrame rule = new Rule();
                  rule.setVisible(true);
                  rule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  rule.setSize(600,600);
                });

            }

            if( event.getSource().equals(Modifier)){
                dispose();
                SwingUtilities.invokeLater(() ->{
                    JFrame ModifierGame=new ModifierGame();
                    ModifierGame.setVisible(true);
                    ModifierGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ModifierGame.setSize(600, 600);
                });
            }

        }
    }

}
