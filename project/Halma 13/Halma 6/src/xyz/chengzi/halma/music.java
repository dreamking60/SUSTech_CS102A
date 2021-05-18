package xyz.chengzi.halma;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Frame;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.swing.JFrame;
public class music extends JFrame {
    File f;
    URI uri;
    URL url;

    // Music(){
//     bgMusic();
//  }
    public music() {
        try {
            f = new File("D:\\新建文件夹 (4)\\zwdzjszgbdnb\\Halma 3\\src\\java.wav");
            uri = f.toURI();
            url = uri.toURL();  //解析地址
            //AudioClip aau;
            //aau = Applet.newAudioClip(url);
            //aau.loop();  //循环播放
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
