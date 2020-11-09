package com.pruebas.iniciodesesion.Controller;

import com.pruebas.iniciodesesion.Entity.Usuario;
import com.pruebas.iniciodesesion.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/private")
public class PrivateController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }

}
