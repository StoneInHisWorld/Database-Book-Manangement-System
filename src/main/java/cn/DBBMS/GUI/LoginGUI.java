package cn.DBBMS.GUI;

import cn.DBBMS.Controller.ManagerController;
import cn.DBBMS.entity.Manager;
import cn.DBBMS.entity.User;
import cn.DBBMS.service.ManagerService;
import cn.DBBMS.service.SystemManagerService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class LoginGUI {
    private JPanel panel1;
    private JLabel Welcome;
    private JButton login;
    private JButton exit;
    private JButton readerLogin;
    private JLabel password;
    private JLabel manager_id;
    private JTextField textField1;
    private JPasswordField passwordField1;

    public LoginGUI(JFrame frame) throws IOException {
        login.addActionListener(new LoginButtonListener(textField1,passwordField1,frame,manager_id));
        exit.addActionListener(new ExitButtonListener());
        readerLogin.addActionListener(new ReaderLoginButtionListener(password,passwordField1,manager_id));
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("LoginGUI");
        frame.setContentPane(new LoginGUI(frame).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

//登录按钮
class LoginButtonListener implements ActionListener {

    private JLabel label;
    private JTextField textField1;
    private JFrame frame;
    private JPasswordField passwordField1;
/*    private ManagerService managerService;
    private SystemManagerService systemManagerService;*/
    private ManagerController managerController;

    public LoginButtonListener(JTextField textField1, JPasswordField passwordField1,
                               JFrame frame, JLabel manager_id) throws IOException {
/*        managerService = new ManagerService();
        managerService.initiate();
        systemManagerService = new SystemManagerService();
        systemManagerService.initiate();*/
        managerController = new ManagerController();
        this.textField1 = textField1;
        this.passwordField1 = passwordField1;
        this.frame = frame;
        this.label = manager_id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String manager_id = textField1.getText();
        String password = passwordField1.getText();
        String title = label.getText();
/*        Manager manager;
        if(label.getText().equals("借阅号：")){
            System.out.println("借阅者登录");
            User user = new User();
            try {
                user = systemManagerService.findUser(toInteger(manager_id));
            } catch (Exception exception) {
                exception.printStackTrace();
                String warning = exception.getMessage();
                JOptionPane.showMessageDialog(null, warning, "出现错误！", JOptionPane.ERROR_MESSAGE);
            }

        }else{
            try {
                //检查是否有输入非法的manager_id，以及是否找到该管理员
                manager = managerService.login(toInteger(manager_id), password);
            } catch (Exception exception) {
                //出现错误则弹窗
                String warning = exception.getMessage();
                JOptionPane.showMessageDialog(null, warning, "出现错误！", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String role = manager.getRole();
            if (role.equals("图书管理员")) {
                try {
                    SystemManagerGUI systemManagerGUI = new SystemManagerGUI();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(null, ioException.getMessage(), "出现错误！",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                frame.setVisible(false);
            } else if (role.equals("系统管理员")) {
                try {
                    SystemManagerGUI systemManagerGUI = new SystemManagerGUI(frame);

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(null, ioException.getMessage(), "出现错误！",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                frame.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "出现了奇怪的管理员！", "出现错误！",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public int toInteger(String manager_id) throws Exception {
        int length = manager_id.length();
        int result = 0;
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
    }*/
        //接收控制层返回的消息
        String message = managerController.login(frame, title, manager_id, password);
        if (message.equals("系统管理员")||message.equals("图书管理员")||message.equals("借阅者")){
            //如果成功登录则隐去当前界面
            frame.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, message, "出现错误！", JOptionPane.ERROR_MESSAGE);
        }
    }
}

//退出按钮
class ExitButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

//借阅者登录按钮
class ReaderLoginButtionListener implements ActionListener{

    private JLabel password;
    private JLabel manager_id;
    private JPasswordField passwordField;

    public ReaderLoginButtionListener(JLabel password,JPasswordField passwordField1,JLabel manager_id){
        this.password = password;
        this.passwordField = passwordField1;
        this.manager_id = manager_id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        passwordField.setVisible(false);
        password.setVisible(false);
        JOptionPane.showMessageDialog(null, "请输入您的借阅号！", "提示",
                JOptionPane.INFORMATION_MESSAGE);
        manager_id.setText("借阅号：");
    }
}