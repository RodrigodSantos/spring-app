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

import com.example.demo.gomes.spring_app.models.RepresentacaoTecEnderecoModel;
import com.example.demo.gomes.spring_app.service.RepresentacaoTecEnderecoService;

@RestController
@RequestMapping("/representacao-tec-endereco")
public class RepresentacaoTecEnderecoController {
    
    @Autowired
    private RepresentacaoTecEnderecoService representacaoTecEnderecoService;

    @GetMapping()
    public List<RepresentacaoTecEnderecoModel> getRepresentacaoTecEnderecos() {
        return representacaoTecEnderecoService.findAll();
    }

    @GetMapping("/{id}")
    public RepresentacaoTecEnderecoModel getRepresentacaoTecEndereco(@PathVariable UUID id) {
        return representacaoTecEnderecoService.findById(id);
    }

    @PostMapping("")
    public RepresentacaoTecEnderecoModel save(@RequestBody RepresentacaoTecEnderecoModel representacaoTecEndereco) {
        return representacaoTecEnderecoService.save(representacaoTecEndereco);
    }

    @PutMapping("/{id}")
    public RepresentacaoTecEnderecoModel update(@PathVariable UUID id, @RequestBody RepresentacaoTecEnderecoModel representacaoTecEndereco) {
        return representacaoTecEnderecoService.update(id, representacaoTecEndereco);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        representacaoTecEnderecoService.delete(id);
    }
}
