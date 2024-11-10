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

    public VeiculoModel save(VeiculoModel veiculo) {
        return veiculoRepository.save(veiculo);
    }

}
