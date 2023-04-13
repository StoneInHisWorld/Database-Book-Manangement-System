package cn.DBBMS.service;

import cn.DBBMS.DAO.BookDAO;
import cn.DBBMS.DAO.ManagerDAO;
import cn.DBBMS.entity.Manager;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ManagerService{

    private InputStream inputStream;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private ManagerDAO managerDAO;

    public void initiate() throws IOException {
        //1、读取主配置文件信息
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2、通过SqlSessionFactoryBuilder创建SqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(inputStream);
        //3、通过SqlSessionFactory对象，创建SqlSession对象
        session = factory.openSession();
        //4、通过SqlSession对象，去代理UserDao
        managerDAO = session.getMapper(ManagerDAO.class);
    }

    public Manager login(int manager_id, String password) throws Exception{
        //建立一个新对象保存参数传过来的manager_id和password
        Manager unVerifiedManager = new Manager();
        unVerifiedManager.setManager_id(manager_id);
        unVerifiedManager.setPassword(password);
        //通过数据库查询对应的id和password是否匹配，并返回查询到的manager对象
        Manager manager = managerDAO.login(unVerifiedManager);
        //如果是空，则id和密码不匹配；否则根据manager的role来决定显示界面
        if (manager == null){
            throw new Exception("账户名或密码不匹配！");
        }
        else{
            return manager;
        }
    }

    public List<Manager> findAll() {
        return null;
    }

    public String getPassword(Integer managerID) {
        return null;
    }

    public void insertManager(Manager manager) {

    }

    public void deleteManager(Integer managerID) {

    }
}
