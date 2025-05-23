package com.atividade.sa4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atividade.sa4.Repository.userRepository;
import com.atividade.sa4.model.userModel;

@Controller
@RequestMapping("/usuarios")
public class userController {
    private userRepository userRepo;

    public userController(userRepository userRepo) {
        this.userRepo = userRepo;
    }
    @GetMapping
    public String listar(Model model)
    {   
        model.addAttribute("usuarios", userRepo.findAll());
        return "usuario-lista";
    }
    @GetMapping("usuarios/cadastrar")
    public String cadastrar(Model model)
    {
        model.addAttribute("usuario", new userModel());
        return "usuario-cadastro";
    }
    @PostMapping
    public String salvar(@ModelAttribute userModel usuario)
    {
        userRepo.save(usuario);
        return "redirect:/usuarios";
    }
    @GetMapping("/editar/{id}")
    public String mostrarPorId(@PathVariable Long id, Model model)
    {
        model.addAttribute("usuario", userRepo.findById(id));
        return "usuario-cadastro";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        userRepo.deleteById(id);
        return "redirect:/usuarios";
    }
}
