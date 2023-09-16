package com.Servlet;

import com.Element.Book;
import com.Element.BorrowBook;
import com.Element.Result;
import com.Function.ManageBook;
import com.Function.ManageBorrow;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        int borrowID = Integer.parseInt(request.getParameter("borrowID"));
        Result result = new Result();

        int res = new ManageBorrow().returnBook(borrowID);
        if(res == -1)
        {
            result.setMsg("数据出错");
        }
        else if(res == 0)
        {
            result.setMsg("还书失败");
        }
        else
        {
            result.setFlag(true);
            result.setMsg("还书成功");

            BorrowBook borrowBook = new ManageBorrow().searchBorrowByBorrowID(borrowID);
            Book book = new ManageBook().searchBookByISBN(borrowBook.getISBN());

            book.setStock(book.getStock() + 1);
            new ManageBook().updateBook(borrowBook.getISBN(),book);
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
