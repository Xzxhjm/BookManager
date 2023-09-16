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

@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String pre_ISBN = request.getParameter("pre_ISBN");
        String post_ISBN = request.getParameter("post_ISBN");
        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        int stock = Integer.parseInt(request.getParameter("stock"));
        Result result = new Result();
        Book book = new ManageBook().searchBookByISBN(pre_ISBN);
        if(book == null)
        {
            result.setMsg("该书不存在");
        }
        else
        {
            if(post_ISBN != null)
                book.setISBN(post_ISBN);
            if(bookName != null)
                book.setBookName(bookName);
            if(author != null)
                book.setAuthor(author);
            if(publisher != null)
                book.setPublisher(publisher);
            if(price != null)
                book.setPrice(price);
            if(description != null)
                book.setDescription(description);
            book.setStock(stock);

            int res = new ManageBook().updateBook(pre_ISBN, book);
            if(res == 1)
            {
                result.setFlag(true);
                result.setMsg("更新成功");
            }
            else
            {
                result.setMsg("更新失败");
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
