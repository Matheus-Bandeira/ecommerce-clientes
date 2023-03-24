package com.ecommerce.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.domain.models.ItemPedido;
import com.ecommerce.domain.models.Pedido;

@Repository
public interface IItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

	List<ItemPedido> findAllByPedido(Pedido pedido);
}
