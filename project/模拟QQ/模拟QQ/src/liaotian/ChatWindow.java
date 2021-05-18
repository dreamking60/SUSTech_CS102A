package liaotian;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.io.*;

import java.net.*;

import java.util.*;



public class ChatWindow extends JFrame implements ActionListener{

    private JButton sendButton;

    private JButton cancelButton;

    private JButton receiveButton;

    private JTextArea receiveText;

    private JTextField sendText;

    private JTextField localPort;

    private JTextField remoteAddress;

    private JTextField remotePort;

    private SendThread sendThread;
    private ReceiveThread receiveThread;

    private JLabel jbl1;

    private JPanel jp2;

    private JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3;

    private JButton jp2_jb1;



    public void denglu() {

        jbl1=new JLabel(new ImageIcon("image/图片1.gif"));

        this.setSize(350, 150);

        this.add(jbl1, "North");

        jp2=new JPanel(new GridLayout(2,2));

        jp2_jbl1=new JLabel("IP地址",JLabel.CENTER);

        jp2_jbl2=new JLabel("端口号(1-65535)",JLabel.CENTER);

        jp2_jbl3=new JLabel("  ");

        jp2_jb1=new JButton("登录");

        jp2_jb1.addActionListener(this);

        jp2.add(jp2_jbl1);



        try {

            jp2.add(new JTextField(InetAddress.getLocalHost().getHostAddress()));

        } catch (UnknownHostException e) {



            jp2.add(new JTextField("当前机器的IP地址是:" + "Unknown"));

        }

        jp2.add(jp2_jbl3);

        jp2.add(jp2_jbl2);

        jp2.add(localPort = new JTextField(""+0));

        jp2.add(jp2_jb1);

        this.add(jp2,"Center");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent arg0 ) {

        if(arg0.getSource()==jp2_jb1)

        {

            jbl1.setVisible(false);

            jp2.setVisible(false);

            GUIini();

            ActionIni();

            ThreadIni();

        }

    }





    private void GUIini(){

        Container c = this.getContentPane();

        c.setLayout(new BorderLayout());

        setSize(400, 500);

        JPanel panel1 = new JPanel(new GridLayout(4, 2));

        panel1.setSize(400, 75);

        panel1.add(new JLabel("发送方IP:"));



        try {

            panel1.add(new JLabel(InetAddress.getLocalHost().getHostAddress()));

        } catch (UnknownHostException e) {

            panel1.add(new JLabel("发送方IP:" + "Unknown"));

        }

        panel1.add(new JLabel("发送方端口:"));

        panel1.add(new JLabel(localPort.getText()));

        panel1.add(new JLabel("接收方IP:"));

        remoteAddress = new JTextField();

        remoteAddress.setColumns(0);

        panel1.add(remoteAddress);

        panel1.add(new JLabel("接收方端口:"));
        remotePort = new JTextField();

        remotePort.setColumns(0);

        panel1.add(remotePort);

        c.add(panel1,BorderLayout.NORTH);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEADING));

        panel2.setSize(400,200);

        panel2.add(new JLabel("聊天记录："));

        receiveText = new JTextArea(15,30);

        receiveText.setEditable(false);

        receiveText.setAutoscrolls(true);

        JScrollPane jsp = new JScrollPane(receiveText);

        panel2.add(jsp);

        panel2.add(new JLabel("信息内容："));

        sendText = new JTextField(30);

        sendText.setAutoscrolls(true);

        panel2.add(sendText);

        c.add(panel2,BorderLayout.CENTER);



        JPanel panel4 = new JPanel(new GridLayout(1, 0));

        panel4.setSize(400,20);

        receiveButton = new JButton("开始接受数据");

        sendButton = new JButton("发送");

        cancelButton = new JButton("清除");

        panel4.add(receiveButton);

        panel4.add(cancelButton);

        panel4.add(sendButton);

        c.add(panel4,BorderLayout.SOUTH);

        setVisible(true);

        setResizable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void ActionIni() {

        this.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {



            }

            public void keyReleased(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_ENTER){

                    sendThread.senMessage(remoteAddress.getText(), Integer.parseInt(remotePort.getText()), sendText.getText());

                    receiveText.setText(receiveText.getText() + "\n" + "发送:" + sendText.getText());

                }

            }

            public void keyPressed(KeyEvent e) {

            }

        });



        cancelButton.addMouseListener(new MouseListener() {

            public void mouseReleased(MouseEvent e) {



                sendText.setText("");

            }





            public void mousePressed(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {





            }





            public void mouseEntered(MouseEvent e) {





            }





            public void mouseClicked(MouseEvent e) {





            }

        });

        sendButton.addMouseListener(new MouseListener() {





            public void mouseReleased(MouseEvent e) {



                sendThread.senMessage(remoteAddress.getText(), Integer.parseInt(remotePort.getText()), sendText.getText());

                receiveText.setText(receiveText.getText()  + "发送:" + sendText.getText()+ "\n");

            }





            public void mousePressed(MouseEvent e) {





            }





            public void mouseExited(MouseEvent e) {





            }





            public void mouseEntered(MouseEvent e) {



            }





            public void mouseClicked(MouseEvent e) {



            }

        });

    }



    private void ThreadIni() {

        sendThread = new SendThread(0, this);
        receiveThread = new ReceiveThread(this, Integer.parseInt(localPort.getText()));
    }



    public ChatWindow() {

        denglu();

    }



    public void printError(String err){

        System.out.println("Error occur:" + err);

    }

    public void setReceive(String receive){

        receiveText.setText(receiveText.getText() + "收到:" + receive+ "\n" );

    }

    public void setLocalPort(int localPortText){
        localPort.setText(""+localPortText);
    }





    public static void main(String[] args) {
        new ChatWindow();

    }



}
