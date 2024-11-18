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

    @Autowired
    private ProprietarioService proprietarioService;

    @Autowired
    private EnderecoService enderecoService;

    public List<ProprietarioEnderecoModel> findAll() {
        return proprietarioEnderecoRepository.findAll();
    }

    public ProprietarioEnderecoModel findById(UUID id) {
        return proprietarioEnderecoRepository.findById(id).get();
    }

    public ProprietarioEnderecoModel save(ProprietarioEnderecoModel proprietarioEndereco) {
        proprietarioEndereco.setProprietario(proprietarioService.findById(proprietarioEndereco.getProprietario().getId()));
        proprietarioEndereco.setEndereco(enderecoService.findById(proprietarioEndereco.getEndereco().getId()));
        return proprietarioEnderecoRepository.save(proprietarioEndereco);
    }

    // public ProprietarioEnderecoModel update(UUID id, EnderecoModel endereco) {
    //     ProprietarioEnderecoModel proprietarioEndereco = new ProprietarioEnderecoModel();
    //     proprietarioEndereco.setId(id);
    //     endereco.setId(proprietarioEnderecoRepository.findById(id).get().getEndereco().getId());
    //     proprietarioEndereco.setEndereco(endereco);

    //     return "";
    // }

    public void delete(UUID id) {
        proprietarioEnderecoRepository.deleteById(id);
        return ;    
    }
}
