package com.example.demo.gomes.spring_app.models;

import java.time.LocalDateTime;
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
@Entity(name = "tb_representacao_tec")
public class RepresentacaoTecModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    private String observacao;
    private String status;
    
    private LocalDateTime dataCadastro = LocalDateTime.now();
    private LocalDateTime dataAlteracao = LocalDateTime.now();
    
    @OneToMany(mappedBy = "representacaoTec", cascade = CascadeType.ALL)
    private List<AgendaModel> agenda;
    
    @OneToMany(mappedBy = "representacaoTec", cascade = CascadeType.ALL)
    private List<RepresentacaoTecEnderecoModel> enderecos;
    
    private boolean isVisible = true;
    
}
