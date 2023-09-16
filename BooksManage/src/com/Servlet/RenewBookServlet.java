package com.Servlet;

import com.Element.Result;
import com.Function.ManageBorrow;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RenewBookServlet")
public class RenewBookServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        int borrowID = Integer.parseInt(request.getParameter("borrowID"));
        Result result = new Result();

        int res = new ManageBorrow().RenewBook(borrowID);
        if(res == -1)
        {
            result.setMsg("借书信息不存在或者已经归还");
        }
        else if(res == 0)
        {
            result.setMsg("续借失败");
        }
        else
        {
            result.setFlag(true);
            result.setMsg("续借成功");
        }

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), result);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request,response);
    }
}
