package com.example.tarefa3.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_categorias")
public class CategoriaProduto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 200, nullable = false)
  private String nome;

  @OneToMany(mappedBy = "categoriaProduto", fetch = FetchType.EAGER) // Um para muitos
  private List<Produto> produtos;

  public CategoriaProduto(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public void atualizar(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public CategoriaProduto() {
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

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }

  @Override
  public String toString() {
    return "CategoriaProduto [id = " + id + ", nome = " + nome + "]";
  }
}

