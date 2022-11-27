package com.service.impl;

import com.mapper.BrandMapper;
import com.pojo.Todo;
import com.pojo.User;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.service.Userservice;

import java.util.List;
import java.util.Map;

public class UserServiceimpl implements Userservice {
SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

@Override
public  String selectuser(String user){
    //获取SqlSession对象
    SqlSession sqlsession = factory.openSession();
    //获取BrandMapper对象
    BrandMapper mapper = sqlsession.getMapper(BrandMapper.class);
    // 调用方法
    String selectuser = mapper.selectuser(user);
    // 释放资源
    sqlsession.close();

    return selectuser;

}

    @Override
    public void adduser(User user) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.adduser(user);
        //提交事务
        sqlSession.commit();

        sqlSession.close();

    }

    @Override
    public String selectusps(Map usps) {
        //获取SqlSession对象
        SqlSession sqlsession = factory.openSession();
        //获取BrandMapper对象
        BrandMapper mapper = sqlsession.getMapper(BrandMapper.class);
        // 调用方法
        String username = (String) usps.get("username");
        //
        String password = mapper.selectusps(username);
        // 释放资源
        sqlsession.close();

        return password;
    }

    public void createuser(String username){
        //获取SqlSession对象
        SqlSession sqlsession = factory.openSession();
        //获取BrandMapper对象
        BrandMapper mapper = sqlsession.getMapper(BrandMapper.class);
        // 调用方法
        mapper.createuser(username);

        sqlsession.close();
    }

    public String selecttable(String tablename){
        //获取SqlSession对象
        SqlSession sqlsession = factory.openSession();
        //获取BrandMapper对象
        BrandMapper mapper = sqlsession.getMapper(BrandMapper.class);
        // 调用方法
        String selecttable = mapper.selecttable(tablename);

        sqlsession.close();

        return selecttable;

    }

    @Override
    public List<Todo> selectall(String tablename) {
        //获取SqlSession对象
        SqlSession sqlsession = factory.openSession();
        //获取BrandMapper对象
        BrandMapper mapper = sqlsession.getMapper(BrandMapper.class);
        // 调用方法
        List<Todo> selectall = mapper.selectall(tablename);

        sqlsession.close();

        return  selectall;
    }

    @Override
    public void addtodo(String tablename,String todoname) {
        //获取SqlSession对象
        SqlSession sqlsession = factory.openSession();
        //获取BrandMapper对象
        BrandMapper mapper = sqlsession.getMapper(BrandMapper.class);
        // 调用方法
        mapper.addtodo(tablename,todoname);

        sqlsession.commit();

        sqlsession.close();
    }

    @Override
    public void deletebyid(String tablename,String id) {
        //获取SqlSession对象
        SqlSession sqlsession = factory.openSession();
        //获取BrandMapper对象
        BrandMapper mapper = sqlsession.getMapper(BrandMapper.class);
        // 调用方法
        mapper.deletebyid(tablename,id);

        sqlsession.commit();
        sqlsession.close();
    }
}
