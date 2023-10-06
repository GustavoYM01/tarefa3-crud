package com.example.tarefa3.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.tarefa3.dtos.CategoriaProdutoDTO;
import com.example.tarefa3.dtos.DadosProdutosDTO;
import com.example.tarefa3.dtos.ProdutoDTO;
import com.example.tarefa3.exceptions.RegraNegocioException;
import com.example.tarefa3.models.CategoriaProduto;
import com.example.tarefa3.models.Produto;
import com.example.tarefa3.repositories.CategoriaProdutoRepository;
import com.example.tarefa3.repositories.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

  private final ProdutoRepository produtoRepository;
  private final CategoriaProdutoRepository categoriaProdutoRepository;

  @Override
  public Produto salvar(ProdutoDTO produtoDTO) {
    CategoriaProduto categ = categoriaProdutoRepository.findById(produtoDTO.getCategoriaProdutoId()).orElseThrow(
      () -> new RegraNegocioException("Código da categoria não encontrado!"));
    Produto p = new Produto();
    p.setPreco(produtoDTO.getPreco());
    p.setCategoriaProduto(categ);
    p.setNome(produtoDTO.getNome());
    return produtoRepository.save(p);
  }

  // public List<ProdutoDTO> listarTodos() {
  //   List<Produto> produtos = produtoRepository.findAll();
  //   List<ProdutoDTO> produtosDTO = new ArrayList();
  //   for (Produto p : produtos) {
  //     produtosDTO.add(new ProdutoDTO(
  //       p.getId(),
  //       p.getNome(),
  //       p.getPreco(),
  //       p.getCategoriaProduto() != null ? p.getCategoriaProduto().getId() : 0
  //     ));
  //   }
  //   return produtosDTO;
  // }

  public List<ProdutoDTO> listarTodosStream() {
    List<ProdutoDTO> produtos = produtoRepository.findAll().stream().map((Produto p) ->  {
      return ProdutoDTO.builder()
      .id(p.getId())
      .nome(p.getNome())
      .preco(p.getPreco())
      .categoriaProdutoId(p.getCategoriaProduto() != null ? p.getCategoriaProduto().getId() : 0)
      .build();
    }).collect(Collectors.toList());
    return produtos;
  }

  @Override
  public DadosProdutosDTO obterPorId(Long id) {
    return produtoRepository.findById(id).map((Produto p) -> {
      return DadosProdutosDTO.builder()
      .id(p.getId())
      .nome(p.getNome())
      .preco(p.getPreco())
      .categoria(
        p. getCategoriaProduto() != null ?
        CategoriaProdutoDTO.builder()
        .id(p.getCategoriaProduto().getId())
        .nome(p.getCategoriaProduto().getNome())
        .build() : null
      ).build();
    }).orElseThrow(() -> new RegraNegocioException("Id do produto não encontrado!"));
  }

  @Override
  public void excluir(Long id) {
    Produto p = produtoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Id não encontrado!"));
    produtoRepository.deleteById(p.getId());
  }

  @Override
  public void editar(Long id, ProdutoDTO dto) {
    Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Id do produto não encontrado."));
    CategoriaProduto categoriaProduto = categoriaProdutoRepository.findById(dto.getCategoriaProdutoId())
    .orElseThrow(() -> new RegraNegocioException("Categoria não encontrado."));
    produto.setNome(dto.getNome());
    produto.setPreco(dto.getPreco());
    produto.setCategoriaProduto(categoriaProduto);
    produtoRepository.save(produto);
  }

  
  
}
