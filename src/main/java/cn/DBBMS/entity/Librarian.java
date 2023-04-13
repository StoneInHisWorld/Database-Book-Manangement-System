package cn.DBBMS.entity;

import cn.DBBMS.DAO.LibrarianDAO;

public class Librarian extends ManagerRole {

    public void cancelReservation(int book_id) {

    }

    public int handleFine(Infor infor) {
        return 1;
    }

    public void lendBook(int user_id, int book_id) {

    }

    public void returnBook(int book_id) {

    }
}
