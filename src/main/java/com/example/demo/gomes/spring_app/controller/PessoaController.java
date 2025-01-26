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

import com.example.demo.gomes.spring_app.models.PessoaModel;
import com.example.demo.gomes.spring_app.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;

    @GetMapping()
    public List<PessoaModel> findAll() {
        return pessoaService.findAll();
    }

    @GetMapping("/{id}")
    public PessoaModel findById(@PathVariable String id) {
        return pessoaService.findById(id);
    }

    @PostMapping("")
    public PessoaModel save(@RequestBody PessoaModel pessoa) {
        return pessoaService.save(pessoa);
    }

    @PutMapping("/{id}")
    public PessoaModel update(@PathVariable UUID id,@RequestBody PessoaModel pessoa) {
        pessoa.setId(id);
        return pessoaService.update(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        pessoaService.delete(id);
    }
    
}
