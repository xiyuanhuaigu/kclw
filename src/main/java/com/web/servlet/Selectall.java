package com.web.servlet;

import com.alibaba.fastjson.JSON;
import com.pojo.Todo;
import com.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/Selectall")
public class Selectall extends HttpServlet {
    private com.service.Userservice userservices =  new UserServiceimpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tablename = req.getParameter("tablename");
        System.out.println("表"+tablename+"正在请求");
        List<Todo> selectall = userservices.selectall(tablename);
        //转成json
        String s = JSON.toJSONString(selectall);

        resp.setContentType("text/text;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(s);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
