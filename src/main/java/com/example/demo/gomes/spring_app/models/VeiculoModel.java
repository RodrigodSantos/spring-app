package com.example.demo.gomes.spring_app.models;

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
    public Long id;

    public String marca;
    public String modelo;
    public String cor;
    public int ano;
    public String placa;
    public String chassi;
    public String renavam;
    public String categoria;
}
