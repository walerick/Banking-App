package com.kaizen.banking.controllers;

import com.kaizen.banking.helpers.HTML;
import com.kaizen.banking.helpers.Token;
import com.kaizen.banking.mailMessenger.MailMessenger;
import com.kaizen.banking.models.Users;
import com.kaizen.banking.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;
@RequiredArgsConstructor
@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;
//    private UserService userService;

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("title", "register");
        model.addAttribute("registerUser", new Users());
        System.out.println("In register page");
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("registerUser") Users user,
                           BindingResult result,
                           @RequestParam("first_name") String first_name,
                           @RequestParam("last_name") String last_name,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password,
                           Model model) throws MessagingException {
        if (result.hasErrors()) {
            return "register"; // This is the Thymeleaf view name
        }

        // Add attributes to the model
        model.addAttribute("first_name",  first_name);
        model.addAttribute("last_name", last_name);
        model.addAttribute("email", email);
        model.addAttribute("password", password);

        //Get Token String
        String token = Token.generateToken();

        //Generate Random Code
        Random rand = new Random();
        int bound = 123;
        int code = bound * rand.nextInt(bound);

        //Get Email Html body
        String emailBody = HTML.htmlEmailTemplate(token,Integer.toString(code));

        //Hash Password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

//        REGISTER USER
        userRepository.registerUser(first_name,last_name,email, hashedPassword,token, Integer.toString(code));

//        Send Email Notification
        MailMessenger.htmlEmailMessenger("noreply@kaizen.com",email,"Verify account", emailBody);

        // Additional logic
//      RETURN TO REGISTER PAGE
        String successMessage = "Account registered successfully, check email and verify account.";
        model.addAttribute("success", successMessage);

        return "register"; // This is the Thymeleaf view name for success page
    }

//    @PostMapping("/register")
//    public ModelAndView register(@Valid @ModelAttribute("registerUser")User user,
//                                 BindingResult result,
//                                 @RequestParam("first_name") String first_name,
//                                 @RequestParam("last_name") String last_name,
//                                 @RequestParam("email") String email,
//                                 @RequestParam("password") String password
//                                 ){
//        ModelAndView registrationPage = new ModelAndView("register");
//        if (result.hasErrors()){
//            return registrationPage;
//        }
//        return registrationPage;
//    }


}


