package com.example.demo.gomes.spring_app.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.gomes.spring_app.models.AgendamentoModel;
import com.example.demo.gomes.spring_app.models.TecnicoModel;
import com.example.demo.gomes.spring_app.models.VeiculoModel;

public interface IAgendamento extends JpaRepository<AgendamentoModel, UUID> {
    
    List<AgendamentoModel> findByData(LocalDate data);
    List<AgendamentoModel> findByVeiculo(VeiculoModel veiculoId);
    List<AgendamentoModel> findByTecnico(TecnicoModel tecnico);
}
