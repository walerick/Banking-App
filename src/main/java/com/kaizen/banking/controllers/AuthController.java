package com.kaizen.banking.controllers;

import com.kaizen.banking.helpers.Token;
import com.kaizen.banking.models.Users;
import com.kaizen.banking.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@Controller
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/login")
    public String getLogin(Model model){
        System.out.println("In login page");
        //Set Token String
        String token = Token.generateToken();
        //Set token to view
        model.addAttribute("token", token);
        model.addAttribute("PageTitle", "Login");

        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("email")String email,
            @RequestParam("password") String password,
            @RequestParam("_token") String token,
            Model model,
            HttpSession session

    ){
        //Validate input fields
        if (email.isEmpty() || email == null || password.isEmpty() || password == null){
            model.addAttribute("error", "username or password cannot be empty.");
            return "login";
        }

        //Check if email Exist
        String getEmailInDatabase = userRepository.getUserEmail(email);
        if (getEmailInDatabase != null){
            //Get Password in Database
            String getPasswordInBase = userRepository.getUserPassword(getEmailInDatabase);
            //Validate Password
            if (!BCrypt.checkpw(password,getPasswordInBase)){
                model.addAttribute("error", "Incorrect Username or Password");
                return "login";
            }
            // End of Validate Password
        }else {
            model.addAttribute("error", "Something went Wrong");
            return "error";
        }
        //CHECK IF USER IS VERIFIED
        int verified = userRepository.isVerified(getEmailInDatabase);
        if (verified != 1){
            model.addAttribute("error", "This account is not yet verified. Please check email and verify account.");
            return "login";
        }
        //END OF CHECK IF USER IS VERIFIED

        //LOG USER IN:
        Users user = userRepository.getUserDetails(getEmailInDatabase);

        //Set Session Attributes
        session.setAttribute("user", user);
        session.setAttribute("token", token);
        session.setAttribute("authenticated",true);
        return "redirect:/app/dashboard";
    }
//    END OF AUTHENTICATING METHOD

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes){
        session.invalidate();
        redirectAttributes.addFlashAttribute("loggedOut", "logged out successfully.");
        return "redirect:/login";
    }
}
