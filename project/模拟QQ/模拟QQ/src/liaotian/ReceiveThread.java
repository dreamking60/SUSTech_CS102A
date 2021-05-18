
package liaotian;



import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.io.*;

import java.net.*;

import java.util.*;



public class ReceiveThread extends Thread {



    private ServerSocket server;

    private ChatWindow window;



    public ReceiveThread(ChatWindow window,int Port) {

        this.window = window;

        try {

            server = new ServerSocket(Port);

            start();

        } catch (IOException e) {

            window.printError("连接出错");

        }

    }





    public void run() {

        while(true){

            Socket socket;

            try {

                socket = server.accept();

                InputStreamReader reader = new InputStreamReader(socket.getInputStream());

                int c;

                StringBuilder sb = new StringBuilder();

                while((c = reader.read()) != -1){

                    sb.append((char)c);

                }

                window.setReceive(sb.toString());
            } catch (IOException e) {



                System.out.println("线程将接受到的数据写入对话框出错");

            }

        }

    }

}
