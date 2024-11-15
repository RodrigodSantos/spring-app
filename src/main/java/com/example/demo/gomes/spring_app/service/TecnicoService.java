package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.models.TecnicoModel;
import com.example.demo.gomes.spring_app.repository.ITecnico;

@Service
public class TecnicoService {
    
    @Autowired
    private ITecnico tecnicoRepository;

    public List<TecnicoModel> findAll() {
        return tecnicoRepository.findAll();
    }

    public TecnicoModel findById(UUID id) {
        return tecnicoRepository.findById(id).get();
    }

    public TecnicoModel save(TecnicoModel tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    public TecnicoModel update(UUID id, TecnicoModel tecnico) {
        tecnico.setId(id);
        return tecnicoRepository.save(tecnico);
    }

    public void delete(UUID id) {
        tecnicoRepository.deleteById(id);
        return ;    
    }

}
