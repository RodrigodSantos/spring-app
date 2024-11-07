package com.gomes.spring_app.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomes.spring_app.models.VeiculoModel;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    
    @PostMapping("/post")  
    public VeiculoModel create(@RequestBody VeiculoModel veiculo) {
        veiculo.id = UUID.randomUUID();
        return veiculo;
    }

}
