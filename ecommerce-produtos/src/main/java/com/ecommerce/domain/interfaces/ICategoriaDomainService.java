package com.ecommerce.domain.interfaces;

import java.util.List;

import com.ecommerce.domain.models.Categoria;

public interface ICategoriaDomainService {

	List<Categoria> findAll();
}
