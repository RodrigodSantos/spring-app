package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.exceptions.BadRequest;
import com.example.demo.gomes.spring_app.exceptions.NotFound;
import com.example.demo.gomes.spring_app.models.ProprietarioContatoModel;
import com.example.demo.gomes.spring_app.repository.IProprietarioContato;

@Service
public class ProprietarioContatoService {
    
    @Autowired
    private IProprietarioContato proprietarioContatoRepository;

    @Autowired
    private ProprietarioService proprietarioService;

    @Autowired
    private ContatoService contatoService;

    public List<ProprietarioContatoModel> findAll() {
        return proprietarioContatoRepository.findAll();
    }

    public ProprietarioContatoModel findById(UUID id) {
        try {
            return proprietarioContatoRepository.findById(id).get();
        } catch (IllegalArgumentException e) {
            throw new BadRequest("Id inválido");
        } catch (Exception e) {
            throw new NotFound("ProprietárioContato não encontrado");
        }
    }

    public ProprietarioContatoModel save(ProprietarioContatoModel proprietarioContato) {
        proprietarioContato.setProprietario(proprietarioService.findById(proprietarioContato.getProprietario().getId()));
        proprietarioContato.setContato(contatoService.findById(proprietarioContato.getContato().getId()));
        return proprietarioContatoRepository.save(proprietarioContato);
    }

    public void delete(UUID id) {
        proprietarioContatoRepository.deleteById(id);
    }

}
