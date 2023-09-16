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

@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        Admin admin = new Admin(username, password, name, phone, email);
        Result result = new Result();
        ManageAdmin manageAdmin = new ManageAdmin();

        int res = manageAdmin.addAdmin(admin);
        if(res == -1)
        {
            result.setMsg("该管理员已存在");
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
