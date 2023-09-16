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

@WebServlet("/SearchUserServlet")
public class SearchUserServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String username = request.getParameter("username");
        System.out.println(username);

        User user = new ManageUser().searchUserByUsername(username);
        Result result = new Result();

        if(user == null)
        {
            result.setMsg("该用户不存在");
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
            mapper.writeValue(response.getOutputStream(), user);
        }

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }
}