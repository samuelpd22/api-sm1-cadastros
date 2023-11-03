package com.apicadastro.apicadastro.entity;

import jakarta.persistence.*;
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
    @Column(name = "nome" ,length = 200, nullable = true)
    private String nome;
    @Column(name = "email" ,length = 50, nullable = true)
    private String email;
    @Column(name = "senha" ,columnDefinition = "TEXT", nullable = true)
    private String senha;
    @Column(name = "tel" ,length = 15, nullable = true)
    private String tel;


}
