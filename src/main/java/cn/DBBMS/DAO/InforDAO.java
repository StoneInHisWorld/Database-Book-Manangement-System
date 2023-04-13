package cn.DBBMS.DAO;

import cn.DBBMS.entity.Infor;

import java.util.List;

public interface InforDAO {

    //查询所有用户数据
    List<Infor> findAll();
}
