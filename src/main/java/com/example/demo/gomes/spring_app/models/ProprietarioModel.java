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
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_proprietario")
public class ProprietarioModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    
    public String nome;
    public String cpf;
    public String endereco;
    public String telefone;
    public String email;
    public String dataNascimento;
    public String sexo;
    public String status;

}
