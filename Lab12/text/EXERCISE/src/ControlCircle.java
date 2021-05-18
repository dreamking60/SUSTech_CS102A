import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlCircle extends JFrame {
    private JButton jbtEnlarge = new JButton("Enlarge");
    private JButton jbtShrink = new JButton("Shrink");
    private CirclePanel canvas = new CirclePanel();

    public ControlCircle() {
        JPanel panel = new JPanel(); // Use the panel to group buttons
        panel.add(jbtEnlarge);
        panel.add(jbtShrink);

        this.add(canvas, BorderLayout.CENTER); // Add canvas to center
        this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame

        // Fill in the code to listen to the action event
        jbtEnlarge.addActionListener(new laListener());
        jbtShrink.addActionListener(new smListener());

    }

    /** Main method */
    public static void main(String[] args) {
        JFrame frame = new ControlCircle();
        frame.setTitle("ControlCircle2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        frame.setVisible(true);
    }

    class laListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            canvas.enlarge();
        }
    }

    class smListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            canvas.shrink();
        }
    }
}


class CirclePanel extends JPanel {
    private int radius = 50; // Default circle radius

    /** Enlarge the circle */
    public void enlarge() {
        radius = (int)(radius * 1.1);
        this.repaint();
    }

    /** Enlarge the circle */
    public void shrink() {
        radius = (int)(radius * 0.9);
        this.repaint();
    }

    /** Repaint the circle */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Fill in the code to draw a circle in the center of the canvas with the radius of this class
        g.drawOval(getWidth()/2-radius, getHeight()/2-radius, 2*radius, 2*radius);
    }
}

