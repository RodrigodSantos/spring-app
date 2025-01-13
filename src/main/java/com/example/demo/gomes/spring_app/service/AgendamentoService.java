package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.models.AgendamentoModel;
import com.example.demo.gomes.spring_app.repository.IAgendamento;
import com.example.demo.gomes.spring_app.repository.IEndereco;
import com.example.demo.gomes.spring_app.repository.IRepresentacaoTec;
import com.example.demo.gomes.spring_app.repository.IVeiculo;

@Service
public class AgendamentoService {
    
    @Autowired
    private IAgendamento agendamentoRepository;

    @Autowired
    private IVeiculo veiculoRepository;

    @Autowired
    private IEndereco enderecoRepository;

    @Autowired
    private IRepresentacaoTec representacaoTecRepository;

    public List<AgendamentoModel> findAll() {
        return agendamentoRepository.findAll();
    }

    public AgendamentoModel findById(UUID id) {
        return agendamentoRepository.findById(id).get();
    }

    public AgendamentoModel save(AgendamentoModel agendamento) {

        
        // agendamento.setVeiculo(veiculoRepository.findById(agendamento.getVeiculo().getId()).get());
        // agendamento.setEndereco(enderecoRepository.findById(agendamento.getEndereco().getId()).get());
        // agendamento.setRepresentacaoTec(representacaoTecRepository.findById(agendamento.getRepresentacaoTec().getId()).get());
        return agendamentoRepository.save(agendamento);
    }

    public AgendamentoModel update(UUID id, AgendamentoModel agendamento) {
        agendamento.setId(id);
        // agendamento.setVeiculo(veiculoRepository.findById(agendamento.getVeiculo().getId()).get());
        // agendamento.setEndereco(enderecoRepository.findById(agendamento.getEndereco().getId()).get());
        // agendamento.setRepresentacaoTec(representacaoTecRepository.findById(agendamento.getRepresentacaoTec().getId()).get());
        return agendamentoRepository.save(agendamento);
    }

    public void deleteById(UUID id) {
        agendamentoRepository.deleteById(id);
    }

}
