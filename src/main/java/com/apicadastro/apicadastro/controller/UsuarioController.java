package com.apicadastro.apicadastro.controller;

import com.apicadastro.apicadastro.entity.UsuarioEntity;
import com.apicadastro.apicadastro.repository.UsuarioRepository;
import com.apicadastro.apicadastro.services.UsuarioServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private UsuarioServices usuarioServices;
    public UsuarioController (UsuarioServices usuarioServices){
        this.usuarioServices = usuarioServices;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> listarTodos(){
        return ResponseEntity.status(200).body(usuarioServices.listarUsuario());
    }
    @PostMapping
    public ResponseEntity<UsuarioEntity> criarUsuario(@Valid @RequestBody UsuarioEntity usuarioentity){
        return ResponseEntity.status(201).body(usuarioServices.criarUsuario(usuarioentity));
    }
    @PostMapping("/login")
    public ResponseEntity<UsuarioEntity> validarSenha(@Valid @RequestBody UsuarioEntity usuarioEntity){
        Boolean valid = usuarioServices.validarSenha(usuarioEntity);
        if (!valid){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(200).build();
    }

    @PutMapping
    public ResponseEntity<UsuarioEntity> editarUsuario(@RequestBody UsuarioEntity usuarioentity){
        return ResponseEntity.status(200).body(usuarioServices.editarUsuario(usuarioentity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarUsuarioPorid(@PathVariable Integer id){
        usuarioServices.excluirUsuario(id);
        return ResponseEntity.status(204).build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExeption(MethodArgumentNotValidException ex){
    Map<String ,String> erros = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
        String fieldName = ((FieldError) error).getField();
        String errorMessege = error.getDefaultMessage();
        erros.put(fieldName, errorMessege);
        });
        return erros;
    }



}
