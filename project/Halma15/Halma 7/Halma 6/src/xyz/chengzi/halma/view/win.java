package xyz.chengzi.halma.view;

import java.awt.*;
import java.awt.image.BufferedImage;

public class win {
    String win;
    char[] a;
    public static void print(String win,char[] a){
        {
            BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = image.createGraphics();
            g.setFont(new Font("宋体", Font.BOLD, 12));
            g.drawString(win, 1, image.getHeight() - 8);
            int[] p = image.getRGB(0, 0, image.getWidth(), image.getHeight(), new int[image.getWidth() * image.getHeight()],
                    0, image.getWidth());
            char[] cs = { a[0],a[1],a[2],a[3] };
            int ics = 0;
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    int off = i * image.getWidth() + j;
                    if (p[off] != 0) {
                        System.out.print(cs[ics]);
                        ics = (ics + 1) % 4;
                    } else {
                        System.out.print("　");
                    }
                    if (j == image.getWidth() - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }
}
