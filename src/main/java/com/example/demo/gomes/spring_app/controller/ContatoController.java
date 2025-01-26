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

import com.example.demo.gomes.spring_app.models.ContatoModel;
import com.example.demo.gomes.spring_app.service.ContatoService;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    
    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<ContatoModel> findAll() {
        return contatoService.findAll();
    }

    @GetMapping("/{id}")
    public ContatoModel findById(@PathVariable String id) {
        return contatoService.findById(id);
    }

    @PostMapping("")
    public ContatoModel save(@RequestBody ContatoModel contato) {
        return contatoService.save(contato);
    }

    @PutMapping("/{id}")
    public ContatoModel update(@PathVariable UUID id, @RequestBody ContatoModel contato) {
        return contatoService.update(id, contato);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        contatoService.delete(id);
    }
}
