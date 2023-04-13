package cn.DBBMS.test;

import cn.DBBMS.DAO.*;
import cn.DBBMS.entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class findAllTest {

    public static void main(String[] args) throws IOException{

        //测试程序
        //1、读取主配置文件信息
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2、通过SqlSessionFactoryBuilder创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //3、通过SqlSessionFactory对象，创建SqlSession对象
        SqlSession session = factory.openSession();
        //4、通过SqlSession对象，去代理UserDao
        UserDAO userDAO = session.getMapper(UserDAO.class);
        BookDAO bookDAO = session.getMapper(BookDAO.class);
        ReservationDAO reservationDAO = session.getMapper(ReservationDAO.class);
        InforDAO inforDAO = session.getMapper(InforDAO.class);
        ManagerDAO managerDAO = session.getMapper(ManagerDAO.class);
        //5、再通过User调用findAll方法
        List<User> userList = userDAO.findAll();
        List<Book> bookList = bookDAO.findAll();
        List<Infor> inforList = inforDAO.findAll();
        List<Reservation> reservationList = reservationDAO.findAll();
        List<Manager> managerList = managerDAO.findAll();
        for(User user:userList){
            System.out.println(user);
        }
        for (Book book : bookList) {
            System.out.println(book);
        }
        for (Infor infor : inforList) {
            System.out.println(infor);
        }
        for (Reservation reservation : reservationList) {
            System.out.println(reservation);
        }
        for (Manager manager : managerList) {
            System.out.println(manager);
        }
        //6、释放资源
        session.close();
        inputStream.close();
    }
}
