package com.example.demo.gomes.spring_app.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_tecnico_endereco")
public class TecnicoEnderecoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "tecnico_id")
    private TecnicoModel tecnico;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoModel endereco;
}