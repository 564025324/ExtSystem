package com.extSystem.dao;

import com.extSystem.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("Select * from user")
    List<User> selectAll();

    @Select("Select * from user where username = #{username} and password = #{password}")
    User selectByUsernamePass(@Param("username") String username, @Param("password") String password);

    @Select("Select * from user where username = #{username}")
    User selectByUsername(@Param("username") String username);

    @Select("Select * from user where id = #{id}")
    User selectByPrimaryId(@Param("id") Integer id);

}
