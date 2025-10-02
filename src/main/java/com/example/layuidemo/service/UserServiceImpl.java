package com.example.layuidemo.service;


import com.example.layuidemo.dao.UserDao;
import com.example.layuidemo.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired
    UserDao userDao;

    public User login(String username, String password) {

        System.out.println("UserServiceImpl: username is " + username + " password is " + password);

        User user = userDao.getUserByUsername(username);

        String md5Hex = DigestUtils.md5Hex("Hello, World!");
        System.out.println("md5 is " + md5Hex);
        if (user == null){
            System.out.println("user is null");
        }

        System.out.println("user password is " + user.getPassword());
        System.out.println("login password is " + password + " after md5 is " + DigestUtils.md5Hex(password));

        if (user != null) {
            System.out.println("UserServiceImpl: password from db is " + user.getPassword());

            if (user.getPassword().equals(DigestUtils.md5Hex(password))) {
                return user;
            }
        }
        return null;

    }

//    public List<User> getALLUsers() {
//        return userDao.getAllUsers();
//    }

}
