package com.example.tarefa3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.tarefa3.models.CategoriaProduto;
import com.example.tarefa3.models.Produto;
import com.example.tarefa3.repositories.CategoriaProdutoRepository;
import com.example.tarefa3.repositories.ProdutoRepository;

@SpringBootApplication
public class Tarefa3Application {

	@Bean
	public CommandLineRunner init(@Autowired ProdutoRepository produtoRepository, @Autowired CategoriaProdutoRepository categoriaProdutoRepository) {
		return args -> {
			System.out.println("\n\r******** Produtos inseridos ********\n\r");
			produtoRepository.save(new Produto(1L, "Caneta", 10.00));
			produtoRepository.save(new Produto(2L, "RTX 3080TI", 5600.00));
			produtoRepository.save(new Produto(3L, "Toyota AE86", 90000.00));

			// List<Produto> listaProduto = produtoRepository.findProdutoByPrecoNamedParam(10.00);
			// System.out.println("\n\r******** Produtos com preços superiores ao parâmetro ********\n\r");
			// listaProduto.forEach(System.out::println);

			// List<Produto> listaProduto = produtoRepository.findProdutoByPrecoMenorIgualNamedParam(5600.00);
			// System.out.println("\n\r******** Produtos com preços menores ou igual ao parâmetro ********\n\r");
			// listaProduto.forEach(System.out::println);

			// List<Produto> listaProduto = produtoRepository.searchByNomeLike("T");
			// System.out.println("\n\r******** Produtos que começam com o parâmetro ********\n\r");
			// listaProduto.forEach(System.out::println);

			System.out.println("\n\r******** Categorias inseridas ********\n\r");
			categoriaProdutoRepository.save(new CategoriaProduto(1L, "Material Escolar"));
			categoriaProdutoRepository.save(new CategoriaProduto(2L, "Placa de Vídeo"));
			categoriaProdutoRepository.save(new CategoriaProduto(3L, "Veículos"));

			// DEFININDO CATEGORIA PARA O(S) PRODUTO(S)
			Produto p1 = produtoRepository.findById(1L).get();
			p1.setCategoriaProduto(categoriaProdutoRepository.findById(1L).get());
			produtoRepository.save(p1);

			Produto p2 = produtoRepository.findById(2L).get();
			p2.setCategoriaProduto(categoriaProdutoRepository.findById(2L).get());
			produtoRepository.save(p2);

			Produto p3 = produtoRepository.findById(3L).get();
			p3.setCategoriaProduto(categoriaProdutoRepository.findById(3L).get());
			produtoRepository.save(p3);

			// List<CategoriaProduto> listaCategoriaProduto = categoriaProdutoRepository.findByNomeLike("M");
			// System.out.println("\n\r******** Categoria(s) que começam com o parâmetro ********\n\r");
			// listaCategoriaProduto.forEach(System.out::println);

			// System.out.println("\n\r******** Categoria e produtos relacionados ao id do parâmetro ********\n\r");
			// List<CategoriaProduto> categs = categoriaProdutoRepository.findAll();
			// for (CategoriaProduto cp : categs) {
			// 	System.out.println(cp.getProdutos().size());
			// }
			// CategoriaProduto cp = categoriaProdutoRepository.findByLeftJoinIdLike(1L);
			// System.out.println(cp.getProdutos().size());
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Tarefa3Application.class, args);
	}

}
