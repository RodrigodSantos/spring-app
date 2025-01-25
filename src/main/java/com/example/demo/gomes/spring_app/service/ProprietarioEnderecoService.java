package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.exceptions.BadRequest;
import com.example.demo.gomes.spring_app.exceptions.NotFound;
import com.example.demo.gomes.spring_app.models.ProprietarioEnderecoModel;
import com.example.demo.gomes.spring_app.repository.IProprietarioEndereco;

@Service
public class ProprietarioEnderecoService {
    
    @Autowired
    private IProprietarioEndereco proprietarioEnderecoRepository;

    @Autowired
    private ProprietarioService proprietarioService;

    @Autowired
    private EnderecoService enderecoService;

    public List<ProprietarioEnderecoModel> findAll() {
        return proprietarioEnderecoRepository.findAll();
    }

    public ProprietarioEnderecoModel findById(UUID id) {
        try {
            return proprietarioEnderecoRepository.findById(id).get();
        } catch (IllegalArgumentException e) {
            throw new BadRequest("Id inválido");
        } catch (Exception e) {
            throw new NotFound("ProprietarioEndereco não encontrado");
        }
    }

    public ProprietarioEnderecoModel save(ProprietarioEnderecoModel proprietarioEndereco) {
        proprietarioEndereco.setProprietario(proprietarioService.findById(proprietarioEndereco.getProprietario().getId()));
        proprietarioEndereco.setEndereco(enderecoService.findById(proprietarioEndereco.getEndereco().getId()));
        return proprietarioEnderecoRepository.save(proprietarioEndereco);
    }

    public void delete(UUID id) {
        proprietarioEnderecoRepository.deleteById(id);
        return ;    
    }
}
