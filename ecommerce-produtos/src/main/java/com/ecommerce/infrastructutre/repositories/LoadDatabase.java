package com.ecommerce.infrastructutre.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ecommerce.domain.models.Categoria;

@Component
public class LoadDatabase implements ApplicationRunner{

	@Autowired
	private ICategoriaRepository categoriaRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		categoriaRepository.save(new Categoria(1, "Informática", null));
		categoriaRepository.save(new Categoria(2, "Eletrônicos", null));
		categoriaRepository.save(new Categoria(3, "Celulares", null));
		categoriaRepository.save(new Categoria(4, "Games", null));
		categoriaRepository.save(new Categoria(5, "Livraria", null));
		categoriaRepository.save(new Categoria(6, "Outros", null));
		
	}
}
