package com.apicadastro.apicadastro.services;

import com.apicadastro.apicadastro.entity.UsuarioEntity;
import com.apicadastro.apicadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServices {

    private PasswordEncoder passwordEncoder;
    private UsuarioRepository repository;
    public UsuarioServices(UsuarioRepository repository){
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    public List<UsuarioEntity> listarUsuario(){
        List<UsuarioEntity> lista = repository.findAll();
        return lista;
    }
    public UsuarioEntity criarUsuario(UsuarioEntity usuarioEntity){
        String encoder = this.passwordEncoder.encode(usuarioEntity.getSenha());
        usuarioEntity.setSenha(encoder);
        UsuarioEntity usuarionovo = repository.save(usuarioEntity);
        return usuarionovo;
    }
    public UsuarioEntity editarUsuario(UsuarioEntity usuarioEntity){
        String encoder = this.passwordEncoder.encode(usuarioEntity.getSenha());
        usuarioEntity.setSenha(encoder);
        UsuarioEntity usuarionovo = repository.save(usuarioEntity);
        return usuarionovo;
    }
    public Boolean excluirUsuario(Integer id){
        repository.deleteById(id);
        return true;
    }

    public Boolean validarSenha(UsuarioEntity usuarioEntity) {
        String senha = repository.getById(usuarioEntity.getId()).getSenha();
        boolean valid = passwordEncoder.matches(usuarioEntity.getSenha() , senha);
        return valid;
    }
}
