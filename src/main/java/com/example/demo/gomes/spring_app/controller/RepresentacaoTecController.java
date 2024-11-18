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

import com.example.demo.gomes.spring_app.models.RepresentacaoTecModel;
import com.example.demo.gomes.spring_app.service.RepresentacaoTecService;

@RestController
@RequestMapping("/representacao-tec")
public class RepresentacaoTecController {
    
    @Autowired
    private RepresentacaoTecService representacaoTecService;

    @GetMapping()
    public List<RepresentacaoTecModel> getRepresentacaoTecs() {
        return representacaoTecService.findAll();
    }

    @GetMapping("/{id}")
    public RepresentacaoTecModel getRepresentacaoTec(@PathVariable UUID id) {
        return representacaoTecService.findById(id);
    }

    @PostMapping("")
    public RepresentacaoTecModel save(@RequestBody RepresentacaoTecModel representacaoTec) {
        return representacaoTecService.save(representacaoTec);
    }

    @PutMapping("/{id}")
    public RepresentacaoTecModel update(@PathVariable UUID id, @RequestBody RepresentacaoTecModel representacaoTec) {
        return representacaoTecService.update(id, representacaoTec);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        representacaoTecService.delete(id);
    }
}
