package com.example.demo.gomes.spring_app.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.gomes.spring_app.models.PessoaModel;
import com.example.demo.gomes.spring_app.models.ProprietarioModel;
import com.example.demo.gomes.spring_app.service.ProprietarioService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/proprietario")
public class ProprietarioController {
    
    @Autowired
    private ProprietarioService proprietarioService;

    @GetMapping()
    public List<ProprietarioModel> getProprietarios() {
        return proprietarioService.findAll();
    }

    @GetMapping("/{id}")
    public ProprietarioModel getProprietario(@PathVariable UUID id) {
        return proprietarioService.findById(id);
    }

    @PostMapping("")
    public ProprietarioModel save(@RequestBody PessoaModel proprietario) {
        return proprietarioService.save(proprietario);
    }

    @PutMapping("/{id}")
    public ProprietarioModel update(@PathVariable UUID id,@RequestBody PessoaModel pessoa) {
        return proprietarioService.update(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        proprietarioService.delete(id);
    }

}
