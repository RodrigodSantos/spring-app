package com.example.demo.gomes.spring_app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.exceptions.BadRequest;
import com.example.demo.gomes.spring_app.exceptions.NotFound;
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

    public AgendamentoModel findById(String id) {
        if (id == null) {
            throw new NotFound("Id não pode ser nulo");
        }
        try {
            return agendamentoRepository.findById(UUID.fromString(id)).get();
        } catch (IllegalArgumentException e) {
            throw new BadRequest("Id inválido");
        } catch (NoSuchElementException  e) {
            throw new NotFound("Id não pode ser nulo");	
        } catch (Exception e) {
            throw new NotFound("Agendamento não encontrado");
        } 
    }
    
    public List<AgendamentoModel> findByData(LocalDate date) {
        return agendamentoRepository.findByData(date);
    }

    public List<AgendamentoModel> findByVeiculo(String veiculoId) {
        try {
            return agendamentoRepository.findByVeiculo(veiculoRepository.findById(UUID.fromString(veiculoId)));
        } catch (IllegalArgumentException e) {
            throw new BadRequest("Id inválido");
        } catch (Exception e) {
            throw new NotFound("Veículo não encontrado");
        }
    }

    public List<AgendamentoModel> findByTecnico(String tecnicoId) {
        try {
            return agendamentoRepository.findByTecnico(tecnicoRepository.findById(UUID.fromString(tecnicoId)));
        } catch (IllegalArgumentException e) {
            throw new BadRequest("Id inválido");
        } catch (Exception e) {
            throw new NotFound("Técnico não encontrado");
        }
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
