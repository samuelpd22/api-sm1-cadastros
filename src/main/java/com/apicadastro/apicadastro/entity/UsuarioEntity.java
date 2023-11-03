package com.apicadastro.apicadastro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name ="API-Cadastro")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "O nome é obrigatorio!")
    @Size(min =  3, message = "O nome deve conter no minimo 3 caracteres!")
    @Column(name = "nome" ,length = 200, nullable = true)
    private String nome;

    @Email(message = "Insira um email valido!")
    @NotBlank(message = "O email é obrigatorio!")
    @Column(name = "email" ,length = 50, nullable = true)
    private String email;

    @NotBlank(message = "A senha é obrigatoria!")
    @Column(name = "senha" ,columnDefinition = "TEXT", nullable = true)
    private String senha;

    @NotBlank(message = "O número de telefone é obrigatorio!")
    @Column(name = "tel" ,length = 15, nullable = true)
    private String tel;


}
