package cn.DBBMS.entity;

import java.util.Date;

public class Infor {

    private int book_id; /*图书ID*/
    private int user_id; /*用户ID*/
    private Date b_time; /*借阅时间*/

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

    public Date getB_time() {
        return b_time;
    }

    public void setB_time(Date b_time) {
        this.b_time = b_time;
    }

    @Override
    public String toString() {
        return "Infor{" +
                "book_id='" + book_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", b_time=" + b_time +
                '}';
    }
}
