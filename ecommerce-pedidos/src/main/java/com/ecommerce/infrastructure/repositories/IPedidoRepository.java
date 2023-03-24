package com.ecommerce.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.domain.models.Pedido;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {

	List<Pedido> findAllByEmailCliente(String emailCliente);
}
