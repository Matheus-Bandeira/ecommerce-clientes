package com.ecommerce.infrastructutre.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.domain.models.Produto;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Integer>{

	//consulta de produtos por categoria
	List<Produto> findAllByCategoriaIdOrderByNomeAsc(Integer id);
}
