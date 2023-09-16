User类：
username(用户名)                        String                       primary key
password(密码)                         String
name(真实姓名)                          String
phone(电话号码)                         String
email(电子邮件)                         String

Admin类
username(用户名)                       String                       primary key
password(密码)                         String
name(真实姓名)                          String
phone(电话号码)                         String
email(电子邮件)                         String

Book类
ISBN(书号)                            String                        primary key
bookName(书名)                        String
author(作者)                          String
publisher(出版社)                      String
price(价格)                           String
description(描述)                     String
stock(库存)                           int

BorrowBook类
borrowId(借书编号)                    int                           primary key
ISBN(书号)                            String
bookName(书名)                        String
borrowerName(借书人姓名)               String
borrowDate(借书日期)                  String
returnDate(还书日期)                  String                        为空表示未还
status(借书状态)                      int                           0表示未还，1表示已还

ManageBook类
public int addBook(Book book);                                      书籍对应的ISBN已存在，返回-1，添加成功，返回1，添加失败，返回0
public Book searchBookByISBN(String ISBN);                          ISBN对应的书籍不存在或者出错，返回null，存在，返回书籍信息
public ArrayList<Book> fuzzySearch(String s);                       模糊查询，找不到返回null，找到返回书籍信息
public int deleteBookByISBN(String ISBN);                           没有ISBN对应的书，返回-1，删除成功，返回1，删除失败，返回0
public int updateBook(String ISBN, Book post);                      没有ISBN对应的书，返回-1，更新成功，返回1，更新失败，返回0

ManageUser类
public int addUser(User user);                                      用户名已存在，返回-1，添加成功，返回1，添加失败，返回0
public User searchUserByUsername(String userName);                  用户名不存在或者出错，返回null，存在，返回用户信息
public int deleteUser(String userName);                             没有用户名对应的用户，返回-1，删除成功，返回1，删除失败，返回0
public int updateUser(String userName, User user);                  没有用户名对应的用户，返回-1，更新成功，返回1，更新失败，返回0

ManageBorrow类
public int borrowBook(String userName, String ISBN)                 用户名和书籍不存在，书借完，返回-1，借书成功，返回1，借书失败，返回0
public BorrowBook searchBorrowByBorrowID(int borrowID)              借书编号不存在或者出错，返回null，存在，返回借书信息
public int returnBook(int borrowID)                                 借书编号不存在、已还，返回-1，还书成功，返回1，还书失败，返回0

ManageAdmin类
public int addAdmin(Admin admin)                                    用户名已存在，返回-1，添加成功，返回1，添加失败，返回0
public int deleteAdmin(String userName)                             没有用户名对应的用户，返回-1，删除成功，返回1，删除失败，返回0
public int updateAdmin(String userName, Admin admin)                没有用户名对应的用户，返回-1，更新成功，返回1，更新失败，返回0
public Admin searchAdmin(String userName)                           用户名不存在或者出错，返回null，存在，返回用户信息

