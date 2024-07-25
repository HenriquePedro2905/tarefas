package api.tarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.tarefas.dolmain.users.AuthenticationDTO;
import api.tarefas.dolmain.users.LoginResDTO;
import api.tarefas.dolmain.users.UsersReqDTO;
import api.tarefas.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody UsersReqDTO data){
        service.registerUser(data);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResDTO> login(@RequestBody AuthenticationDTO data){
        var response = service.login(data);
        return ResponseEntity.ok(response);
    }
}