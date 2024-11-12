package com.example.demo.gomes.spring_app.models;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    public UUID id;
    
    public String nome;
    public String cpf;
    public String endereco;
    public String telefone;
    public String email;
    public String dataNascimento;
    public String sexo;
    public String status;

    @OneToMany(mappedBy = "proprietario")
    @JsonManagedReference
    private List<EnderecoModel> enderecos;

}
