package cn.DBBMS.test;

import cn.DBBMS.entity.Book;
import cn.DBBMS.entity.Infor;
import cn.DBBMS.entity.LendInfor;
import cn.DBBMS.entity.User;
import cn.DBBMS.service.LibrarianService;
import cn.DBBMS.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class LibrarianServiceTest {

    private LibrarianService librarianService;
    private UserService userService;

    @Before
    public void init() throws IOException {
        librarianService = new LibrarianService();
        librarianService.initiate();
        userService = new UserService();
        userService.initiate();
    }

    @Test
    public void testHandleFine(){
/*        //List<LendInfor> lendInforList = userService.findInfor(2840000);
        if (lendInforList.isEmpty()){
            System.out.println("没有借阅书籍！");
            return;
        }
        for (LendInfor lendInfor : lendInforList) {
            Infor infor = new Infor();
            infor.setB_time(lendInfor.getB_time());
            infor.setUser_id(2840000);
            infor.setBook_id(lendInfor.getBook_id());
            double price = librarianService.handleFine(infor);
            System.out.println(price);
        }*/
    }

    @Test
    public void lendBook(){
        int user_id=2840000;
        int book_id=6;
        String b_time;
        Book book=new Book();
        User user=new User();
        int count_borrowed;
        int user_id_who;
        user=librarianService.legal_and_can_borrowed(user_id);
        //先是合法
        if(user.getIs_illegal()==0){
            count_borrowed = librarianService.count_borrowed(user_id);
            System.out.println(count_borrowed);
            System.out.println(user.getCan_borrow());
            if(count_borrowed < user.getCan_borrow()){
                //查询书的状态
                book=librarianService.borrowed_and_reserved(book_id);
                //没被借的话
                if(book.getIs_borrowed()==0){
                    //书没被预约或者预约是自己
                    if(book.getIs_reserved()==1){
                        user_id_who=librarianService.who_reservation(book_id);
                        if(user_id==user_id_who){
                            Infor infor=new Infor();
                            infor.setBook_id(book_id);
                            infor.setUser_id(user_id);
                            Date date =new Date();
                            infor.setB_time(date);
                            librarianService.insert_info(infor);
                            System.out.println("借书成功");
                        }
                        else {
                            System.out.println("书被预约，且不是自己，不可借书");
                        }

                    }
                    else{
                        Infor infor=new Infor();
                        infor.setBook_id(book_id);
                        infor.setUser_id(user_id);
                        Date date =new Date();
                        infor.setB_time(date);
                        librarianService.insert_info(infor);
                        System.out.println("借书成功");
                    }
                }
                else {
                    System.out.println("书被借走，不可借书");
                }
            }
            else {
                System.out.println("借书过多，不可借书");
            }
        }
        else{
            System.out.println("欠款未还，不可借书");
        }

        //librarianService.borrowed_and_reserved(book_id);
      /* Infor infor=new Infor();
       infor.setBook_id(book_id);
       infor.setUser_id(user_id);
       Date date =new Date();
       infor.setB_time(date);
       librarianService.insert_info(infor);*/


    }
}
