package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.models.ProprietarioVeiculoModel;
import com.example.demo.gomes.spring_app.repository.IProprietarioVeiculo;

@Service
public class ProprietarioVeiculoService {
    
    @Autowired
    private IProprietarioVeiculo proprietarioVeiculoRepository;

    @Autowired
    private ProprietarioService proprietarioService;

    @Autowired
    private VeiculoService veiculoService;

    public List<ProprietarioVeiculoModel> findAll() {
        return proprietarioVeiculoRepository.findAll();
    }

    public ProprietarioVeiculoModel findById(UUID id) {
        return proprietarioVeiculoRepository.findById(id).get();
    }

    public ProprietarioVeiculoModel save(ProprietarioVeiculoModel proprietarioVeiculo) {
        proprietarioVeiculo.setProprietario(proprietarioService.findById(proprietarioVeiculo.getProprietario().getId()));
        proprietarioVeiculo.setVeiculo(veiculoService.findById(proprietarioVeiculo.getVeiculo().getId()));
        return proprietarioVeiculoRepository.save(proprietarioVeiculo);
    }

    public void delete(UUID id) {
        proprietarioVeiculoRepository.deleteById(id);
        return ;    
    }
}
