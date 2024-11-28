package com.example.demo.gomes.spring_app.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_veiculo")
public class VeiculoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private String placa;
    private String chassi;
    private String renavam;
    private String categoria;
    private boolean delete = false;
}
