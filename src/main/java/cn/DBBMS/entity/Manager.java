package cn.DBBMS.entity;

public class Manager {


    private int manager_id;//管理员账号
    private String password;//密码
    private String manager_name;//管理员名字
    private String role;//管理员角色：图书管理员、系统管理员
    private ManagerRole managerRole;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {

        this.role = role;
        if (role=="图书管理员")
            this.managerRole=new Librarian();
        else
            this.managerRole=new SystemManager();
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manager_id='" + manager_id + '\'' +
                ", password='" + password + '\'' +
                ", manager_name='" + manager_name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
