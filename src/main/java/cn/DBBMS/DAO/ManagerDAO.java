package cn.DBBMS.DAO;

import cn.DBBMS.entity.Manager;

import java.util.List;

public interface ManagerDAO {

    //管理员登录
    Manager login(Manager unVerifiedManager);

    //基本功能
    List<Manager> findAll();
}
