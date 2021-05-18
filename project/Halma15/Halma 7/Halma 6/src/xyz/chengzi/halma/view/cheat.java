package xyz.chengzi.halma.view;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;


public class cheat{
    public cheat(){

        JFrame jFrame = new JFrame("cheat");
        JPanel jPanel = new JPanel();
        JTextArea ruleTxt;
        ruleTxt = new JTextArea(30,30);
        ruleTxt.setText("\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "            你作弊了\n" +
                "            好好反思");

        ruleTxt.setFont(new Font("宋体", Font.BOLD, 20));
        ruleTxt.setBounds(10,10,100,100);
        jPanel.add(ruleTxt);
        jFrame.setContentPane(jPanel);
        jFrame.setSize(600, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}