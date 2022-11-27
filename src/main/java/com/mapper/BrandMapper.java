package com.mapper;

import com.pojo.Todo;
import org.apache.ibatis.annotations.Param;
import com.pojo.User;
import java.util.List;

public interface BrandMapper {
    //查询用户是否存在

    String selectuser(@Param("user") String user);

    //注册用户
    void adduser(@Param("user") User user);

    //登录
    String selectusps (@Param("user") String user);

    //创建用户表
    void createuser(@Param("tablename") String tablename);

    //查询表名
    String selecttable(@Param("tablename") String tablename);

    //查询所有todo
    List<Todo> selectall (@Param("tablename") String tablename);

    void addtodo(@Param("tablename") String tablename,@Param("todoname") String todoname);

    void deletebyid(@Param("tablename") String tablename,@Param("id") String id);
}
