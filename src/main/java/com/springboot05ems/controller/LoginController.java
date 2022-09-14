package com.springboot05ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author BoBooY
 * @date 2022/9/6 11:52
 */
@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        //任意用户名和123密码即可登录
        if(!StringUtils.isEmpty(username) && password.equals("123")) {
            //登录注册session
            session.setAttribute("loginUser",username);
            return "redirect:/main.html"; //跳转首页
        } else {
            //登录失败！存放错误信息
            model.addAttribute("msg","用户名或密码错误！");
            return "index";
        }
    }
}
