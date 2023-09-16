package com.Function;

import com.Element.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManageAdmin
{
    String url = "jdbc:mysql://127.0.0.1:3306/xzx?useUnicode=true&characterEncoding=utf8&useSSL=true";
    String username="xzx";
    String password="xzx2331427663";
    public int addAdmin(Admin admin)
    {
        Admin admins = searchAdmin(admin.getUsername());
        if(admins != null)
        {
            System.out.println("该管理员已存在");
            return -1;
        }

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO admin VALUES('"
                    +admin.getUsername()+"','"
                    +admin.getPassword()+"','"
                    +admin.getName()+"','"
                    +admin.getPhone()+"','"
                    +admin.getEmail()+"');";

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
    public int deleteAdmin(String userName)
    {
        Admin admins = searchAdmin(userName);
        if(admins == null)
        {
            System.out.println("该管理员不存在");
            return -1;
        }
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM admin WHERE username = '"+userName+"';";
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
    public int updateAdmin(String userName, Admin admin)
    {
        Admin admins = searchAdmin(userName);
        if(admins == null)
        {
            System.out.println("该管理员不存在");
            return -1;
        }

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "UPDATE admin SET username = '"+admin.getUsername()
                    +"',password = '"+admin.getPassword()
                    +"',name = '"+admin.getName()
                    +"',phone = '"+admin.getPhone()
                    +"',email = '"+admin.getEmail()
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
    public Admin searchAdmin(String userName)
    {
        Admin admin = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM admin WHERE username = '"+userName+"';";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next())
            {
                admin = new Admin();
                admin.setUsername(resultSet.getString("username"));
                admin.setPassword(resultSet.getString("password"));
                admin.setName(resultSet.getString("name"));
                admin.setPhone(resultSet.getString("phone"));
                admin.setEmail(resultSet.getString("email"));
            }
            resultSet.close();
            statement.close();
            connection.close();

            return admin;
        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
