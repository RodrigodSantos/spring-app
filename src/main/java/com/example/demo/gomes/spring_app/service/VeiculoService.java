package com.example.demo.gomes.spring_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gomes.spring_app.models.VeiculoModel;
import com.example.demo.gomes.spring_app.repository.IVeiculo;

@Service
public class VeiculoService {  

    @Autowired
    private IVeiculo veiculoRepository;

    public List<VeiculoModel> findAll() {
        return veiculoRepository.findAll();
    }

    public VeiculoModel findById(Long id) {
        return veiculoRepository.findById(id).get();
    }

    public VeiculoModel save(VeiculoModel veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public VeiculoModel update(Long id, VeiculoModel veiculo) {
        veiculo.setId(id);
        return veiculoRepository.save(veiculo);
    }

    public void delete(Long id) {
        veiculoRepository.deleteById(id);
        return ;
    }

}
