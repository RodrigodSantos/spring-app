package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.exceptions.BadRequest;
import com.example.demo.gomes.spring_app.exceptions.NotFound;
import com.example.demo.gomes.spring_app.models.TecnicoEnderecoModel;
import com.example.demo.gomes.spring_app.repository.ITecnicoEndereco;

@Service
public class TecnicoEnderecoService {
    
    @Autowired
    private ITecnicoEndereco tecnicoEnderecoRepository;

    public List<TecnicoEnderecoModel> findAll() {
        return tecnicoEnderecoRepository.findAll();
    }

    public TecnicoEnderecoModel findById(UUID id) {
        try {
            return tecnicoEnderecoRepository.findById(id).get();
        } catch (IllegalArgumentException e) {
            throw new BadRequest("Id inválido");
        } catch (Exception e) {
            throw new NotFound("TecnicoEndereco não encontrado");
        }
    }

    public TecnicoEnderecoModel save(TecnicoEnderecoModel tecnicoEndereco) {
        return tecnicoEnderecoRepository.save(tecnicoEndereco);
    }

    public TecnicoEnderecoModel update(UUID id, TecnicoEnderecoModel tecnicoEndereco) {
        tecnicoEndereco.setId(id);
        return tecnicoEnderecoRepository.save(tecnicoEndereco);
    }

    public void delete(UUID id) {
        tecnicoEnderecoRepository.deleteById(id);
    }
}
