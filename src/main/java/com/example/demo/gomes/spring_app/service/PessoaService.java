package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.exceptions.BadRequest;
import com.example.demo.gomes.spring_app.exceptions.NotFound;
import com.example.demo.gomes.spring_app.models.PessoaModel;
import com.example.demo.gomes.spring_app.repository.IPessoa;

@Service
public class PessoaService {
    
    @Autowired
    private IPessoa pessoaRepository;

    public List<PessoaModel> findAll() {
        return pessoaRepository.findAll();
    }

    public PessoaModel findById(String id) {
        try {
            return pessoaRepository.findById(UUID.fromString(id)).get();
        } catch (IllegalArgumentException e) {
            throw new BadRequest("Id inválido");
        } catch (Exception e) {
            throw new NotFound("Pessoa não encontrada");
        }
    }

    public PessoaModel save(PessoaModel pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public PessoaModel update(UUID id, PessoaModel pessoa) {
        pessoa.setId(id);
        return pessoaRepository.save(pessoa);
    }

    public void delete(UUID id) {
        pessoaRepository.deleteById(id);
        return ;    
    }
}
