package com.example.demo.gomes.spring_app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.gomes.spring_app.models.AgendaModel;
import com.example.demo.gomes.spring_app.service.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    
    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public List<AgendaModel> findAll() {
        return agendaService.findAll();
    }

    @GetMapping("/{id}")
    public AgendaModel findById(@PathVariable UUID id) {
        return agendaService.findById(id);
    }

    @PostMapping("")
    public AgendaModel save(AgendaModel agenda) {
        return agendaService.save(agenda);
    }

    @PutMapping("/{id}")
    public AgendaModel update(@PathVariable UUID id, AgendaModel agenda) {
        return agendaService.update(id, agenda);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        agendaService.deleteById(id);
    }
}
