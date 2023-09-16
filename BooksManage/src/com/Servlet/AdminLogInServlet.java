package com.Servlet;

import com.Element.Admin;
import com.Element.Result;
import com.Function.ManageAdmin;
import com.Function.ManageUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminLogInServlet")
public class AdminLogInServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);
        System.out.println(password);

        ManageAdmin manageAdmin = new ManageAdmin();
        Result result = new Result();
        Admin admin = manageAdmin.searchAdmin(username);

        if(admin == null)
        {
            result.setMsg("该管理员不存在");
            result.setUsername(username);
        }
        else
        {
            if(!admin.getPassword().equals(password))
            {
                result.setMsg("密码错误");
                result.setUsername(username);
            }
            else
            {
                result.setFlag(true);
                result.setMsg("登录成功");
                result.setUsername(username);
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
