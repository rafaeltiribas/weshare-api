package com.weshare.weshare.repository;

import com.weshare.weshare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByContaAndSenha(String conta, String senha);
}
