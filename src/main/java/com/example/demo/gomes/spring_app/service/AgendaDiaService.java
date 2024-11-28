package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.models.AgendaDiaModel;
import com.example.demo.gomes.spring_app.repository.IAgendaDia;

@Service
public class AgendaDiaService {
    
    @Autowired
    private IAgendaDia agendaDiaRepository;

    public List<AgendaDiaModel> findAll() {
        return agendaDiaRepository.findAll();
    }

    public AgendaDiaModel findById(UUID id) {
        return agendaDiaRepository.findById(id).get();
    }

    public AgendaDiaModel save(AgendaDiaModel agendaDia) {
        return agendaDiaRepository.save(agendaDia);
    }

    public AgendaDiaModel update(UUID id, AgendaDiaModel agendaDia) {
        agendaDia.setId(id);
        return agendaDiaRepository.save(agendaDia);
    }

    public void deleteById(UUID id) {
        agendaDiaRepository.deleteById(id);
    }
}
