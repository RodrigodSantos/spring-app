package com.example.demo.gomes.spring_app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.gomes.spring_app.models.ProprietarioContatoModel;
import com.example.demo.gomes.spring_app.service.ProprietarioContatoService;

@RestController
@RequestMapping("/proprietario-contato")
public class ProprietarioContatoController {
    
    @Autowired
    private ProprietarioContatoService proprietarioContatoService;

    @GetMapping
    public List<ProprietarioContatoModel> findAll() {
        return proprietarioContatoService.findAll();
    }

    @GetMapping("/{id}")
    public ProprietarioContatoModel findById(@PathVariable UUID id) {
        return proprietarioContatoService.findById(id);
    }

    @PostMapping("")
    public ProprietarioContatoModel save(@RequestBody ProprietarioContatoModel proprietarioContatoModel) {
        return proprietarioContatoService.save(proprietarioContatoModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        proprietarioContatoService.delete(id);
    }
}
