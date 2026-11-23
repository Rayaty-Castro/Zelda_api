package com.hyrule.zelda.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personagens")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String raca;
    private String papel;
    private Integer coracoes;

    // 1. Construtor vazio
    public Personagem() {
    }

    // 2. Construtor com todos os atributos
    public Personagem(Long id, String nome, String raca, String papel, Integer coracoes) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.papel = papel;
        this.coracoes = coracoes;
    }

    // 3. Construtor com todos os atributos menos o ID
    public Personagem(String nome, String raca, String papel, Integer coracoes) {
        this.nome = nome;
        this.raca = raca;
        this.papel = papel;
        this.coracoes = coracoes;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public Integer getCoracoes() {
        return coracoes;
    }

    public void setCoracoes(Integer coracoes) {
        this.coracoes = coracoes;
    }
}
