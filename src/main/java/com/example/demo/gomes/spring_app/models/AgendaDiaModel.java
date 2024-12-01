package com.example.demo.gomes.spring_app.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_agenda_dia")
public class AgendaDiaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String dia;
    private Integer capacidadeManha;
    private Integer capacidadeTarde;
    private Integer capacidadeNoite;
    
    @JsonBackReference
    @ManyToOne
    private AgendaModel agenda;
    
    private boolean isVisible = true;
    
}
