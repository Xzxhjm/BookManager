package com.Servlet;

import com.Element.Book;
import com.Element.Result;
import com.Function.ManageBook;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SearchBookByISBNServlet")
public class SearchBookByISBNServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String ISBN = request.getParameter("ISBN");
        System.out.println(ISBN);

        Book book = new ManageBook().searchBookByISBN(ISBN);
        Result result = new Result();

        if(book == null)
        {
            result.setMsg("该书不存在");

            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(), result);
        }
        else
        {
            result.setFlag(true);
            result.setMsg("查询成功");

            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(), book);
        }
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }
}
