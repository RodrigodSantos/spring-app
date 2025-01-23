package com.example.demo.gomes.spring_app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.exceptions.InternalServerError;
import com.example.demo.gomes.spring_app.models.AgendamentoModel;
import com.example.demo.gomes.spring_app.repository.IAgendamento;

@Service
public class AgendamentoService {
    
    @Autowired
    private IAgendamento agendamentoRepository;

    @Autowired
    private VeiculoService veiculoRepository;

    @Autowired
    private TecnicoService tecnicoRepository;

    public List<AgendamentoModel> findAll() {
        return agendamentoRepository.findAll();
    }

    public AgendamentoModel findById(UUID id) throws Exception {
        return agendamentoRepository.findById(id).orElseThrow(
            () -> new InternalServerError("Agendamento não encontrado")
        );
    }

    public List<AgendamentoModel> findByData(LocalDate date) {
        return agendamentoRepository.findByData(date);
    }

    public List<AgendamentoModel> findByVeiculo(UUID veiculoId) {
        return agendamentoRepository.findByVeiculo(veiculoRepository.findById(veiculoId));
    }

    public List<AgendamentoModel> findByTecnico(UUID tecnico) {
        return agendamentoRepository.findByTecnico(tecnicoRepository.findById(tecnico));
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
