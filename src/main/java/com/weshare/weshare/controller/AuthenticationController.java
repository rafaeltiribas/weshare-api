package com.weshare.weshare.controller;

import com.weshare.weshare.exception.LoginException;
import com.weshare.weshare.model.Usuario;
import com.weshare.weshare.service.AuthenticationService;
import com.weshare.weshare.util.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("autenticacao")   // http://localhost:8080/autenticacao
public class AuthenticationController {

    @Autowired
    private AuthenticationService autenticacaoService;

    @PostMapping("login")  // http://localhost:8080/autenticacao/login
    public TokenResponse login(@RequestBody Usuario usuario) {
        Usuario usuarioLogado = autenticacaoService.login(usuario);
        if (usuarioLogado != null) {
            System.out.println("Sucesso");
            return new TokenResponse("Sucesso");
        } else {
            System.out.println("Falha");
            throw new LoginException("Ocorreu um erro de login.");
        }
        // 400 Bad Request - quando falta a conta ou a senha.
        // 401 Unauthorized - conta existente mas senha inválida.
        // 403 Forbidden - autenticado, mas falta permissão para acessar o recurso.
        // 422 Unprocessable Entity - conta informada, mas não existe no bd.
    }
}
