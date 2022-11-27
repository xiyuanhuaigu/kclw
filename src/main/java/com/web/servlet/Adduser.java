package com.web.servlet;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import com.service.Userservice;
import com.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Adduser")
public class Adduser extends HttpServlet {
private Userservice userservice = new UserServiceimpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收注册的用户数据
        String Username = req.getParameter("username");
        String Password = req.getParameter("password");
        Map m1 = new HashMap();
        m1.put("username",Username);
        m1.put("password",Password);
        System.out.println(m1);
        //转化为User对象
        User user = JSON.parseObject(JSON.toJSONString(m1), User.class);

        //调用方法提交
        userservice.adduser(user);
        //响应标识
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("succese");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
