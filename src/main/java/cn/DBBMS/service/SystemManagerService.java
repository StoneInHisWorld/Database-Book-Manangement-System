package cn.DBBMS.service;

import cn.DBBMS.DAO.BookDAO;
import cn.DBBMS.DAO.ManagerDAO;
import cn.DBBMS.DAO.SystemManagerDAO;
import cn.DBBMS.DAO.UserDAO;
import cn.DBBMS.entity.Book;
import cn.DBBMS.entity.Manager;
import cn.DBBMS.entity.SystemManager;
import cn.DBBMS.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SystemManagerService{

    private InputStream inputStream;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private SystemManagerDAO systemManagerDAO;
    private UserDAO userDAO;
    private BookDAO bookDAO;
    private ManagerDAO managerDAO;

    public void initiate() throws IOException {
        //1、读取主配置文件信息
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2、通过SqlSessionFactoryBuilder创建SqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(inputStream);
        //3、通过SqlSessionFactory对象，创建SqlSession对象
        session = factory.openSession();
        //4、通过SqlSession对象，去代理UserDao
        systemManagerDAO = session.getMapper(SystemManagerDAO.class);
        userDAO = session.getMapper(UserDAO.class);
        bookDAO = session.getMapper(BookDAO.class);
        managerDAO = session.getMapper(ManagerDAO.class);
    }

    public void createBook(String book_name2,String author2,String category2,String publisher2,int prince2) {
        Book book = new Book();
    /*    book.setPublisher("武汉理工大学出版社");
        book.setPrice(34);
        book.setCategory("外文图书");
        book.setBook_name("《1234》");
        book.setAuthor("杀马特");*/
        book.setPublisher(publisher2);
        book.setPrice(prince2);
        book.setCategory(category2);
        book.setBook_name(book_name2);
        book.setAuthor(author2);

        systemManagerDAO.createBook(book);
    }

    public void createLibrarian(String name, String role, String password) {
        Manager librarian = new Manager();
        librarian.setPassword(password);
        librarian.setRole(role);
        librarian.setManager_name(name);
        systemManagerDAO.createLibrarian(librarian);
//        systemManagerDAO.howManyLibrarian();
    }

    public void createUser(String name, String role) {
        User user = new User();
        user.setRole(role);
        user.setUser_name(name);
        systemManagerDAO.createUser(user);
    }

    public void deleteBook(int book_id) throws Exception {
        Book book = systemManagerDAO.findBook(book_id);
        if (book== null){
            throw new Exception("没有该图书！");
        }
        systemManagerDAO.deleteBook(book_id);
    }

    public void deleteLibrarian(int manager_id) throws Exception {
        Manager manager = systemManagerDAO.findLibrarian(manager_id);
        if (manager == null){
            throw new Exception("没有该管理员！");
        }
        else if (manager.getRole().equals("系统管理员")){
            throw new Exception("不允许删除系统管理员！");
        }
        systemManagerDAO.deleteLibrarian(manager_id);
    }

    public void deleteUser(int user_id) throws Exception {

        User user = systemManagerDAO.findUser(user_id);
        if (user== null){
            throw new Exception("没有该借阅者！");
        }
        systemManagerDAO.deleteUser(user_id);
    }

    public Book findBook(int book_id) throws Exception {

        Book book = systemManagerDAO.findBook(book_id);
        if (book==null){
            System.out.println("未找到该书目");
            throw new Exception("未找到该书目");
        }
        else{
            System.out.println(book.toString());
        }
        return book;
    }

    public List<Book> findAllBook(){
        return bookDAO.findAll();
    }

    public User findUser(int user_id) throws Exception {
        User user = new User();
        user = systemManagerDAO.findUser(user_id);
        if (user == null){
            //如果没有找到
            throw new Exception("没有该用户！");
        }
        return user;
    }

    public List<User> findAllUsers(){
        return userDAO.findAll();
    }

    public Manager findLibrarian(int manager_id) throws Exception {
        Manager manager = systemManagerDAO.findLibrarian(manager_id);
        if (manager == null){
            throw new Exception("没有该图书管理员！");
        }
        if (manager.getRole().equals("系统管理员")){
            throw new Exception("该ID为系统管理员！");
        }
        /*user_id =1;
        systemManagerDAO.findUser(user_id);*/

        return manager;
    }

    public List<Manager> findAllLibrarian(){
        List<Manager> librarians = new ArrayList<Manager>();
        librarians = managerDAO.findAll();
        for(int i =0 ;i<librarians.size();i++){
            if (librarians.get(i).getRole().equals("系统管理员")){
                //将系统管理员从列表中清除
                librarians.remove(i);
            }
        }
        return librarians;
    }

    public void updateBook(Book newBook) throws Exception {
        Book oldBook = systemManagerDAO.findBook(newBook.getBook_id());
        if (oldBook == null){
            throw new Exception("没有该图书！");
        }

        String name = newBook.getBook_name();
        String author = newBook.getAuthor();
        String category = newBook.getCategory();
        String press = newBook.getPublisher();
        int price = newBook.getPrice();

        if ( !name.equals("")) {
            //如果不为空
            if (!name.equals(oldBook.getBook_name())) {
                //如果新旧图书名字不一致
                oldBook.setBook_name(name);
            }
        }
            /* if (oldUser.getCan_borrow()!=newUser.getCan_borrow()&&
                newUser.getRole() != null){
            oldUser.setCan_borrow(newUser.getCan_borrow());
        }else */
        if( !author.equals("") ){
            if (!author.equals(oldBook.getAuthor())) {
                oldBook.setAuthor(author);
            }
        }
        if( !category.equals("") ){
            if (!category.equals(oldBook.getCategory())) {
                oldBook.setCategory(category);
            }
        }
        if( !press.equals("") ){
            if (!press.equals(oldBook.getPublisher())) {
                oldBook.setPublisher(press);
            }
        }
        if( price!= 0 ){
            if ( price!=oldBook.getPrice()) {
                oldBook.setPrice(price);
            }
        }
        systemManagerDAO.updateBook(oldBook);
    }

    public void updateUser(User newUser) throws Exception {
        User oldUser = systemManagerDAO.findUser(newUser.getUser_id());
        String role = newUser.getRole();
        String name = newUser.getUser_name();
        if (oldUser == null){
            //如果没有找到
            throw new Exception("没有该借阅者！");
        }
/*        if (oldUser.getIs_illegal()!=newUser.getIs_illegal()||
                ){
            oldUser.setIs_illegal(newUser.getIs_illegal());
        }
        else */
        if (role.equals("老师") || role.equals("博士生") ||  role.equals("研究生") ||
                role.equals("本科生") || role.equals("专科生")||role.equals("")) {
            if ( !role.equals("")) {
                //如果不为空
                if (!role.equals(oldUser.getRole())) {
                    //如果新旧借阅者角色不一致
                    oldUser.setRole(role);
                }
            }
            if( !name.equals("") ){
                if (!name.equals(oldUser.getUser_name())) {
                    oldUser.setUser_name(newUser.getUser_name());
                }
            }
            systemManagerDAO.updateUser(oldUser);
        }
        else {
            throw new Exception("请输入正确的角色！\n" +
                    "角色包括：老师、博士生、研究生、本科生、专科生");
        }

    }

    public void updateLibrarian(Manager newLibrarian) throws Exception {

        Manager oldLibrarian = systemManagerDAO.findLibrarian(newLibrarian.getManager_id());
        String role = oldLibrarian.getRole();
        String name = newLibrarian.getManager_name();
        String password = newLibrarian.getPassword();
        if (role.equals("图书管理员")) {
            if (!name.equals("")){
                //如果名字有变更

                    oldLibrarian.setManager_name(newLibrarian.getManager_name());

            }
            if (!password.equals("")){
                //如果密码有变更

                    oldLibrarian.setPassword(newLibrarian.getPassword());

            }
            systemManagerDAO.updateLibrarian(oldLibrarian);
        }
        else{
            //如果是系统管理员，则不允许删除
            throw new Exception("不允许更改系统管理员！");
        }
    }

}
