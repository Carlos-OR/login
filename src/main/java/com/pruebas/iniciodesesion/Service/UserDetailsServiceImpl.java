package com.pruebas.iniciodesesion.Service;

import com.pruebas.iniciodesesion.Entity.Usuario;
import com.pruebas.iniciodesesion.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsuario(username);
        User.UserBuilder builder = null;

        if (usuario != null){
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(usuario.getClave());
            builder.authorities(new SimpleGrantedAuthority("USER_ROLE"));
        }else{
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return builder.build();
    }
}
