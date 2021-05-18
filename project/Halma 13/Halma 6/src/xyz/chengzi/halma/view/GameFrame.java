package xyz.chengzi.halma.view;
import xyz.chengzi.halma.controller.GameController;
import xyz.chengzi.halma.model.ChessBoard;
import xyz.chengzi.halma.model.information;
import xyz.chengzi.halma.music;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class GameFrame<ObjectOnputStream> extends JFrame {
    File f;
    URI uri;
    URL url;

    private JButton undo = new JButton("Undo"); //悔棋
    private JButton save = new JButton("Save");
    private JButton load = new JButton("Load");
    private JButton restart = new JButton("Restart");
    private JButton EXIT = new JButton("Exit");
    private JButton button = new JButton("music");
    private JLabel null0 = new JLabel("  ");
    private JLabel null1 = new JLabel("  ");
    private JLabel null2 = new JLabel("  ");
    private JLabel null3 = new JLabel("  ");
    private JLabel null4 = new JLabel("  ");
    private JLabel null5 = new JLabel("  ");
    private JLabel null6 = new JLabel("  ");
    private JLabel Player = new JLabel();
    private File datafile;
    private ChessBoard chessboard;
    private ChessBoardComponent chessboardComponent;

    private final JFrame jf = new JFrame("Tip");


    public GameFrame(ChessBoardComponent chessBoardComponent, ChessBoard chessboard, File file) {
        add(chessBoardComponent, BorderLayout.CENTER);
        this.chessboard = chessboard;
        this.chessboardComponent = chessBoardComponent;
        setTitle("2020 CS102A Project");
        setSize(776, 810);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        datafile = file;
        JPanel control = new JPanel();
        JLabel statusLabel = new JLabel("Sample label");
        Player.setText(chessboard.getColor());
        add(statusLabel, BorderLayout.SOUTH);
        GridBagLayout gr = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        control.setLayout(gr);
        final int[] count = {0};
        button.addActionListener(ex -> {
            count[0]++;
            if (count[0] == 1) {
                try {
                    f = new File("D:\\\\music\\\\src\\\\湖心勇者.wav");
                    uri = f.toURI();
                    try {
                        url = uri.toURL();  //解析地址
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    AudioClip aau;
                    aau = Applet.newAudioClip(url);
                    aau.loop();  //循环播放
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        gr.addLayoutComponent(Player,c);
        gr.addLayoutComponent(null4, c);
        gr.addLayoutComponent(save, c);
        gr.addLayoutComponent(null5, c);
        gr.addLayoutComponent(load, c);
        gr.addLayoutComponent(null6, c);
        gr.addLayoutComponent(undo, c);
        gr.addLayoutComponent(null0, c);
        gr.addLayoutComponent(button,c);
        gr.addLayoutComponent(null1, c);
        gr.addLayoutComponent(restart, c);
        gr.addLayoutComponent(null3, c);
        gr.addLayoutComponent(EXIT, c);

        control.add(Player);
        control.add(null4);
        control.add(save);
        control.add(null5);
        control.add(load);
        control.add(null6);
        control.add(undo);
        control.add(null0);
        control.add(button);
        control.add(null1);
        control.add(restart);
        control.add(null3);
        control.add(EXIT);
        this.add(control, BorderLayout.EAST);


        save.addActionListener(new ButtonControl());
        load.addActionListener(new ButtonControl());
        undo.addActionListener(new ButtonControl());
        restart.addActionListener(new ButtonControl());
        EXIT.addActionListener(new ButtonControl());
    }
    public class ButtonControl implements ActionListener{
        public void actionPerformed(ActionEvent event){
            jf.setSize(400, 400);
            jf.setLocationRelativeTo(null);
            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            if(event.getSource().equals(restart)){
                int result = JOptionPane.showConfirmDialog(
                        jf,
                        "Restart?",
                        "tip",
                        JOptionPane.YES_NO_CANCEL_OPTION
                );
                if( result == 0) {
                    dispose();
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
                        GameController controller = new GameController(chessBoardComponent, chessBoard, Datafile);
                        GameFrame mainFrame = new GameFrame(chessBoardComponent, chessBoard, Datafile);
                        controller.setMainFrame(mainFrame);
                        mainFrame.setVisible(true);
                        new music();
                    });
                }
            }
            if(event.getSource().equals(EXIT)){
                int result = JOptionPane.showConfirmDialog(
                        jf,
                        "Exit?",
                        "tip",
                        JOptionPane.YES_NO_CANCEL_OPTION
                );
                if( result == 0) {
                    dispose();
                    //返回主界面
                    SwingUtilities.invokeLater(() -> {
                        JFrame START = new Start();
                        START.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        START.setVisible(true);
                        START.setTitle("Halma");
                        START.setSize(600, 600);
                    });
                }
            }
            if(event.getSource().equals(undo)) {
                int result = JOptionPane.showConfirmDialog(
                        jf,
                        "undo?",
                        "tip",
                        JOptionPane.YES_NO_CANCEL_OPTION
                );
                if (result == 0){
                    dispose();
                    SwingUtilities.invokeLater(() -> {
                    try {
                        ObjectInputStream in = new ObjectInputStream(new FileInputStream(datafile));
                        information message = (information)in.readObject();
                        System.out.println(message.getColor());
                        ChessBoard chessBoard = new ChessBoard(16, message.getChinesechecker());
                        ChessBoardComponent chessBoardComponent = new ChessBoardComponent(640, 16);
                        GameController gameController = new GameController(chessBoardComponent, chessBoard, datafile, message);
                        GameFrame mainFrame = new GameFrame(chessBoardComponent, chessBoard, datafile);
                        gameController.setMainFrame(mainFrame);
                        mainFrame.setVisible(true);;
                        new music();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    });

            }
            }
            if( event.getSource().equals(load)){
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

            if(event.getSource().equals(save)){
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
                int option = fileChooser.showSaveDialog(null);
                if(option == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try{
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                        ObjectInputStream in = new ObjectInputStream(new FileInputStream(datafile));
                        out.writeObject((information)in.readObject());
                    } catch (IOException |ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
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

    public Color nextPlayer(Color color) {
        if(chessboard.Chinesechecker==2){
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

    public void setPlayer(String a){
        Player.setText(a);
    }

}
