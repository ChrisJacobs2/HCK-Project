package com.csc340sp23;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;        


/**
 *
 * @author Christopher Jacobs
 */
@Controller
//@RequestMapping("/home")
public class PrototypeController {
    
    @GetMapping("/")
    public String getHome() {
        return "project/home";
    }
    
    
}



