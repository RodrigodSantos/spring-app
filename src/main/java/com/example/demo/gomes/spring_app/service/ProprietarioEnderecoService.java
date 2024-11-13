package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.models.ProprietarioEnderecoModel;
import com.example.demo.gomes.spring_app.repository.IProprietarioEndereco;

@Service
public class ProprietarioEnderecoService {
    
    @Autowired
    private IProprietarioEndereco proprietarioEnderecoRepository;

    public List<ProprietarioEnderecoModel> findAll() {
        return proprietarioEnderecoRepository.findAll();
    }

    public ProprietarioEnderecoModel findById(UUID id) {
        return proprietarioEnderecoRepository.findById(id).get();
    }

    public ProprietarioEnderecoModel save(ProprietarioEnderecoModel proprietarioEndereco) {
        return proprietarioEnderecoRepository.save(proprietarioEndereco);
    }

    public ProprietarioEnderecoModel update(UUID id, ProprietarioEnderecoModel proprietarioEndereco) {
        proprietarioEndereco.setId(id);
        return proprietarioEnderecoRepository.save(proprietarioEndereco);
    }

    public void delete(UUID id) {
        proprietarioEnderecoRepository.deleteById(id);
        return ;    
    }
}
