package com.gomes.spring_app.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_veiculo")
public class VeiculoModel {
    
    @Id
    public UUID id;

    public String marca;
    public String modelo;
    public String cor;
    public int ano;
    public String placa;
    public String chassi;
    public String renavam;
    public String categoria;

    @CreationTimestamp
    public LocalDateTime created_at;

    public VeiculoModel() {
        this.id = UUID.randomUUID(); // Gera o UUID manualmente
        this.created_at = LocalDateTime.now();
    }
}
