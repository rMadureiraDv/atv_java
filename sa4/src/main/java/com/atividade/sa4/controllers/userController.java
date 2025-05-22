package com.atividade.sa4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.atividade.sa4.model.userModel;
import com.atividade.sa4.repository.userRepository;

import jakarta.validation.Valid;

@Controller
public class userController {
    userRepository userRepo;

    @GetMapping("/signup")
    public String showSignUpForm(userModel user) {
        return "add-user";
    }
    
    @PostMapping("/adduser")
    public String addUser(@Valid userModel user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        
        userRepo.save(user);
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String showUserList(Model model) {
    model.addAttribute("users", userRepo.findAll());
    return "index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        userModel user = userRepo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    
        model.addAttribute("user", user);
        return "update-user";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid userModel user, 
    BindingResult result, Model model) {
        if (result.hasErrors()) {
         user.setId(id);
            return "update-user";
        }
        
    userRepo.save(user);
    return "redirect:/index";
}
    
@GetMapping("/delete/{id}")
public String deleteUser(@PathVariable("id") long id, Model model) {
    userModel user = userRepo.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    userRepo.delete(user);
    return "redirect:/index";
}
}
