package com.hyrule.zelda.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
    private Integer poder;
    private String raridade;

    // 1. Construtor vazio
    public Item() {
    }

    // 2. Construtor com todos os atributos
    public Item(Long id, String nome, String tipo, Integer poder, String raridade) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.poder = poder;
        this.raridade = raridade;
    }

    // 3. Construtor com todos os atributos menos o ID
    public Item(String nome, String tipo, Integer poder, String raridade) {
        this.nome = nome;
        this.tipo = tipo;
        this.poder = poder;
        this.raridade = raridade;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getPoder() {
        return poder;
    }

    public void setPoder(Integer poder) {
        this.poder = poder;
    }

    public String getRaridade() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }
}
