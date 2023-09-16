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

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String ISBN = request.getParameter("ISBN");
        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        int stock = Integer.parseInt(request.getParameter("stock"));

        Result result = new Result();
        Book book = new Book(ISBN, bookName, author, publisher, price, description, stock);
        ManageBook manageBook = new ManageBook();

        int res = manageBook.addBook(book);
        if(res == -1)
        {
            result.setMsg("该书籍对应的ISBN已存在");
        }
        else if(res == 0)
        {
            result.setMsg("添加失败");
        }
        else
        {
            result.setFlag(true);
            result.setMsg("添加成功");
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
