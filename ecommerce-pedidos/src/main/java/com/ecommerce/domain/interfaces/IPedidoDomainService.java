package com.ecommerce.domain.interfaces;

import java.util.List;

import com.ecommerce.domain.models.ItemPedido;
import com.ecommerce.domain.models.Pedido;

public interface IPedidoDomainService {

	void save(Pedido pedido, List<ItemPedido> itensPedido) throws Exception;

	List<Pedido> findByCliente(String email) throws Exception;

}
