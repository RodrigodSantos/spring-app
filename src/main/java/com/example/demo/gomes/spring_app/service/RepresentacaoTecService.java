package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.models.RepresentacaoTecModel;
import com.example.demo.gomes.spring_app.repository.IRepresentacaoTec;

@Service
public class RepresentacaoTecService {
    
    @Autowired
    private IRepresentacaoTec representacaoTecRepository;

    public List<RepresentacaoTecModel> findAll() {
        return representacaoTecRepository.findAll();
    }

    public RepresentacaoTecModel findById(UUID id) {
        return representacaoTecRepository.findById(id).get();
    }

    public RepresentacaoTecModel save(RepresentacaoTecModel representacaoTec) {        
        return representacaoTecRepository.save(representacaoTec);
    }

    public RepresentacaoTecModel update(UUID id, RepresentacaoTecModel representacaoTec) {
        representacaoTec.setDataCadastro(representacaoTecRepository.findById(id).get().getDataCadastro()); 
        representacaoTec.setId(id);
        return representacaoTecRepository.save(representacaoTec);
    }

    public void delete(UUID id) {
        representacaoTecRepository.deleteById(id);
    }
}
