package com.example.demo.gomes.spring_app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.gomes.spring_app.models.ProprietarioModel;

public interface IProprietario extends JpaRepository<ProprietarioModel, UUID> {
    
}
