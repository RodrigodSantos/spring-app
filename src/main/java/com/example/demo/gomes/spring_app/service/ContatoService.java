package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.exceptions.BadRequest;
import com.example.demo.gomes.spring_app.exceptions.NotFound;
import com.example.demo.gomes.spring_app.models.ContatoModel;
import com.example.demo.gomes.spring_app.repository.IContato;

@Service
public class ContatoService {
    
    @Autowired
    private IContato contatoRepository;

    public List<ContatoModel> findAll() {
        return contatoRepository.findAll();
    }

    public ContatoModel findById(String id) {
        try {
            return contatoRepository.findById(UUID.fromString(id)).get();
        } catch (IllegalArgumentException e) {
            throw new BadRequest("Id inválido");
        } catch (Exception e) {
            throw new NotFound("Contato não encontrado");
        }
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
