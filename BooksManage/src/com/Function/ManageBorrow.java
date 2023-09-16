package com.Function;

import com.Element.Book;
import com.Element.BorrowBook;
import com.Element.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManageBorrow
{
    String url = "jdbc:mysql://127.0.0.1:3306/xzx?useUnicode=true&characterEncoding=utf8&useSSL=true";
    String username="xzx";
    String password="xzx2331427663";
    public int borrowBook(String ISBN, String userName)
    {
        Book book = new ManageBook().searchBookByISBN(ISBN);
        User user = new ManageUser().searchUserByUsername(userName);
        if(book == null)
        {
            System.out.println("该书不存在");
            return -1;
        }
        if(user == null)
        {
            System.out.println("该用户不存在");
            return -1;
        }

        if(book.getStock() == 0)
        {
            System.out.println("该书库存为0");
            return -1;
        }

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM borrow";
            ResultSet resultSet = statement.executeQuery(sql);
            int borrowID = 0;
            while(resultSet.next())
                borrowID++;
            borrowID++;


            String date = LocalDate.now().toString();
            String ddl = LocalDate.now().plusWeeks(2).toString();
            BorrowBook borrowBook = new BorrowBook(borrowID, ISBN, book.getBookName(), userName, date, ddl);
            sql = "INSERT INTO borrow VALUES('"
                    +borrowBook.getBorrowID()+"','"
                    +borrowBook.getISBN()+"','"
                    +borrowBook.getBookName()+"','"
                    +borrowBook.getBorrowerName()+"','"
                    +borrowBook.getBorrowDate()+"','"
                    +borrowBook.getDdl()+"','"
                    +borrowBook.getReturnDate()+"','"
                    +borrowBook.getStatus()+"');";
            statement.executeUpdate(sql);

            Book post_book = new Book(book.getISBN(),
                    book.getBookName(),
                    book.getAuthor(),
                    book.getPublisher(),
                    book.getPrice(),
                    book.getDescription(),
                    book.getStock() - 1);
            new ManageBook().updateBook(ISBN,post_book);
            System.out.println("库存减1更新成功");

            resultSet.close();
            statement.close();
            connection.close();

            return 1;
        }catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    public BorrowBook searchBorrowByBorrowID(int borrowID)
    {
        BorrowBook borrowBook = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM borrow WHERE borrowID = '"+borrowID+"';";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next())
            {
                borrowBook = new BorrowBook(
                        resultSet.getInt("borrowID"),
                        resultSet.getString("ISBN"),
                        resultSet.getString("bookName"),
                        resultSet.getString("borrowerName"),
                        resultSet.getString("borrowDate"),
                        resultSet.getString("ddl"),
                        resultSet.getString("returnDate"),
                        resultSet.getInt("status"));
            }

            resultSet.close();
            statement.close();
            connection.close();

            return borrowBook;

        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<BorrowBook> searchAll()
    {
        ArrayList<BorrowBook> borrowBooks = new ArrayList<>();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM borrow;";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next())
            {
                BorrowBook borrowBook = new BorrowBook(
                        resultSet.getInt("borrowID"),
                        resultSet.getString("ISBN"),
                        resultSet.getString("bookName"),
                        resultSet.getString("borrowerName"),
                        resultSet.getString("borrowDate"),
                        resultSet.getString("ddl"),
                        resultSet.getString("returnDate"),
                        resultSet.getInt("status"));
                borrowBooks.add(borrowBook);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return borrowBooks;
    }
    public int returnBook(int borrowID)
    {
        BorrowBook borrowBook = searchBorrowByBorrowID(borrowID);
        if(borrowBook == null)
        {
            System.out.println("该借阅记录不存在");
            return -1;
        }
        if(borrowBook.getStatus() == 1)
        {
            System.out.println("该书已归还");
            return -1;
        }
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String date = LocalDate.now().toString();
            String sql = "UPDATE borrow SET returnDate = '"+date+"', status = '1' WHERE borrowID = '"+borrowID+"';";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();

            return 1;
        }catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    public ArrayList<BorrowBook> SearchBorrowByUser(String borrowerName)
    {
        ArrayList<BorrowBook> borrowBooks = new ArrayList<BorrowBook>();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM borrow WHERE borrowerName = '"+borrowerName+"';";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next())
            {
                BorrowBook borrowBook = new BorrowBook(
                        resultSet.getInt("borrowID"),
                        resultSet.getString("ISBN"),
                        resultSet.getString("bookName"),
                        resultSet.getString("borrowerName"),
                        resultSet.getString("borrowDate"),
                        resultSet.getString("ddl"),
                        resultSet.getString("returnDate"),
                        resultSet.getInt("status"));

                borrowBooks.add(borrowBook);
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return borrowBooks;
    }

    //
    public int RenewBook(int borrowID)
    {
        BorrowBook borrowBook = searchBorrowByBorrowID(borrowID);
        if(borrowBook == null)
        {
            System.out.println("借书信息不存在");
            return -1;
        }
        if(borrowBook.getStatus() == 1)
        {
            System.out.println("该书已还");
            return -1;
        }

        String new_ddl = LocalDate.now().plusWeeks(2).toString();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();

            String sql = "UPDATE borrow SET ddl = '" + new_ddl + "' WHERE borrowID ='" + borrowID + "';";
            statement.executeUpdate(sql);


            statement.close();
            connection.close();
            return 1;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
}
