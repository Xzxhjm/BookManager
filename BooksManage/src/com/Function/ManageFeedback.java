package com.Function;

import com.Element.Feedback;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageFeedback
{
    String url = "jdbc:mysql://127.0.0.1:3306/xzx?useUnicode=true&characterEncoding=utf8&useSSL=true";
    String username="xzx";
    String password="xzx2331427663";

    public int addFeedback(String username, String content)
    {
        try
        {
            ArrayList<Feedback> feedbacks = searchAllFeedback();
            int count = feedbacks.size();
            count++;

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO feedback VALUES ("+count+",'"+username+"','"+content+"');";
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

    public ArrayList<Feedback> searchAllFeedback()
    {
        ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM feedback;";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next())
            {
                Feedback feedback = new Feedback(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("content")
                );
                System.out.println("1:"+resultSet.getString("username"));
                feedbacks.add(feedback);
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return feedbacks;
    }
}
