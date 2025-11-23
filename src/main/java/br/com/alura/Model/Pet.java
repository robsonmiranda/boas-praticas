package br.com.alura.Model;

import java.math.BigDecimal;

public class Pet {

    private Long id;
    private String tipo;
    private Float peso;
    private String nome;
    private String raca;
    private Integer idade;
    private String cor;

    public Pet() {
    }

    public Pet(String tipo, Float peso, String nome, String raca, Integer idade, String cor) {
        this.tipo = tipo.toUpperCase();
        this.peso = peso;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.cor = cor;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    public Float getPeso() {
        return peso;
    }
}
