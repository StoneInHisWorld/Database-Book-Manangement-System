package cn.DBBMS.DAO;

import cn.DBBMS.entity.*;

import java.util.List;

public interface UserDAO {

    //以下是系统功能
    //通过输入的图书ID，以及user自身的user_id，联合系统当前时间创建预定信息，注意检查当前图书是否被借阅，是否被预定
    void createReservation(Reservation reservation);
    //通过输入的图书ID，查找数据库内图书，显示查找到的图书的图书ID、书名、作者、分类、出版社
    Book findBook(int book_id);
    //通过user_id，在视图lend_infor内查找其借阅信息
    List<LendInfor> findInfor(int user_id);

    //基本功能
    List<User> findAll();
}
