package com.csc340sp23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
        


/**
 *
 * @author Christopher Jacobs
 */
@Controller
@RequestMapping("/home")
public class PrototypeController {
    
    @GetMapping("")
    public String getHome() {
        return "project/home";
    }
    
    
}



