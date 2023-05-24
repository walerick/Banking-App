package com.kaizen.banking.controllers;

import com.kaizen.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("title", "Cowrywise");
        model.addAttribute("message", "test the attribute");
        System.out.println("In Home Page");
        return "index";
    }



    @GetMapping("/error")
    public String getErrorPage(Model model){
        model.addAttribute("title", "error");
        System.out.println("In Error page");
        return "error";
    }

    @GetMapping("/verify")
    public String getVerifyPage(
            @RequestParam("token")String token,
            @RequestParam("code")String code,
            Model model){
        userRepository.verifyAccount(token, code);
        //Get token in database
        String dbToken = userRepository.checkToken(token);
        //Check if Token is valid.
        if(dbToken == null){
            model.addAttribute("error", "Token has expired");
            return "error";
        }
        model.addAttribute("success", "Account created successfully, Please proceed to Log In");
        System.out.println("In verify Account Controller");
        return "login";
    }
}
