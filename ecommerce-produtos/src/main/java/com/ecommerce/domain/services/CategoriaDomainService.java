package com.ecommerce.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.interfaces.ICategoriaDomainService;
import com.ecommerce.domain.models.Categoria;
import com.ecommerce.infrastructutre.repositories.ICategoriaRepository;

@Service
public class CategoriaDomainService implements ICategoriaDomainService{

	@Autowired
	private ICategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> findAll() {
		return categoriaRepository.findAllByOrderByNomeAsc();
	}

}
