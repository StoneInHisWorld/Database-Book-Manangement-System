package cn.DBBMS.Controller;

import cn.DBBMS.GUI.DisplayGUI;
import cn.DBBMS.entity.Book;
import cn.DBBMS.entity.Manager;
import cn.DBBMS.entity.User;
import cn.DBBMS.service.SystemManagerService;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SystemManagerController {

    private SystemManagerService systemManagerService;

    public SystemManagerController() throws IOException {
        systemManagerService = new SystemManagerService();
        systemManagerService.initiate();
    }

    public void delete(String function, List<String> stringList) throws Exception {
        int id = toInteger(stringList.get(0));
        if (id == 0){
            throw new Exception("请输入ID！");
        }
        if (function.equals("删除借阅者")){
            System.out.println("正在删除借阅者");
            systemManagerService.deleteUser(id);
        }
        else if (function.equals("删除图书")){
            System.out.println("正在删除图书");
            systemManagerService.deleteBook(id);
        }
        else{
            //如果是删除图书管理员
            System.out.println("正在删除图书管理员");
            systemManagerService.deleteLibrarian(id);
        }
    }

    public void findAll(String function){
        DisplayGUI displayGUI = new DisplayGUI();
        ArrayList<String> columnNames = new ArrayList<String>();
        if (function.equals("查找所有的借阅者")){
            System.out.println("正在查找所有借阅者");
            columnNames.add("借阅ID");
            columnNames.add("姓名");
            columnNames.add("借阅的图书上限");
            columnNames.add("是否有违规记录");
            columnNames.add("角色");
            displayGUI.createTable(columnNames);

            List<User> userList = systemManagerService.findAllUsers();
            Object[] columns={columnNames.get(0),columnNames.get(1),
                    columnNames.get(2),columnNames.get(3),columnNames.get(4)};
            displayGUI.insertRow(columns);
            for (User user : userList) {
                Object[] objects = {user.getUser_id(),user.getUser_name(),
                                    user.getCan_borrow(),user.getIs_illegal(),
                                    user.getRole()};
                displayGUI.insertRow(objects);
            }
        }
        else if (function.equals("查找所有的图书")){
            System.out.println("正在查找所有图书");
            columnNames.add("图书ID");
            columnNames.add("书名");
            columnNames.add("作者");
            columnNames.add("分类");
            columnNames.add("出版社");
            columnNames.add("价格");
            columnNames.add("是否被借阅");
            columnNames.add("是否被预约");
            displayGUI.createTable(columnNames);

            List<Book> bookList = systemManagerService.findAllBook();
            Object[] columns={columnNames.get(0),columnNames.get(1),
                    columnNames.get(2),columnNames.get(3),columnNames.get(4)
                    ,columnNames.get(5),columnNames.get(6),columnNames.get(7)};
            displayGUI.insertRow(columns);
            for (Book book : bookList) {
                Object[] objects = {book.getBook_id(),book.getBook_name(),
                book.getAuthor(),book.getCategory(),book.getPublisher(),
                book.getPrice(),book.getIs_borrowed(),book.getIs_reserved()};
                displayGUI.insertRow(objects);
            }
        }
        else{
            //如果是查找图书管理员
            System.out.println("正在查找所有图书管理员");
            columnNames.add("图书管理员ID");
            columnNames.add("书名");
            columnNames.add("角色");
            displayGUI.createTable(columnNames);

            List<Manager> librarians = systemManagerService.findAllLibrarian();
            Object[] columns={columnNames.get(0),columnNames.get(1),
                    columnNames.get(2)};
            displayGUI.insertRow(columns);
            for (Manager librarian : librarians) {
                Object[] objects = {librarian.getManager_id(),librarian.getManager_name()};
                displayGUI.insertRow(objects);
            }
        }
    }

    public void find(String function, ArrayList<JLabel> labelArrayList,
                     List<String> stringList) throws Exception {
        int id = toInteger(stringList.get(0));
        if (id == 0){
            throw new Exception("请输入ID！");
        }
        if (function.equals("查找借阅者")){
            System.out.println("正在查找借阅者");
            User user = systemManagerService.findUser(id);
            labelArrayList.get(0).setText("借阅者ID为："+user.getUser_id());
            labelArrayList.get(1).setText("借阅者姓名为："+user.getUser_name());
            labelArrayList.get(1).setVisible(true);
            labelArrayList.get(2).setText("借阅者借阅书目上限为："+user.getCan_borrow());
            labelArrayList.get(2).setVisible(true);
            labelArrayList.get(3).setText("借阅者是否有违纪记录："+user.getIs_illegal());
            labelArrayList.get(3).setVisible(true);
            labelArrayList.get(4).setText("借阅者角色为："+user.getRole()+"           下面的按钮不要点");
            labelArrayList.get(4).setVisible(true);
        }
        else if (function.equals("查找图书")){
            System.out.println("正在查找图书");
            Book book = systemManagerService.findBook(id);
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
        else{
            //如果是查找图书管理员
            System.out.println("正在查找图书管理员");
            Manager manager = systemManagerService.findLibrarian(id);
            labelArrayList.get(0).setText("图书管理员ID为："+manager.getManager_id());
            labelArrayList.get(1).setText("图书管理员名字为："+manager.getManager_name()
                    +"           下面的按钮不要点");
            labelArrayList.get(1).setVisible(true);
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
