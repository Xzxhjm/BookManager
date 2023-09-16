package com.Servlet;

import com.Element.Admin;
import com.Element.Result;
import com.Function.ManageAdmin;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String pre_username = request.getParameter("pre_username");
        String post_username = request.getParameter("post_username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        Result result = new Result();
        result.setFlag(false);

        ManageAdmin manageAdmin = new ManageAdmin();
        Admin admin = manageAdmin.searchAdmin(pre_username);

        if(admin == null)
        {
            result.setMsg("该管理员不存在");
            result.setUsername(pre_username);
        }
        else
        {
            if(post_username != null)
                admin.setName(post_username);
            if(password != null)
                admin.setPassword(password);
            if(name != null)
                admin.setName(name);
            if(phone != null)
                admin.setPhone(phone);
            if(email != null)
                admin.setEmail(email);

            int res = manageAdmin.updateAdmin(pre_username, admin);
            if(res == 1)
            {
                result.setFlag(true);
                result.setMsg("更新成功");
                result.setUsername(post_username);
            }
            else
            {
                result.setMsg("更新失败");
                result.setUsername(pre_username);
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
