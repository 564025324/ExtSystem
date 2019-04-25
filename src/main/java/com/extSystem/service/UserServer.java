package com.extSystem.service;

import com.extSystem.generator.model.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServer {

    List<User> selectAll();

//    PageInfo<User> selectAll(int pageNum, int pageSize);
//
//    User selectByUsernamePass(String username, String password);
//
//    User selectByUsername(String username);
}
