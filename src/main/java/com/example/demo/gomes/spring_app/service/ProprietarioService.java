package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.exceptions.BadRequest;
import com.example.demo.gomes.spring_app.exceptions.NotFound;
import com.example.demo.gomes.spring_app.models.PessoaModel;
import com.example.demo.gomes.spring_app.models.ProprietarioModel;
import com.example.demo.gomes.spring_app.repository.IPessoa;
import com.example.demo.gomes.spring_app.repository.IProprietario;

@Service
public class ProprietarioService {
    
    @Autowired
    private IProprietario proprietarioRepository;

    @Autowired
    private IPessoa pessoaRepository;

    public List<ProprietarioModel> findAll() {
        return proprietarioRepository.findAll();
    }
    
    public ProprietarioModel findById(String id) {
        try {
            return proprietarioRepository.findById(UUID.fromString(id)).get();
        } catch (IllegalArgumentException e) {
            throw new BadRequest("Id inválido");
        } catch (Exception e) {
            throw new NotFound("Proprietario não encontrado");
        }
    }

    public ProprietarioModel save(PessoaModel pessoa) {
        pessoaRepository.save(pessoa);
        ProprietarioModel proprietario = new ProprietarioModel();
        proprietario.setPessoa(pessoa);
        return proprietarioRepository.save(proprietario);
    }

    public ProprietarioModel update(UUID id, PessoaModel pessoa) {
        pessoa.setId(proprietarioRepository.findById(id).get().getPessoa().getId());
        pessoaRepository.save(pessoa);
        return proprietarioRepository.findById(id).get();
    }

    public void delete(UUID id) {
        PessoaModel pessoa = new PessoaModel();
        pessoa = proprietarioRepository.findById(id).get().getPessoa();
        proprietarioRepository.deleteById(id);
        pessoaRepository.deleteById(pessoa.getId());
        return ;    
    }
}
