package com.example.demo.gomes.spring_app.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.gomes.spring_app.models.VeiculoModel;
import com.example.demo.gomes.spring_app.service.VeiculoService;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping()
    public List<VeiculoModel> getVeiculos() {
        return veiculoService.findAll();
    }
    
    
    @PostMapping("/post")  
    public VeiculoModel create(@RequestBody VeiculoModel veiculo) {
        return veiculo;
    }

}
