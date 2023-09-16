package com.Function;

import com.Element.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageBook
{
    String url = "jdbc:mysql://127.0.0.1:3306/xzx?useUnicode=true&characterEncoding=utf8&useSSL=true";
    String username="xzx";
    String password="xzx2331427663";
    public int addBook(Book book)//添加书籍
    {
        Book books = searchBookByISBN(book.getISBN());
        if(books != null)
        {
            System.out.println("该书对应的ISBN已存在");
            return -1;
        }

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO book VALUES('"
                    +book.getISBN()+"','"
                    +book.getBookName()+"','"
                    +book.getAuthor()+"','"
                    +book.getPublisher()+"','"
                    +book.getPrice()+"','"
                    +book.getDescription()+"','"
                    +book.getStock()+"');";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();

            return 1;

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    public Book searchBookByISBN(String ISBN)//通过ISBN查找书籍
    {
        Book book = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM book WHERE ISBN = '"+ISBN+"';";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next())
            {
                book = new Book(resultSet.getString("ISBN"),
                        resultSet.getString("bookName"),
                        resultSet.getString("author"),
                        resultSet.getString("publisher"),
                        resultSet.getString("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("stock"));
            }

            resultSet.close();
            statement.close();
            connection.close();

            return book;

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Book> searchBookByName(String bookName)
    {
        ArrayList<Book> books = new ArrayList<Book>();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("bookName: "+bookName);
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM book WHERE bookName = '"+bookName+"';";
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("resultSet: "+resultSet);
            while(resultSet.next())
            {
                Book book = new Book(resultSet.getString("ISBN"),
                        resultSet.getString("bookName"),
                        resultSet.getString("author"),
                        resultSet.getString("publisher"),
                        resultSet.getString("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("stock"));
                books.add(book);
            }

            resultSet.close();
            statement.close();
            connection.close();

            if(books.size() == 0)
                return null;
            else
                return books;

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Book> searchBookByAuthor(String author)
    {
        ArrayList<Book> books = new ArrayList<Book>();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM book WHERE author = '"+author+"';";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next())
            {
                Book book = new Book(resultSet.getString("ISBN"),
                        resultSet.getString("bookName"),
                        resultSet.getString("author"),
                        resultSet.getString("publisher"),
                        resultSet.getString("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("stock"));
                books.add(book);
            }

            resultSet.close();
            statement.close();
            connection.close();

            if(books.size() == 0)
                return null;
            else
                return books;

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Book> searchBookByPublisher(String publisher)
    {
        ArrayList<Book> books = new ArrayList<Book>();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM book WHERE publisher = '"+publisher+"';";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next())
            {
                Book book = new Book(resultSet.getString("ISBN"),
                        resultSet.getString("bookName"),
                        resultSet.getString("author"),
                        resultSet.getString("publisher"),
                        resultSet.getString("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("stock"));
                books.add(book);
            }

            resultSet.close();
            statement.close();
            connection.close();

            if(books.size() == 0)
                return null;
            else
                return books;

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Book> fuzzySearch(String s)// 模糊查找
    {
        ArrayList<Book> books = new ArrayList<Book>();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM book WHERE ISBN LIKE '%" + s +"%'"
                    +" OR bookName LIKE '%" + s +"%'"
                    +" OR author LIKE '%" + s +"%'"
                    +" OR publisher LIKE '%" + s +"%';";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next())
            {
                Book book = new Book(resultSet.getString("ISBN"),
                        resultSet.getString("bookName"),
                        resultSet.getString("author"),
                        resultSet.getString("publisher"),
                        resultSet.getString("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("stock"));
                books.add(book);
            }
            resultSet.close();
            statement.close();
            connection.close();

            if(books.size() == 0)
                return null;
            else
                return books;

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Book> searchAll()
    {
        ArrayList<Book> books = new ArrayList<Book>();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM book;";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next())
            {
                Book book = new Book(resultSet.getString("ISBN"),
                        resultSet.getString("bookName"),
                        resultSet.getString("author"),
                        resultSet.getString("publisher"),
                        resultSet.getString("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("stock"));
                books.add(book);
            }

            resultSet.close();
            statement.close();
            connection.close();


        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return books;
    }
    public int deleteBookByISBN(String ISBN)//删除书籍
    {
        Book book = searchBookByISBN(ISBN);
        if(book == null)
        {
            System.out.println("该书不存在");
            return -1;
        }

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM book WHERE ISBN = '"+ISBN+"';";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();

            return 1;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    public int updateBook(String ISBN, Book post)
    {
        Book book = searchBookByISBN(ISBN);
        if(book == null)
        {
            System.out.println("该书不存在");
            return -1;
        }
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "UPDATE book SET ISBN = '"+post.getISBN()+"',"
                    +"bookName = '"+post.getBookName()+"',"
                    +"author = '"+post.getAuthor()+"',"
                    +"publisher = '"+post.getPublisher()+"',"
                    +"price = '"+post.getPrice()+"',"
                    +"description = '"+post.getDescription()+"',"
                    +"stock = '"+post.getStock()+"'"
                    +" WHERE ISBN = '"+ISBN+"';";
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
}
