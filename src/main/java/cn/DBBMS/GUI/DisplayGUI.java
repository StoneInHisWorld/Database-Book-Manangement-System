package cn.DBBMS.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class DisplayGUI {
    private JTable table1;
    private JPanel panel1;
    private JFrame frame;
    private DefaultTableModel tableModel;

    public DisplayGUI(){
        JFrame frame = new JFrame("查询结果");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        this.frame = frame;
    }

    public void createTable(ArrayList<String> strings){
        tableModel = (DefaultTableModel) table1.getModel();
        //因为只有DefaultTableModel有addColumn的功能，而table.getModel()返回的是一个TableModel类型的对象
        //查看API，DefaultTableModel实现了TableModel的接口，为了调用DefaultTableModel的方法，必须强制类型转换
        //初始化表格
        for (String string : strings) {
            tableModel.addColumn(string);
        }


//        return table;
    }

    public static void main(String[] args) {
        DisplayGUI displayGUI = new DisplayGUI();

    }

    public void insertRow(Object[] objects){
        tableModel.addRow(objects);
    }


}
