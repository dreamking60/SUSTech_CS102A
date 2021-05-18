package xyz.chengzi.halma.view;

import xyz.chengzi.halma.Halma;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rule extends JFrame {
    private JButton Return = new JButton("Return");
    private JLabel rule = new JLabel();
    private JLabel null1 = new JLabel(" ");

    public Rule(){
        GridBagLayout gr = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        JTextArea ruleTxt = new JTextArea();
        rule.setText("1、游戏人数：2 ， 3 ， 4 ， 6 人。2人、4人或者6人下棋时与对角线的一方对抗，3人下棋时，相互间隔排列。\n" +
                "2、走子规则：棋子的移动可以一步步在有直线连接的相邻六个方向进行，如果相邻位置上有任何方的一个棋子，\n"+
                "该位置直线方向下一个位置是空的，则可以直接\"跳\"到该空位上，\"跳\"的过程中，只要相同条件满足就可以连续进行。谁最先把正对面的阵地全部占领，谁就取得胜利。\n" +
                "3、胜负判定：任意一方先进营为胜");
        gr.addLayoutComponent(rule, c);
        gr.addLayoutComponent(null1, c);
        gr.addLayoutComponent(Return, c);
        ruleTxt.add(rule);
        ruleTxt.add(null1);
        ruleTxt.add(Return);
        this.add(ruleTxt);
        Return.addActionListener(new ButtonControl());
    }

    public class ButtonControl implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            dispose();
            if( event.getSource().equals(Return)){
                SwingUtilities.invokeLater(() -> {
                    JFrame START = new Start();
                    START.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    START.setVisible(true);
                    START.setTitle("Halma");
                    START.setSize(600, 600);
                });
            }
        }
    }
}
