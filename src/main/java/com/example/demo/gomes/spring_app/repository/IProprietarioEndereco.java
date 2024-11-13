package com.example.demo.gomes.spring_app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.gomes.spring_app.models.ProprietarioEnderecoModel;

public interface IProprietarioEndereco extends JpaRepository<ProprietarioEnderecoModel, UUID> {
    
}
