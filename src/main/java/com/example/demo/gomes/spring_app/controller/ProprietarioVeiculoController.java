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

import com.example.demo.gomes.spring_app.models.ProprietarioVeiculoModel;
import com.example.demo.gomes.spring_app.service.ProprietarioVeiculoService;

@RestController
@RequestMapping("/proprietario-veiculo")
public class ProprietarioVeiculoController {
    
    @Autowired
    private ProprietarioVeiculoService proprietarioVeiculoService;

    @GetMapping()
    public List<ProprietarioVeiculoModel> findAll() {
        return proprietarioVeiculoService.findAll();
    }

    @GetMapping("/{id}")
    public ProprietarioVeiculoModel findById(@PathVariable UUID id) {
        return proprietarioVeiculoService.findById(id);
    }

    @PostMapping("")
    public ProprietarioVeiculoModel save(@RequestBody ProprietarioVeiculoModel proprietarioVeiculo) {
        return proprietarioVeiculoService.save(proprietarioVeiculo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        proprietarioVeiculoService.delete(id);
        return ;    
    }
}
