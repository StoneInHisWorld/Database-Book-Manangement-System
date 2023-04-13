package cn.DBBMS.service;

import cn.DBBMS.DAO.LibrarianDAO;
import cn.DBBMS.DAO.ManagerDAO;
import cn.DBBMS.DAO.SystemManagerDAO;
import cn.DBBMS.entity.Book;
import cn.DBBMS.entity.Infor;
import cn.DBBMS.entity.Librarian;
import cn.DBBMS.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

public class LibrarianService {

    private InputStream inputStream;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private SystemManagerDAO systemManagerDAO;
    private LibrarianDAO librarianDAO;

    public void initiate() throws IOException {
        //1、读取主配置文件信息
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2、通过SqlSessionFactoryBuilder创建SqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(inputStream);
        //3、通过SqlSessionFactory对象，创建SqlSession对象
        session=factory.openSession();
        //session = factory.openSession();
        //4、通过SqlSession对象，去代理UserDao
      // managerDAO = session.getMapper(ManagerDAO.class);
       librarianDAO=session.getMapper(LibrarianDAO.class);
       systemManagerDAO = session.getMapper(SystemManagerDAO.class);
      //  librarianDAO=session.getMapper(librarianDAO.getClass());
    }

    //取消预约
    public void cancelReservation(int book_id) throws Exception {
        Book book = systemManagerDAO.findBook(book_id);
        if (book == null){
            throw new Exception("没有该书目");
        }
        else if(book.getIs_reserved()==0){
            throw new Exception("该书目没有被预约！");
        }
        librarianDAO.cancelReservation(book_id);
        librarianDAO.update_is_Reserved(book_id);
    }

    //处理罚款
    public Double handleFine(Infor infor) throws Exception {
        int price = librarianDAO.handleFine(infor);
        //获取到时间间隔
        Date b_time = infor.getB_time();
        Date cur_time = new Date();
        long gap_time = cur_time.getTime() - b_time.getTime();
        if (gap_time<0) {
            throw new Exception("出现了未来的借阅记录！");
        }

        //获取用户角色
        User user = systemManagerDAO.findUser(infor.getUser_id());
        if (user==null){
            throw new Exception("借阅该书的借阅者不存在！！");
        }
        double can_borrow_time = 8.64 * Math.pow(10,7);
        if (user.getRole().equals("老师")){
            can_borrow_time *= 90;
        }
        else if (user.getRole().equals("博士生")){
            can_borrow_time *= 60;
        }
        else{
            can_borrow_time *= 30;
        }

/*        Calendar b_calendar = Calendar.getInstance();
        Calendar cur_calendar = Calendar.getInstance();
        b_calendar.setTime(b_time);
        cur_calendar.setTime(cur_time);
        //计算逾期时间
        int gap_year = cur_calendar.get(Calendar.YEAR) - b_calendar.get(Calendar.YEAR);
        int gap_month = cur_calendar.get(Calendar.MONTH) - b_calendar.get(Calendar.MONTH);
        int gap_day = cur_calendar.get(Calendar.DAY_OF_MONTH) - b_calendar.get(Calendar.DAY_OF_MONTH);*/

        //计算罚金
        if(gap_time-can_borrow_time<0) {
            //如果没有超时
            return 0.00;
        }
        else if (gap_time - can_borrow_time < 6.05 * Math.pow(10,8)){
            //七天以内
            return price*0.1;
        }
        else if (gap_time - can_borrow_time < 2.59 * Math.pow(10,9)){
            //30天以内
            return price*0.5;
        }
        else {
            return price * 2.0;
        }
    }

    //以下为借书操作
    //借书的调用函数
    public void lendBook(int user_id, int book_id) throws Exception {

        String b_time;
        Book book=new Book();
        User user;
        int count_borrowed;
        int user_id_who;
        user=legal_and_can_borrowed(user_id);
        //先是合法
        if(user.getIs_illegal()==0){
            count_borrowed = count_borrowed(user_id);
            System.out.println(count_borrowed);
            System.out.println(user.getCan_borrow());
            if(count_borrowed < user.getCan_borrow()){
                //查询书的状态
                book=borrowed_and_reserved(book_id);
                //没被借的话
                if(book.getIs_borrowed()==0){
                    //书没被预约或者预约是自己
                    if(book.getIs_reserved()==1){
                        user_id_who=who_reservation(book_id);
                        if(user_id==user_id_who){
                            Infor infor=new Infor();
                            infor.setBook_id(book_id);
                            infor.setUser_id(user_id);
                            Date date =new Date();
                            infor.setB_time(date);
                            insert_info(infor);
                            System.out.println("借书成功");
                        }
                        else {
                            System.out.println("书被预约，且不是自己，不可借书");
                            throw new Exception("该书已经被其他人预约！");
                        }
                    }
                    else{
                        Infor infor=new Infor();
                        infor.setBook_id(book_id);
                        infor.setUser_id(user_id);
                        Date date =new Date();
                        infor.setB_time(date);
                        insert_info(infor);
                        librarianDAO.afterLend(book_id);
                        System.out.println("借书成功");
                    }
                }
                else {
                    System.out.println("书被借走，不可借书");
                    throw new Exception("该书已被其他人借阅！");

                }
            }
            else {
                System.out.println("借书过多，不可借书");
                throw new Exception("该借阅者借书已经超过最大可借阅数目！");

            }
        }
        else{
            System.out.println("欠款未还，不可借书");
            throw new Exception("该借阅者有逾期未归还的书籍！");

        }

        //borrowed_and_reserved(book_id);
      /* Infor infor=new Infor();
       infor.setBook_id(book_id);
       infor.setUser_id(user_id);
       Date date =new Date();
       infor.setB_time(date);
       librarianService.insert_info(infor);*/
    }

    public User legal_and_can_borrowed(int user_id){
        User user1=new User();
        user1 =librarianDAO.legal_and_can_borrowed(user_id);
        return user1;
    }

    public int count_borrowed(int user_id) {
        int count_borrowed;
        count_borrowed=librarianDAO.count_borrowed(user_id);
        return count_borrowed ;
    }

    public Book borrowed_and_reserved(int book_id) {
        Book book=new Book();
        book=librarianDAO.borrowed_and_reserved(book_id);
        return book;
    }

    public int who_reservation(int book_id){
        int a=777;
        librarianDAO.who_reservation(book_id);
        return a;
    }

    public void insert_info(Infor infor) {
        librarianDAO.insert_info(infor);
    }

    //以下为还书操作
    public void returnBook(int book_id) throws Exception {
        Book book = systemManagerDAO.findBook(book_id);
        if (book == null){
            throw new Exception("本馆不存在该书目！");
        }
        Infor infor = librarianDAO.findInforOfBook(book_id);
        if (infor == null){
            throw new Exception("没有该书的借阅信息！");
        }
        double fine = handleFine(infor);
        //如果该书逾期归还
        if (fine > 0) {
            throw new Exception("该书逾期归还，需要缴纳罚款"+fine+"元");
        }
        librarianDAO.returnBook(book_id);
        librarianDAO.afterReturn(book_id);
        librarianDAO.deleteInfor(book_id);
    }

    public void forceReturn(int book_id){
        librarianDAO.returnBook(book_id);
        librarianDAO.afterReturn(book_id);
        librarianDAO.deleteInfor(book_id);
    }

}
