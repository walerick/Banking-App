package com.kaizen.banking.controllers;

import com.kaizen.banking.models.Accounts;
import com.kaizen.banking.models.Users;
import com.kaizen.banking.repository.AccountRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {
    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("/dashboard")
    public String getDashboard (HttpSession session, Model model){

        //GET THE DETAILS OF THE LOGGED-IN USER
        Users user = (Users) session.getAttribute("user");

        //GET THE ACCOUNT OF THE LOGGED-IN USER
        List<Accounts> getUserAccount = accountRepository.getUserAccountById(user.getUser_id());

        //GET BALANCE
        BigDecimal totalAccountBalance = accountRepository.getTotalBalance(user.getUser_id());
        model.addAttribute("userAccounts", getUserAccount);
        model.addAttribute("totalBalance", totalAccountBalance);

        return "dashboard";
    }

}
