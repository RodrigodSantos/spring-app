package com.example.demo.gomes.spring_app.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
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
@Entity(name = "tb_endereco")
public class EnderecoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    public Integer cep;
    public String logradouro;
    public String numero;
    public String complemento;
    public String bairro;
    public String cidade;
    public String estado;
    public String pais;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proprietario_id")
    @JsonBackReference
    private ProprietarioModel proprietario;

}
