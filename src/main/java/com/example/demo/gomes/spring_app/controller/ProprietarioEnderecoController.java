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

import com.example.demo.gomes.spring_app.models.ProprietarioEnderecoModel;
import com.example.demo.gomes.spring_app.service.ProprietarioEnderecoService;

@RestController
@RequestMapping("/proprietario-endereco")
public class ProprietarioEnderecoController {
    
    @Autowired
    private ProprietarioEnderecoService proprietarioEnderecoService;
    
    @GetMapping()
    public List<ProprietarioEnderecoModel> getProprietarioEnderecos() {
        return proprietarioEnderecoService.findAll();
    }

    @GetMapping("/{id}")
    public ProprietarioEnderecoModel getProprietarioEndereco(@PathVariable UUID id) {
        return proprietarioEnderecoService.findById(id);
    }

    @PostMapping("")
    public ProprietarioEnderecoModel save(@RequestBody ProprietarioEnderecoModel proprietarioEndereco) {
        return proprietarioEnderecoService.save(proprietarioEndereco);
    }

    // @PutMapping("/{id}")
    // public ProprietarioEnderecoModel update(@PathVariable UUID id, @RequestBody EnderecoModel endereco) {
    //     return proprietarioEnderecoService.update(id, endereco);
    // }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        proprietarioEnderecoService.delete(id);
    }

}
