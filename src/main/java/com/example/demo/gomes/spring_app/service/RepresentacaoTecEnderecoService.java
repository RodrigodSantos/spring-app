package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.models.RepresentacaoTecEnderecoModel;
import com.example.demo.gomes.spring_app.repository.IRepresentacaoTecEndereco;

@Service
public class RepresentacaoTecEnderecoService {
    
    @Autowired
    private IRepresentacaoTecEndereco representacaoTecEnderecoRepository;

    @Autowired
    private RepresentacaoTecService representacaoTecService;

    @Autowired
    private EnderecoService enderecoService;

    public List<RepresentacaoTecEnderecoModel> findAll() {
        return representacaoTecEnderecoRepository.findAll();
    }

    public RepresentacaoTecEnderecoModel findById(UUID id) {
        return representacaoTecEnderecoRepository.findById(id).get();
    }

    public RepresentacaoTecEnderecoModel save(RepresentacaoTecEnderecoModel representacaoTecEndereco) {
        representacaoTecEndereco.setRepresentacaoTec(representacaoTecService.findById(representacaoTecEndereco.getRepresentacaoTec().getId()));
        representacaoTecEndereco.setEndereco(enderecoService.findById(representacaoTecEndereco.getEndereco().getId()));
        return representacaoTecEnderecoRepository.save(representacaoTecEndereco);
    }

    public RepresentacaoTecEnderecoModel update(UUID id, RepresentacaoTecEnderecoModel representacaoTecEndereco) { 
        representacaoTecEndereco.setId(id);
        return representacaoTecEnderecoRepository.save(representacaoTecEndereco);
    }

    public void delete(UUID id) {
        representacaoTecEnderecoRepository.deleteById(id);
    }
}
