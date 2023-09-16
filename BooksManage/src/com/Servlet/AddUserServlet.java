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
import java.io.IOException;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet
{
    ManageUser manageUser = new ManageUser();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        User user = new User(username, password, name, phone, email);
        Result result = new Result();

        int res = manageUser.addUser(user);
        if(res == -1)
        {
            result.setMsg("该用户已存在");
            result.setUsername(username);
        }
        else if(res == 0)
        {
            result.setMsg("添加失败");
            result.setUsername(username);
        }
        else
        {
            result.setFlag(true);
            result.setMsg("添加成功");
            result.setUsername(username);
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
