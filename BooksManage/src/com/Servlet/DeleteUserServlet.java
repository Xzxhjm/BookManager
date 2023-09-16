package com.Servlet;

import com.Element.Result;
import com.Function.ManageUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String username = request.getParameter("username");
        System.out.println(username);

        ManageUser manageUser = new ManageUser();
        Result result = new Result();
        int res = manageUser.deleteUser(username);
        if(res == -1)
        {
            result.setMsg("该用户不存在");
            result.setUsername(username);
        }
        else if(res == 0)
        {
            result.setMsg("删除失败");
            result.setUsername(username);
        }
        else
        {
            result.setFlag(true);
            result.setMsg("删除成功");
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
