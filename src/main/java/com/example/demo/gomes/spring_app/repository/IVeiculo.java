package com.example.demo.gomes.spring_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.gomes.spring_app.models.VeiculoModel;

public interface IVeiculo extends JpaRepository<VeiculoModel, Long> {
    
}
