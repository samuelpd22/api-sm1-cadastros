package com.apicadastro.apicadastro.services;

import com.apicadastro.apicadastro.entity.UsuarioEntity;
import com.apicadastro.apicadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServices {

    private UsuarioRepository repository;
    public UsuarioServices(UsuarioRepository repository){
        this.repository = repository;
    }
    public List<UsuarioEntity> listarUsuario(){
        List<UsuarioEntity> lista = repository.findAll();
        return lista;
    }
    public UsuarioEntity criarUsuario(UsuarioEntity usuarioEntity){
        UsuarioEntity usuarionovo = repository.save(usuarioEntity);
        return usuarionovo;
    }
    public UsuarioEntity editarUsuario(UsuarioEntity usuarioEntity){
        UsuarioEntity usuarionovo = repository.save(usuarioEntity);
        return usuarionovo;
    }
    public Boolean excluirUsuario(Integer id){
        repository.deleteById(id);
        return true;
    }
}
