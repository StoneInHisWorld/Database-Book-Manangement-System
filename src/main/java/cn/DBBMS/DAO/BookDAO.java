package cn.DBBMS.DAO;


import cn.DBBMS.entity.Book;

import java.util.List;

public interface BookDAO {

    //查询所有图书信息数据
    List<Book> findAll();
}
