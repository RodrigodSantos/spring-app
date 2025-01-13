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

import com.example.demo.gomes.spring_app.models.AgendamentoModel;
import com.example.demo.gomes.spring_app.service.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
    
    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public List<AgendamentoModel> findAll() {
        return agendamentoService.findAll();
    }

    @GetMapping("/{id}")
    public AgendamentoModel findById(@PathVariable UUID id) {
        return agendamentoService.findById(id);
    }

    @PostMapping("")
    public AgendamentoModel save(@RequestBody AgendamentoModel agendamento) {
        return agendamentoService.save(agendamento);
    }

    @PutMapping("/{id}")
    public AgendamentoModel update(@PathVariable UUID id, @RequestBody AgendamentoModel agendamento) {
        return agendamentoService.update(id, agendamento);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        agendamentoService.deleteById(id);
        return;
    }

}
