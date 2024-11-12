package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.models.EnderecoModel;
import com.example.demo.gomes.spring_app.models.ProprietarioModel;
import com.example.demo.gomes.spring_app.repository.IEndereco;
import com.example.demo.gomes.spring_app.repository.IProprietario;

@Service
public class EnderecoService {
    
    @Autowired
    private IEndereco enderecoRepository;

    @Autowired
    private IProprietario proprietarioRepository;

    public List<EnderecoModel> findAll() {
        return enderecoRepository.findAll();
    }

    public EnderecoModel findById(UUID id) {
        return enderecoRepository.findById(id).get();
    }

    public EnderecoModel save(EnderecoModel endereco) {
        UUID proprietario_id = endereco.getProprietario().getId();
        ProprietarioModel proprietario = proprietarioRepository.findById(proprietario_id).get();
        endereco.setProprietario(proprietario);
        return enderecoRepository.save(endereco);
    }

    public EnderecoModel update(UUID id, EnderecoModel endereco) {
        endereco.setId(id);
        return enderecoRepository.save(endereco);
    }

    public void delete(UUID id) {
        enderecoRepository.deleteById(id);
        return ;    
    }

}
