package com.Function;

import com.Element.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageUser
{
    String url = "jdbc:mysql://127.0.0.1:3306/xzx?useUnicode=true&characterEncoding=utf8&useSSL=true";
    String username="xzx";
    String password="xzx2331427663";
    public int addUser(User user)
    {
        User users = searchUserByUsername(user.getUsername());
        if(users != null)
        {
            System.out.println("该用户名已存在");
            return -1;
        }

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO user VALUES('"
                    +user.getUsername()+"','"
                    +user.getPassword()+"','"
                    +user.getName()+"','"
                    +user.getPhone()+"','"
                    +user.getEmail()+"');";
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
    public User searchUserByUsername(String userName)
    {
        User user = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM user WHERE username = '"+userName+"';";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next())
            {
                user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setPhone(resultSet.getString("phone"));
                user.setEmail(resultSet.getString("email"));
            }
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("查询成功");
            return user;
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("数据库驱动不存在！");
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("查询失败");
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<User> searchAll()
    {
        ArrayList<User> users = new ArrayList<User>();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM user;";

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next())
            {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setPhone(resultSet.getString("phone"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }

            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("查询成功");
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return users;
    }
    public int deleteUser(String userName)
    {
        User users = searchUserByUsername(userName);
        if(users == null)
        {
            System.out.println("该用户不存在");
            return -1;
        }

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM user WHERE username = '"+userName+"';";
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
    public int updateUser(String userName, User user)
    {
        User users = searchUserByUsername(userName);
        if(users == null)
        {
            System.out.println("该用户不存在");
            return -1;
        }

        try
        {
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            System.out.println(user.getName());

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "UPDATE user SET username = '"+user.getUsername()
                    +"', password = '"+user.getPassword()
                    +"', name = '"+user.getName()
                    +"', phone = '"+user.getPhone()
                    +"', email = '"+user.getEmail()
                    +"' WHERE username = '"+userName+"';";
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
