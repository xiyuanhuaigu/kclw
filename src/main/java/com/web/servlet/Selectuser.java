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
import java.io.IOException;
import java.util.List;

@WebServlet("/Selectuser")
public class Selectuser extends HttpServlet {
    private Userservice Userservice =  new UserServiceimpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Username = req.getParameter("username");

        //System.out.println(Username);
        //1.调用service查询
        String selectuser = Userservice.selectuser(Username);
        System.out.println("用户"+selectuser+"正在请求");
        //System.out.println(selectuser);
        //2.转为JSON
        String s = JSON.toJSONString(selectuser);
        //3.写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
