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

import com.example.demo.gomes.spring_app.models.PessoaModel;
import com.example.demo.gomes.spring_app.models.TecnicoModel;
import com.example.demo.gomes.spring_app.service.TecnicoService;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController {
    
    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping()
    public List<TecnicoModel> findAll() {
        return tecnicoService.findAll();
    }

    @GetMapping("/{id}")
    public TecnicoModel findById(@PathVariable UUID id) {
        return tecnicoService.findById(id);
    }

    @PostMapping("")
    public TecnicoModel save(@RequestBody PessoaModel pessoa) {
        return tecnicoService.save(pessoa);
    }

    @PutMapping("/{id}")
    public TecnicoModel update(@PathVariable UUID id,@RequestBody PessoaModel pessoa) {
        return tecnicoService.update(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        tecnicoService.delete(id);
        return ;
    }
}
