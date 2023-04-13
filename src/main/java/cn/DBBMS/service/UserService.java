package cn.DBBMS.service;

import cn.DBBMS.DAO.*;

import cn.DBBMS.DAO.SystemManagerDAO;
import cn.DBBMS.entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

public class UserService{

    private InputStream inputStream;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDAO userDAO;
    private SystemManagerDAO systemManagerDAO;

    public void initiate() throws IOException {
        //1、读取主配置文件信息
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2、通过SqlSessionFactoryBuilder创建SqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(inputStream);
        //3、通过SqlSessionFactory对象，创建SqlSession对象
        session = factory.openSession();
        //4、通过SqlSession对象，去代理UserDao
        userDAO =session.getMapper(UserDAO.class);
        systemManagerDAO = session.getMapper(SystemManagerDAO.class);
    }

    public void createReservation(int user_id,int book_id) throws Exception {

        //先检查该书目有没有被预定
        Book book = systemManagerDAO.findBook(book_id);
        if (book==null){
            throw new Exception("没有该书目！");
        }
        //如果书目被预定
        if (book.getIs_reserved()==1){
            throw new Exception("该书已经被预定！");
        }
        else {
            //添加预定信息
            Date date = new Date();
            //更改时间格式

            Reservation reservation = new Reservation();
            reservation.setBook_id(book_id);
            reservation.setR_time(date);
            reservation.setUser_id(user_id);
            userDAO.createReservation(reservation);
            book.setIs_reserved(1);
            systemManagerDAO.updateBook_is_reserved(book);//更新图书信息。
            System.out.println("该书目已被预订");
        }
    }

    public Book findBook(int book_id) throws Exception {
        Book book = new Book();
        book = userDAO.findBook(book_id);
        if (book == null){
            throw new Exception("该书目不存在！");
        }
        return book;
    }

    //寻找自己的借阅信息
    public List<LendInfor> findInfor(int user_id) throws Exception {
        List<LendInfor> lendInforList;
        lendInforList = userDAO.findInfor(user_id);
        if (lendInforList.size()==0){
            //如果没有找到
            throw new Exception("该用户没有借阅信息！");
        }
        return lendInforList;
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }
}
