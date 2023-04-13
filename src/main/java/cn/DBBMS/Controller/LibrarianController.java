package cn.DBBMS.Controller;

import cn.DBBMS.entity.Librarian;
import cn.DBBMS.service.LibrarianService;

import javax.swing.*;
import java.io.IOException;

public class LibrarianController {

    private LibrarianService librarianService;

    public LibrarianController() throws IOException {
        librarianService = new LibrarianService();
        librarianService.initiate();
    }

    public void cancelReservation(int book_id) throws Exception {
        librarianService.cancelReservation(book_id);
    }

    public void lendBook(int user_id,int book_id) throws Exception {
        librarianService.lendBook(user_id,book_id);
    }

    public void returnBook(int book_id)  {
        try{
            librarianService.returnBook(book_id);
        }
        catch (Exception e){
            if (e.getMessage().startsWith("该书逾期归还")){
                JOptionPane.showMessageDialog(null,
                        e.getMessage(), "出现错误！",
                        JOptionPane.ERROR_MESSAGE);
                //缴纳罚款后强制还书
                librarianService.forceReturn(book_id);
                return;
            }
            JOptionPane.showMessageDialog(null,
                    e.getMessage(), "出现错误！",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null,
                "还书成功！", "提示",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
