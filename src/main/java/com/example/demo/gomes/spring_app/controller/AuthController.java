package com.example.demo.gomes.spring_app.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.gomes.spring_app.dtos.LoginRequestDTO;
import com.example.demo.gomes.spring_app.dtos.RegisterRequestDTO;
import com.example.demo.gomes.spring_app.dtos.ResponseDTO;
import com.example.demo.gomes.spring_app.infra.security.TokenService;
import com.example.demo.gomes.spring_app.models.PessoaModel;
import com.example.demo.gomes.spring_app.repository.IPessoa;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IPessoa pessoaRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        PessoaModel pessoa = this.pessoaRepository.findByCpf(body.cpf()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (passwordEncoder.matches(pessoa.getSenha(), body.senha())) {
            String token = this.tokenService.generateToken(pessoa);
            return ResponseEntity.ok(new ResponseDTO(pessoa.getNome(), token));
        }
        return ResponseEntity.badRequest().body("Senha inválida");
    }

    @PostMapping("/register")
    public ResponseEntity login(@RequestBody RegisterRequestDTO body) {
        Optional<PessoaModel> pessoa = this.pessoaRepository.findByCpf(body.cpf());

        if (pessoa.isEmpty()) {
            PessoaModel novaPessoa = new PessoaModel();
            novaPessoa.setSenha(passwordEncoder.encode(body.senha()));
            novaPessoa.setCpf(body.cpf());
            novaPessoa.setNome(body.nome());
            this.pessoaRepository.save(novaPessoa);
            
            String token = this.tokenService.generateToken(novaPessoa);
            return ResponseEntity.ok(new ResponseDTO(novaPessoa.getNome(), token));
        }
        return ResponseEntity.badRequest().body("Senha inválida");
    }
}
