package com.pruebas.iniciodesesion.Controller;

import com.pruebas.iniciodesesion.Entity.Usuario;
import com.pruebas.iniciodesesion.Repository.UsuarioRepository;
import com.pruebas.iniciodesesion.Service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    IUsuarioService iUsuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/auth/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");

        return mav;
    }

    @GetMapping("/auth/registro")
    public ModelAndView Formregistrar(){
        ModelAndView modelAndView = new ModelAndView("registro");

        modelAndView.addObject("parametro", new Usuario());

        return modelAndView;

    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Usuario usuario){
        usuario.setClave(passwordEncoder.encode(usuario.getClave()));
        usuarioRepository.save(usuario);
        return "redirect:/auth/login";
    }
}
