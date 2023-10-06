package com.example.tarefa3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tarefa3.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
  @Query("SELECT p FROM Produto p WHERE p.preco > :preco")
  List<Produto> findProdutoByPrecoNamedParam( @Param("preco") Double preco);

  @Query("SELECT p FROM Produto p WHERE p.preco <= :preco")
  List<Produto> findProdutoByPrecoMenorIgualNamedParam( @Param("preco") Double preco);

  @Query("SELECT p FROM Produto p WHERE p.nome LIKE :nome%")
  List<Produto> searchByNomeLike( @Param("nome") String nome);
}
