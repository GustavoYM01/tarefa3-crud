package com.example.tarefa3.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.tarefa3.dtos.DadosProdutosDTO;
import com.example.tarefa3.dtos.ProdutoDTO;
import com.example.tarefa3.services.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
  private ProdutoService produtoService;

  public ProdutoController (ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Long inserir(@RequestBody ProdutoDTO produtoDTO) {
    return produtoService.salvar(produtoDTO).getId();
  }

  @GetMapping()
  public List<ProdutoDTO> obterTodos() {
    return  produtoService.listarTodosStream();
    //return produtoService.listarTodos();
  }

  @GetMapping("{id}")
  public DadosProdutosDTO obterPorId(@PathVariable Long id) {
    return produtoService.obterPorId(id);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    produtoService.excluir(id);
  }

  @PutMapping("{id}")
  public void edit(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
    produtoService.editar(id, dto);
  }
}
