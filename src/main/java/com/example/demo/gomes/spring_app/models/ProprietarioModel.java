package com.example.demo.gomes.spring_app.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private UUID id;
    
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String dataNascimento;
    private String sexo;
    private String status;

    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL)
    private List<ProprietarioEnderecoModel> enderecos;
}
