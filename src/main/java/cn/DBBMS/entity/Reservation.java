package cn.DBBMS.entity;

import java.util.Date;

public class Reservation {

    private int book_id; /*图书ID*/
    private int user_id; /*用户ID*/
    private Date r_time; /*预约时间*/

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getR_time() {
        return r_time;
    }

    public void setR_time(Date r_time) {
        this.r_time = r_time;
    }

    @Override
    public String toString() {
        return "Infor{" +
                "book_id='" + book_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", r_time=" + r_time +
                '}';
    }
}
