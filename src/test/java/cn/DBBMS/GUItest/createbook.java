package cn.DBBMS.GUItest;

import javax.swing.*;

public class createbook {
    public static void main(String[] args) {
        JFrame frame = new JFrame("createbook");
        frame.setContentPane(new createbook().createbook1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel createbook1;
    private JButton Button1;
    private JButton Button;



}
