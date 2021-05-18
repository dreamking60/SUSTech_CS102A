package liaotian;



import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.io.*;

import java.net.*;

import java.util.*;



public class SendThread {



    ChatWindow chatWindow;

    private String remoteIP = "";

    private int port = 0;

    private String message = "";



    public SendThread(int port,ChatWindow window) {

        chatWindow = window;

    }



    public void notRun() {

        InetSocketAddress isa = new InetSocketAddress(remoteIP, port);

        try {

            Socket socket = new Socket();

            socket.connect(isa);

            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());

            writer.write(message);

            writer.flush();

            writer.close();

            System.out.println("将数据写入到流中");

        } catch (IOException e) {

            e.printStackTrace();

        }finally{

            message = "";

        }

    }



    public void senMessage(String host,int port,String message){

        remoteIP = host;

        this.port = port;

        this.message = message;

        notRun();

    }

}

