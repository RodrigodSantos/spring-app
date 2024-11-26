package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.models.AgendaModel;
import com.example.demo.gomes.spring_app.repository.IAgenda;

@Service
public class AgendaService {
    
    @Autowired
    private IAgenda agendaRepository;

    public List<AgendaModel> findAll() {
        return agendaRepository.findAll();
    }

    public AgendaModel findById(UUID id) {
        return agendaRepository.findById(id).get();
    }

    public AgendaModel save(AgendaModel agenda) {
        return agendaRepository.save(agenda);
    }

    public AgendaModel update(UUID id, AgendaModel agenda) {
        agenda.setId(id);
        return agendaRepository.save(agenda);
    }

    public void deleteById(UUID id) {
        agendaRepository.deleteById(id);
    }
}
