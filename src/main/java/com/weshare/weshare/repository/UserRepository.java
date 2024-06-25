package com.weshare.weshare.repository;

import com.weshare.weshare.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {

    Usuario findByContaAndSenha(String conta, String senha);
}
