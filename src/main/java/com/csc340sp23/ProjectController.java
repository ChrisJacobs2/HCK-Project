package com.csc340sp23;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;        


/**
 *
 * @author Christopher Jacobs
 */
@Controller
//@RequestMapping("/home")
public class ProjectController {
    
    @GetMapping("/")
    public String getHome() {
        return "project/home";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/403")
    public String _403() {
        return "403";
    }
    
    
    
}



