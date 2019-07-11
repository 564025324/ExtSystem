package com.extSystem.service;

import com.extSystem.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServer {

    List<User> selectAll();

    User getUserById(Integer id);
}
