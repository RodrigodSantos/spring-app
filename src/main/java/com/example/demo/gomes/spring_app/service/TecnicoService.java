package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.exceptions.BadRequest;
import com.example.demo.gomes.spring_app.exceptions.NotFound;
import com.example.demo.gomes.spring_app.models.PessoaModel;
import com.example.demo.gomes.spring_app.models.TecnicoModel;
import com.example.demo.gomes.spring_app.repository.IPessoa;
import com.example.demo.gomes.spring_app.repository.ITecnico;

@Service
public class TecnicoService {
    
    @Autowired
    private ITecnico tecnicoRepository;

    @Autowired
    private IPessoa pessoaRepository;

    public List<TecnicoModel> findAll() {
        return tecnicoRepository.findAll();
    }

    public TecnicoModel findById(UUID id) {
        try {
            return tecnicoRepository.findById(id).get();
        } catch (IllegalArgumentException e) {
            throw new BadRequest("Id inválido");
        } catch (Exception e) {
            throw new NotFound("Tecnico não encontrado");
        }
    }

    public TecnicoModel save(PessoaModel pessoa) {
        pessoaRepository.save(pessoa);
        TecnicoModel tecnico = new TecnicoModel();
        tecnico.setPessoa(pessoa);
        return tecnicoRepository.save(tecnico);
    }

    public TecnicoModel update(UUID id, PessoaModel pessoa) {
        pessoa.setId(tecnicoRepository.findById(id).get().getPessoa().getId());
        pessoaRepository.save(pessoa);
        return tecnicoRepository.findById(id).get();
    }

    public void delete(UUID id) {
        PessoaModel pessoa = new PessoaModel();
        pessoa = tecnicoRepository.findById(id).get().getPessoa();
        tecnicoRepository.deleteById(id);
        pessoaRepository.deleteById(pessoa.getId());
        return ;    
    }

}
