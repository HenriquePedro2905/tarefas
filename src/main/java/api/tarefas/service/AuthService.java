package api.tarefas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import api.tarefas.dolmain.users.AuthenticationDTO;
import api.tarefas.dolmain.users.UserRepository;
import api.tarefas.dolmain.users.Users;
import api.tarefas.dolmain.users.UsersReqDTO;

@Service
public class AuthService {

    @Autowired
    UserRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService service;

    public Users registerUser(UsersReqDTO data){

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        Users newUser = new Users(data.login(), encryptedPassword, data.name());
        return repository.save(newUser);
    }

    public String login(AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        String token = service.generateToken((Users) auth.getPrincipal());

        return token;
    }
}


