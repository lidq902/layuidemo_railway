package com.example.layuidemo.dao;

import com.example.layuidemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserDao {
   User getUserByUsername(String username);
   //List<User> getAllUsers();
}
