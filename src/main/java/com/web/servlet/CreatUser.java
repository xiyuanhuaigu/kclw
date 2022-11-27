package com.web.servlet;

import com.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/Creat")
public class CreatUser extends HttpServlet {
    private com.service.Userservice userservices =  new UserServiceimpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String selectuser = userservices.selectuser(username);
        if(Objects.equals(selectuser,username))
        {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write("error");
        }
        else {
            userservices.createuser(username);
            resp.getWriter().write("succese");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
