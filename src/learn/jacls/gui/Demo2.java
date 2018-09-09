package learn.jacls.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by FanXingGuo on 2018/9/9.
 */
public class Demo2 {
    private Frame frame;
    private MenuBar menuBar;
    private Menu menu;
    private Menu subMenu;
    private MenuItem menuItemCls;
    private MenuItem menuItemSub;

    public Demo2(){
        init();
    }

    public void init(){
        frame =new Frame("记事本");
        menuBar=new MenuBar();
        menu=new Menu("文件");
        subMenu=new Menu("新建");
        menuItemCls=new MenuItem("退出");
        menuItemSub=new MenuItem("文本文档");

        frame.setBounds(100,100,500,400);
        frame.setLayout(new FlowLayout());

        subMenu.add(menuItemSub);
        menu.add(subMenu);
        menu.add(menuItemCls);

        menuBar.add(menu);
        frame.setMenuBar(menuBar);

        MyEven();

        frame.setVisible(true);

    }

    public void MyEven(){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        menuItemCls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }

    public static void main(String[] args) {
        new Demo2();
    }
}
