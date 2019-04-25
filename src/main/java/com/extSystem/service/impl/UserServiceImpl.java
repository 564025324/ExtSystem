package com.extSystem.service.impl;

import com.extSystem.dao.UserDao;
import com.extSystem.model.User;
import com.extSystem.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserServer {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
//        User u = userDao.selectByPrimaryId(1);
//        System.out.println(u);
//        List<User> list = new ArrayList<>();
//        list.add(u);
//        return list;
    }

//    public PageInfo<User> selectAll(int pageNum, int pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        List<User> listAll = selectAll();
//        PageInfo<User> pageInfo = new PageInfo<>(listAll);
//        return pageInfo;
//    }

//    @Override
//    public User selectByUsernamePass(String username, String password) {
//        return null;
//    }
//
//    @Override
//    public User selectByUsername(String username) {
//        return null;
//    }
}
