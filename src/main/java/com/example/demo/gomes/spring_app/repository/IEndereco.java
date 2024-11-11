package com.example.demo.gomes.spring_app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.gomes.spring_app.models.EnderecoModel;

public interface IEndereco extends JpaRepository<EnderecoModel, UUID> {
    
}
