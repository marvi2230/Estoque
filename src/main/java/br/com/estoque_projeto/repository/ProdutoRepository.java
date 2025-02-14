package br.com.estoque_projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estoque_projeto.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}