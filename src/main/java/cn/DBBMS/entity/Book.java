package cn.DBBMS.entity;

public class Book {

    private int book_id;/*图书ID*/
    private String book_name;/*书名*/
    private String author;  /*作者*/
    private String category;  /*分类*/
    private String publisher; /*出版社*/
    private int price;	/*书价*/
    private int is_borrowed;	 /*是否在馆*/
    private int is_reserved;	/*是否被预约*/

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIs_borrowed() {
        return is_borrowed;
    }

    public void setIs_borrowed(int is_borrowed) {
        this.is_borrowed = is_borrowed;
    }

    public int getIs_reserved() {
        return is_reserved;
    }

    public void setIs_reserved(int is_reserved) {
        this.is_reserved = is_reserved;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id='" + book_id + '\'' +
                ", book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", is_borrowed=" + is_borrowed +
                ", is_reserved=" + is_reserved +
                '}';
    }
}
