package com.ecommerce.infrastructutre.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.domain.models.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{

	List<Categoria> findAllByOrderByNomeAsc();
}
