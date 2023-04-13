package cn.DBBMS.test;

import cn.DBBMS.DAO.*;
import cn.DBBMS.entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class InsertTest {

    private InputStream inputStream;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDAO userDAO;
    private BookDAO bookDAO;
    private ReservationDAO reservationDAO;
    private InforDAO inforDAO;
    private ManagerDAO managerDAO;
    private SystemManagerDAO systemManagerDAO;

    public InsertTest() throws IOException {
        init();
    }

    @Before
    public void init() throws IOException {
        //1、读取主配置文件信息
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2、通过SqlSessionFactoryBuilder创建SqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(inputStream);
        //3、通过SqlSessionFactory对象，创建SqlSession对象
        session = factory.openSession();
        //4、通过SqlSession对象，去代理UserDao
        userDAO = session.getMapper(UserDAO.class);
        bookDAO = session.getMapper(BookDAO.class);
        reservationDAO = session.getMapper(ReservationDAO.class);
        inforDAO = session.getMapper(InforDAO.class);
        managerDAO = session.getMapper(ManagerDAO.class);
        systemManagerDAO = session.getMapper(SystemManagerDAO.class);
    }


    @After
    public void destroy() throws IOException{
        //提交事务，释放资源
        session.commit();

        session.close();
        inputStream.close();
    }
}
