package cn.DBBMS.DAO;

import cn.DBBMS.entity.Book;
import cn.DBBMS.entity.Infor;
import cn.DBBMS.entity.User;

public interface LibrarianDAO {

    //通过输入的user_id以及book_id，删除数据库中对应用户对应书籍的预定信息
    void cancelReservation(int book_id);
    void update_is_Reserved(int book_id);
    //通过输入的借阅信息infor，查询到借阅的书籍的书价，再根据借阅信息中的b_time与系统时间做差计算出罚款金额
    int handleFine(Infor infor);

    //通过输入的user_id以及book_id联合系统当前时间建立相应的借阅信息，注意检查该书目是否有被借出
    //void lendBook(int user_id, int book_id);

    //通过输入的book_id删除数据库Infor表中对应的借阅信息
    void returnBook(int book_id);
    void afterReturn(int book_id);
    Infor findInforOfBook(int book_id);
    void deleteInfor(int book_id);

    //以下全部为借书，通过输入的book_id与user_id解决
    User legal_and_can_borrowed(int user_id);//返回一个人
    int count_borrowed(int user_id);//返回借阅数
    Book borrowed_and_reserved(int book_id);//返回一本书
    void insert_info(Infor infor);
    int who_reservation(int book_id);
    void afterLend(int book_id);//更改是否借阅标识

}
