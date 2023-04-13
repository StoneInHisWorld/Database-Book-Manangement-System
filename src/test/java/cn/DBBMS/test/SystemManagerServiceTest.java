package cn.DBBMS.test;

import cn.DBBMS.entity.*;
import cn.DBBMS.service.LibrarianService;
import cn.DBBMS.service.ManagerService;
import cn.DBBMS.service.SystemManagerService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class SystemManagerServiceTest {

    private ManagerService managerService;
    private SystemManagerService systemManagerService;
    private LibrarianService librarianService;

    @Before
    public void init() throws IOException {
        managerService = new ManagerService();
        managerService.initiate();
        systemManagerService = new SystemManagerService();
        systemManagerService.initiate();
        librarianService = new LibrarianService();
        librarianService.initiate();
    }

    @Test
    //正在改，但是ui出了问题
    public void testCreateBook(){
        String book_name2;
        String author2;
        String category2;
        String publisher2;
        int prince2;

        book_name2="0";
        author2="0";
        category2="0";
        publisher2="0";
        prince2=0;
        if(  book_name2=="0"||author2=="0"||category2=="0"||publisher2=="0"||prince2==0){
            System.out.println("图书信息不完整");
        }
        else {
            systemManagerService.createBook(book_name2, author2, category2, publisher2, prince2);
        }
    }

    @Test
    public void testCreateLibrarian(){

        //systemManagerService.createLibrarian();
    }

    @Test
    public void testCreateUser(){
        //systemManagerService.createUser();
    }

    @Test
    public void testDeleteBook(){
        //systemManagerService.deleteBook();
    }

    @Test
    public void testDeleteLibrarian(){
        //systemManagerService.deleteLibrarian();
    }

    @Test
    public void testDeleteUser(){
        //systemManagerService.deleteUser();
    }

    @Test
    public void testFindBook(){
        //systemManagerService.findBook();
    }

    @Test
    public  void testfindUser(){

        //User user= systemManagerService.findUser(2840000);
        //if (user==null)
            return ;
        //System.out.println(user.toString());

    }

    @Test
    public  void testfindLibrarian(){
        //Manager manager = systemManagerService.findLibrarian(1);
        //System.out.println(manager.toString());
    }

    @Test
    //管理员更新图书信息测试通过，六个参数
    public  void testupdatebook(){
        String book_name2="book1";
        String author2="author1";
        String category2="中文";
        String publisher2="出版社1";
        int book_id=1;
        int prince2=0;
        Book book=new Book();
        book.setPublisher(publisher2);
        book.setPrice(prince2);
        book.setCategory(category2);
        book.setBook_name(book_name2);
        book.setAuthor(author2);
        book.setBook_id(book_id);
        //systemManagerService.updateBook(book);
    }

    @Test
    public void updateUser(){
        String role="大傻子";
        String user_name="小菊花";
        int user_id=2840006;
        User user=new User();
        user.setRole(role);
        user.setUser_name(user_name);
        user.setUser_id(user_id);
       // systemManagerService.updateUser(user);
    }

    @Test
    public void updateLibrarian(){
        String role="总统";
        String manager_name="橘子";
        String password="1111";
        int manager_id=1;
        Manager manager=new Manager();
        manager.setRole(role);
        manager.setManager_name(manager_name);
        manager.setPassword(password);
        manager.setManager_id(manager_id);
        //systemManagerService.updateLibrarian(manager);
    }


}
