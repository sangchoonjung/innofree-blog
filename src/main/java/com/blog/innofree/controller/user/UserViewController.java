package com.blog.innofree.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    @GetMapping("/login")
    public String login() {
//        return "/user/login";
        return "/oauthLogin";
    }

    @GetMapping("/signup")
    public String signup() {
        return "/user/signup";
    }
}
