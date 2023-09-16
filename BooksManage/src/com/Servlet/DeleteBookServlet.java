package com.Servlet;

import com.Element.Result;
import com.Function.ManageBook;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String ISBN = request.getParameter("ISBN");

        Result result = new Result();
        int res = new ManageBook().deleteBookByISBN(ISBN);

        if(res == -1)
        {
            result.setMsg("该书不存在");
        }
        else if(res == 0)
        {
            result.setMsg("删除失败");
        }
        else
        {
            result.setFlag(true);
            result.setMsg("删除成功");
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
