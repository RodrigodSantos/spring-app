package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.models.ProprietarioModel;
import com.example.demo.gomes.spring_app.repository.IProprietario;

@Service
public class ProprietarioService {
    
    @Autowired
    private IProprietario proprietarioRepository;

    public List<ProprietarioModel> findAll() {
        return proprietarioRepository.findAll();
    }
    
    public ProprietarioModel findById(UUID id) {
        return proprietarioRepository.findById(id).get();
    }

    public ProprietarioModel save(ProprietarioModel proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    public ProprietarioModel update(UUID id, ProprietarioModel proprietario) {
        proprietario.setId(id);
        return proprietarioRepository.save(proprietario);
    }

    public void delete(UUID id) {
        proprietarioRepository.deleteById(id);
        return ;
    }

}
