package com.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

@WebServlet("/Addtodo")
public class Addtodo extends HttpServlet {

    private Userservice userservice = new UserServiceimpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码
        req.setCharacterEncoding("utf-8");
        //接收todo
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        System.out.println(s);
        JSONObject jsonObject = JSON.parseObject(s);

        String Tablename = (String)jsonObject.get("tablename");
        String Todoname = (String)jsonObject.get("todoname");

        System.out.println("表"+Tablename+"正在添加数据");
        //调用方法提交
        userservice.addtodo(Tablename,Todoname);
        //响应标识
        resp.setContentType("text/text;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("succese");
    }
}
