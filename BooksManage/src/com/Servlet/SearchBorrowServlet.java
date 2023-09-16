package com.Servlet;

import com.Element.BorrowBook;
import com.Element.Result;
import com.Function.ManageBorrow;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SearchBorrowServlet")
public class SearchBorrowServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        int borrowID = Integer.parseInt(request.getParameter("borrowID"));

        Result result = new Result();
        BorrowBook borrowBook = new ManageBorrow().searchBorrowByBorrowID(borrowID);

        if(borrowBook == null)
        {
            result.setMsg("数据出错");
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(), result);
        }
        else
        {
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(), borrowBook);
        }
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }
}
