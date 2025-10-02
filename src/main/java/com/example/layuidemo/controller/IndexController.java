package com.example.layuidemo.controller;

import com.example.layuidemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @GetMapping ("/main")
    public String index(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginUser") == null){
            return "redirect:/login";
        }
        User user = (User) session.getAttribute("loginUser");

        model.addAttribute("user",user);
        model.addAttribute("sessionId", session.getId());
        model.addAttribute("title", "首页");
        return "layout/main";
    }

    @GetMapping ("/")
    public String login(Model model) {
        model.addAttribute("title", "首页");
        return "login";
    }

    @GetMapping ("/login")
    public String login2(Model model) {
        model.addAttribute("title", "首页");
        return "login";
    }

    @GetMapping ("/logout")
    public String logout(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession(false);
        if (session != null){
            System.out.println("session is destoryed!.......logout");
            session.invalidate();
        }
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("title", "数据统计");
        return "pages/dashboard :: dashboard";
    }

}
