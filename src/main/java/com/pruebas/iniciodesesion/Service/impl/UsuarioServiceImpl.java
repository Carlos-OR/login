package com.pruebas.iniciodesesion.Service.impl;

import com.pruebas.iniciodesesion.Entity.Usuario;
import com.pruebas.iniciodesesion.Repository.UsuarioRepository;
import com.pruebas.iniciodesesion.Service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Usuario registrar(Usuario us) {
        us.setClave(passwordEncoder.encode(us.getClave()));
        return usuarioRepository.save(us);
    }
}
