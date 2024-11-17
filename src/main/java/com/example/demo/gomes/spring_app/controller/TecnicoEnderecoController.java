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

import com.example.demo.gomes.spring_app.models.TecnicoEnderecoModel;
import com.example.demo.gomes.spring_app.service.EnderecoService;
import com.example.demo.gomes.spring_app.service.TecnicoEnderecoService;
import com.example.demo.gomes.spring_app.service.TecnicoService;

@RestController
@RequestMapping("/tecnico-endereco")
public class TecnicoEnderecoController {
    
    @Autowired
    private TecnicoEnderecoService tecnicoEnderecoService;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping()
    public List<TecnicoEnderecoModel> findAll() {
        return tecnicoEnderecoService.findAll();
    }

    @GetMapping("/{id}")
    public TecnicoEnderecoModel findById(@PathVariable UUID id) {
        return tecnicoEnderecoService.findById(id);
    }

    @PostMapping("")
    public TecnicoEnderecoModel save(@RequestBody TecnicoEnderecoModel tecnicoEndereco) {
        tecnicoEndereco.setTecnico(tecnicoService.findById(tecnicoEndereco.getTecnico().getId()));
        tecnicoEndereco.setEndereco(enderecoService.findById(tecnicoEndereco.getEndereco().getId()));
        return tecnicoEnderecoService.save(tecnicoEndereco);
    }

    @PutMapping("/{id}")
    public TecnicoEnderecoModel update(@PathVariable UUID id, @RequestBody TecnicoEnderecoModel tecnicoEndereco) {
        return tecnicoEnderecoService.update(id, tecnicoEndereco);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        tecnicoEnderecoService.delete(id);
    }
}
