import javax.swing.*;
import java.awt.*;

public class HelloWorld2 extends JFrame {
    private JLabel label;

    public HelloWorld2(){
        super("Our first Swing program");
        setLayout(new FlowLayout());
        label = new JLabel("Hello World");
        label.setFont(new Font("San Serif", Font.PLAIN,30));
        add(label);
    }
    public static void main(String[] args){
        HelloWorld2 gui = new HelloWorld2();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(800, 600);
        gui.setVisible(true);
    }
}
