package com.apicadastro.apicadastro.entity;

import jakarta.persistence.*;

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
