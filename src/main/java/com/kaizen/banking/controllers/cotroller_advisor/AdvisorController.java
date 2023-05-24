package com.kaizen.banking.controllers.cotroller_advisor;

import com.kaizen.banking.models.Users;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
@ControllerAdvice
public class AdvisorController {
    @ModelAttribute("registerUser")
    public Users getUserDefaults(){
        return new Users();
    }

}
