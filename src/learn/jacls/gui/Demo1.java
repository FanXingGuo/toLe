package learn.jacls.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * Created by FanXingGuo on 2018/9/7.
 */



public class Demo1 {
    private Frame frame;
    private Button button;
    private TextField textField;
    private TextArea textArea;
    private Dialog dialog;
    private Button okbtn;
    private Label label;

    Demo1(){
        init();
    }
    public void init(){
        frame =new Frame("提示");
        button=new Button("转到");
        textField =new TextField(20);
        textArea =new TextArea(10,30);
        dialog=new Dialog(frame,"提示信息",true);
        label=new Label();
        okbtn=new Button("确定");



        frame.setBounds(100,100,300,400);
        frame.setLayout(new FlowLayout());
        frame.add(textField);
        frame.add(button);
        frame.add(textArea);

        dialog.setBounds(30,30,200,100);
        dialog.setLayout(new FlowLayout());
        dialog.add(label);
        dialog.add(okbtn);

        myEvn();

        frame.setVisible(true);


    }

    public void myEvn(){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        button.addMouseListener(new MouseAdapter() {
            int count=0;
            @Override
            public void mouseClicked(MouseEvent e) {

//                System.out.printf("鼠标点击"+count++);
            }
        });


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showList();
            }
        });

        okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.setVisible(false);
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    showList();
                }
            }
        });
    }

    private void showDio(){
        String st=textField.getText();
        label.setText("您输入的地址:"+st+",不合法请重输");
        dialog.setVisible(true);
    }

    private void showList(){
        String st=textField.getText();
        File file=new File(st);
        if(file.exists()&&file.isDirectory()){
            String [] names=file.list();
            for (String name:names){
                textArea.append(name+"\r\n");
            }
        }
        else {
            showDio();
        }
    }


    public static void main(String[] args) {
        new Demo1();
    }
}

