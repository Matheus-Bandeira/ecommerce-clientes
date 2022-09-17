package com.ecommerce.domain.interfaces;

import java.util.List;

import com.ecommerce.domain.models.Produto;

public interface IProdutoDomainService {

	Produto save(Produto produto, Integer categoriaId);
	
	Produto delete(Integer id);
	
	List<Produto> findAll(Integer categoriaId);
}
