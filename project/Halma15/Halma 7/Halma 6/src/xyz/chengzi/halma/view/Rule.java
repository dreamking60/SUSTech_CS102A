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
        GridBagConstraints c = null;
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        JPanel ruleTxt = new JPanel();
        rule.setText("<html><body>"+"1、游戏人数：2 ， 3 ， 4 ， 6 人。2人、4人或者6人下棋时与对角线的一方对抗，3人下棋时，相互间隔排列。" + "<br>" +
                "2、走子规则：棋子的移动可以一步步在有直线连接的相邻六个方向进行，如果相邻位置上有任何方的一个棋子，该位置直线方向下一个位置是空的，则可以直接\"跳\"到该空位上，\"跳\"的过程中，只要相同条件满足就可以连续进行。谁最先把正对面的阵地全部占领，谁就取得胜利。" + "<br>" +
                "3、胜负判定：任意一方先进营为胜"+ "<br>" + "4、分数计算：按照棋类游戏的标准记分方法，每局棋结束,胜者1分,负者0分,平棋各记0.5分。\n" +
                "棋子的移动可以一步步在有直线连接的相邻六个方向进行，如果相邻位置上有任何方的一个棋子，该位置直线方向下一个位置是空的，则可以直接“跳”到该空位上，“跳”的过程中，只要相同条件满足就可以连续进行。谁最先把正对面的阵地全部占领，谁就取得胜利。\n" +
                "中国跳棋主要有一字跳和空跳两大类，最根本的差异为：一字跳在直线上跨一子跳一步在空位；空跳为在直线上夸一子跳对称位子空位上。所谓对称位置即棋盘有一子为桥，要跳的子到桥如果有3步空位，那么夸过桥后落子在直线对称3步空位处，以此类推");
        gr.addLayoutComponent(rule, c);
        gr.addLayoutComponent(null1, c);

        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        gr.addLayoutComponent(Return, c);
        ruleTxt.setLayout(gr);
        Return.setSize(200, 200);
        ruleTxt.add(null1);
        ruleTxt.add(Return);
        ruleTxt.add(null1);
        this.add(rule, BorderLayout.CENTER);
        this.add(ruleTxt, BorderLayout.SOUTH);
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
