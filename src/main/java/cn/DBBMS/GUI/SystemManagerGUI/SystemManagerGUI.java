package cn.DBBMS.GUI.SystemManagerGUI;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import cn.DBBMS.Controller.SystemManagerController;
import cn.DBBMS.entity.Book;
import cn.DBBMS.entity.Manager;
import cn.DBBMS.entity.User;
import cn.DBBMS.service.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SystemManagerGUI {
    private JPanel jPanel;
    private JFrame frame;
    private JScrollPane OperationArea;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private ArrayList<JTextField> textFieldArrayList;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private ArrayList<JLabel> labelArrayList;
    private JButton BackButton;
    private JButton ConfirmButton;
    private JTextField textField6;
    private JLabel label6;
    private JLabel label7;
    private ArrayList<JButton> buttonArrayList;
    private Dimension dimension;


    //自动创建主框架，不指定上一界面的GUI
    public SystemManagerGUI() throws IOException {
        dimension = jPanel.getSize();
        //添加主框架
        frame = new JFrame("系统管理员界面");
        SystemManagerMenu systemManagerMenu = new SystemManagerMenu(tabbedPane1,
                textFieldArrayList,labelArrayList,buttonArrayList);
        frame.setContentPane(jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(systemManagerMenu);
        frame.pack();
        frame.setVisible(true);

        //添加输入框
        textFieldArrayList = new ArrayList<JTextField>();
        textFieldArrayList.add(textField1);
        textFieldArrayList.add(textField2);
        textFieldArrayList.add(textField3);
        textFieldArrayList.add(textField4);
        textFieldArrayList.add(textField5);
        textFieldArrayList.add(textField6);
        textField1.setVisible(false);
        textField2.setVisible(false);
        textField3.setVisible(false);
        textField4.setVisible(false);
        textField5.setVisible(false);
        textField6.setVisible(false);
        //添加标签
        labelArrayList = new ArrayList<JLabel>();
        labelArrayList.add(label1);
        labelArrayList.add(label2);
        labelArrayList.add(label3);
        labelArrayList.add(label4);
        labelArrayList.add(label5);
        labelArrayList.add(label6);
        labelArrayList.add(label7);
        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        label6.setVisible(false);
        label7.setVisible(false);
        //按钮添加监听
        ConfirmButton.addActionListener(new ConfirmButtonActionListener(
                textFieldArrayList,tabbedPane1,labelArrayList));
        BackButton.addActionListener(new BackButtonActionListener(frame,frame));
        //添加按钮
        buttonArrayList = new ArrayList<JButton>();
        buttonArrayList.add(ConfirmButton);
        buttonArrayList.add(BackButton);

    }

    //自动创建主框架，指定上一界面的GUI
    public SystemManagerGUI(JFrame mainFrame) throws IOException {
        dimension = jPanel.getSize();

        //添加输入框
        textFieldArrayList = new ArrayList<JTextField>();
        textFieldArrayList.add(textField1);
        textFieldArrayList.add(textField2);
        textFieldArrayList.add(textField3);
        textFieldArrayList.add(textField4);
        textFieldArrayList.add(textField5);
        textFieldArrayList.add(textField6);
        textField1.setVisible(false);
        textField2.setVisible(false);
        textField3.setVisible(false);
        textField4.setVisible(false);
        textField5.setVisible(false);
        textField6.setVisible(false);
        //添加标签
        labelArrayList = new ArrayList<JLabel>();
        labelArrayList.add(label1);
        labelArrayList.add(label2);
        labelArrayList.add(label3);
        labelArrayList.add(label4);
        labelArrayList.add(label5);
        labelArrayList.add(label6);
        labelArrayList.add(label7);
        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        label6.setVisible(false);
        label7.setVisible(false);
        //添加主框架
        frame = new JFrame("系统管理员界面");

        frame.setContentPane(jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
        //按钮添加监听
        ConfirmButton.addActionListener(new ConfirmButtonActionListener(
                textFieldArrayList,tabbedPane1,labelArrayList));
        BackButton.addActionListener(new BackButtonActionListener(frame,mainFrame));
        //添加按钮
        buttonArrayList = new ArrayList<JButton>();
        buttonArrayList.add(ConfirmButton);
        buttonArrayList.add(BackButton);

        SystemManagerMenu systemManagerMenu = new SystemManagerMenu(tabbedPane1,
                textFieldArrayList,labelArrayList,buttonArrayList);
        frame.setJMenuBar(systemManagerMenu);
    }

    //指定主框架和上一界面的GUI
    public SystemManagerGUI(JFrame frame,JFrame mainFrame) throws IOException {
        dimension = jPanel.getSize();
        this.frame = frame;
        //添加输入框
        textFieldArrayList = new ArrayList<JTextField>();
        textFieldArrayList.add(textField1);
        textFieldArrayList.add(textField2);
        textFieldArrayList.add(textField3);
        textFieldArrayList.add(textField4);
        textFieldArrayList.add(textField5);
        textFieldArrayList.add(textField6);
        textField1.setVisible(false);
        textField2.setVisible(false);
        textField3.setVisible(false);
        textField4.setVisible(false);
        textField5.setVisible(false);
        textField6.setVisible(false);
        //添加标签
        labelArrayList = new ArrayList<JLabel>();
        labelArrayList.add(label1);
        labelArrayList.add(label2);
        labelArrayList.add(label3);
        labelArrayList.add(label4);
        labelArrayList.add(label5);
        labelArrayList.add(label6);
        labelArrayList.add(label7);
        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        label6.setVisible(false);
        label7.setVisible(false);
        //按钮添加监听
        ConfirmButton.addActionListener(new ConfirmButtonActionListener(
                textFieldArrayList,tabbedPane1,labelArrayList));
        BackButton.addActionListener(new BackButtonActionListener(frame,mainFrame));
        //添加按钮
        buttonArrayList = new ArrayList<JButton>();
        buttonArrayList.add(ConfirmButton);
        buttonArrayList.add(BackButton);
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("系统管理员界面");
        SystemManagerGUI systemManagerGUI = new SystemManagerGUI(frame,frame);
        SystemManagerMenu systemManagerMenu = new SystemManagerMenu(systemManagerGUI.tabbedPane1,
                systemManagerGUI.textFieldArrayList,systemManagerGUI.labelArrayList,
                systemManagerGUI.buttonArrayList);
        frame.setVisible(true);
        frame.setContentPane(systemManagerGUI.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(systemManagerMenu);
        frame.pack();

    }
}

class SystemManagerMenu extends JMenuBar {

    private JTabbedPane tabbedPane1;
    private ArrayList<JTextField> textFieldArrayList;
    private ArrayList<JLabel> labelArrayList;
    private ArrayList<JButton> buttonArrayList;

    public SystemManagerMenu(JTabbedPane tabbedPane1,ArrayList<JTextField> textFieldArrayList,
                             ArrayList<JLabel> labelArrayList, ArrayList<JButton> buttonArrayList) throws IOException {
            add(createManageReaderMenu(tabbedPane1,textFieldArrayList,
                    labelArrayList,buttonArrayList));//添加“管理借阅者”菜单
            add(createManageBookMenu(tabbedPane1,textFieldArrayList,
                    labelArrayList,buttonArrayList));//添加“管理图书”菜单
            add(createManageLibrarianMenu(tabbedPane1,textFieldArrayList,
                    labelArrayList,buttonArrayList));//添加“管理图书管理员”菜单
            add(createOther(tabbedPane1,textFieldArrayList,
                    labelArrayList,buttonArrayList));//添加"其他功能"菜单
            this.tabbedPane1 = tabbedPane1;
            this.textFieldArrayList = textFieldArrayList;
            this.labelArrayList = labelArrayList;
            this.buttonArrayList = buttonArrayList;
            setVisible(true);
    }

    //定义"管理借阅者"菜单
    private JMenu createManageReaderMenu(JTabbedPane tabbedPane1,ArrayList<JTextField> textFieldArrayList,
                                         ArrayList<JLabel> labelArrayList,ArrayList<JButton> buttonArrayList) throws IOException {

        //第一个菜单栏
        JMenu menu=new JMenu("管理借阅者");
        menu.setSize(100,30);
        //menu.setMnemonic(KeyEvent.VK_F);//设置快速访问符

        //存储按钮的标签
        String label;

        JMenuItem item=new JMenuItem("添加借阅者");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new AddingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        menu.add(item);

        item=new JMenuItem("更新借阅者");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new UpdatingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        menu.add(item);

        item=new JMenuItem("删除借阅者");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new DeletingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        menu.add(item);

//        menu.addSeparator();//将新分隔符追加到菜单的末尾
        item=new JMenuItem("查找借阅者");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new FindingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        menu.add(item);

        menu.addSeparator();//将新分隔符追加到菜单的末尾
        item=new JMenuItem("查找所有借阅者");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new AllFindingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        menu.add(item);

        return menu;
    }

    //定义"管理图书"菜单
    private JMenu createManageBookMenu(JTabbedPane tabbedPane1,ArrayList<JTextField> textFieldArrayList,
                                       ArrayList<JLabel> labelArrayList,ArrayList<JButton> buttonArrayList) throws IOException {
        //第一个菜单栏
        JMenu menu=new JMenu("管理图书");
        menu.setSize(100,30);
        //menu.setMnemonic(KeyEvent.VK_F);//设置快速访问符

        //存储按钮的标签
        String label;

        JMenuItem item=new JMenuItem("添加图书");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new AddingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        menu.add(item);

        item=new JMenuItem("更新图书");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new UpdatingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        menu.add(item);

        item=new JMenuItem("删除图书");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new DeletingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        menu.add(item);

//        menu.addSeparator();//将新分隔符追加到菜单的末尾
        item=new JMenuItem("查找图书");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new FindingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        menu.add(item);

        menu.addSeparator();//将新分隔符追加到菜单的末尾
        item=new JMenuItem("查找所有图书");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new AllFindingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        menu.add(item);

        return menu;
    }

    //定义"管理图书管理员"菜单
    private JMenu createManageLibrarianMenu(JTabbedPane tabbedPane1,ArrayList<JTextField> textFieldArrayList,
                                            ArrayList<JLabel> labelArrayList,ArrayList<JButton> buttonArrayList) throws IOException {
        //第一个菜单栏
        JMenu menu=new JMenu("管理图书管理员");
        menu.setSize(100,30);
        //menu.setMnemonic(KeyEvent.VK_F);//设置快速访问符

        //存储按钮的标签
        String label;

        JMenuItem item=new JMenuItem("添加图书管理员");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new AddingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        menu.add(item);

        item=new JMenuItem("更新图书管理员");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new UpdatingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        menu.add(item);

        item=new JMenuItem("删除图书管理员");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new DeletingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        menu.add(item);

//        menu.addSeparator();//将新分隔符追加到菜单的末尾
        item=new JMenuItem("查找图书管理员");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new FindingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        menu.add(item);

        menu.addSeparator();//将新分隔符追加到菜单的末尾
        item=new JMenuItem("查找所有图书管理员");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new AllFindingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        menu.add(item);

        return menu;
    }

    //定义"管理图书管理员"菜单
    private JMenu createOther(JTabbedPane tabbedPane1,ArrayList<JTextField> textFieldArrayList,
                                            ArrayList<JLabel> labelArrayList,ArrayList<JButton> buttonArrayList) throws IOException {
        //第一个菜单栏
        JMenu menu=new JMenu("其他操作");
        menu.setSize(100,30);
        //menu.setMnemonic(KeyEvent.VK_F);//设置快速访问符

        //存储按钮的标签
        String label;

        JMenuItem item=new JMenuItem("备份数据库");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new AddingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        menu.add(item);

        item=new JMenuItem("添加系统管理员");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new UpdatingActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        menu.add(item);

        return menu;
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        JFrame frame=new JFrame("菜单栏");
        frame.setSize(300,200);
        //frame.setJMenuBar(new SystemManagerMenu());
        frame.setVisible(true);

    }

}

//“添加”功能按钮监听
class AddingActionListener implements ActionListener {

    private String label;
    private JTabbedPane tabbedPane1;
    private ArrayList<JTextField> textFieldArrayList;
    private ArrayList<JLabel> labelArrayList;
    private ArrayList<JButton> buttonArrayList;

    public AddingActionListener(String label, JTabbedPane tabbedPane1,ArrayList<JTextField> textFieldArrayList,
                                ArrayList<JLabel> labelArrayList,ArrayList<JButton> buttonArrayList) throws IOException {

        this.label = label;
        this.tabbedPane1 = tabbedPane1;
        this.textFieldArrayList = textFieldArrayList;
        this.labelArrayList = labelArrayList;
        this.buttonArrayList = buttonArrayList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(label);
        labelArrayList.get(0).setVisible(false);
        labelArrayList.get(1).setVisible(false);
        labelArrayList.get(2).setVisible(false);
        labelArrayList.get(3).setVisible(false);
        labelArrayList.get(4).setVisible(false);
        labelArrayList.get(5).setVisible(false);
        labelArrayList.get(6).setVisible(false);
        textFieldArrayList.get(0).setVisible(false);
        textFieldArrayList.get(1).setVisible(false);
        textFieldArrayList.get(2).setVisible(false);
        textFieldArrayList.get(3).setVisible(false);
        textFieldArrayList.get(4).setVisible(false);
        textFieldArrayList.get(5).setVisible(false);
        textFieldArrayList.get(0).setText("");
        textFieldArrayList.get(1).setText("");
        textFieldArrayList.get(2).setText("");
        textFieldArrayList.get(3).setText("");
        textFieldArrayList.get(4).setText("");
        textFieldArrayList.get(5).setText("");
        buttonArrayList.get(0).setVisible(true);
        buttonArrayList.get(1).setVisible(true);

        if (label.equals("添加图书管理员")){
            tabbedPane1.setTitleAt(0,"添加图书管理员");

            labelArrayList.get(0).setVisible(true);
            labelArrayList.get(0).setText("请输入图书管理员的名字：");
            labelArrayList.get(1).setVisible(true);
            labelArrayList.get(1).setText("请输入图书管理员的密码：");
            textFieldArrayList.get(0).setVisible(true);
            textFieldArrayList.get(1).setVisible(true);
        }
        else if (label.equals("添加图书") ){
            tabbedPane1.setTitleAt(0,"添加图书");
            labelArrayList.get(0).setVisible(true);
            labelArrayList.get(0).setText("请输入添加书籍的书名：");
            labelArrayList.get(1).setVisible(true);
            labelArrayList.get(1).setText("请输入添加书籍的作者：");
            labelArrayList.get(2).setVisible(true);
            labelArrayList.get(2).setText("请输入添加书籍的分类：");
            labelArrayList.get(3).setVisible(true);
            labelArrayList.get(3).setText("请输入添加书籍的出版社：");
            labelArrayList.get(4).setVisible(true);
            labelArrayList.get(4).setText("请输入添加书籍的价格：");
            textFieldArrayList.get(0).setVisible(true);
            textFieldArrayList.get(1).setVisible(true);
            textFieldArrayList.get(2).setVisible(true);
            textFieldArrayList.get(3).setVisible(true);
            textFieldArrayList.get(4).setVisible(true);
        }
        else{
            //添加借阅者
            tabbedPane1.setTitleAt(0,"添加借阅者");
            labelArrayList.get(0).setVisible(true);
            labelArrayList.get(0).setText("请输入您的姓名：");
            labelArrayList.get(1).setVisible(true);
            labelArrayList.get(1).setText("请输入您的角色：");
            textFieldArrayList.get(0).setVisible(true);
            textFieldArrayList.get(1).setVisible(true);
        }
    }
}

//“查询”功能按钮监听
class FindingActionListener implements ActionListener {


    private String label;
    private JTabbedPane tabbedPane1;
    private ArrayList<JTextField> textFieldArrayList;
    private ArrayList<JLabel> labelArrayList;
    private ArrayList<JButton> buttonArrayList;

    public FindingActionListener(String label, JTabbedPane tabbedPane1,ArrayList<JTextField> textFieldArrayList,
                                ArrayList<JLabel> labelArrayList,ArrayList<JButton> buttonArrayList) throws IOException {

        this.label = label;
        this.tabbedPane1 = tabbedPane1;
        this.textFieldArrayList = textFieldArrayList;
        this.labelArrayList = labelArrayList;
        this.buttonArrayList = buttonArrayList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(label);
        labelArrayList.get(0).setVisible(false);
        labelArrayList.get(1).setVisible(false);
        labelArrayList.get(2).setVisible(false);
        labelArrayList.get(3).setVisible(false);
        labelArrayList.get(4).setVisible(false);
        labelArrayList.get(5).setVisible(false);
        labelArrayList.get(6).setVisible(false);
        textFieldArrayList.get(0).setVisible(false);
        textFieldArrayList.get(1).setVisible(false);
        textFieldArrayList.get(2).setVisible(false);
        textFieldArrayList.get(3).setVisible(false);
        textFieldArrayList.get(4).setVisible(false);
        textFieldArrayList.get(5).setVisible(false);
        textFieldArrayList.get(0).setText("");
        textFieldArrayList.get(1).setText("");
        textFieldArrayList.get(2).setText("");
        textFieldArrayList.get(3).setText("");
        textFieldArrayList.get(4).setText("");
        textFieldArrayList.get(5).setText("");
        buttonArrayList.get(0).setVisible(true);
        buttonArrayList.get(1).setVisible(true);

        if (label.equals("查找图书管理员")){
            tabbedPane1.setTitleAt(0,"查找图书管理员");

            labelArrayList.get(0).setVisible(true);
            labelArrayList.get(0).setText("请输入图书管理员的ID：");
            textFieldArrayList.get(0).setVisible(true);
            return;
        }
        else if (label.equals("查找图书") ){
            tabbedPane1.setTitleAt(0,"查找图书");

            labelArrayList.get(0).setVisible(true);
            labelArrayList.get(0).setText("请输入图书的ID：");
            textFieldArrayList.get(0).setVisible(true);
            return;
        }
        else{
            //查询借阅者
            tabbedPane1.setTitleAt(0,"查找借阅者");

            labelArrayList.get(0).setVisible(true);
            labelArrayList.get(0).setText("请输入借阅者的ID：");
            textFieldArrayList.get(0).setVisible(true);
            return;
        }
    }
}

//“更新”功能按钮监听
class UpdatingActionListener implements ActionListener {

    private String label;
    private JTabbedPane tabbedPane1;
    private ArrayList<JTextField> textFieldArrayList;
    private ArrayList<JLabel> labelArrayList;
    private ArrayList<JButton> buttonArrayList;


    public UpdatingActionListener(String label, JTabbedPane tabbedPane1,ArrayList<JTextField> textFieldArrayList,
                                  ArrayList<JLabel> labelArrayList,ArrayList<JButton> buttonArrayList) throws IOException {

        this.label = label;
        this.tabbedPane1 = tabbedPane1;
        this.textFieldArrayList = textFieldArrayList;
        this.labelArrayList = labelArrayList;
        this.buttonArrayList = buttonArrayList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(label);
        labelArrayList.get(0).setVisible(false);
        labelArrayList.get(1).setVisible(false);
        labelArrayList.get(2).setVisible(false);
        labelArrayList.get(3).setVisible(false);
        labelArrayList.get(4).setVisible(false);
        labelArrayList.get(5).setVisible(false);
        labelArrayList.get(6).setVisible(false);
        textFieldArrayList.get(0).setVisible(false);
        textFieldArrayList.get(1).setVisible(false);
        textFieldArrayList.get(2).setVisible(false);
        textFieldArrayList.get(3).setVisible(false);
        textFieldArrayList.get(4).setVisible(false);
        textFieldArrayList.get(5).setVisible(false);
        textFieldArrayList.get(0).setText("");
        textFieldArrayList.get(1).setText("");
        textFieldArrayList.get(2).setText("");
        textFieldArrayList.get(3).setText("");
        textFieldArrayList.get(4).setText("");
        textFieldArrayList.get(5).setText("");
        buttonArrayList.get(0).setVisible(true);
        buttonArrayList.get(1).setVisible(true);

        if (label.equals("更新图书管理员")){
            tabbedPane1.setTitleAt(0,"更新图书管理员");

            labelArrayList.get(0).setVisible(true);
            labelArrayList.get(0).setText("请输入要更改的图书管理员的ID：");
            labelArrayList.get(1).setVisible(true);
            labelArrayList.get(1).setText("请输入更改后的图书管理员的名字：");
            labelArrayList.get(2).setVisible(true);
            labelArrayList.get(2).setText("请输入更改后的图书管理员的密码：");
            textFieldArrayList.get(0).setVisible(true);
            textFieldArrayList.get(1).setVisible(true);
            textFieldArrayList.get(2).setVisible(true);
        }
        else if (label.equals("更新图书") ){
            tabbedPane1.setTitleAt(0,"更新图书");
            labelArrayList.get(0).setVisible(true);
            labelArrayList.get(0).setText("请输入要更改的书籍的ID：");
            labelArrayList.get(1).setVisible(true);
            labelArrayList.get(1).setText("请输入更改后的书籍的书名：");
            labelArrayList.get(2).setVisible(true);
            labelArrayList.get(2).setText("请输入更改后的书籍的作者：");
            labelArrayList.get(3).setVisible(true);
            labelArrayList.get(3).setText("请输入更改后的书籍的分类：");
            labelArrayList.get(4).setVisible(true);
            labelArrayList.get(4).setText("请输入更改后的书籍的出版社：");
            labelArrayList.get(5).setVisible(true);
            labelArrayList.get(5).setText("请输入更改后的书籍的价格：");
            textFieldArrayList.get(0).setVisible(true);
            textFieldArrayList.get(1).setVisible(true);
            textFieldArrayList.get(2).setVisible(true);
            textFieldArrayList.get(3).setVisible(true);
            textFieldArrayList.get(4).setVisible(true);
            textFieldArrayList.get(5).setVisible(true);
        }
        else{
            //更新借阅者
            tabbedPane1.setTitleAt(0,"更新借阅者");
            labelArrayList.get(0).setVisible(true);
            labelArrayList.get(0).setText("请输入要更改的借阅者的ID：");
            labelArrayList.get(1).setVisible(true);
            labelArrayList.get(1).setText("请输入更改后的借阅者的名字：");
            labelArrayList.get(2).setVisible(true);
            labelArrayList.get(2).setText("请输入更改后的借阅者的角色：");
            textFieldArrayList.get(0).setVisible(true);
            textFieldArrayList.get(1).setVisible(true);
            textFieldArrayList.get(2).setVisible(true);
        }
    }
}

//“删除”功能按钮监听
class DeletingActionListener implements ActionListener {

    private String label;
    private JTabbedPane tabbedPane1;
    private ArrayList<JTextField> textFieldArrayList;
    private ArrayList<JLabel> labelArrayList;
    private ArrayList<JButton> buttonArrayList;


    public DeletingActionListener(String label, JTabbedPane tabbedPane1,ArrayList<JTextField> textFieldArrayList,
                                  ArrayList<JLabel> labelArrayList,ArrayList<JButton> buttonArrayList) throws IOException {

        this.label = label;
        this.tabbedPane1 = tabbedPane1;
        this.textFieldArrayList = textFieldArrayList;
        this.labelArrayList = labelArrayList;
        this.buttonArrayList = buttonArrayList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(label);
        labelArrayList.get(0).setVisible(false);
        labelArrayList.get(1).setVisible(false);
        labelArrayList.get(2).setVisible(false);
        labelArrayList.get(3).setVisible(false);
        labelArrayList.get(4).setVisible(false);
        labelArrayList.get(5).setVisible(false);
        labelArrayList.get(6).setVisible(false);
        textFieldArrayList.get(0).setVisible(false);
        textFieldArrayList.get(1).setVisible(false);
        textFieldArrayList.get(2).setVisible(false);
        textFieldArrayList.get(3).setVisible(false);
        textFieldArrayList.get(4).setVisible(false);
        textFieldArrayList.get(5).setVisible(false);
        textFieldArrayList.get(0).setText("");
        textFieldArrayList.get(1).setText("");
        textFieldArrayList.get(2).setText("");
        textFieldArrayList.get(3).setText("");
        textFieldArrayList.get(4).setText("");
        textFieldArrayList.get(5).setText("");
        buttonArrayList.get(0).setVisible(true);
        buttonArrayList.get(1).setVisible(true);
        if (label.equals("删除图书管理员")){
            tabbedPane1.setTitleAt(0,"删除图书管理员");

            labelArrayList.get(0).setVisible(true);
            labelArrayList.get(0).setText("请输入要删除的图书管理员的ID：");
            textFieldArrayList.get(0).setVisible(true);
        }
        else if (label.equals("删除图书") ){
            tabbedPane1.setTitleAt(0,"删除图书");

            labelArrayList.get(0).setVisible(true);
            labelArrayList.get(0).setText("请输入要删除的图书的ID：");
            textFieldArrayList.get(0).setVisible(true);

        }
        else{
            //删除借阅者
            tabbedPane1.setTitleAt(0,"删除借阅者");

            labelArrayList.get(0).setVisible(true);
            labelArrayList.get(0).setText("请输入要删除的借阅者的ID：");
            textFieldArrayList.get(0).setVisible(true);
        }
    }
}

//“查询所有”功能按钮监听
class AllFindingActionListener implements ActionListener {

    private String label;
    private JTabbedPane tabbedPane1;
    private ArrayList<JTextField> textFieldArrayList;
    private ArrayList<JLabel> labelArrayList;
    private ArrayList<JButton> buttonArrayList;

    public AllFindingActionListener(String label, JTabbedPane tabbedPane1,ArrayList<JTextField> textFieldArrayList,
                                  ArrayList<JLabel> labelArrayList,ArrayList<JButton> buttonArrayList) throws IOException {

        this.label = label;
        this.tabbedPane1 = tabbedPane1;
        this.textFieldArrayList = textFieldArrayList;
        this.labelArrayList = labelArrayList;
        this.buttonArrayList = buttonArrayList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(label);
        labelArrayList.get(0).setVisible(false);
        labelArrayList.get(1).setVisible(false);
        labelArrayList.get(2).setVisible(false);
        labelArrayList.get(3).setVisible(false);
        labelArrayList.get(4).setVisible(false);
        labelArrayList.get(5).setVisible(false);
        labelArrayList.get(6).setVisible(false);
        textFieldArrayList.get(0).setVisible(false);
        textFieldArrayList.get(1).setVisible(false);
        textFieldArrayList.get(2).setVisible(false);
        textFieldArrayList.get(3).setVisible(false);
        textFieldArrayList.get(4).setVisible(false);
        textFieldArrayList.get(5).setVisible(false);
        textFieldArrayList.get(0).setText("");
        textFieldArrayList.get(1).setText("");
        textFieldArrayList.get(2).setText("");
        textFieldArrayList.get(3).setText("");
        textFieldArrayList.get(4).setText("");
        textFieldArrayList.get(5).setText("");
        buttonArrayList.get(0).setVisible(true);
        buttonArrayList.get(1).setVisible(true);
        if (label.equals("查找所有图书管理员")){
            tabbedPane1.setTitleAt(0,"查找所有的图书管理员");


        }
        else if (label.equals("查找所有图书") ){
            tabbedPane1.setTitleAt(0,"查找所有的图书");

        }
        else{
            //删除借阅者
            tabbedPane1.setTitleAt(0,"查找所有的借阅者");

        }
    }
}

//确认按钮监听
class ConfirmButtonActionListener implements ActionListener{

    private SystemManagerService systemManagerService;
    private SystemManagerController systemManagerController;
    private ArrayList<JTextField> textFieldArrayList;
    private ArrayList<JLabel> labelArrayList;
//    private final ArrayList<JButton> buttonArrayList;
    private List<String> stringList;
    private JTabbedPane tabbedPane;

    public ConfirmButtonActionListener(ArrayList<JTextField> textFieldArrayList, JTabbedPane tabbedPane,
                                       ArrayList<JLabel> labelArrayList
                                       ) throws IOException {
//        this.buttonArrayList = buttonArrayList;
        systemManagerService = new SystemManagerService();
        systemManagerService.initiate();
        systemManagerController = new SystemManagerController();
        stringList = new ArrayList<String>();
        this.textFieldArrayList = textFieldArrayList;
        this.tabbedPane = tabbedPane;
        this.labelArrayList = labelArrayList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        stringList.clear();
        //获取输入框内的字符串
        for (JTextField jTextField : textFieldArrayList) {
            if(jTextField.isVisible()) {
                //如果当前能看到则记录数据
                stringList.add(jTextField.getText());
            }
        }
        String function = tabbedPane.getTitleAt(0);
        if (function.equals("添加图书管理员")){
            System.out.println("正在添加图书管理员");
            String name = stringList.get(0);
            String password = stringList.get(1);
            systemManagerService.createLibrarian(name,"图书管理员",password);
        }
        else if(function.equals("添加图书")){
            System.out.println("正在添加图书");
            String name = stringList.get(0);
            String author = stringList.get(1);
            String category = stringList.get(2);
            String publisher = stringList.get(3);
            String str_price = stringList.get(4);
            int price;
            try {
                price = toInteger(str_price);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "请输入正确的价格！", "出现错误！",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            systemManagerService.createBook(name,author,category,publisher,price);
            JOptionPane.showMessageDialog(null, "添加图书成功！", "提示",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else if (function.equals("添加借阅者")){
            System.out.println("正在添加借阅者");
            String name = stringList.get(0);
            String role = stringList.get(1);
            if (role.equals("老师") || role.equals("博士生") ||  role.equals("研究生") ||
                    role.equals("本科生") || role.equals("专科生")) {
                systemManagerService.createUser(name, role);
                JOptionPane.showMessageDialog(null, "添加借阅者成功！", "提示",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "请输入正确的角色！\n" +
                                "角色包括：老师、博士生、研究生、本科生、专科生", "出现错误！",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        else if(function.equals("更新借阅者")){
            System.out.println("正在更新借阅者");
            int id;
            String name;
            String role;
            try {
                id = toInteger(stringList.get(0));
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "请输入正确的ID！", "出现错误！",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            name = stringList.get(1);
            role = stringList.get(2);
            User user = new User();
            user.setUser_id(id);
            user.setUser_name(name);
            user.setRole(role);
            try {
                systemManagerService.updateUser(user);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(),
                        "出现错误！",JOptionPane.ERROR_MESSAGE);
                exception.printStackTrace();
                return;
            }
            JOptionPane.showMessageDialog(null, "更改成功！",
                    "提示",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(function.equals("更新图书")){
            System.out.println("正在更新图书");
            int id;
            String name;
            String author;
            String category;
            String press;
            int price;
            try {
                id = toInteger(stringList.get(0));
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "请输入正确的ID！", "出现错误！",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            name = stringList.get(1);
            author = stringList.get(2);
            category = stringList.get(3);
            press = stringList.get(4);
            try {
                price = toInteger(stringList.get(5));
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "请输入正确的价格！", "出现错误！",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            Book book = new Book();
            book.setBook_id(id);
            book.setBook_name(name);
            book.setAuthor(author);
            book.setCategory(category);
            book.setPublisher(press);
            book.setPrice(price);
            try {
                systemManagerService.updateBook(book);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(),
                        "出现错误！",JOptionPane.ERROR_MESSAGE);
                exception.printStackTrace();
                return;
            }
            JOptionPane.showMessageDialog(null, "更改成功！",
                    "提示",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(function.equals("更新图书管理员")){
            System.out.println("正在更新图书管理员");
            int id;
            String name;
            String password;
            try {
                id = toInteger(stringList.get(0));
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "请输入正确的ID！", "出现错误！",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            name = stringList.get(1);
            password = stringList.get(2);
            Manager manager = new Manager();
            manager.setManager_id(id);
            manager.setManager_name(name);
            manager.setPassword(password);
            try {
                systemManagerService.updateLibrarian(manager);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(),
                        "出现错误！",JOptionPane.ERROR_MESSAGE);
                exception.printStackTrace();
                return;
            }
            JOptionPane.showMessageDialog(null, "更改成功！",
                    "提示",JOptionPane.INFORMATION_MESSAGE);
        }
        else if (function.startsWith("删除")){
            System.out.println("正在删除");
            try {
                systemManagerController.delete(function,stringList);
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null, exception.getMessage(), "出现错误！",
                        JOptionPane.ERROR_MESSAGE);
                return ;
            }
            JOptionPane.showMessageDialog(null, "删除成功！", "提示",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else if(function.startsWith("查找所有")){
            System.out.println("查找所有");
            systemManagerController.findAll(function);
        }
        else if (function.startsWith("查找")){
            System.out.println("查找");
            try {
                systemManagerController.find(function,labelArrayList,stringList);
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null, exception.getMessage(), "出现错误！",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            //隐去所有输入框，使用标签显示查找结果
            for (JTextField jTextField : textFieldArrayList) {
                jTextField.setVisible(false);
            }
        }
        else{
            //未选择功能
            JOptionPane.showMessageDialog(null, "请选择要执行的功能！", "出现错误！",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public int toInteger(String manager_id) throws Exception {
        int length = manager_id.length();
        int result = 0;
        if (length ==0)
            return 0;
        for (int i=0;i<length;i++){
            result += Math.pow(10,length-i-1) * toInteger(manager_id.charAt(i));
        }
        return result;
    }

    public int toInteger(char c) throws Exception{
        //如果输入了无效字符
        if (c<48 || c>58){
            throw new Exception("输入了无效字符！");
        }
        else{
            return c-48;
        }
    }
}

//返回按钮监听
class BackButtonActionListener implements ActionListener{

    private ArrayList<JTextField> textFieldArrayList;
    private List<String> stringList;
    private JTabbedPane tabbedPane;
    private JFrame frame;
    private JFrame mainFrame;

    public BackButtonActionListener(JFrame frame, JFrame mainFrame){
        this.frame = frame;
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(frame!=mainFrame) {
            frame.setVisible(false);
            mainFrame.setVisible(true);
        }
        else{
            System.exit(0);
        }
    }
}