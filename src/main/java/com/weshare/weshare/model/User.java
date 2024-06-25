package com.weshare.weshare.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "A 'Conta' deve ser informada.")
    private String conta;
    @NotEmpty(message = "A 'Senha' deve ser informada.")
    private String senha;

    public User(String conta, String senha) {
        this.conta = conta;
        this.senha = senha;
    }
}

