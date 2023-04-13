package cn.DBBMS.entity;

import java.io.Serializable;

public class User implements Serializable {

    //实体的属性名和数据库的字段保持一致
    private int user_id;
    private String user_name;
    private int can_borrow;
    private int is_illegal;
    private String role;

    @Override
    public String toString() {
        return "Student{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", can_borrow=" + can_borrow +
                ", is_illegal=" + is_illegal +
                ", role='" + role + '\'' +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getCan_borrow() {
        return can_borrow;
    }

    public void setCan_borrow(int can_borrow) {
        this.can_borrow = can_borrow;
    }

    public int getIs_illegal() {
        return is_illegal;
    }

    public void setIs_illegal(int is_illegal) {
        this.is_illegal = is_illegal;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
