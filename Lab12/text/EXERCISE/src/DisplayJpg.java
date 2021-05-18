import javax.swing.*;
import java.awt.*;

public class DisplayJpg
{
    public static void main(String[] args)
    {
        JFrame window=new JFrame(); //create a Frame
        ImageIcon picture=new ImageIcon("C:\\Users\\ZIHAN\\Desktop\\a.jpg"); //load a picture from computer
        picture.setImage(picture.getImage().getScaledInstance(
                picture.getIconWidth()/2,
                picture.getIconHeight()/2,
                Image.SCALE_DEFAULT));
        JLabel label=new JLabel(picture); //add the picture to a label
        window.add(label); //add the label to the frame
        window.setVisible(true); //Set the window to visible
        window.setSize(picture.getIconWidth(),picture.getIconHeight()); //set the size of the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //let the window can be close by click "x"
    }
}
