package com.example.demo.gomes.spring_app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.gomes.spring_app.models.EnderecoModel;
import com.example.demo.gomes.spring_app.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping()
    public List<EnderecoModel> getEnderecos() {
        return enderecoService.findAll();
    }

    @GetMapping("/{id}")
    public EnderecoModel getEndereco(@PathVariable UUID id) {
        return enderecoService.findById(id);
    }

    @PostMapping("")
    public EnderecoModel save(@RequestBody EnderecoModel endereco) {
        return enderecoService.save(endereco);
    }

    @PutMapping("/{id}")
    public EnderecoModel update(@PathVariable UUID id, @RequestBody EnderecoModel endereco) {
        enderecoService.findById(id);
        return enderecoService.update(id, endereco);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        enderecoService.delete(id);
    }

}
