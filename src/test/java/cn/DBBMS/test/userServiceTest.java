package cn.DBBMS.test;

import cn.DBBMS.entity.LendInfor;
import cn.DBBMS.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class userServiceTest {

    private UserService userService;

    @Before
    public void init() throws IOException {
        userService = new UserService();
        userService.initiate();
    }

    @Test
    public void testCreatReservation(){
        //userService.createReservation(1);
    }

    @Test
    public void testFindBook(){
       // System.out.println(userService.findBook(1).toString());
    }

    @Test
    public void testFindInfor(){
/*        List<LendInfor> lendInforList = userService.findInfor(1);
        //如果没有查询到任何结果
        if (lendInforList.isEmpty()){
            System.out.println("没有找到任何数据！");
            return;
        }
        for (LendInfor lendInfor : lendInforList) {
            System.out.println(lendInfor.toString());
        }*/
    }


}
