package com.service;

import com.pojo.User;
import com.pojo.Todo;

import java.util.List;
import java.util.Map;

public interface Userservice {
    String selectuser(String user);

    void adduser(User user);

    String selectusps(Map usps);

    void createuser(String username);

    String selecttable(String tablename);

    List<Todo> selectall(String tablename);

    void addtodo(String tablename,String todoname);

    void deletebyid(String tablename,String id);
}
