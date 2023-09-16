package com.Servlet;

import com.Element.Book;
import com.Element.Result;
import com.Function.ManageBook;
import com.Function.ManageFeedback;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddFeedbackServlet")
public class AddFeedbackServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String username = request.getParameter("username");
        String content = request.getParameter("content");


        Result result = new Result();
        int res = new ManageFeedback().addFeedback(username,content);
        if(res == 1)
        {
            result.setFlag(true);
            result.setMsg("添加成功");
        }
        else
        {
            result.setMsg("添加失败");
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
