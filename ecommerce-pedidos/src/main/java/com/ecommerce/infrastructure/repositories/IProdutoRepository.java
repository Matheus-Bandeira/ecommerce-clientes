package com.ecommerce.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.domain.models.Produto;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Integer> {

}
