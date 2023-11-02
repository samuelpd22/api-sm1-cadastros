package com.apicadastro.apicadastro.controller;

import com.apicadastro.apicadastro.entity.UsuarioEntity;
import com.apicadastro.apicadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> listarTodos(){
        List<UsuarioEntity> lista = usuarioRepository.findAll();
        return ResponseEntity.status(200).body(lista);
    }
    @PostMapping
    public ResponseEntity<UsuarioEntity> criarUsuario(@RequestBody UsuarioEntity usuarioentity){
        UsuarioEntity usuarioEntity = usuarioRepository.save(usuarioentity);
        return ResponseEntity.status(201).body(usuarioEntity);
    }
    @PutMapping
    public ResponseEntity<UsuarioEntity> editarUsuario(@RequestBody UsuarioEntity usuarioentity){
        UsuarioEntity usuarioEntity = usuarioRepository.save(usuarioentity);
        return ResponseEntity.status(201).body(usuarioEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarUsuarioPorid(@PathVariable Integer id){
        usuarioRepository.deleteById(id);
        return ResponseEntity.status(204).build();
    }




}
