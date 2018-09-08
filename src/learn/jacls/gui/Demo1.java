package learn.jacls.gui;

import java.awt.*;
import java.awt.event.*;
/**
 * Created by FanXingGuo on 2018/9/7.
 */



public class Demo1 {
    private Frame frame;
    private Button button;
    private TextField textField;

    Demo1(){
        init();
    }
    public void init(){
        frame =new Frame("提示");
        button=new Button("我是一个按钮");
        textField =new TextField(20);

        frame.setBounds(100,100,200,200);
        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.add(textField);

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
        //活动监听
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.printf("按钮 退出");
//                System.exit(0);
//            }
//        });


        //鼠标事件
        button.addMouseListener(new MouseAdapter() {
            int count=0;
            @Override
            public void mouseClicked(MouseEvent e) {

                System.out.printf("鼠标点击"+count++);
            }
        });

        //鼠标双击
//        button.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if(e.getClickCount()==2){
//                    System.out.println("鼠标双击!");
//                }
//            }
//        });

        //键盘事件
//        textField.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                System.out.println("getKeyChar():"+e.getKeyChar()+",code:"+e.getKeyCode());
//            }
//        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
//                if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_ENTER){
//                    System.out.println("ctrl+enter 按下");
//                }
                int code=e.getKeyCode();
                if(!(code>=KeyEvent.VK_0&&code<=KeyEvent.VK_9)){
                    System.out.println("输入不合法");
                    e.consume();
                }
            }
        });
    }


    public static void main(String[] args) {
        new Demo1();
    }
}

