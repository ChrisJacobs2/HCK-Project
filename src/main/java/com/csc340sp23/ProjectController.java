package com.csc340sp23;

import com.csc340sp23.Account.User;
import com.csc340sp23.Account.UserDto;
import com.csc340sp23.Account.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;        
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author Christopher Jacobs
 */
@Controller
public class ProjectController {
    
    private UserService userService;
    
    public ProjectController(UserService userService) {
        this.userService = userService;
    }
     
    @GetMapping("/")
    public String getHome() {
        return "project/home";
    }
    
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    
    @GetMapping("/register")
    public String getRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "signup-form";
    }
    
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/403")
    public String _403() {
        return "403";
    }
    
    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    
    
    
}



