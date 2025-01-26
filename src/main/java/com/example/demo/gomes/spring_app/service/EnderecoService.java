package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.exceptions.BadRequest;
import com.example.demo.gomes.spring_app.exceptions.NotFound;
import com.example.demo.gomes.spring_app.models.EnderecoModel;
import com.example.demo.gomes.spring_app.repository.IEndereco;
@Service
public class EnderecoService {
    
    @Autowired
    private IEndereco enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    public List<EnderecoModel> findAll() {
        return enderecoRepository.findAll();
    }

    public EnderecoModel findById(String id) {
        try {
            return enderecoRepository.findById(UUID.fromString(id)).get();
        } catch (IllegalArgumentException e) {
            throw new BadRequest("Id inválido");
        } catch (Exception e) {
            throw new NotFound("Endereço não encontrado");
        }
    }

    public EnderecoModel save(EnderecoModel endereco) {
        endereco.setPessoa(pessoaService.findById(endereco.getPessoa().getId().toString()));
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
