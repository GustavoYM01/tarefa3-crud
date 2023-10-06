package com.example.tarefa3.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosProdutosDTO {
  private Long id;
  private String nome;
  private Double preco;
  private CategoriaProdutoDTO categoria;
}
