package com.example.demo.gomes.spring_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.exceptions.BadRequest;
import com.example.demo.gomes.spring_app.exceptions.NotFound;
import com.example.demo.gomes.spring_app.models.VeiculoModel;
import com.example.demo.gomes.spring_app.repository.IVeiculo;

@Service
public class VeiculoService {  

    @Autowired
    private IVeiculo veiculoRepository;

    @Autowired
    private ProprietarioService proprietarioService;

    public List<VeiculoModel> findAll() {
        return veiculoRepository.findAll();
    }

    public VeiculoModel findById(String id) {
        try {
            return veiculoRepository.findById(UUID.fromString(id)).get();
        } catch (IllegalArgumentException e) {
            throw new BadRequest("Id inválido");
        } catch (Exception e) {
            throw new NotFound("Veiculo não encontrado");
        }
    }

    public VeiculoModel save(VeiculoModel veiculo) {
        veiculo.setProprietario(proprietarioService.findById(veiculo.getProprietario().getId().toString()));
        return veiculoRepository.save(veiculo);
    }

    public VeiculoModel update(UUID id, VeiculoModel veiculo) {
        veiculo.setId(id);
        return veiculoRepository.save(veiculo);
    }

    public void delete(UUID id) {
        veiculoRepository.deleteById(id);
        return ;
    }

}
