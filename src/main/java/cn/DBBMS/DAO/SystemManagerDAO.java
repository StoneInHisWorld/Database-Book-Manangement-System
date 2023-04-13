package cn.DBBMS.DAO;

import cn.DBBMS.entity.Book;
import cn.DBBMS.entity.Manager;
import cn.DBBMS.entity.User;

public interface SystemManagerDAO {

    void createBook(Book book);
    //输入图书的书名、作者、分类、出版社、书价到一个新的book对象中，传入数据库，创建一个新的图书
    void createLibrarian(Manager librarian);
//    int createDBUser(Manager librarian);
//    int howManyLibrarian();
    //输入图书管理员的密码、姓名，向数据库传递role=‘图书管理员’，创建一个新的图书管理员
    //创建管理员的同时创建一个新的数据库用户
    void createUser(User user);
    //输入用户的姓名、用户角色，创建一个新的用户
    void deleteBook(int book_id);
    //通过输入的book_id，删除数据库内对应的书目
    void deleteLibrarian(int manager_id);
    //通过输入的manager_id，删除数据库内对应的书目
    void deleteUser(int user_id);
    //通过输入的book_id，删除数据库内对应的书目
    Book findBook(int book_id);
    //通过输入的book_id，查找显示数据库内对应书目的图书ID、书名、作者、出版社、书价，返回一个Book对象，再将这些数据挑出来即可
    User findUser(int user_id);
    //通过输入的user_id，查找数据库内的用户的信息，并全部显示
    Manager findLibrarian(int manager_id);
    //通过输入的manager_id，查找数据库内的图书管理员的信息，并全部显示
    void updateBook(Book book);
    //输入一个已存在于数据库的book_id，然后将修改的数据全部存入到Book对象中，更新对应id的书目的信息
    void updateBook_is_reserved(Book book);
    //输入一个已存在于数据库的book_id，然后将修改的数据全部存入到Book对象中，更新对应id的书目的信息
    void updateUser(User user);
    //输入一个已存在于数据库的user_id，然后将修改的数据全部存入到User对象中，更新对应id的用户的信息
    void updateLibrarian(Manager manager);
    //输入一个已存在于数据库的manager_id，然后将修改的数据全部存入到Manager对象中，更新对应id的用户的信息

}
