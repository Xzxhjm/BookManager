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

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String pre_username = request.getParameter("pre_username");
        String post_username = request.getParameter("post_username");
        System.out.println(post_username);
        System.out.printf("\n\n\n");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        Result result = new Result();
        result.setFlag(false);

        ManageUser manageUser = new ManageUser();
        User user = manageUser.searchUserByUsername(pre_username);

        if(user == null)
        {
            result.setMsg("该用户不存在");
            result.setUsername(pre_username);
        }
        else
        {
            if(post_username != null)
                user.setUsername(post_username);
            if(password != null)
                user.setPassword(password);
            if(name != null)
                user.setName(name);
            if(phone != null)
                user.setPhone(phone);
            if(email != null)
                user.setEmail(email);

            System.out.println(user.getUsername());
            System.out.printf("\n\n");
            int res = manageUser.updateUser(pre_username, user);
            if(res == 1)
            {
                result.setFlag(true);
                result.setMsg("更新成功");
                result.setUsername(post_username);
            }
            else
            {
                result.setMsg("更新失败");
                result.setUsername(pre_username);
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
