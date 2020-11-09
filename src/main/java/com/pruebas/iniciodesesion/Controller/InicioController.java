package com.pruebas.iniciodesesion.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class InicioController {

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");

        return mav;
    }
}
