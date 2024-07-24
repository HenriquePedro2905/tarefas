package api.tarefas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import api.tarefas.dolmain.users.UserRepository;
import api.tarefas.dolmain.users.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = repository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("usuario nao encontrado"));
        return users;
    }

}
