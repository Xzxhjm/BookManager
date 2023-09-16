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

@WebServlet("/SearchAdminServlet")
public class SearchAdminServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String username = request.getParameter("username");
        System.out.println(username);

        Admin admin = new ManageAdmin().searchAdmin(username);
        Result result = new Result();

        if(admin == null)
        {
            result.setMsg("该管理员不存在");
            result.setUsername(username);

            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(), result);
        }
        else
        {
            result.setFlag(true);
            result.setMsg("查询成功");
            result.setUsername(username);

            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(), admin);
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }
}
