package cn.DBBMS.GUI.LibrarianGUI;

import cn.DBBMS.Controller.LibrarianController;
import cn.DBBMS.entity.Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibrarianGUI {
    private JPanel jPanel;
    private JScrollPane OperationArea;
    private JTabbedPane tabbedPane1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton BackButton;
    private JButton ConfirmButton;
    private ArrayList<JTextField> textFieldArrayList;
    private ArrayList<JLabel> labelArrayList;
    private ArrayList<JButton> buttonArrayList;
    private JFrame frame;
    private Manager librarian;

    //指定上一界面的
    public LibrarianGUI(JFrame mainFrame, Manager librarian) throws IOException {
        this.librarian = librarian;
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
        frame = new JFrame("图书管理员界面");

        frame.setContentPane(jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //按钮添加监听
        ConfirmButton.addActionListener(new ConfirmButtonActionListener(
                textFieldArrayList,tabbedPane1,labelArrayList,librarian));
        BackButton.addActionListener(new BackButtonActionListener(frame,mainFrame));
        //添加按钮
        buttonArrayList = new ArrayList<JButton>();
        buttonArrayList.add(ConfirmButton);
        buttonArrayList.add(BackButton);

        LibrarianMenu librarianMenu = new LibrarianMenu(tabbedPane1,
                textFieldArrayList,labelArrayList,buttonArrayList);
        librarianMenu.setVisible(true);
        frame.setJMenuBar(librarianMenu);
        frame.pack();
    }

    //不指定上一界面的
    public LibrarianGUI(Manager librarian) throws IOException {
        this.librarian = librarian;
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
        frame = new JFrame("图书管理员界面");

        frame.setContentPane(jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        //按钮添加监听
        ConfirmButton.addActionListener(new ConfirmButtonActionListener(
                textFieldArrayList,tabbedPane1,labelArrayList,librarian));
        BackButton.addActionListener(new BackButtonActionListener(frame,frame));
        //添加按钮
        buttonArrayList = new ArrayList<JButton>();
        buttonArrayList.add(ConfirmButton);
        buttonArrayList.add(BackButton);

        LibrarianMenu librarianMenu = new LibrarianMenu(tabbedPane1,
                textFieldArrayList,labelArrayList,buttonArrayList);
        librarianMenu.setVisible(true);
        frame.setJMenuBar(librarianMenu);

        frame.pack();
    }

    public static void main(String[] args) throws IOException {
        Manager manager = new Manager();
        manager.setManager_id(4);
        new LibrarianGUI(manager);
    }
}

class LibrarianMenu extends JMenuBar {

    private JTabbedPane tabbedPane1;
    private ArrayList<JTextField> textFieldArrayList;
    private ArrayList<JLabel> labelArrayList;
    private ArrayList<JButton> buttonArrayList;

    public LibrarianMenu(JTabbedPane tabbedPane1, ArrayList<JTextField> textFieldArrayList,
                         ArrayList<JLabel> labelArrayList, ArrayList<JButton> buttonArrayList) throws IOException {
        add(createMenu(tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));//添加“选择功能”菜单
/*        add(createFindBookMenu(tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));//添加“查找图书”菜单
        add(createFindInfor(tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));//添加“查询自己的借阅信息”菜单*/
        this.tabbedPane1 = tabbedPane1;
        this.textFieldArrayList = textFieldArrayList;
        this.labelArrayList = labelArrayList;
        this.buttonArrayList = buttonArrayList;
        setVisible(true);
    }

    //定义"选择功能"菜单
    private JMenu createMenu(JTabbedPane tabbedPane1,ArrayList<JTextField> textFieldArrayList,
                             ArrayList<JLabel> labelArrayList,ArrayList<JButton> buttonArrayList) throws IOException {

        //第一个菜单栏
        JMenu menu=new JMenu("选择功能");
        menu.setSize(100,30);

        //存储按钮的标签
        String label;
        JMenuItem item=new JMenuItem("取消预约");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new cancelReservationActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        menu.add(item);

        item=new JMenuItem("借书");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new lendBookActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        menu.add(item);

        item=new JMenuItem("还书");
        item.setSize(100,30);
        label = item.getActionCommand();
        item.addActionListener(new returnBookActionListener(label,tabbedPane1,textFieldArrayList,
                labelArrayList,buttonArrayList));
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        menu.add(item);

        return menu;
    }

/*
    //定义"查找图书"菜单
    private JMenu createFindBookMenu(JTabbedPane tabbedPane1,ArrayList<JTextField> textFieldArrayList,
                                       ArrayList<JLabel> labelArrayList,ArrayList<JButton> buttonArrayList) throws IOException {
        //第一个菜单栏
        JMenu menu=new JMenu("查找图书");
        menu.setSize(100,30);
        //menu.setMnemonic(KeyEvent.VK_F);//设置快速访问符

        //存储按钮的标签
        String label;

        return menu;
    }
*/

/*    //定义"查询自己的借阅信息"菜单
    private JMenu createFindInfor(JTabbedPane tabbedPane1,ArrayList<JTextField> textFieldArrayList,
                                            ArrayList<JLabel> labelArrayList,ArrayList<JButton> buttonArrayList) throws IOException {
        //第一个菜单栏
        JMenu menu=new JMenu("管理图书管理员");
        menu.setSize(100,30);
        //menu.setMnemonic(KeyEvent.VK_F);//设置快速访问符


        //存储按钮的标签
        String label;


        return menu;
    }*/

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        JFrame frame=new JFrame("菜单栏");
        frame.setSize(300,200);
        //frame.setJMenuBar(new SystemManagerMenu());
        frame.setVisible(true);

    }

}

//返回按钮监听
class BackButtonActionListener implements ActionListener {

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

//确认按钮监听
class ConfirmButtonActionListener implements ActionListener{

    private final ArrayList<JTextField> textFieldArrayList;
    private final ArrayList<JLabel> labelArrayList;
    /*    private final ArrayList<JButton> buttonArrayList;*/
    private final List<String> stringList;
    private final JTabbedPane tabbedPane;
    private final Manager manager;
    private final LibrarianController controller;

    public ConfirmButtonActionListener(ArrayList<JTextField> textFieldArrayList, JTabbedPane tabbedPane,
                                       ArrayList<JLabel> labelArrayList,
                                       Manager manager) throws IOException {
        stringList = new ArrayList<String>();
        controller = new LibrarianController();
        this.textFieldArrayList = textFieldArrayList;
        this.tabbedPane = tabbedPane;
        this.labelArrayList = labelArrayList;
        this.manager = manager;
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
        if (function.equals("取消预约")){
            System.out.println("正在取消预约");
            String id = stringList.get(0);
            int book_id;
            try {
                book_id = toInteger(id);
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        exception.getMessage(), "出现了错误！",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                controller.cancelReservation(book_id);
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        exception.getMessage(), "出现了错误！",
                        JOptionPane.ERROR_MESSAGE);
                return;

            }
            JOptionPane.showMessageDialog(null,
                    "取消预约成功！", "提示",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else if(function.equals("借书")){
            System.out.println("正在借书");
            String id = stringList.get(0);
            int user_id, book_id;
            try {
                user_id = toInteger(id);
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        exception.getMessage(), "出现了错误！",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            id = stringList.get(1);
            try {
                book_id = toInteger(id);
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        exception.getMessage(), "出现了错误！",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                controller.lendBook(user_id,book_id);
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        exception.getMessage(), "出现了错误！",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null,
                    "借书成功！", "提示",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else if (function.equals("还书")){
            System.out.println("正在还书");
            String id = stringList.get(0);
            int book_id;
            try {
                book_id = toInteger(id);
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        exception.getMessage(), "出现了错误！",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            controller.returnBook(book_id);

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

//“取消预约”功能按钮监听
class cancelReservationActionListener implements ActionListener {

    private final String label;
    private final JTabbedPane tabbedPane1;
    private final ArrayList<JTextField> textFieldArrayList;
    private final ArrayList<JLabel> labelArrayList;
    private final ArrayList<JButton> buttonArrayList;

    public cancelReservationActionListener(String label, JTabbedPane tabbedPane1,
                                           ArrayList<JTextField> textFieldArrayList,
                                           ArrayList<JLabel> labelArrayList,
                                           ArrayList<JButton> buttonArrayList)
            throws IOException {

        this.label = label;
        this.tabbedPane1 = tabbedPane1;
        this.textFieldArrayList = textFieldArrayList;
        this.labelArrayList = labelArrayList;
        this.buttonArrayList = buttonArrayList;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(label);
//        labelArrayList.get(0).setVisible(false);
        labelArrayList.get(1).setVisible(false);
        labelArrayList.get(2).setVisible(false);
        labelArrayList.get(3).setVisible(false);
        labelArrayList.get(4).setVisible(false);
        labelArrayList.get(5).setVisible(false);
        labelArrayList.get(6).setVisible(false);
//        textFieldArrayList.get(0).setVisible(false);
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

        tabbedPane1.setTitleAt(0,label);

        labelArrayList.get(0).setVisible(true);
        labelArrayList.get(0).setText("请输入要取消预约的书目的ID：");

        textFieldArrayList.get(0).setVisible(true);

    }
}

//“借书”功能按钮监听
class lendBookActionListener implements ActionListener {

    private final String label;
    private final JTabbedPane tabbedPane1;
    private final ArrayList<JTextField> textFieldArrayList;
    private final ArrayList<JLabel> labelArrayList;
    private final ArrayList<JButton> buttonArrayList;

    public lendBookActionListener(String label, JTabbedPane tabbedPane1,
                                  ArrayList<JTextField> textFieldArrayList,
                                  ArrayList<JLabel> labelArrayList,
                                  ArrayList<JButton> buttonArrayList
    ) throws IOException {

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

        tabbedPane1.setTitleAt(0,label);

        labelArrayList.get(0).setVisible(true);
        labelArrayList.get(0).setText("请输入要借阅的借阅者ID：");
        labelArrayList.get(1).setVisible(true);
        labelArrayList.get(1).setText("请输入要借阅的书目的书籍ID：");
        textFieldArrayList.get(0).setVisible(true);
        textFieldArrayList.get(1).setVisible(true);
    }
}

//“还书”功能按钮监听
class returnBookActionListener implements ActionListener {

    private final String label;
    private final JTabbedPane tabbedPane1;
    private final ArrayList<JTextField> textFieldArrayList;
    private final ArrayList<JLabel> labelArrayList;
    private final ArrayList<JButton> buttonArrayList;

    public returnBookActionListener(String label, JTabbedPane tabbedPane1, ArrayList<JTextField> textFieldArrayList,
                                  ArrayList<JLabel> labelArrayList, ArrayList<JButton> buttonArrayList) throws IOException {

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

        tabbedPane1.setTitleAt(0,label);
        labelArrayList.get(0).setVisible(true);
        labelArrayList.get(0).setText("请输入归还的书目的ID：");
        textFieldArrayList.get(0).setVisible(true);
    }
}
