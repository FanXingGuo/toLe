package learn.jacls.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

/**
 * Created by FanXingGuo on 2018/9/9.
 */
public class Demo2 {
    private Frame frame;
    private MenuBar menuBar;
    private Menu menu;
    private Menu subMenu;
    private MenuItem saveItem;
    private MenuItem openItem;
    private MenuItem exitItem;
    private TextArea textArea;

    private FileDialog openDialog;
    private FileDialog saveDialog;
    private File file;

    public Demo2(){
        init();
    }

    public void init(){
        frame =new Frame("记事本");

        menuBar=new MenuBar();
        menu=new Menu("文件");


        exitItem=new MenuItem("退出");
        openItem=new MenuItem("打开");
        saveItem=new MenuItem("保存");

        textArea=new TextArea(20,20);

        openDialog=new FileDialog(frame,"打开",FileDialog.LOAD);
        saveDialog=new FileDialog(frame,"保存",FileDialog.SAVE);

        frame.setBounds(100,100,500,400);



        menu.add(openItem);
        menu.add(saveItem);
        menu.add(exitItem);
        menuBar.add(menu);

        frame.setMenuBar(menuBar);
        frame.add(textArea);

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

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDialog.setVisible(true);
                String fileDir=openDialog.getDirectory();
                String fileName=openDialog.getFile();

                if(fileDir==null||fileName==null)
                    return;

                file=new File(fileDir,fileName);

                textArea.setText("");
                try{
                    BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
                    String line=null;
                    while((line=bufferedReader.readLine())!=null){
                        textArea.append(line+"\r\n");
                    }
                }
                catch (Exception ex){
                    throw new RuntimeException("读取失败");
                }
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(file==null){
                    saveDialog.setVisible(true);
                    String fileDir=saveDialog.getDirectory();
                    String fileName=saveDialog.getFile();
                    if(fileDir==null||fileName==null)
                        return;
                    file=new File(fileDir,fileName);
                }

                try{
                    BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
                    String text=textArea.getText();
                    bufferedWriter.write(text);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
                catch (Exception e1){
                    throw new RuntimeException("保存失败");
                }



            }
        });




    }

    public static void main(String[] args) {
        new Demo2();
    }
}
