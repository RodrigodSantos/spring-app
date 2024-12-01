package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.models.ContatoModel;
import com.example.demo.gomes.spring_app.repository.IContato;

@Service
public class ContatoService {
    
    @Autowired
    private IContato contatoRepository;

    public List<ContatoModel> findAll() {
        return contatoRepository.findAll();
    }

    public ContatoModel findById(UUID id) {
        return contatoRepository.findById(id).get();
    }

    public ContatoModel save(ContatoModel contato) {
        return contatoRepository.save(contato);
    }

    public ContatoModel update(UUID id, ContatoModel contato) {
        contato.setId(id);
        return contatoRepository.save(contato);
    }

    public void delete(UUID id) {
        contatoRepository.deleteById(id);
    }
}
