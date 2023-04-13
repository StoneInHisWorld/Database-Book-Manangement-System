package cn.DBBMS.DAO;

import cn.DBBMS.entity.Reservation;

import java.util.List;

public interface ReservationDAO {

    //查询所有用户数据
    List<Reservation> findAll();
}
