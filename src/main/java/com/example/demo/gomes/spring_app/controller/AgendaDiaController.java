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

import com.example.demo.gomes.spring_app.models.AgendaDiaModel;
import com.example.demo.gomes.spring_app.service.AgendaDiaService;

@RestController
@RequestMapping("/agenda-dia")
public class AgendaDiaController {
    
    @Autowired
    private AgendaDiaService agendaDiaService;

    @GetMapping()
    public List<AgendaDiaModel> findAll() {
        return agendaDiaService.findAll();
    }

    @GetMapping("/{id}")
    public AgendaDiaModel findById(@PathVariable UUID id) {
        return agendaDiaService.findById(id);
    }

    @PostMapping("")
    public AgendaDiaModel save(@RequestBody AgendaDiaModel agendaDia) {
        return agendaDiaService.save(agendaDia);
    }

    @PutMapping("/{id}")
    public AgendaDiaModel update(@PathVariable UUID id, @RequestBody AgendaDiaModel agendaDia) {
        return agendaDiaService.update(id, agendaDia);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        agendaDiaService.deleteById(id);
    }
}
