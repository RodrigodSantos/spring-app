package com.example.demo.gomes.spring_app.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.gomes.spring_app.models.VeiculoModel;
import com.example.demo.gomes.spring_app.service.VeiculoService;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping()
    public List<VeiculoModel> getVeiculos() {
        return veiculoService.findAll();
    }

    @GetMapping("/{id}")
    public VeiculoModel getVeiculo(@PathVariable String id) {
        return veiculoService.findById(id);
    }
    
    @PostMapping("")  
    public VeiculoModel save(@RequestBody VeiculoModel veiculo) {
        return veiculoService.save(veiculo);
    }

    @PutMapping("/{id}")
    public VeiculoModel update(@PathVariable String id, @RequestBody VeiculoModel veiculo) {
        veiculoService.findById(id);
        return veiculoService.update(UUID.fromString(id), veiculo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        veiculoService.delete(id);
    }
}
