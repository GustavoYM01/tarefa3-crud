package com.example.tarefa3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tarefa3.models.CategoriaProduto;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {
  @Query("SELECT cp FROM CategoriaProduto cp WHERE cp.nome LIKE :nome%")
  List<CategoriaProduto> findByNomeLike( @Param("nome") String nome);

  @Query("SELECT cp FROM CategoriaProduto cp LEFT JOIN FETCH cp.produtos WHERE cp.id = :id")
  CategoriaProduto findByLeftJoinIdLike(@Param("id") Long id);
}