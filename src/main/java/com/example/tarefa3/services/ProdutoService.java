package com.example.tarefa3.services;

import java.util.List;

import com.example.tarefa3.dtos.DadosProdutosDTO;
import com.example.tarefa3.dtos.ProdutoDTO;
import com.example.tarefa3.models.Produto;

public interface ProdutoService {
  Produto salvar(ProdutoDTO produtoDTO);
  // List<ProdutoDTO> listarTodos();
  List<ProdutoDTO> listarTodosStream();
  DadosProdutosDTO obterPorId(Long id);
  void excluir (Long id);
  void editar (Long id, ProdutoDTO dto);
}
