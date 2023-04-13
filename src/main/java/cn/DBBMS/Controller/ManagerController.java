package cn.DBBMS.Controller;

import cn.DBBMS.GUI.SystemManagerGUI.SystemManagerGUI;
import cn.DBBMS.GUI.LibrarianGUI.LibrarianGUI;
import cn.DBBMS.GUI.UserGUI.UserGUI;
import cn.DBBMS.entity.Manager;
import cn.DBBMS.entity.User;
import cn.DBBMS.service.ManagerService;
import cn.DBBMS.service.SystemManagerService;

import javax.swing.*;
import java.io.IOException;

public class ManagerController {

    private ManagerService managerService;
    private SystemManagerService systemManagerService;

    public ManagerController() throws IOException {
        managerService = new ManagerService();
        managerService.initiate();
        systemManagerService = new SystemManagerService();
        systemManagerService.initiate();
    }

    //从界面类中提取关键信息进行分析判断登录者角色
    public String login(JFrame frame, String title, String manager_id, String password){

        //如果是借阅者登录
        if(title.equals("借阅号：")){
            System.out.println("借阅者登录");
            User user = new User();
            try {
                //尝试查找有无该借阅者
                user = systemManagerService.findUser(toInteger(manager_id));
                //打开借阅者主界面
                UserGUI userGUI = new UserGUI(frame,user);
            } catch (Exception exception) {
                exception.printStackTrace();
                return exception.getMessage();
            }
            return "借阅者";
        }else{
            Manager manager;
            try {
                //检查是否有输入非法的manager_id，以及是否找到该管理员
                manager = managerService.login(toInteger(manager_id), password);
            } catch (Exception exception) {
                //出现错误则弹窗
                return exception.getMessage();
            }
            String role = manager.getRole();
            if (role.equals("图书管理员")) {
                try {
                    LibrarianGUI librarianGUI = new LibrarianGUI(frame,manager);
                } catch (IOException ioException) {
                    return ioException.getMessage();
                }
                return "图书管理员";
            } else if (role.equals("系统管理员")) {
                try {
                    SystemManagerGUI systemManagerGUI = new SystemManagerGUI(frame);

                } catch (IOException ioException) {
                    return ioException.getMessage();
                }
                return "系统管理员";
            } else {
                return "出现了奇怪的管理员！";
            }
        }
    }

    public int toInteger(String manager_id) throws Exception {
        int length = manager_id.length();
        int result = 0;
        for (int i=0;i<length;i++){
            result += Math.pow(10,length-i-1) * toInteger(manager_id.charAt(i));
        }
        return result;
    }

    public int toInteger(char c) throws Exception{
        //如果输入了无效字符
        if (c<48 || c>58){
            throw new Exception("输入了无效字符！");
        }
        else{
            return c-48;
        }
    }
}
