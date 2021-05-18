import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingCounter extends JFrame {
    private JTextField tfCount;
    private JButton btnCount;
    private int count = 0;
    public SwingCounter(){
        setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
        add(new JLabel("Counter"));
        tfCount = new JTextField("0");
        tfCount.setEditable(false); add(tfCount);
        btnCount = new JButton("Count"); add(btnCount);
        btnCount.addActionListener(new ButtonClickListener());
    }

    public class ButtonClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ARG0){
            count++; tfCount.setText(count + "");
        }
    }

    public static void main(String[] args) {
        SwingCounter sc = new SwingCounter();
        sc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sc.setVisible(true);
        sc.setSize(800, 600);
    }
}
