
CREATE DATABASE DBBMS
CHARACTER SET gbk
COLLATE gbk_chinese_ci;

/*图书信息表*/
CREATE TABLE IF NOT EXISTS Book (
book_id INT(10) AUTO_INCREMENT PRIMARY KEY, /*图书ID*/
book_name CHAR(30) NOT NULL, /*书名*/
author CHAR(30) NOT NULL, /*作者*/
category CHAR(10) NOT NULL, /*分类*/
publisher CHAR(10) NULL, /*出版社*/
price INT(10) NOT NULL, /*书价*/
is_borrowed TINYINT(1) NOT NULL DEFAULT 1, /*是否在馆*/
is_reserved TINYINT(1) NOT NULL DEFAULT 0 /*是否被预约*/
)
AUTO_INCREMENT=000000
ENGINE = MEMORY;

/*用户信息表*/
CREATE TABLE IF NOT EXISTS User(
user_id INT(10) AUTO_INCREMENT PRIMARY KEY, /*用户号*/
user_name CHAR(10) NOT NULL, /*姓名*/
can_borrow TINYINT(1) NULL, /*能够借阅的书目数量*/
is_illegal TINYINT(1) NULL, /*是否有违规行为*/
role CHAR(10) NOT NULL /*用户角色（权限）*/
)
AUTO_INCREMENT=2840000
ENGINE = MEMORY;
/*can_borrow以及is_illegal做成插入的时候，触发器根据用户角色自动生成*/

/*管理员信息表*/
CREATE TABLE IF NOT EXISTS Manager(
manager_id INT(10) AUTO_INCREMENT PRIMARY KEY, /*管理员号*/
password CHAR(10) NOT NULL, /*密码*/
manager_name CHAR(10) NOT NULL, /*姓名*/
role CHAR(10) NOT NULL /*用户角色（权限），有图书管理员和系统管理员*/
)
ENGINE = MEMORY;

/*借阅信息表*/
CREATE TABLE IF NOT EXISTS Infor (
book_id INT(10) NOT NULL PRIMARY KEY, /*图书ID*/
user_id INT(10) NOT NULL, /*用户ID*/
b_time DATE NOT NULL, /*借阅时间*/
FOREIGN KEY (book_id) REFERENCES BOOK(book_id), /*参照性约束*/
FOREIGN KEY (user_id) REFERENCES Student(user_id) 
)
ENGINE = MEMORY;

/*在User中插入数据，user_id、can_borrow、is_illegal是自动生成的*/
INSERT INTO User(user_name,role)
VALUES('王二锤','老师');
/*插入Book表格中的数据*/
INSERT INTO Book(book_name,author,category,publisher,price)
VALUES ('我很懒','王元','中文图书','湖北大学出版社',20);
/*插入Infor表格中的数据*/
INSERT INTO Infor(book_id,user_id,b_time)
VALUES ('00001','2840000','2020/12/27');
/*插入Manager表格中的数据*/
INSERT INTO Manager(PASSWORD,manager_name,role)
VALUES ('123456','张三','图书管理员');

/*查询借阅信息并显示给用户*/
CREATE VIEW lend_infor AS 
SELECT i.user_id,b.book_id,b.book_name,b.author,b.category,b.publisher,i.b_time
FROM Infor AS i 
JOIN USER AS u ON i.user_id=u.user_id 
JOIN Book AS b ON i.book_id=b.book_id;
CREATE VIEW v_stu as SELECT u.user_name,b.book_name, b.author,b.category,b.publisher,i.b_time FROM User as u,Book as b,Infor as i;

/*自动添加可借阅书籍的触发器*/
DELIMITER //
CREATE TRIGGER auto_fill_can_borrow BEFORE INSERT
ON USER FOR EACH ROW
BEGIN
DECLARE user_role CHAR(10);
SELECT NEW.role INTO user_role;
CALL can_borrow(@result,user_role);
SET NEW.can_borrow=@result,NEW.is_illegal=0;
END//
DELIMITER ;

/*查询借阅信息并显示给用户*/
SELECT *
FROM lend_infor;
SELECT * FROM v_stu WHERE user_name="张三";
