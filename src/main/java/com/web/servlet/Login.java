package com.web.servlet;

import com.service.Userservice;
import com.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet("/Login")
public class Login extends HttpServlet {

    private com.service.Userservice userservices =  new UserServiceimpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Username = req.getParameter("username");
        String Password = req.getParameter("password");
        Map m1 = new HashMap();
        m1.put("username",Username);
        m1.put("password",Password);
        String selectusps = userservices.selectusps(m1);
        System.out.println("用户"+Username+"密码"+Password+"正在登录");
        if(Objects.equals(selectusps, Password))
        {
            String selectuser = userservices.selecttable(Username);
            if(Objects.equals(selectuser,Username))
            {
                System.out.println("数据库已经存在");
            }
            else {
                userservices.createuser(Username);
                System.out.println(Username+"数据库正在创建");
            }
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write("success");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
