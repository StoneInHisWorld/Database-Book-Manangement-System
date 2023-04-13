package cn.DBBMS.test;

import cn.DBBMS.entity.Manager;
import cn.DBBMS.service.LibrarianService;
import cn.DBBMS.service.ManagerService;
import cn.DBBMS.service.SystemManagerService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ManagerServiceTest {

    private ManagerService managerService;
    private SystemManagerService systemManagerService;
    private LibrarianService librarianService;

    @Before
    public void init() throws IOException {
        managerService = new ManagerService();
        managerService.initiate();
/*        systemManagerService = new SystemManagerService();
        systemManagerService.initiate();
        librarianService = new LibrarianService();
        librarianService.initiate();*/
    }

    @Test
    public void testLogin() throws Exception {
        Manager manager = managerService.login(1,"123456");
        if (manager == null){
            System.out.println("登录失败");
        }
        else{
            System.out.println(manager.toString());
        }
    }
}
