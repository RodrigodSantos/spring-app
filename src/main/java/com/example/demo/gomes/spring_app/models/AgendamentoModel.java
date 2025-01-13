package com.example.demo.gomes.spring_app.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_agendamento")
public class AgendamentoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private VeiculoModel veiculo;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoModel endereco;

    @ManyToOne
    @JoinColumn(name = "representacao_tec_id")
    private RepresentacaoTecModel representacaoTec;

    private LocalDate data;

    private boolean isVisible = true;
}
