package com.example.layuidemo.controller;

import com.example.layuidemo.entity.User;
import com.example.layuidemo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/login")
    public String doLogin(String username, String password, HttpServletRequest request, Model model){
        System.out.println("login begin username is " + username + " password is " + password);

        User user = userService.login(username,password);
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("loginUser",user);
            session.setMaxInactiveInterval(30 * 60);

            //model.addAttribute("user",user);
            return "redirect:/main";
        }else {
            return "error";
        }
    }

    @GetMapping("/list")
    public String userList(Model model) {
        // 模拟用户数据
        List<User> users = Arrays.asList(
                new User(1L, "admin","张三","e10adc3949ba59abbe56e057f20f883e","admin@example.com",  "管理员"),
                new User(2L, "user1", "李四","e10adc3949ba59abbe56e057f20f883e","user1@example.com",  "管理员")
        );

        model.addAttribute("users", users);
        model.addAttribute("title", "用户列表");

        System.out.println("userList method is called;");
        return "pages/list :: userList";
    }

    @GetMapping("/form")
    public String userForm(Model model) {
        model.addAttribute("title", "用户表单");
        return "pages/form :: userForm";
    }

}
