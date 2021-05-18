package xyz.chengzi.halma.view;
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

public class StarShine1 extends JComponent{
    private List<Shape> stars=new LinkedList<Shape>();
    private static Random random=new Random();
    private static Color[][] colors={
            {Color.WHITE, Color.ORANGE},
            {Color.WHITE, Color.BLUE},
            {Color.ORANGE, Color.PINK},
            {Color.ORANGE, Color.green},
            {Color.PINK,Color.green},
            {Color.WHITE,Color.PINK}
    };
    public StarShine1(){
        setBackground(Color.WHITE);
        new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int centerX =random.nextInt(getWidth());
                int centerY =random.nextInt(getHeight());
                double innerSize = 1 + (5 * Math.random());
                double outerSize = innerSize + 5 + (15 * Math.random());
                stars.add(getStar(centerX,centerY,innerSize,outerSize));
                long tm=Runtime.getRuntime().totalMemory();
                long mm=Runtime.getRuntime().maxMemory();
                long fm=Runtime.getRuntime().freeMemory();
                long um=tm-fm;
                repaint();
            }
        }).start();
    }

    public void paintComponent(Graphics g) {
        Color a=new Color(13, 31,111);
        Graphics2D g3d = (Graphics2D)g;
        GradientPaint background = new GradientPaint(0f, 0f, a.darker(),
                0f, (float)getHeight(), a.brighter());
        g3d.setPaint(background);
        g3d.fillRect(0, 0, getWidth(), 4*getHeight()/5);
        background = new GradientPaint(0f, (float)4*getHeight()/5,
                Color.BLACK,
                0f, (float)getHeight(), Color.GRAY.darker());
        g3d.setPaint(background);
        g3d.fillRect(0, 4*getHeight()/5, getWidth(), getHeight()/5);
        g3d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for (Shape star : stars) {
            Rectangle rect = star.getBounds();
            Point2D center = new Point2D.Float(
                    rect.x + (float)rect.width / 2.0f,
                    rect.y + (float)rect.height / 2.0f);
            float radius = (float)rect.width / 2.0f;
            float[] dist = {0.1f, 0.9f};
            RadialGradientPaint paint = new RadialGradientPaint(center, radius,
                    dist, colors[random.nextInt(colors.length)]);
            g3d.setPaint(paint);
            g3d.fill(star);
            g3d.clipRect(0,0,1000,520);
            g3d.setColor(Color.PINK);
            g3d.setFont(new Font("华文新魏", 2, 66));
            g3d.drawString("绿方赢了", 170, 120);
            g3d.setFont(new Font("华文新魏", 3, 100));
            g3d.drawString("希", 580, 250);
            g3d.drawString("腊", 800, 350);
            g3d.drawString("跳", 600, 420);
            g3d.drawString("棋", 800, 500);
            g3d.setColor(Color.YELLOW);
            g3d.fillOval(10,10,100,100);
        }
    }
    private static Shape getStar(double x, double y,
                                 double innerRadius, double outerRadius) {
        GeneralPath path = new GeneralPath();
        double outerAngleIncrement = 2 * Math.PI / 5;
        double outerAngle = 0.0;
        double innerAngle = outerAngleIncrement / 2.0;
        x += outerRadius;
        y += outerRadius;
        float x1 = (float) (Math.cos(outerAngle) * outerRadius + x);
        float y1 = (float) (Math.sin(outerAngle) * outerRadius + y);
        float x2 = (float) (Math.cos(innerAngle) * innerRadius + x);
        float y2 = (float) (Math.sin(innerAngle) * innerRadius + y);
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        outerAngle += outerAngleIncrement;
        innerAngle += outerAngleIncrement;
        for (int i = 1; i < 5; i++) {
            x1 = (float) (Math.cos(outerAngle) * outerRadius + x);
            y1 = (float) (Math.sin(outerAngle) * outerRadius + y);
            path.lineTo(x1, y1);
            x2 = (float) (Math.cos(innerAngle) * innerRadius + x);
            y2 = (float) (Math.sin(innerAngle) * innerRadius + y);
            path.lineTo(x2, y2);
            outerAngle += outerAngleIncrement;
            innerAngle += outerAngleIncrement;
        }
        path.closePath();
        return path;
    }
    /** 创建界面 */
    public static void createAndShowGUI() {
        final JFrame f = new JFrame("胜利");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 800);
        f.add(new StarShine1());
        f.setVisible(true);
        f.setLocationRelativeTo(f.getOwner());
    }

    public static void main(String[] args) {
        createAndShowGUI();
    }
}


