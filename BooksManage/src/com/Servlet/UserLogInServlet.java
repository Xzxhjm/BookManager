package com.Servlet;

import com.Element.Result;
import com.Element.User;
import com.Function.ManageUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserLogInServlet")
public class UserLogInServlet extends HttpServlet
{
    ManageUser manageUser = new ManageUser();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        User user = manageUser.searchUserByUsername(username);
        Result result = new Result();
        result.setUsername(username);

        if(user == null)
        {
            System.out.println("登录用户不存在");
            result.setFlag(false);
            result.setMsg("登录用户不存在");
        }
        else
        {
            if(user.getPassword().equals(password))
            {
                System.out.println("登录成功");
                result.setFlag(true);
                result.setMsg("登录成功");
            }
            else
            {
                System.out.println("密码错误");
                result.setFlag(false);
                result.setMsg("密码错误");
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), result);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }
}
