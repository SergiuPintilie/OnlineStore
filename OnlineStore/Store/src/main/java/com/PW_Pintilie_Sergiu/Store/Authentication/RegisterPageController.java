package com.PW_Pintilie_Sergiu.Store.Authentication;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.sql.SQLOutput;

@Controller
public class RegisterPageController {
    @GetMapping("/inregistrare")
    public String register(Model model){
        model.addAttribute("registerForm",new RegisterRequest());
        return "register-page";
    }
    @GetMapping("/login")
    public String login(Model model){

        model.addAttribute("loginForm",new AuthenticationRequest());
        return "login-page";
    }
    @GetMapping("/admin_panel")
    public String getAdminPage(){
        return "admin";
    }
}
