package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.models.AgendamentoModel;
import com.example.demo.gomes.spring_app.repository.IAgendamento;

@Service
public class AgendamentoService {
    
    @Autowired
    private IAgendamento agendamentoRepository;

    public List<AgendamentoModel> findAll() {
        return agendamentoRepository.findAll();
    }

    public AgendamentoModel findById(UUID id) {
        return agendamentoRepository.findById(id).get();
    }

    public AgendamentoModel save(AgendamentoModel agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public AgendamentoModel update(UUID id, AgendamentoModel agendamento) {
        agendamento.setId(id);
        return agendamentoRepository.save(agendamento);
    }

    public void deleteById(UUID id) {
        agendamentoRepository.deleteById(id);
    }

}
