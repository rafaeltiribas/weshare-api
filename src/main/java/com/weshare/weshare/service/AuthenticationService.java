package com.weshare.weshare.service;

import com.weshare.weshare.model.Usuario;
import com.weshare.weshare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository usuarioRepository;

    public Usuario login(Usuario usuario) {
        System.out.println("Conta = " + usuario.getConta() + " e senha = " + usuario.getSenha());
        return usuarioRepository.findByContaAndSenha(
                usuario.getConta(), usuario.getSenha());
    }
}
