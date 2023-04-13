package cn.DBBMS.Controller;

import cn.DBBMS.GUI.DisplayGUI;
import cn.DBBMS.entity.Book;
import cn.DBBMS.entity.LendInfor;
import cn.DBBMS.service.UserService;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    private UserService userService;

    public UserController() throws IOException {
        userService = new UserService();
        userService.initiate();
    }

    public void reserveBook(int user_id, int book_id) throws Exception {
        userService.createReservation(user_id,book_id);
        JOptionPane.showMessageDialog(null, "预约图书成功！", "提示",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void findBook(int book_id, ArrayList<JTextField> textFieldArrayList,
                         ArrayList<JLabel> labelArrayList) throws Exception {
        Book book = userService.findBook(book_id);
        //隐去所有输入框，使用标签显示查找结果
        for (JTextField jTextField : textFieldArrayList) {
            jTextField.setVisible(false);
        }
        labelArrayList.get(0).setText("书本借阅者ID为："+book.getBook_id());
        labelArrayList.get(1).setText("图书名为："+book.getBook_name());
        labelArrayList.get(1).setVisible(true);
        labelArrayList.get(2).setText("图书作者为："+book.getAuthor());
        labelArrayList.get(2).setVisible(true);
        labelArrayList.get(3).setText("图书分类为："+book.getCategory());
        labelArrayList.get(3).setVisible(true);
        labelArrayList.get(4).setText("图书出版社为："+book.getPublisher());
        labelArrayList.get(4).setVisible(true);
        labelArrayList.get(5).setText("图书价格为："+book.getPrice());
        labelArrayList.get(5).setVisible(true);
        labelArrayList.get(6).setText("图书是否被借出："+book.getIs_borrowed()
                +" 图书是否被预定："+book.getIs_reserved()+"           下面的按钮不要点");
        labelArrayList.get(6).setVisible(true);
    }

    public void findInfor(int user_id) throws Exception {
        List<LendInfor> lendInforList = userService.findInfor(user_id);
        DisplayGUI displayGUI = new DisplayGUI();
        ArrayList<String> columnNames = new ArrayList<String>();
        System.out.println("正在查找所有借阅信息");

        columnNames.add("借阅ID");
        columnNames.add("书籍ID");
        columnNames.add("书名");
        columnNames.add("作者");
        columnNames.add("分类");
        columnNames.add("出版社");
        columnNames.add("借阅时间");
        displayGUI.createTable(columnNames);
        Object[] columns={columnNames.get(0),columnNames.get(1),
                columnNames.get(2),columnNames.get(3),columnNames.get(4),
                columnNames.get(5),columnNames.get(6)};
        displayGUI.insertRow(columns);

        for (LendInfor lendInfor : lendInforList) {
            Object[] objects = {user_id,lendInfor.getBook_id(),lendInfor.getBook_name(),
            lendInfor.getAuthor(),lendInfor.getCategory(),lendInfor.getPublisher(),
            lendInfor.getB_time()};
            displayGUI.insertRow(objects);
        }
    }
}
