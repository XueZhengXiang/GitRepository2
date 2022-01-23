package com.example.boot05admin1.controller;

import com.example.boot05admin1.been.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @GetMapping(value = {"/login", "/"})
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (!user.getUserName().isEmpty() &&"12345".equals(user.getUserName())) {
            //把登录成功的用户保存起来
            session.setAttribute("loginUser", user.getUserName());
            //解决表单重复提交
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号或者密码错误！！！");
            return "login";
        }

    }
    //解决表单重复提交
    @GetMapping("main.html")
    public String mainHtml(HttpSession session, Model model) {
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            model.addAttribute("msg", "用户不存在,重新登录！！！");
            return "login";
        }
    }
}
