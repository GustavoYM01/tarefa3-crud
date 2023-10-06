package com.example.tarefa3.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 200, nullable = false)
  private String nome;

  @Column(nullable = false)
  private Double preco;

  @ManyToOne // Muitos para 1
  @JoinColumn(name = "id_categoria") // Chave estrangeira
  private CategoriaProduto categoriaProduto;

  public Produto(Long id, String nome, Double preco) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
  }

  public void atualizar(Long id, String nome, Double preco) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
  }

  public Produto() {
  }

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

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public CategoriaProduto getCategoriaProduto() {
    return categoriaProduto;
  }

  public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
    this.categoriaProduto = categoriaProduto;
  }

  @Override
  public String toString() {
    return "Produto [id = " + id + ", nome = " + nome + ", preço = " + preco + "]";
  }
}

