package com.example.demo.gomes.spring_app.infra.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.models.PessoaModel;
import com.example.demo.gomes.spring_app.repository.IPessoa;

@Component
public class CustomUserDetailsService implements UserDetailsService{
    
    @Autowired
    private IPessoa pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PessoaModel pessoa = this.pessoaRepository.findByCpf(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new org.springframework.security.core.userdetails.User(pessoa.getCpf(), pessoa.getSenha(), new ArrayList<>());
    }
}
